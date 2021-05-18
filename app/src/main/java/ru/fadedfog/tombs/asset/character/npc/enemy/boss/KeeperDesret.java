package ru.fadedfog.tombs.asset.character.npc.enemy.boss;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.npc.enemy.Enemy;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class KeeperDesret extends Character implements Enemy {

	public KeeperDesret() {
		super();
		initHitbox();
	}
	
	public KeeperDesret(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(4, 5.5);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void moveToLeft() {
		System.out.println("Keeper Desert move Left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Keeper Desert move Right.");
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
		System.out.println("Keeper Desert atack.");
	}

	@Override
	public void shoot() {
		System.out.println("Keeper Desert shoot.");
	}
	
	@Override
	public void protection() {
		System.out.println("Keeper Desert protection.");
	}
	
	@Override
	public void kill() {
		System.out.println("Keeper Desert die.");
	}
	
	@Override
	public void dropReward() {
		System.out.println("Keeper Desert drop trophy.");
	}

}
