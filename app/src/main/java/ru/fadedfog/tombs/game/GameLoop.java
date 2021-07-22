package ru.fadedfog.tombs.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.controller.UserKeys;
import ru.fadedfog.tombs.generate.RoomConfig;
import ru.fadedfog.tombs.settings.SettingsGame;
import ru.fadedfog.tombs.view.GameView;
import ru.fadedfog.tombs.service.ServiceStatisticsCollector;

@Component
public class GameLoop extends Thread{
	private SettingsGame settingsGame;
	private static final Logger LOG = LogManager.getLogger();
	private RoomConfig roomConfig;
	private Room room;
	private boolean pause;
	private boolean isMainMenu;
	private boolean isLose;
	@Autowired
	private ServiceStatisticsCollector service;
	private UserKeys userKeys;
	private GameView gameView;
	
	
	public GameLoop() {
		System.setProperty("java.awt.headless", "false");
		isLose = false;
		isMainMenu = true;
		settingsGame = SettingsGame.getInstance();
		this.roomConfig = new RoomConfig();
		userKeys = new UserKeys(this);
		gameView = new GameView(userKeys);
	}
	
	@Override
	public void run() {
		init();
		
		while(!isInterrupted()) {
			game();
		}
		
	}
	
	private void game() {
		if (!isMainMenu) {
			if (!isPause()) {
				try {
					stepOfGame();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				gameView.setPauseMenu();
			}
		} else {
			gameView.setStartMenu();
		}
	}
	
	private void stepOfGame() throws InterruptedException {
		Thread.sleep(500l);
		if (isHeroLive()) {
			moveCharacters();
			TreasureHunter<MoveBehavior> treasureHunter = (TreasureHunter<MoveBehavior>) room.getCharacters().get(room.getPointUser());
			gameView.setHeroSteps(treasureHunter.getNumberStepsUser());
			LOG.info("getNumberStepsUser(): " + treasureHunter.getNumberStepsUser());
		} else {
			setLose(true);
			gameView.setLoseMenu();
		}
	}

	private void init() {
		try {
			Runtime.getRuntime().addShutdownHook(new ProcessorHook(service));
			pause = false;
			initRoom();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initRoom() throws JsonParseException, JsonMappingException, IOException {
		if (room == null) {
			this.room = roomConfig.deserialize();
		}
		initRoomElements();
	}
	
	private void initRoomElements() {
		initCharacters();
		initSurfaces();
		
	}
	
	private void initCharacters() {
		List<Character<MoveBehavior>> characters = new ArrayList<>(room.getCharacters().values());
		for (Character<MoveBehavior> element: characters) {
			Thread characterThread = new Thread(element, element.getName());
			characterThread.start();
		}
	}
	
	private void initSurfaces() {
		
	}
	
	public boolean isPause() {
		return pause;
	} 

	public void pause() {
		this.pause = true;
	}
	
	public void proceed() {
		this.pause = false;
	}
	
	private boolean isHeroLive() {
		TreasureHunter<MoveBehavior> treasureHunter = (TreasureHunter<MoveBehavior>) room.getCharacters().get(room.getPointUser());
		return treasureHunter.getHearts() > 0;
	}
	
	private void moveCharacters() {
		int xMonster = 1;
    	int yMonster = 0;
    	ConcurrentHashMap<Point, Character<MoveBehavior>> newPositionCharacters = new ConcurrentHashMap<>();
    	List<Point> pointsRemove = new ArrayList<>();
    	
    	for (Map.Entry<Point, Character<MoveBehavior>> character: room.getCharacters().entrySet()) {
    		Character<MoveBehavior> value = character.getValue();
	    	Point key = character.getKey();
	    	Point newKey = value.move(xMonster, yMonster, key);
	    	LOG.info("##newKey " + value.getName() + " || " + newKey + "\n");
	    	if (value instanceof TreasureHunter<?>) {
	    		changePositionUser((TreasureHunter<MoveBehavior>) value, key, key);
	    	}
	    	LOG.info(!room.getCharacters().containsKey(newKey));
	    	if (!room.getCharacters().containsKey(newKey) && !(value instanceof TreasureHunter<?>)) {
		    	pointsRemove.add(key);
		    	newPositionCharacters.put(newKey, value);
	    	}
    	}
    	
    	for (Point point: pointsRemove) {
    		room.getCharacters().remove(point);
    	}
    	
    	room.getCharacters().putAll(newPositionCharacters);
    	
    	for (Map.Entry<Point, Character<MoveBehavior>> chaEntry: room.getCharacters().entrySet()) {
    		if (chaEntry.getValue() instanceof TreasureHunter<?>) {
    			LOG.info(chaEntry.getKey() + " " + chaEntry.getValue());
	    	} 
    	}
    	
    	LOG.info("\n\n");
	}
	
	
	private void render() {
		
	}
	
	private void update() {
		
	}
	
	public void changePositionUser(TreasureHunter<MoveBehavior> user, Point oldPoint, Point newPoint) {
		ConcurrentHashMap<Point, Character<MoveBehavior>> characters = room.getCharacters();
		if (!characters.containsKey(newPoint)) {
			characters.remove(oldPoint);
			characters.put(newPoint, user);	
			room.setPointUser(newPoint);
			TreasureHunter<MoveBehavior> treasureHunter = (TreasureHunter<MoveBehavior>) room.getCharacters().get(newPoint);
			treasureHunter.increaseNumberSteps();
			service.setNumberSteps(treasureHunter.getNumberStepsUser());
		}
	} 
	
	
	public RoomConfig getRoomConfig() {
		return roomConfig;
	}

	public void setRoomConfig(RoomConfig roomConfig) {
		this.roomConfig = roomConfig;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public SettingsGame getSettingsGame() {
		return settingsGame;
	}
	
	public boolean isMainMenu() {
		return isMainMenu;
	}

	public void setMainMenu(boolean isMainMenu) {
		this.isMainMenu = isMainMenu;
	}
	
	public boolean isLose() {
		return isLose;
	}

	public void setLose(boolean isLose) {
		this.isLose = isLose;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((roomConfig == null) ? 0 : roomConfig.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameLoop other = (GameLoop) obj;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (roomConfig == null) {
			if (other.roomConfig != null)
				return false;
		} else if (!roomConfig.equals(other.roomConfig))
			return false;
		return true;
	}

}
