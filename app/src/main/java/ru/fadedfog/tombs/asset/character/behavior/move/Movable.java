package ru.fadedfog.tombs.asset.character.behavior.move;

import ru.fadedfog.tombs.asset.geometry.Point;

public class Movable implements MoveBehavior {

	public Movable() {}
	
	@Override
	public void move(int x, int y, Point point) {
		point.setX(point.getX() + x);
		point.setY(point.getY() + y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
