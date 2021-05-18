package ru.fadedfog.tombs.asset.reward;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Reward {
	private Hitbox hitbox;
	private Point point;
	private TypeReward typeReward;
	
	public Reward(TypeReward typeReward, Point point) {
		this.typeReward = typeReward;
		this.point = point;
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

	public TypeReward getTypeReward() {
		return typeReward;
	}

	public void setTypeReward(TypeReward typeReward) {
		this.typeReward = typeReward;
	}
	
}
