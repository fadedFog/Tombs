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
import ru.fadedfog.tombs.view.GameView;
import ru.fadedfog.tombs.service.ServiceStatisticsCollector;
import ru.fadedfog.tombs.settings.SettingsGame;

@Component
public class GameLoop extends Thread{
	private static final Logger LOG = LogManager.getLogger();
	private SettingsGame settingsGame;
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
		this.roomConfig = new RoomConfig();
		userKeys = new UserKeys(this);
		gameView = new GameView(userKeys);
	}
	
	@Override
	public void run() {
		init();
		
		while(!isInterrupted()) {
			game();
			LOG.info("Hunter's position: " + this.room.getPointUser());
		}
		
	}
	
	private void game() {
		try {
			update();
			render();
		} catch (InterruptedException e) {
			e.printStackTrace();
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
    	
    	for (Map.Entry<Point, Character<MoveBehavior>> pointAndCharacter: room.getCharacters().entrySet()) {
    		Character<MoveBehavior> character = pointAndCharacter.getValue();
	    	Point pointCharacter = pointAndCharacter.getKey();
	    	Point newPointCharacter = character.move(xMonster, yMonster, pointCharacter);
	    	
	    	if (character instanceof TreasureHunter<?>) {
	    		Point newPointHunter = new Point(pointCharacter.getX(), newPointCharacter.getY());
	    		changePositionUser((TreasureHunter<MoveBehavior>) character, pointCharacter, newPointHunter);
	    	} else if (!room.getCharacters().containsKey(newPointCharacter)) {
	    		LOG.info("NewPointCharacter: " + character.getName() + " || " + newPointCharacter + "\n");
	    		pointsRemove.add(pointCharacter);
		    	newPositionCharacters.put(newPointCharacter, character);
	    	}
	    	
    	}
    	
    	for (Point point: pointsRemove) {
    		room.getCharacters().remove(point);
    	}
    	
    	room.getCharacters().putAll(newPositionCharacters);
    	
    	for (Map.Entry<Point, Character<MoveBehavior>> chaEntry: room.getCharacters().entrySet()) {
    		if (chaEntry.getValue() instanceof TreasureHunter<?>) {
	    	} 
    	}
    	
    	LOG.info("\n\n");
	}
	
	
	private void render() {
		if (!isMainMenu) {
			if (!isPause()) {
				if (isHeroLive()) {
					TreasureHunter<MoveBehavior> treasureHunter = (TreasureHunter<MoveBehavior>) room.getCharacters().get(room.getPointUser());
					gameView.setHeroSteps(treasureHunter.getNumberStepsUser(), room.getPointUser());
				} else {
					gameView.setLoseMenu();
				}
			} else {
				gameView.setPauseMenu();
			}
		} else {
			gameView.setStartMenu();
		}
	}
	
	private void update() throws InterruptedException {
		Thread.sleep(500l);
		if (isHeroLive()) {
			moveCharacters();
		} else {
			setLose(true);
		}
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
	
	public SettingsGame getSettingsGame() {
		return settingsGame;
	}

	public void setSettingsGame(SettingsGame settingsGame) {
		this.settingsGame = settingsGame;
		this.roomConfig.setSettingsGame(settingsGame);
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
