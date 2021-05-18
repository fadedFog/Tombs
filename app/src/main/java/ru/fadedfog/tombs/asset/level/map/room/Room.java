package ru.fadedfog.tombs.asset.level.map.room;

import java.util.Map;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;

public class Room {
	private int width;
	private int height;
	private String name;
	private Map<Point, Character> characters;
	private Map<Point, Surface> surfaces;
	
	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getHeight() {
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

	public Map<Point, Character> getCharacters() {
		return characters;
	}

	public void setCharacters(Map<Point, Character> characters) {
		this.characters = characters;
	}

	public Map<Point, Surface> getSurfaces() {
		return surfaces;
	}

	public void setSurfaces(Map<Point, Surface> surfaces) {
		this.surfaces = surfaces;
	}
	
}
