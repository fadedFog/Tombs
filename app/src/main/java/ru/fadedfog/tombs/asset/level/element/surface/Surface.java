package ru.fadedfog.tombs.asset.level.element.surface;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Surface {
	private Hitbox hitbox;
	private Point point;
	private TypeSurface typeSurface;
	
	public Surface(TypeSurface typeSurface, Point point) {
		this.typeSurface = typeSurface;
		this.point = point;
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

	public TypeSurface getTypeSurface() {
		return typeSurface;
	}

	public void setTypeSurface(TypeSurface typeSurface) {
		this.typeSurface = typeSurface;
	}
	
}
