package ru.fadedfog.tombs.asset.level.map.room;

import java.util.Map;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.character.Character;

public class Room {
	private double width;
	private double height;
	private String name;
	private Map<Point, Character> characters;
	private Map<Point, Surface<TypeSurface>> surfaces;
	
	public Room() {
		
	}
	
	public Room(int width, int height, String name,  
			Map<Point, Character> characters, Map<Point, Surface<TypeSurface>> surfaces) {
		this.width = width;
		this.height = height;
		this.name = name;
		this.characters = characters;
		this.surfaces = surfaces;
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
	
	public Map<Point, Character> getCharacters() {
		return characters;
	}

	public void setCharacters(Map<Point, Character> characters) {
		this.characters = characters;
	}
	
	public Map<Point, Surface<TypeSurface>> getSurfaces() {
		return surfaces;
	}

	public void setSurfaces(Map<Point, Surface<TypeSurface>> surfaces) {
		this.surfaces = surfaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + ((characters == null) ? 0 : characters.hashCode());
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surfaces == null) ? 0 : surfaces.hashCode());
		result = prime * result + width;
		return (int) result;
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
