package ru.fadedfog.tombs.asset.character.npc.peaseful;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Mouse extends Character implements PeacefulCreature {

	public Mouse() {
		super();
		initHitbox();
	}
	
	public Mouse(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(0.2, 0.2);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void moveToLeft() {
		System.out.println("Mouse move Left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Mouse move Right.");
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

	}

	@Override
	public void shoot() {

	}
	
	@Override
	public void protection() {

	}
	
	@Override
	public void kill() {

	}
	
	@Override
	public void dropReward() {

	}
	
}
