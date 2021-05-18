package ru.fadedfog.tombs.asset.character.npc.enemy.usual;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.npc.enemy.Enemy;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Skeleton extends Character implements Enemy {

	public Skeleton() {
		super();
		initHitbox();
	}
	
	public Skeleton(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 1.85);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void moveToLeft() {
		System.out.println("Skeleton move Left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Skeleton move Right.");
	}
	
	@Override
	public void crouch() {
		
	}

	@Override
	public void jump() {
		System.out.println("Skeleton jump.");
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
		System.out.println("Skeleton climb.");
	}

	@Override
	public void teleport() {
		
	}
	
	@Override
	public void atack() {
		System.out.println("Skeleton atack.");
	}

	@Override
	public void shoot() {
		
	}
	
	@Override
	public void protection() {

	}
	
	@Override
	public void kill() {
		System.out.println("Skeleton die.");
	}
	
	@Override
	public void dropReward() {
		System.out.println("Skeleton drop reward.");
	}
	
}
