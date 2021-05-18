package ru.fadedfog.tombs.asset.level.element.climb;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Roap extends ClimbItem {

	public Roap() {
		super();
		initHitbox();
	}
	
	public Roap(Point point) {
		super(point);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(0.5, 1);
		setHitbox(new Hitbox(point1, point2));
	}
	
}
