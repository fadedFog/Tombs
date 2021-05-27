package ru.fadedfog.tombs.asset.character.behavior.move;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import ru.fadedfog.tombs.asset.geometry.Point;

@JsonIgnoreType
public interface MoveBehavior {
	
	public void move(int x, int y, Point point);
	
}
