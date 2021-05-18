package ru.fadedfog.tombs.asset.level.element.surface;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public enum TypeSurface {
	BLOCK {
		@Override
		public Surface createSurface(Point point) {
			Surface surface = new Surface(BLOCK, point);
			initHitBox(surface, BOTTOM_LEFT, TOP_RIGHT_BLOCK);
			return surface;
		}
	},
	BALK {
		@Override
		public Surface createSurface(Point point) {
			Surface surface = new Surface(BALK, point);
			initHitBox(surface, BOTTOM_LEFT, TOP_RIGHT_BALK);
			return surface;
		}
	},
	BLOCK_INVISIBLE {
		@Override
		public Surface createSurface(Point point) {
			Surface surface = new Surface(BLOCK_INVISIBLE, point);
			initHitBox(surface, BOTTOM_LEFT, TOP_RIGHT_BLOCK_INVISIBLE);
			return surface;
		}
	},
	PLATFORM {
		@Override
		public Surface createSurface(Point point) {
			Surface surface = new Surface(PLATFORM, point);
			initHitBox(surface, BOTTOM_LEFT, TOP_RIGHT_PLATFORM);
			return surface;
		}
	},
	OLD_PLATFORM {
		@Override
		public Surface createSurface(Point point) {
			Surface surface = new Surface(OLD_PLATFORM, point);
			initHitBox(surface, BOTTOM_LEFT, TOP_RIGHT_OLD_PLATFORM);
			return surface;
		}
	};
	
	private static final Point BOTTOM_LEFT = new Point(0, 0);
	private static final Point TOP_RIGHT_BLOCK = new Point(1, 1);
	private static final Point TOP_RIGHT_BALK = new Point(0.5, 0.5);
	private static final Point TOP_RIGHT_BLOCK_INVISIBLE = new Point(1, 1);
	private static final Point TOP_RIGHT_PLATFORM = new Point(1, 0.5);
	private static final Point TOP_RIGHT_OLD_PLATFORM = new Point(1, 0.5);
	
	public abstract Surface createSurface(Point point);
	
	private static void initHitBox(Surface surface, Point bottomLeft, Point topRight) {
		Hitbox hitbox = new Hitbox(bottomLeft, topRight);
		surface.setHitbox(hitbox);
	}
}
