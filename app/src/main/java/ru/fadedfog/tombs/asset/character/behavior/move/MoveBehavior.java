package ru.fadedfog.tombs.asset.character.behavior.move;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public interface MoveBehavior {
	
	public void move(int x, int y);
	
}
