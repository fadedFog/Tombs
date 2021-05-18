package ru.fadedfog.tombs.asset.character.npc.enemy.boss;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.npc.enemy.Enemy;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class DireMiner extends Character implements Enemy {
	
	public DireMiner() {
		super();
		initHitbox();
	}
	
	public DireMiner(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(2, 2.5);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void moveToLeft() {
		System.out.println("Dire Miner move Left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Dire Miner move Right.");
	}
	
	@Override
	public void crouch() {
		
	}

	@Override
	public void jump() {
		System.out.println("Dire Miner jump.");
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
		System.out.println("Dire Miner teleport.");
	}
	
	@Override
	public void atack() {
		System.out.println("Dire Miner atack.");
	}

	@Override
	public void shoot() {
		System.out.println("Dire Miner shoot.");
	}
	
	@Override
	public void protection() {
		System.out.println("Dire Miner protection.");
	}
	
	@Override
	public void kill() {
		System.out.println("Dire Miner die.");
	}
	
	@Override
	public void dropReward() {
		System.out.println("Dire Miner drop trophy.");
	}
	
}
