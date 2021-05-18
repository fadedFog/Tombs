package ru.fadedfog.tombs.asset.level.element.container;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public enum TypeContainer {
	BARREL {
		@Override
		public Container createContainer(boolean isOpened, Point point) {
			Container container = new Container(BARREL, false, point);
			initHitBox(container, BOTTOM_LEFT, TOP_RIGHT_BARREL);
			return container;
		}
	},
	BOX {
		@Override
		public Container createContainer(boolean isOpened, Point point) {
			Container container = new Container(BOX, false, point);
			initHitBox(container, BOTTOM_LEFT, TOP_RIGHT_BOX);
			return container;
		}
	},
	CHEST {
		@Override
		public Container createContainer(boolean isOpened, Point point) {
			Container container = new Container(CHEST, false, point);
			initHitBox(container, BOTTOM_LEFT, TOP_RIGHT_CHEST);
			return container;
		}
	};
	
	private static final Point BOTTOM_LEFT = new Point(0, 0);
	private static final Point TOP_RIGHT_BARREL = new Point(1, 1);
	private static final Point TOP_RIGHT_BOX = new Point(1, 1);
	private static final Point TOP_RIGHT_CHEST = new Point(1, 1);
	
	public abstract Container createContainer(boolean isOpened, Point point);
	
	private static void initHitBox(Container container, Point borromLeft, Point topRight) {
		Hitbox hitbox = new Hitbox(borromLeft, topRight);
		container.setHitbox(hitbox);
	}
}
