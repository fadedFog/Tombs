package ru.fadedfog.tombs.asset.character.npc.enemy.usual;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.npc.enemy.Enemy;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Bat extends Character implements Enemy {

	public Bat() {
		super();
		initHitbox();
	}
	
	public Bat(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(0.5, 0.5);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void moveToLeft() {
		System.out.println("Bat move Left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Bat move Right.");
	}
	
	@Override
	public void crouch() {
		
	}

	@Override
	public void jump() {
		
	}
	
	@Override
	public void fly() {
		System.out.println("Bat fly.");
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
		System.out.println("Bat atack.");
	}

	@Override
	public void shoot() {
		
	}
	
	@Override
	public void protection() {

	}
	
	@Override
	public void kill() {
		System.out.println("Bat die.");
	}
	
	@Override
	public void dropReward() {
		System.out.println("Bat drop reward.");
	}

}
