package ru.fadedfog.tombs.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.generate.RoomConfig;

public class GameLoop extends Thread{
	private RoomConfig roomConfig;
	private Room room;
	private boolean pause;
	
	
	public GameLoop() {
		this.roomConfig = new RoomConfig();
	}
	
	@Override
	public void run() {
		init();
		
		while(!isInterrupted()) {
			if (!isPause()) {
				moveCharacters();
			}
		}
		
	}

	private void init() {
		try {
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
	
	private void moveCharacters() {
		int xMonster = 1;
    	int yMonster = 0;
    	Map<Point, Character<MoveBehavior>> newPositionCharacters = new HashMap<>();
    	List<Point> pointsRemove = new ArrayList<>();
    	
    	for (Map.Entry<Point, Character<MoveBehavior>> character: room.getCharacters().entrySet()) {
    		Character<MoveBehavior> value = character.getValue();
    		Point key = character.getKey();
    		pointsRemove.add(key);
    		Point newKey = value.move(xMonster, yMonster, key);
    		newPositionCharacters.put(newKey, value);
    	}
    	
    	for (Point point: pointsRemove) {
    		room.getCharacters().remove(point);
    	}
    	
    	room.getCharacters().putAll(newPositionCharacters);
    	
	}
	
	private void render() {
		
	}
	
	private void update() {
		
	}

	public Point getPointUser() {
		Map<Point, Character<MoveBehavior>> characters = room.getCharacters();
		Point pointUser = null;
		for (Map.Entry<Point, Character<MoveBehavior>> pointCharacter: characters.entrySet()) {
			Point point = pointCharacter.getKey();
			Character<MoveBehavior> character = pointCharacter.getValue();
			if (character instanceof TreasureHunter<?>) {
				pointUser = point;
			}
		}
		return pointUser;
	}
	
	public TreasureHunter<MoveBehavior> getUser() {
		List<Character<MoveBehavior>> characters = new ArrayList<>(room.getCharacters().values());
		TreasureHunter<MoveBehavior> user = null;
		for (Character<MoveBehavior> character: characters) {
			if (character instanceof TreasureHunter<?>) {
				user = (TreasureHunter<MoveBehavior>) character;
			}
		}
		
		return user;
	}
	
	public void changePositionUser(Point oldPoint, Point newPoint) {
		Map<Point, Character<MoveBehavior>> characters = room.getCharacters();
		Character<MoveBehavior> user = characters.get(oldPoint);
		characters.remove(oldPoint);
		
		characters.put(newPoint, user);
		
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
