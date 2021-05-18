package ru.fadedfog.tombs.asset.reward;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Bullet extends Reward{
	
	public Bullet() {
		super();
		initHitbox();
	}
	
	public Bullet(Point point) {
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
