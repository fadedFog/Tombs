package ru.fadedfog.tombs.game;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.generate.RoomConfig;

public class GameLoop extends Thread{
	private boolean isRunning = false; 
	private RoomConfig roomConfig;
	private Room room;
	
	
	public GameLoop() {
		this.roomConfig = new RoomConfig();
	}
	
	public void stopLoop() {
		setRunning(false);
	}
	
	@Override
	public void run() {
		init();
		
		while(!isInterrupted()) {
		}
		
	}

	private void init() {
		try {
			setRunning(true);
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
		Map<Point, Character<MoveBehavior>> characters = room.getCharacters();
		for (Map.Entry<Point, Character<MoveBehavior>> character: characters.entrySet()) {
			Thread characterThread = new Thread(character.getValue(), character.getValue().getName());
			characterThread.start();
		}
	}
	
	private void initSurfaces() {
		
	}
		
	private void render() {
		
	}
	
	private void update() {
		
	}
	
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
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
	
}
