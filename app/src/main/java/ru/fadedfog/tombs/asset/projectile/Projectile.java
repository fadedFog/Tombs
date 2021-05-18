package ru.fadedfog.tombs.asset.projectile;

import ru.fadedfog.tombs.asset.action.Atackable;
import ru.fadedfog.tombs.asset.action.Killable;
import ru.fadedfog.tombs.asset.action.Moveable;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public abstract class Projectile  implements Moveable, Atackable, Killable {
	private int xVelocity;
	private int yVelocity;
	private Hitbox hitbox;
	private Point point;
	
	public Projectile() {
		
	}
	
	public Projectile(int xVelocity, int yVelocity, Point point) {
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.point = point;
	}
	
	public abstract void initHitbox();
	
	public int getxVelocity() {
		return xVelocity;
	}
	
	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getyVelocity() {
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
	
}
