package ru.fadedfog.tombs.generate;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.level.map.room.Room;

public class SerializerRoom {
	private static final String PATH = "src/main/resources/config_files/room.json";
	private static final ObjectMapper mapper = new ObjectMapper();
	private String customPath;
	private double width;
	private double height;
	private String name;
	private Point pointHunter;
	private TreasureHunter treasureHunter;
	private Point[] pointsCharacters;
	private Character[] characters;
	private Point[] pointsSurfaces;
	private Surface[] surfaces;
	
	public void serialize(Room room) throws JsonGenerationException, JsonMappingException, IOException {
		initParameters(room);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		if (customPath == null) {
		mapper.writeValue(new File(PATH), this);
		} else {
			mapper.writeValue(new File(customPath), this);
		}
	}

	private void initParameters(Room room) {
		this.width = room.getWidth();
		this.height = room.getHeight();
		this.name = room.getName();
		iniCharactersPoints(room);
		initSurfacesPoints(room);
	}

	private void iniCharactersPoints(Room room) {
		Map<Point, Character> charactersMap = room.getCharacters();
		int length = charactersMap.size();
		pointsCharacters = new Point[length - 1];
		characters = new Character[length - 1];
		
		int i = 0;
		for (Map.Entry<Point, Character> character: charactersMap.entrySet()) {
			Point point = character.getKey();
			Character npc = character.getValue();
			if (npc instanceof TreasureHunter) {
				setPointHunter(point);
				treasureHunter = (TreasureHunter) npc;
			} else {
				pointsCharacters[i] = point;
				characters[i] = npc;
				i++;
			}
		}
		
	} 
	
	private void initSurfacesPoints(Room room) {
		Map<Point, Surface<TypeSurface>> surfacesMap = room.getSurfaces();
		int length = surfacesMap.size();
		pointsSurfaces = new Point[length];
		surfaces = new Surface[length];
		
		int i = 0;
		for (Map.Entry<Point, Surface<TypeSurface>> surface: surfacesMap.entrySet()) {
			pointsSurfaces[i] = surface.getKey();
			surfaces[i] = surface.getValue();
			i++;
		}	
	} 
	
	public Room deserialize() throws JsonParseException, JsonMappingException, IOException {
		SerializerRoom serializerRoom = mapper.readValue(new File(PATH), SerializerRoom.class);
		Room newRoom = initParametersRoom(serializerRoom);
		return newRoom;
	} 
	
	private Room initParametersRoom(SerializerRoom serilizeRoom) {
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
	
	private Map<Point, Character> initMapCharacters(SerializerRoom serializerRoom) {
		Map<Point, Character> charactersResult = new HashMap<Point, Character>();
		charactersResult.put(serializerRoom.getPointHunter(), serializerRoom.getTreasureHunter());
		Character[] characters = serializerRoom.getCharacters();
		Point[] points = serializerRoom.getPointsCharacters();
		for (int i = 0; i < characters.length; i++) {
			charactersResult.put(points[i], characters[i]);
		}
		
		return charactersResult;
	}
	
	private Map<Point, Surface<TypeSurface>> initMapSurfaces(SerializerRoom serializerRoom) {
		Map<Point, Surface<TypeSurface>> surfecesResult = new HashMap<Point, Surface<TypeSurface>>();
		Surface<TypeSurface>[] surfaces = serializerRoom.getSurfaces();
		Point[] points = serializerRoom.getPointsSurfaces();
		for (int i = 0; i < surfaces.length; i++) {
			surfecesResult.put(points[i], surfaces[i]);
		}
		
		return surfecesResult;
	}
	
	@Override
	public String toString() {
		return width + " " + height + " " + name +"\npointsCharacters: " 
				+ Arrays.toString(pointsCharacters) + "\ncharacters: "
				+ Arrays.toString(characters) + "\npointsSurfaces: " 
				+ Arrays.toString(pointsSurfaces) + "\nsurfaces: " 
				+ Arrays.toString(surfaces);
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Point[] getPointsCharacters() {
		return pointsCharacters;
	}
	
	public void setPointsCharacters(Point[] pointsCharacters) {
		this.pointsCharacters = pointsCharacters;
	}
	
	public Character[] getCharacters() {
		return characters;
	}
	
	public void setCharacters(Character[] characters) {
		this.characters = characters;
	}
	
	public Point[] getPointsSurfaces() {
		return pointsSurfaces;
	}
	
	public void setPointsSurfaces(Point[] pointsSurfaces) {
		this.pointsSurfaces = pointsSurfaces;
	}
	
	public Surface[] getSurfaces() {
		return surfaces;
	}
	
	public void setSurfaces(Surface[] surfaces) {
		this.surfaces = surfaces;
	}

	public TreasureHunter getTreasureHunter() {
		return treasureHunter;
	}

	public void setTreasureHunter(TreasureHunter treasureHunter) {
		this.treasureHunter = treasureHunter;
	}

	public Point getPointHunter() {
		return pointHunter;
	}

	public void setPointHunter(Point pointHunter) {
		this.pointHunter = pointHunter;
	}

	public String getCustomPath() {
		return customPath;
	}

	public void setCustomPath(String customPath) {
		this.customPath = customPath;
	}
	
}