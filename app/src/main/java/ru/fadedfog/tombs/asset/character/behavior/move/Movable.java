package ru.fadedfog.tombs.asset.character.behavior.move;

import ru.fadedfog.tombs.asset.geometry.Point;

public class Movable implements MoveBehavior {

	public Movable() {}
	
	@Override
	public Point move(int x, int y, Point point) {
		int newX = x + point.getX();
		int newY = y + point.getY();
		return new Point(newX, newY);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
