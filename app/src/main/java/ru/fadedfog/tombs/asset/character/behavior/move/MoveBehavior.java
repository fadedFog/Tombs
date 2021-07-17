package ru.fadedfog.tombs.asset.character.behavior.move;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import ru.fadedfog.tombs.asset.geometry.Point;


@JsonIgnoreType
public interface MoveBehavior {
	static final int ZERO = 0;
	static final int GRAVITATION = -1;
	
	public Point move(int x, int y, Point point);
	
	Point getPointaAfterGravitation(Point point);
	
	void setBoostZero();
	
	int getBoost();
	
	void increaseBoost();
	
}
