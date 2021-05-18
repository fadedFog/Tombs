package ru.fadedfog.tombs.asset.character.npc.enemy.usual;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.npc.enemy.Enemy;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Slime extends Character implements Enemy {

	public Slime() {
		super();
		initHitbox();
	}
	
	public Slime(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 1);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void moveToLeft() {
		System.out.println("Slime move left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Slime move Riht.");
	}
	
	@Override
	public void crouch() {
		
	}

	@Override
	public void jump() {
		System.out.println("Slime jump.");
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
		System.out.println("Slime atack.");
	}

	@Override
	public void shoot() {
		
	}
	
	@Override
	public void protection() {

	}
	
	@Override
	public void kill() {
		System.out.println("Slime die.");
	}
	
	@Override
	public void dropReward() {
		System.out.println("Slime drop reward.");
	}

}
