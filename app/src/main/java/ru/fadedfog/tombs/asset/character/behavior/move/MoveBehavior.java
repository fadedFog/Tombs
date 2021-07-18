package ru.fadedfog.tombs.asset.character.behavior.move;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import ru.fadedfog.tombs.asset.geometry.Point;


@JsonIgnoreType
public interface MoveBehavior {
	
	public Point move(int x, int y, Point point);
	
	Point getPointaAfterGravitation(Point point);
	
	void setBoostZero();
	
	int getBoost();
	
	void increaseBoost();
	
}
