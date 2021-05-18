package ru.fadedfog.tombs.asset.level.element.trap;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public enum TypeTrap {
	BOUDLER_HOLDER {
		@Override
		public Trap createTrap(Point point) {
			Trap trap = new Trap(BOUDLER_HOLDER, point);
			initHitBox(trap, BOTTOM_LEFT, TOP_RIGHT_BOUDLER_HOLDER);
			return trap;
		}
	},
	DART_TRAP {
		@Override
		public Trap createTrap(Point point) {
			Trap trap = new Trap(DART_TRAP, point);
			initHitBox(trap, BOTTOM_LEFT, TOP_RIGHT_DART_TRAP);
			return trap;
		}
	},
	SPIKE {
		@Override
		public Trap createTrap(Point point) {
			Trap trap = new Trap(SPIKE, point);
			initHitBox(trap, BOTTOM_LEFT, TOP_RIGHT_SPIKE);
			return trap;
		}
	};
	
	private static final Point BOTTOM_LEFT = new Point(0, 0);
	private static final Point TOP_RIGHT_BOUDLER_HOLDER = new Point(1, 1);
	private static final Point TOP_RIGHT_DART_TRAP = new Point(1, 1);
	private static final Point TOP_RIGHT_SPIKE = new Point(1, 1);
	
	public abstract Trap createTrap(Point point);
	
	private static void initHitBox(Trap trap, Point bottomLeft, Point topRight) {
		Hitbox hitbox = new Hitbox(bottomLeft, topRight);
		trap.setTurned(Turned.DOWN);
		trap.setHitbox(hitbox);
	}
}
