package ru.fadedfog.tombs.asset.reward;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class PoitionProtection extends Reward {
	
	public PoitionProtection() {
		super();
		initHitbox();
	}
	
	public PoitionProtection(Point point) {
		super(point);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 1);
		setHitbox(new Hitbox(point1, point2));
	}
	
}
