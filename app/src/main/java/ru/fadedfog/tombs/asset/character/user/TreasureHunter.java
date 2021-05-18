package ru.fadedfog.tombs.asset.character.user;

import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.behavior.attack.AttackBehavior;
import ru.fadedfog.tombs.asset.character.behavior.attack.TypeAttack;
import ru.fadedfog.tombs.asset.character.behavior.death.KillBehavior;
import ru.fadedfog.tombs.asset.character.behavior.death.TypeKill;
import ru.fadedfog.tombs.asset.character.behavior.jump.JumpBehavior;
import ru.fadedfog.tombs.asset.character.behavior.jump.TypeJump;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.behavior.move.TypeMove;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class TreasureHunter {
	private final Point BOTTOM_LEFT = new Point(0, 0);
	private final Point TOP_RIGHT = new Point(1, 2);
	private int hearts;
	private double xVelocity;
	private double yVelocity;
	private CharacterTurned turned;
	private Hitbox hitbox;
	private Point point;
	private static TreasureHunter hunter;
	private int potionsProtection;
	private int bullets;
	private int totalScore;
	private int levelScore;
	private AttackBehavior attackBehavior;
	private MoveBehavior moveBehavior;
	private KillBehavior killBehavior;
	private JumpBehavior jumpBehavior;
	
	private TreasureHunter() {
		initHitbox();
	}

	public void initHitbox() {
		setHitbox(new Hitbox(BOTTOM_LEFT, TOP_RIGHT));
	}
	
	public static TreasureHunter getInstance() {
		if (hunter == null) {
			initParametersHunter();
		}
		return hunter;
	}
	
	//TODO init read from file properties, than remove this test code.
	private static final int HEARTS = 1;
	private static final double START_VELOCITY = 0;
	private static final Point POINT = new Point(0, 0);
	private static final CharacterTurned TURNED = CharacterTurned.RIGHT;
	private static final int POITIONS_PROTECTION = 3;
	private static final int BULLETS = 6;
	private static final int TOTAL_SCORE = 0;
	private static final int LEVEL_SCORE = 0;
	private static final TypeAttack TYPE_ATTACK = TypeAttack.ATTACKABLE;
	private static final TypeMove TYPE_MOVE = TypeMove.MOVEABLE;
	private static final TypeKill TYPE_KILL = TypeKill.KILLABLE;
	private static final TypeJump TYPE_JUMP = TypeJump.JUMPABLE;
	
	private static void initParametersHunter() {
		hunter = new TreasureHunter();
		// TODO get hunter with setup parameters from class ReadParametersTreasureHunter
		hunter.setHearts(HEARTS);
		hunter.setxVelocity(START_VELOCITY);
		hunter.setPoint(POINT);
		hunter.setTurned(TURNED);
		hunter.setPotionsProtection(POITIONS_PROTECTION);
		hunter.setBullets(BULLETS);
		hunter.setTotalScore(TOTAL_SCORE);
		hunter.setLevelScore(LEVEL_SCORE);
		hunter.setAttackBehavior(TYPE_ATTACK.getAttackBehavior());
		hunter.setMoveBehavior(TYPE_MOVE.getSpecificMove());
		hunter.setKillBehavior(TYPE_KILL.getSpecificKill());
		hunter.setJumpBehavior(TYPE_JUMP.getSpecificJump());
	}
	
	public void moveToRight() {
		moveBehavior.moveToRight();
	}
	
	public void moveToLeft() {
		moveBehavior.moveToLeft();
	}
	
	public void moveToDiagonalyUpRight() {
		moveBehavior.moveToDiagonalyUpRight();
	}
	
	public void moveToDiagonalyUpLeft() {
		moveBehavior.moveToDiagonalyUpLeft();
	}
	
	public void attack() {
		attackBehavior.attack();
	}
	
	public void kill() {
		killBehavior.kill();
	}
	
	public void jump() {
		jumpBehavior.jump();
	}
	

	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public CharacterTurned getTurned() {
		return turned;
	}

	public void setTurned(CharacterTurned turned) {
		this.turned = turned;
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

	public AttackBehavior getAttackBehavior() {
		return attackBehavior;
	}

	public void setAttackBehavior(AttackBehavior attackBehavior) {
		this.attackBehavior = attackBehavior;
	}

	public MoveBehavior getMoveBehavior() {
		return moveBehavior;
	}

	public void setMoveBehavior(MoveBehavior moveBehavior) {
		this.moveBehavior = moveBehavior;
	}

	public KillBehavior getKillBehavior() {
		return killBehavior;
	}

	public void setKillBehavior(KillBehavior killBehavior) {
		this.killBehavior = killBehavior;
	}

	public JumpBehavior getJumpBehavior() {
		return jumpBehavior;
	}

	public void setJumpBehavior(JumpBehavior jumpBehavior) {
		this.jumpBehavior = jumpBehavior;
	}
	
}
