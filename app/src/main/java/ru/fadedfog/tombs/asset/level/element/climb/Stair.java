package ru.fadedfog.tombs.asset.level.element.climb;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Stair extends ClimbItem {
	
	public Stair() {
		super();
		initHitbox();
	}
	
	public Stair(Point point) {
		super(point);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1.5, 1.5);
		setHitbox(new Hitbox(point1, point2));
	}
	
}
