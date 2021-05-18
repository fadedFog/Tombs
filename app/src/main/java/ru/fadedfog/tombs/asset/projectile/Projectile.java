package ru.fadedfog.tombs.asset.projectile;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Projectile {
	private double xVelocity;
	private double yVelocity;
	private Hitbox hitbox;
	private Point point;
	private TypeProjectile typeProjectile;
	
	public Projectile(TypeProjectile typeProjectile, double xVelocity, double yVelocity, Point point) {
		this.typeProjectile = typeProjectile;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.point = point;
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

	public TypeProjectile getTypeProjectile() {
		return typeProjectile;
	}

	public void setTypeProjectile(TypeProjectile typeProjectile) {
		this.typeProjectile = typeProjectile;
	}
	
}
