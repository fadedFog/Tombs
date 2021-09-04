package ru.fadedfog.tombs.asset.character.behavior.move;



import ru.fadedfog.tombs.ApplicationContextKeeper;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.settings.SettingsGame;

public class Movable implements MoveBehavior {
	private SettingsGame settingsGame;
	private int boost;
	
	public Movable() {
		this.settingsGame = ApplicationContextKeeper.getContext().getBean(SettingsGame.class);
	}
	
	@Override
	public Point move(int x, int y, Point point) {
		int newX = x + point.getX();
		int newY = y + point.getY();
		Point afterGravitation = getPointaAfterGravitation(new Point(newX, newY));
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
	public SettingsGame getSettingsGame() {
		return settingsGame;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
