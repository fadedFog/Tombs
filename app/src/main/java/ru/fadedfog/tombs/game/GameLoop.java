package ru.fadedfog.tombs.game;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.generate.RoomConfig;

public class GameLoop {
	private boolean isRunning = false; 
	private RoomConfig roomConfig;
	private Room room;
	
	
	public GameLoop() {
		this.roomConfig = new RoomConfig();
	}

	public void start() {
		setRunning(true);
		run();
	}
	
	public void stop() {
		setRunning(false);
	}
	
	private void run() {
		init();
		
		while(isRunning) {
			stop();
		}
		
	}

	private void init() {
		try {
			initRoom();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initRoom() throws JsonParseException, JsonMappingException, IOException {
		this.room = roomConfig.deserialize();
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
