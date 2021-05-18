package ru.fadedfog.tombs.asset.reward;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public abstract class Reward {
	private Hitbox hitbox;
	private Point point;

	public Reward() {
		
	}
	
	public Reward(Point point) {
		this.point = point;
	}
	
	public abstract void initHitbox();
	
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
