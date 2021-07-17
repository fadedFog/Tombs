package ru.fadedfog.tombs.asset.character.behavior.move;

import ru.fadedfog.tombs.asset.geometry.Point;

public class Immovable implements MoveBehavior {
	private int boost = ZERO;
	
	public Immovable() {}
	
	@Override
	public Point move(int x, int y, Point point) {
		Point afterGravitation = getPointaAfterGravitation(point);
		return afterGravitation;
	}
	
	@Override
	public Point getPointaAfterGravitation(Point point) {
		Point afterGraviation = new Point(point.getX(), point.getY() + (GRAVITATION - getBoost()));
		increaseBoost();
		return afterGraviation;
	}

	@Override
	public void setBoostZero() {
		boost = ZERO;
	}
	
	@Override
	public int getBoost() {
		return boost;
	}
	
	@Override
	public void increaseBoost() {
		this.boost += 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
