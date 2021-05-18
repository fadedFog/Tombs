package ru.fadedfog.tombs.asset.level.map;

import java.util.List;

import ru.fadedfog.tombs.asset.level.map.room.Room;

public class MapBuilder {
	private Map map;
	
	public void setRooms(List<Room> rooms) {
		if( isMapNull() ) {
			createMap();
		}
		map.setRooms(rooms);
	}
	
	public void setTypeMap(TypeMap typeMap) {
		if( isMapNull() ) {
			createMap();
		}
		map.setTypeMap(typeMap);
	}
	
	private boolean isMapNull() {
		return map == null;
	}
	
	private void createMap() {
		map = new Map();
	}
	
	public Map getMap() {
		return map;
	}
	
	public void reset() {
		map = null;
	}
	
}
