package ru.fadedfog.tombs.asset.character.npc.enemy;

import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.behavior.attack.AttackBehavior;
import ru.fadedfog.tombs.asset.character.behavior.death.KillBehavior;
import ru.fadedfog.tombs.asset.character.behavior.jump.JumpBehavior;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Enemy {
	private int hearts;
	private double xVelocity;
	private double yVelocity;
	private CharacterTurned turned;
	private Hitbox hitbox;
	private Point point;
	private TypeEnemy typeEnemy;
	private AttackBehavior attackBehavior;
	private MoveBehavior moveBehavior;
	private KillBehavior killBehavior;
	private JumpBehavior jumpBehavior;
	
	public Enemy(TypeEnemy typeEnemy, double xVelocity, double yVelocity, Point point) {
		this.typeEnemy = typeEnemy;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.point = point;
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

	public CharacterTurned getTurned() {
		return turned;
	}

	public void setTurned(CharacterTurned turned) {
		this.turned = turned;
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

	public TypeEnemy getTypeEnemy() {
		return typeEnemy;
	}

	public void setTypeEnemy(TypeEnemy typeEnemy) {
		this.typeEnemy = typeEnemy;
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
