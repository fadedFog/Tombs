package ru.fadedfog.tombs.asset.character.behavior.move;

import ru.fadedfog.tombs.asset.geometry.Point;

public class Immovable implements MoveBehavior {

	public Immovable() {}
	
	@Override
	public void move(int x, int y, Point point) {
	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
}
