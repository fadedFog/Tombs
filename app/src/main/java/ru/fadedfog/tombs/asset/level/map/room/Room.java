package ru.fadedfog.tombs.asset.level.map.room;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;


public class Room {
	private int width;
	private int height;
	private String name;
	private ConcurrentHashMap<Point, Character<MoveBehavior>> characters;
	private Map<Point, Surface<TypeSurface>> surfaces;
	private Point pointUser;
	
	
	public Room(int width, int height, String name,  
			ConcurrentHashMap<Point, Character<MoveBehavior>> characters, Map<Point, Surface<TypeSurface>> surfaces) {
		this.width = width;
		this.height = height;
		this.name = name;
		this.characters = characters;
		this.surfaces = surfaces;
		initPointUser();
	}
	
	public void initPointUser() {
		for (Map.Entry<Point, Character<MoveBehavior>> pointCharacter: characters.entrySet()) {
			Point point = pointCharacter.getKey();
			Character<MoveBehavior> character = pointCharacter.getValue();
			if (character instanceof TreasureHunter<?>) {
				setPointUser(point);
			}
		}
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

	public ConcurrentHashMap<Point, Character<MoveBehavior>> getCharacters() {
		return characters;
	}

	public void setCharacters(ConcurrentHashMap<Point, Character<MoveBehavior>> characters) {
		this.characters = characters;
	}

	public Map<Point, Surface<TypeSurface>> getSurfaces() {
		return surfaces;
	}

	public void setSurfaces(Map<Point, Surface<TypeSurface>> surfaces) {
		this.surfaces = surfaces;
	}
	
	public Point getPointUser() {
		return pointUser;
	}

	public void setPointUser(Point pointUser) {
		this.pointUser = pointUser;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characters == null) ? 0 : characters.hashCode());
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surfaces == null) ? 0 : surfaces.hashCode());
		result = prime * result + width;
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
		Room other = (Room) obj;
		if (characters == null) {
			if (other.characters != null)
				return false;
		} else if (!characters.equals(other.characters))
			return false;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surfaces == null) {
			if (other.surfaces != null)
				return false;
		} else if (!surfaces.equals(other.surfaces))
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
}
