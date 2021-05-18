package ru.fadedfog.tombs.asset.level.element.climb;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public enum TypeClimbItem {
	ROAP {
		@Override
		public ClimbItem createClimbItem(Point point) {
			ClimbItem climbItem = new ClimbItem(ROAP, point);
			initHitBox(climbItem, BOTTOM_LEFT, TOP_RIGHT_STAIR);
			return climbItem;
		}
	},
	STAIR {
		@Override
		public ClimbItem createClimbItem(Point point) {
			ClimbItem climbItem = new ClimbItem(STAIR, point);
			initHitBox(climbItem, BOTTOM_LEFT, TOP_RIGHT_ROAP);
			return climbItem;
		}
	};
	
	private static final Point BOTTOM_LEFT = new Point(0, 0);
	private static final Point TOP_RIGHT_STAIR = new Point(1, 1);
	private static final Point TOP_RIGHT_ROAP = new Point(0.5, 0.5);
	
	public abstract ClimbItem createClimbItem(Point point);
	
	private static void initHitBox(ClimbItem climbItem, Point bottomLeft, Point topRight) {
		Hitbox hitbox = new Hitbox(bottomLeft, topRight);
		climbItem.setHitbox(hitbox);
	}
}
