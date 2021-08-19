package ru.fadedfog.tombs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.Immovable;
import ru.fadedfog.tombs.asset.character.behavior.move.Movable;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.game.GameLoop;
import ru.fadedfog.tombs.game.StateGame;

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
    	GameLoop gameLoop = new GameLoop();
    	gameLoop.start();
    	assertFalse(gameLoop.getStateGame() == StateGame.PAUSE);
    	
    	gameLoop.setStateGame(StateGame.PAUSE);
    	assertTrue(gameLoop.getStateGame() == StateGame.PAUSE);
    	
    	gameLoop.setStateGame(StateGame.ON);
    	assertFalse(gameLoop.getStateGame() == StateGame.PAUSE);
    	
    	gameLoop.interrupt();
    	assertFalse(gameLoop.getStateGame() == StateGame.PAUSE);
    }
    
    @Test
    public void testSwitchStateGame() throws Exception {
    	ApplicationContext context = ApplicationContextKeeper.getContext();
    	GameLoop gameLoop = context.getBean(GameLoop.class);
    	TreasureHunter<MoveBehavior> treasureHunter = new TreasureHunter<MoveBehavior>();
    	treasureHunter.setHearts(2);
    	treasureHunter.setName("Hunter");
    	treasureHunter.setLevelScore(999);
    	treasureHunter.setTotalScore(9999);
    	treasureHunter.setNumberStepsUser(0);
    	Movable movable = new Movable();
    	treasureHunter.setMoveBehavior(movable);
    	Character<MoveBehavior> monster1 = new Character<>();
    	monster1.setName("Monster#1");
    	Immovable immovable1 = new Immovable();
    	monster1.setMoveBehavior(immovable1);
    	monster1.setHearts(1);
    	
    	ConcurrentHashMap<Point, Character<MoveBehavior>> map1 = new ConcurrentHashMap<>();
    	map1.put(new Point(5, 5), treasureHunter);
    	map1.put(new Point(10, 2), monster1);
    	Map<Point, Surface<TypeSurface>> map2 = new HashMap<>();
    	
    	int width = 100;
    	int height = 60;
    	String name = "RoomTest";
    	Room room = new Room(width, height, name, map1, map2);
    	
    	gameLoop.setRoom(room);
    	gameLoop.start();
    	
    	assertTrue(gameLoop.getStateGame() == StateGame.MAIN_MENU);

    	KeyEvent ke = new KeyEvent(new Component() {}, 0, 0l, 0, KeyEvent.VK_ENTER);
    	gameLoop.getUserKeys().keyPressed(ke);
    	assertTrue(gameLoop.getStateGame() == StateGame.ON);
    	
    	ke = new KeyEvent(new Component() {}, 0, 0l, 0, KeyEvent.VK_ESCAPE);
    	gameLoop.getUserKeys().keyPressed(ke);
    	assertTrue(gameLoop.getStateGame() == StateGame.PAUSE);
    	
    	ke = new KeyEvent(new Component() {}, 0, 0l, 0, KeyEvent.VK_ESCAPE);
    	gameLoop.getUserKeys().keyPressed(ke);
    	assertTrue(gameLoop.getStateGame() == StateGame.ON);
    	
    	room = gameLoop.getRoom();
    	TreasureHunter<MoveBehavior> hunter = (TreasureHunter<MoveBehavior>) room.getCharacters().get(room.getPointUser());
    	hunter.setHearts(0);
    	Thread.sleep(500l);
    	
    	assertTrue(gameLoop.getStateGame() == StateGame.LOSE);
    }
    
    @Test
    public void testChangeGravitation() {
    	GameLoop gameLoop = new GameLoop();
    	gameLoop.getSettingsGame().setGravitation(10);
    	Movable movable = new Movable(); 
    	assertTrue(movable.getSettingsGame().getGravitation() == 10);
    }
}
