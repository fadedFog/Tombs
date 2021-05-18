package ru.fadedfog.tombs.asset.character.user;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class TreasureHunter extends Character implements Hero {
	private static TreasureHunter hunter;
	private int potionsProtection;
	private int bullets;
	private int totalScore;
	private int levelScore;
	
	private TreasureHunter() {
	}
	
	public TreasureHunter(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		super(hearts, xVelocity, yVelocity, point, turned);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 2);
		setHitbox(new Hitbox(point1, point2));
	}
	
	public static TreasureHunter getInstance() {
		if (hunter == null) {
			hunter = new TreasureHunter();
		}
		return hunter;
	}
	
	@Override
	public void moveToLeft() {
		System.out.println("Hero move Left.");
	}

	@Override
	public void moveToRight() {
		System.out.println("Hero move Right.");
	}
	
	@Override
	public void crouch() {
		System.out.println("Hero crouch.");
	}

	@Override
	public void jump() {
		System.out.println("Hero jump.");
	}
	
	@Override
	public void fly() {
		
	}

	@Override
	public void dodjeToLeft() {
		System.out.println("Hero dodge Left.");
	}

	@Override
	public void dodjeToRight() {
		System.out.println("Hero dodge Right.");
	}

	@Override
	public void climb() {
		System.out.println("Hero climb.");
	}

	@Override
	public void teleport() {
		
	}
	
	@Override
	public void atack() {
		System.out.println("Hero atack.");
	}

	@Override
	public void shoot() {
		System.out.println("Hero shoot.");
	}
	
	@Override
	public void protection() {
		System.out.println("Hero protection.");
	}
	
	@Override
	public void kill() {
		System.out.println("Hero die.");
	}
	
	@Override
	public void dropReward() {
		System.out.println("Hero drop all reward.");
	}

	public int getPotionsProtection() {
		return potionsProtection;
	}

	public void setPotionsProtection(int potionsProtection) {
		this.potionsProtection = potionsProtection;
	}
	
	public int getBullets() {
		return bullets;
	}

	public void setBullets(int bullets) {
		this.bullets = bullets;
	}
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getLevelScore() {
		return levelScore;
	}

	public void setLevelScore(int levelScore) {
		this.levelScore = levelScore;
	}

}
