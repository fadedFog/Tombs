package ru.fadedfog.tombs.generate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.behavior.move.TypeMove;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.settings.SettingsGame;

public class RoomConfig {
	@Autowired
	private SettingsGame settingsGame;
	private static final String PATH = "src/main/resources/room.json";
	private static final ObjectMapper mapper = new ObjectMapper();
	@JsonIgnoreProperties
	private String customPath;
	private int width;
	private int height;
	private String name;
	private TreasureHunterFull treasureHunter;
	private List<CharacterFull> characters;
	private List<SurfaceFull> surfaces;
	
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
		this.characters = initCharacters(room);
		this.surfaces = initSurfaces(room);
	}
	
	private List<CharacterFull> initCharacters(Room room) {
		List<CharacterFull> result = new ArrayList<>();
		Map<Point, Character<MoveBehavior>> charactersMap = room.getCharacters();
		for (Map.Entry<Point, Character<MoveBehavior>> characterPair: charactersMap.entrySet()) {
			Point point = characterPair.getKey();
			Character<MoveBehavior> character = characterPair.getValue();
			if (!isTreasureHunter(character)) {
				TypeMove typeMove = getTypeMove(character.getMoveBehavior());
				result.add(new CharacterFull(point, character, typeMove));
			} else {
				initTreasureHunterFull(point, character);			
			}
		}
		
		return result;
	}
	
	private TypeMove getTypeMove(MoveBehavior moveBehavior) {
		return TypeMove.getTypeMove(moveBehavior);
	}
	
	private boolean isTreasureHunter(Character<MoveBehavior> character) {
		return character instanceof TreasureHunter;
	}
	
	private void initTreasureHunterFull(Point point, Character<MoveBehavior> character) {
		TreasureHunter<MoveBehavior> hunter = (TreasureHunter<MoveBehavior>) character;
		TypeMove typeMove = getTypeMove(character.getMoveBehavior());
		treasureHunter = new TreasureHunterFull(point, character, typeMove, hunter.getNumberStepsUser());
	}
	
	private List<SurfaceFull> initSurfaces(Room room) {
		List<SurfaceFull> result = new ArrayList<SurfaceFull>();
		Map<Point, Surface<TypeSurface>> surfacesMap = room.getSurfaces();
		
		for (Map.Entry<Point, Surface<TypeSurface>> surfacePair: surfacesMap.entrySet()) {
			Point point = surfacePair.getKey();
			Surface<TypeSurface> surface = surfacePair.getValue();
			result.add(new SurfaceFull(point, surface));
		}	
		
		
		return result;
	}
	
	public Room deserialize() throws JsonParseException, JsonMappingException, IOException {
		RoomConfig serializerRoom = mapper.readValue(new File(getPath()), RoomConfig.class);
		Room newRoom = initParametersRoom(serializerRoom);
		return newRoom;
	} 
	
	private Room initParametersRoom(RoomConfig serilizeRoom) {
		int width = serilizeRoom.getWidth();
		int height = serilizeRoom.getHeight();
		String name = serilizeRoom.getName();
		ConcurrentHashMap<Point, Character<MoveBehavior>> characters = initMapCharacters(serilizeRoom);
		Map<Point, Surface<TypeSurface>> surfaces = initMapSurfaces(serilizeRoom);
		Room room = new Room(width, height, name, characters, surfaces);
		
		return room;
	} 
	
	private ConcurrentHashMap<Point, Character<MoveBehavior>> initMapCharacters(RoomConfig serializerRoom) {
		ConcurrentHashMap<Point, Character<MoveBehavior>> result = new ConcurrentHashMap<Point, Character<MoveBehavior>>();
		MoveBehavior moveBehavior;
		TreasureHunterFull hunter = serializerRoom.getTreasureHunter();
		if (hunter != null) {
			TreasureHunter<MoveBehavior> treasureHunter = hunter.getTreasureHunter();
			moveBehavior = getMoveBehavior(hunter.getTypeMove());
			treasureHunter.setMoveBehavior(moveBehavior);
			result.put(hunter.getPoint(), treasureHunter);
		}
	
		List<CharacterFull> characters = serializerRoom.getCharacters();
		for (int i = 0; i < characters.size(); i++) {
			Point point = characters.get(i).getPoint();
			Character<MoveBehavior> character = characters.get(i).getCharacter();
			moveBehavior = getMoveBehavior(characters.get(i).getTypeMove());
			character.setMoveBehavior(moveBehavior);
			result.put(point, character);
		}
		
		return result;
	}
	
	private MoveBehavior getMoveBehavior(TypeMove typeMove) {
		return typeMove.getMoveBehavior();
	}
	
	private Map<Point, Surface<TypeSurface>> initMapSurfaces(RoomConfig serializerRoom) {
		Map<Point, Surface<TypeSurface>> result = new HashMap<Point, Surface<TypeSurface>>();
		List<SurfaceFull> surfaces = serializerRoom.getSurfaces();
		for (int i = 0; i < surfaces.size(); i++) {
			Point point = surfaces.get(i).getPoint();
			Surface surface = surfaces.get(i).getSurface();
			result.put(point, surface);
		}
		
		return result;
	}

	public SettingsGame getSettingsGame() {
		return settingsGame;
	}

	public void setSettingsGame(SettingsGame settingsGame) {
		this.settingsGame = settingsGame;
	}

	public static ObjectMapper getMapper() {
		return mapper;
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
	
	public TreasureHunterFull getTreasureHunter() {
		return treasureHunter;
	}

	public void setTreasureHunter(TreasureHunterFull treasureHunter) {
		this.treasureHunter = treasureHunter;
	}

	public List<CharacterFull> getCharacters() {
		return characters;
	}

	public void setCharacters(List<CharacterFull> characters) {
		this.characters = characters;
	}

	public List<SurfaceFull> getSurfaces() {
		return surfaces;
	}

	public void setSurfaces(List<SurfaceFull> surfaces) {
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