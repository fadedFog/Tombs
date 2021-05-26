package ru.fadedfog.tombs.asset.character.behavior.move;

public class CantMoveable implements MoveBehavior {

	public CantMoveable() {}
	
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
