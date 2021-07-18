/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.fadedfog.tombs;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.Movable;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.generate.RoomConfig;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppTest {
    private final String NAME_LEVEL_CONFIG_FILE = "src/test/resources/room.json";
	
//    @Before
//    public void setUpHeadlessMode() {
//        System.setProperty("java.awt.headless", "true");
//    }
//    
//    @Test
//    public void whenSetUpSuccessfulThenHeadlessIsTrue() {
//    	assertTrue(GraphicsEnvironment.isHeadless());
//    }
    
    @Test
    public void testGenerateStage() throws JsonGenerationException, JsonMappingException, IOException {
    	int width = 100;
    	int height = 60;
    	String name = "RoomTest";
    	TreasureHunter<MoveBehavior> treasureHunter = new TreasureHunter<MoveBehavior>();
    	treasureHunter.setHearts(2);
    	treasureHunter.setName("Hunter");
    	treasureHunter.setLevelScore(999);
    	treasureHunter.setTotalScore(9999);
    	treasureHunter.setNumberStepsUser(0);
    	treasureHunter.setMoveBehavior(new Movable());
    	Character<MoveBehavior> npc = new Character<MoveBehavior>();
    	npc.setHearts(1);
    	npc.setName("NPC_1");
    	npc.setMoveBehavior(new Movable());
    	ConcurrentHashMap<Point, Character<MoveBehavior>> map1 = new ConcurrentHashMap<Point, Character<MoveBehavior>>();
    	map1.put(new Point(1,1), treasureHunter);
    	map1.put(new Point(2,2), npc);
    	Surface<TypeSurface> block = new Surface<TypeSurface>(TypeSurface.BLOCK);
    	Map<Point, Surface<TypeSurface>> map2 = new HashMap<>();
    	map2.put(new Point(2,2), block);
    	
    	Room room = new Room(width, height, name, map1, map2);
    	
    	RoomConfig serializerRoom = new RoomConfig();
    	serializerRoom.setCustomPath(NAME_LEVEL_CONFIG_FILE);
    	serializerRoom.serialize(room);
    	
    	Room newRoom = serializerRoom.deserialize();
    	
    	assertEquals(room, newRoom);
    }
    
}