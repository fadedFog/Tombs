package ru.fadedfog.tombs.asset.level.map;

import java.util.List;

import ru.fadedfog.tombs.asset.level.map.room.Room;

public class Map {
	private TypeMap typeMap;
	private List<Room> rooms;

	public Map() {
		
	}
	
	public Map(TypeMap typeMap, List<Room> rooms) {
		this.typeMap = typeMap;
		this.rooms = rooms;
	}
	
	public TypeMap getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(TypeMap typeMap) {
		this.typeMap = typeMap;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
