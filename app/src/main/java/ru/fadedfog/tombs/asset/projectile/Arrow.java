package ru.fadedfog.tombs.asset.projectile;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Arrow extends Projectile {

	public Arrow() {
		super();
		initHitbox();
	}
	
	public Arrow(int xVelocity, int yVelocity, Point point) {
		super(xVelocity, yVelocity, point);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(0.25, 0.75);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void moveToLeft() {
		
	}

	@Override
	public void moveToRight() {
		
	}
	
	@Override
	public void atack() {
		
	}

	@Override
	public void kill() {
		
	}

}
