package ru.fadedfog.tombs.generate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.level.map.room.Room;

public class RoomConfig {
	private static final String PATH = "src/main/resources/room.json";
	private static final ObjectMapper mapper = new ObjectMapper();
	@JsonIgnoreProperties
	private String customPath;
	private int width;
	private int height;
	private String name;
	private Characters characters;
	private Surfaces surfaces;
	
	public void serialize(Room room) throws JsonGenerationException, JsonMappingException, IOException {
		initParameters(room);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File(getPath()), this);
	}
	
	private String getPath() {
		if (customPath == null) {
			return PATH;
		} else {
			return customPath;
		}
	}

	private void initParameters(Room room) {
		this.width = room.getWidth();
		this.height = room.getHeight();
		this.name = room.getName();
		this.characters = Characters.initCharacters(room);
		this.surfaces = Surfaces.initSurfaces(room);
	}
	
	public Room deserialize() throws JsonParseException, JsonMappingException, IOException {
		RoomConfig serializerRoom = mapper.readValue(new File(PATH), RoomConfig.class);
		Room newRoom = initParametersRoom(serializerRoom);
		return newRoom;
	} 
	
	private Room initParametersRoom(RoomConfig serilizeRoom) {
		Room room = new Room();
		room.setWidth(serilizeRoom.getWidth());
		room.setHeight(serilizeRoom.getHeight());
		room.setName(serilizeRoom.getName());
		Map<Point, Character> characters = initMapCharacters(serilizeRoom);
		room.setCharacters(characters);
		Map<Point, Surface<TypeSurface>> surfaces = initMapSurfaces(serilizeRoom);
		room.setSurfaces(surfaces);
		
		return room;
	} 
	
	private Map<Point, Character> initMapCharacters(RoomConfig serializerRoom) {
		Map<Point, Character> charactersResult = new HashMap<Point, Character>();
		Point pointHunter = serializerRoom.getCharacters().getPointHunter();
		TreasureHunter treasureHunter = serializerRoom.getCharacters().getTreasureHunter();
		charactersResult.put(pointHunter, treasureHunter);
		
		List<Character> characters = serializerRoom.getCharacters().getCharacters();
		List<Point> points = serializerRoom.getCharacters().getPointsCharacters();
		for (int i = 0; i < characters.size(); i++) {
			charactersResult.put(points.get(i), characters.get(i));
		}
		
		return charactersResult;
	}
	
	private Map<Point, Surface<TypeSurface>> initMapSurfaces(RoomConfig serializerRoom) {
		Map<Point, Surface<TypeSurface>> surfecesResult = new HashMap<Point, Surface<TypeSurface>>();
		List<Surface> surfaces = serializerRoom.getSurfaces().getSurfaces();
		List<Point> points = serializerRoom.getSurfaces().getPointsSurfaces();
		for (int i = 0; i < surfaces.size(); i++) {
			surfecesResult.put(points.get(i), surfaces.get(i));
		}
		
		return surfecesResult;
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Characters getCharacters() {
		return characters;
	}

	public void setCharacters(Characters characters) {
		this.characters = characters;
	}

	public Surfaces getSurfaces() {
		return surfaces;
	}

	public void setSurfaces(Surfaces surfaces) {
		this.surfaces = surfaces;
	}
	
	@JsonIgnore
	public String getCustomPath() {
		return customPath;
	}
	
	@JsonIgnore
	public void setCustomPath(String customPath) {
		this.customPath = customPath;
	}
	
}