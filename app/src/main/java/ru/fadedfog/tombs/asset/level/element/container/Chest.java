package ru.fadedfog.tombs.asset.level.element.container;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.Surface;
import ru.fadedfog.tombs.asset.reward.Reward;

public class Chest extends Container {
	
	public Chest() {
		super();
		initHitbox();
	}
	
	public Chest(boolean isOpened, Point point, Reward reward, Surface surface) {
		super(isOpened, point, reward, surface);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1.5, 1.5);
		setHitbox(new Hitbox(point1, point2));
	}

	@Override
	public void kill() {
		
	}	
	
	@Override
	public void dropReward() {
		
	}
	
}
