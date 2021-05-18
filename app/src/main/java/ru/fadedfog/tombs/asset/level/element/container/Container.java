package ru.fadedfog.tombs.asset.level.element.container;

import ru.fadedfog.tombs.asset.action.Dropable;
import ru.fadedfog.tombs.asset.action.Killable;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.Surface;
import ru.fadedfog.tombs.asset.reward.Reward;

public abstract class Container implements Killable, Dropable {
	private boolean isOpened;
	private Hitbox hitbox;
	private Point point;
	private Reward reward;

	public Container() {
		
	}
	
	public Container(boolean isOpened, Point point, Reward reward, Surface surface) {
		this.isOpened = isOpened;
		this.point = point;
		this.reward = getRandomReward();
	}
	
	public abstract void initHitbox();
	
	private Reward getRandomReward() {
		return null;
	}
	
	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}
	
}
