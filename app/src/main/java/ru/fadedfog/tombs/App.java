/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.fadedfog.tombs;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.Immovable;
import ru.fadedfog.tombs.asset.character.behavior.move.Movable;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.controller.UserKeys;
import ru.fadedfog.tombs.game.GameLoop;
import ru.fadedfog.tombs.view.GameView;

public class App {

    public static void main(String[] args) throws Exception {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	GameLoop gameLoop = context.getBean(GameLoop.class);
    	
    	TreasureHunter<MoveBehavior> treasureHunter = new TreasureHunter<MoveBehavior>();
    	treasureHunter.setHearts(2);
    	treasureHunter.setName("Hunter");
    	treasureHunter.setLevelScore(999);
    	treasureHunter.setTotalScore(9999);
    	treasureHunter.setNumberStepsUser(0);
    	treasureHunter.setMoveBehavior(new Movable());
    	Character<MoveBehavior> monster1 = new Character<>();
    	monster1.setName("Monster#1");
    	monster1.setMoveBehavior(new Immovable());
    	monster1.setHearts(1);
    	Character<MoveBehavior> monster2 = new Character<>();
    	monster2.setName("Monster#2");
    	monster2.setMoveBehavior(new Immovable());
    	monster2.setHearts(1);
    	ConcurrentHashMap<Point, Character<MoveBehavior>> map1 = new ConcurrentHashMap<>();
    	map1.put(new Point(0, 1), monster2);
    	map1.put(new Point(5, 1), treasureHunter);
    	map1.put(new Point(10, 1), monster1);
    	
    	Surface<TypeSurface> block = new Surface<TypeSurface>(TypeSurface.BLOCK);
    	Surface<TypeSurface> block2 = new Surface<TypeSurface>(TypeSurface.BLOCK);
    	Map<Point, Surface<TypeSurface>> map2 = new HashMap<>();
    	map2.put(new Point(2,2), block);
    	map2.put(new Point(2,3), block2);
    	
    	
    	int width = 100;
    	int height = 60;
    	String name = "RoomTest";
    	Room room = new Room(width, height, name, map1, map2);
    	System.out.println(new Point(1, 1) + " " + treasureHunter);
    	gameLoop.setRoom(room);
    	gameLoop.start();

    	UserKeys userKeys = new UserKeys(gameLoop);
    	GameView gameView = new GameView(userKeys);
    	
    }
    
}
