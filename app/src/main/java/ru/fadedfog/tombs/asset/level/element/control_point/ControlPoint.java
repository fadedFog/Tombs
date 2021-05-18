package ru.fadedfog.tombs.asset.level.element.control_point;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class ControlPoint {
	private Hitbox hitbox;
	private Point point;
	
	public ControlPoint() {
		
	}
	
	public ControlPoint(Point point) {
		this.point = point;
	}
	
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(2.5, 0.25);
		setHitbox(new Hitbox(point1, point2));
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

}
