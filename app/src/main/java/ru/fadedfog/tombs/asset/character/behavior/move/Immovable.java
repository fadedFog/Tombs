package ru.fadedfog.tombs.asset.character.behavior.move;

public class Immovable implements MoveBehavior {

	public Immovable() {}
	
	@Override
	public void move(int x, int y) {
	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
}
