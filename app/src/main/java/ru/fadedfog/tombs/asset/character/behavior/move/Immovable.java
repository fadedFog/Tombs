package ru.fadedfog.tombs.asset.character.behavior.move;

import org.springframework.beans.factory.annotation.Autowired;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.settings.SettingsGame;

public class Immovable implements MoveBehavior {
	@Autowired
	private SettingsGame settingsGame;
	private int boost;
	
	public Immovable() {
		boost = settingsGame.ZERO;
	}
	
	@Override
	public Point move(int x, int y, Point point) {
		Point afterGravitation = getPointaAfterGravitation(point);
		return afterGravitation;
	}
	
	@Override
	public Point getPointaAfterGravitation(Point point) {
		Point afterGraviation = new Point(point.getX(), point.getY() + (settingsGame.getGravitation() - getBoost()));
		increaseBoost();
		return afterGraviation;
	}
	
	@Override
	public int getBoost() {
		return boost;
	}
	
	@Override
	public void setBoostZero() {
		this.boost =  settingsGame.ZERO;
	}
	
	@Override
	public void increaseBoost() {
		if (settingsGame.getGravitation() < 0) {
			this.boost += 1;
		} else if (settingsGame.getGravitation() > 0) {
			this.boost -= 1;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
