package ru.fadedfog.tombs.asset.level.element.climb;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class ClimbItem {
	private Hitbox hitbox;
	private Point point;
	private TypeClimbItem typeClimbItem;
	
	public ClimbItem(TypeClimbItem typeClimbItem, Point point) {
		this.typeClimbItem = typeClimbItem;
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


	public TypeClimbItem getTypeClimbItem() {
		return typeClimbItem;
	}


	public void setTypeClimbItem(TypeClimbItem typeClimbItem) {
		this.typeClimbItem = typeClimbItem;
	}
	
}
