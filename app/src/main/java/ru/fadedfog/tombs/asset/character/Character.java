package ru.fadedfog.tombs.asset.character;

import ru.fadedfog.tombs.asset.action.Atackable;
import ru.fadedfog.tombs.asset.action.Climbable;
import ru.fadedfog.tombs.asset.action.Crouchable;
import ru.fadedfog.tombs.asset.action.Dodgeable;
import ru.fadedfog.tombs.asset.action.Dropable;
import ru.fadedfog.tombs.asset.action.Flyable;
import ru.fadedfog.tombs.asset.action.Jumpable;
import ru.fadedfog.tombs.asset.action.Killable;
import ru.fadedfog.tombs.asset.action.Moveable;
import ru.fadedfog.tombs.asset.action.Protectionable;
import ru.fadedfog.tombs.asset.action.Shootable;
import ru.fadedfog.tombs.asset.action.Teleportable;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public abstract class Character implements Moveable, Atackable, Killable, Dropable, Crouchable, Jumpable, Flyable, Dodgeable, Climbable, Shootable, Teleportable, Protectionable {
	private int hearts;
	private double xVelocity;
	private double yVelocity;
	private CharacterTurned turned;
	private Hitbox hitbox;
	private Point point;
	
	public Character() {
		
	}
	
	public Character(int hearts, double xVelocity, double yVelocity, Point point, CharacterTurned turned) {
		this.turned = turned;
		this.hearts = hearts;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.point = point;
	}
	
	public abstract void initHitbox();
	
	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(int yVelocity) {
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
	
}
