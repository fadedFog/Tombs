package ru.fadedfog.tombs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.Movable;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.game.GameLoop;
import ru.fadedfog.tombs.settings.SettingsGame;

public class GameLoopTest {
	private final String NAME_LEVEL_CONFIG_FILE = "src/test/resources/room.json";

	@Test
    public void testGameLoop() {
    	GameLoop gameLoop = new GameLoop();
    	gameLoop.getRoomConfig().setCustomPath(NAME_LEVEL_CONFIG_FILE);
    	gameLoop.start();
    	gameLoop.interrupt();
    	assertTrue(gameLoop.isInterrupted());
    	
   }
      
    @Test
    public void testMovingNPCs() throws JsonGenerationException, JsonMappingException, IOException {    	
    	SettingsGame settingsGame = new SettingsGame();
    	String name1 = "Monseter_1";
    	String name2 = "Monseter_2";
    	Point point1 = new Point(0, 5);
    	Character<MoveBehavior> monster1 = new Character<>();
    	monster1.setMoveBehavior(new Movable());
    	monster1.setName(name1);
    	monster1.setHearts(2);
    	Point point2 = new Point(3, -2);
    	Character<MoveBehavior> monster2 = new Character<>();
    	monster2.setMoveBehavior(new Movable());
    	monster2.setName(name2);
    	monster2.setHearts(1);
    	
    	List<Point> oldPoints = new ArrayList<>();
    	oldPoints.add(point1);
    	oldPoints.add(point2);
    	ConcurrentHashMap<Point, Character<MoveBehavior>> characters = new ConcurrentHashMap<Point, Character<MoveBehavior>>();
    	characters.put(point1, monster1);
    	characters.put(point2, monster2);
    	
    	
    	Room room = new Room(60, 100, "testRoom2", characters, new HashMap<>());
    	
    	GameLoop gameLoop = new GameLoop();
    	gameLoop.setRoom(room);
    	gameLoop.start();
    	
    	try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	gameLoop.interrupt();
    	
    	Map<Point, Character<MoveBehavior>> map = gameLoop.getRoom().getCharacters();
    	List<Point> newPoints = new ArrayList<>(map.keySet());   	
    	
    	assertFalse(oldPoints.equals(newPoints));
    }
	
    @Test
    public void testPauseGameLoop() {
//    	GameLoop gameLoop = new GameLoop();
//    	gameLoop.start();
//    	assertFalse(gameLoop.isPause());
//    	
//    	gameLoop.pause();
//    	assertTrue(gameLoop.isPause());
//    	
//    	gameLoop.proceed();
//    	assertFalse(gameLoop.isPause());
//    	
//    	gameLoop.interrupt();
//    	assertFalse(gameLoop.isPause());
//    	
    }
    
    @Test
    public void testChangeGravitation() {
//    	GameLoop gameLoop = new GameLoop();
//    	gameLoop.getSettingsGame().setGravitation(10);
//    	Movable movable = new Movable(); 
//    	assertTrue(movable.getSettingsGame().getGravitation() == 10);
    }
}
