package ru.fadedfog.tombs.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.map.room.Room;

public class Characters {
	private Point pointHunter;
	private TreasureHunter treasureHunter;
	private List<Point> pointsCharacters;
	private List<Character> characters;
	
	
	public static Characters initCharacters(Room room) {
		Characters result = new Characters();
		List<Point> points = new ArrayList<>();
		List<Character> characters = new ArrayList<>();
		Map<Point, Character> charactersMap = room.getCharacters();
		
		for (Map.Entry<Point, Character> characterPair: charactersMap.entrySet()) {
			Point point = characterPair.getKey();
			Character character = characterPair.getValue();
			if (isTreasureHunter(character)) {
				result.setPointHunter(point);
				result.setTreasureHunter((TreasureHunter) character);
			} else {
				points.add(point);
				characters.add(character);
			}
		}
		
		result.setPointsCharacters(points);
		result.setCharacters(characters);
		
		return result;
	}
	
	private static boolean isTreasureHunter(Character character) {
		return character instanceof TreasureHunter;
	}
	
	
	
	public List<Point> getPointsCharacters() {
		return pointsCharacters;
	}
	
	public void setPointsCharacters(List<Point> pointsCharacters) {
		this.pointsCharacters = pointsCharacters;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
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

	
	
}
