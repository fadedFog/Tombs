package ru.fadedfog.tombs.asset.level.element.surface;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.Surface;

public class Balk extends Surface {

	public Balk() {
		super();
		initHitbox();
	}
	
	public Balk(Point point) {
		super(point);
		initHitbox();
	}

	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(0.5, 0.5);
		setHitbox(new Hitbox(point1, point2));
	}
	
}
