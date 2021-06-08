package ru.fadedfog.tombs.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.game.GameLoop;

public class StatisticsCollector extends Thread {
	private GameLoop gameLoop;
	private Room room;
	private ConcurrentHashMap<Point, Character<MoveBehavior>> characters;
	private Point pointUser;
	private Map<Point, Surface<TypeSurface>> surfaces;

	public StatisticsCollector(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
	}

	@Override
	public void run() {
		while(!gameLoop.isInterrupted()) {
			collectStatistics();
		}
	}
	
	private void collectStatistics() {
		collectStatisticRoom();
	}
	
	private void collectStatisticRoom() {
		this.room = gameLoop.getRoom();
		this.characters = room.getCharacters();
		this.pointUser = room.getPointUser();
		this.surfaces = room.getSurfaces();
	}
	
	public GameLoop getGameLoop() {
		return gameLoop;
	}

	public void setGameLoop(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
	}

	public Room getRoom() {
		return room;
	}
	
	public ConcurrentHashMap<Point, Character<MoveBehavior>> getCharacters() {
		return characters;
	}

	public Point getPointUser() {
		return pointUser;
	}

	public Map<Point, Surface<TypeSurface>> getSurfaces() {
		return surfaces;
	}
	
}
