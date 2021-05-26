package ru.fadedfog.tombs.asset.character.behavior.move;

public class Moveable implements MoveBehavior {

	public Moveable() {}
	
	@Override
	public void moveLeft() {
	}

	@Override
	public void moveRight() {
	}

	@Override
	public void moveDiagonallyUpRight() {
	}

	@Override
	public void moveDiagonallUpLeft() {
	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
