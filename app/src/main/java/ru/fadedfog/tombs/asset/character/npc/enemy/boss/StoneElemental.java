package ru.fadedfog.tombs.asset.character.npc.enemy.boss;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.npc.enemy.Enemy;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class StoneElemental extends Character implements Enemy {

	public StoneElemental() {
		super();
		initHitbox();
	}
	
	public StoneElemental(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(3, 3.85);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void moveToLeft() {
		System.out.println("Stone Elemental move Left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Stone Elemental move Right.");
	}
	
	@Override
	public void crouch() {
		
	}

	@Override
	public void jump() {
		
	}
	
	@Override
	public void fly() {
		System.out.println("Stone Element fly.");
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
		System.out.println("Stone Elemental teleport.");
	}
	
	@Override
	public void atack() {
		System.out.println("Stone Elemental atack.");
	}

	@Override
	public void shoot() {
		System.out.println("Stone Elemental shoot.");
	}
	
	@Override
	public void protection() {
		System.out.println("Stone Elemental protection.");
	}
	
	@Override
	public void kill() {
		System.out.println("Stone Elemental die.");
	}
	
	@Override
	public void dropReward() {
		System.out.println("Stone Elemental drop trophy.");
	}

}
