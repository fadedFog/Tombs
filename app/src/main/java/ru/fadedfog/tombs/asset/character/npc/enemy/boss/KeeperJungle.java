package ru.fadedfog.tombs.asset.character.npc.enemy.boss;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.npc.enemy.Enemy;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class KeeperJungle extends Character implements Enemy {

	public KeeperJungle() {
		super();
		initHitbox();
	}
	
	public KeeperJungle(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(3, 3);
		setHitbox(new Hitbox(point1, point2));
	}	
	
	@Override
	public void moveToLeft() {
		System.out.println("Keeper Jungle move Left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Keeper Jungle move Right.");
	}
	
	@Override
	public void crouch() {
		
	}

	@Override
	public void jump() {
		
	}
	
	@Override
	public void fly() {
		
	}

	@Override
	public void dodjeToLeft() {
		
	}

	@Override
	public void dodjeToRight() {
		
	}

	@Override
	public void climb() {
		
	}

	@Override
	public void teleport() {
		
	}
	
	@Override
	public void atack() {
		System.out.println("Keeper Jungle atack.");
	}

	@Override
	public void shoot() {
		System.out.println();
	}
	
	@Override
	public void protection() {
		System.out.println("Keeper Jungle protection.");
	}
	
	@Override
	public void kill() {
		System.out.println("Keeper Jungle die.");
	}
	
	@Override
	public void dropReward() {
		System.out.println("Keeper Jungle drop trophy.");
	}

}
