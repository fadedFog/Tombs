package ru.fadedfog.tombs.asset.character.behavior.move;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public interface MoveBehavior {
	
	public void moveLeft();
	public void moveRight();
	public void moveDiagonallyUpRight();
	public void moveDiagonallUpLeft();
	
}
