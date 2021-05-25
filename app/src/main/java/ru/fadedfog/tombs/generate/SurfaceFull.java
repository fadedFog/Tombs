package ru.fadedfog.tombs.generate;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;

public class SurfaceFull {
	private Point point;
	private Surface surface;
	
	public SurfaceFull() {
	}

	public SurfaceFull(Point point, Surface surface) {
		this.point = point;
		this.surface = surface;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurfaceFull other = (SurfaceFull) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		return true;
	}

	
	
	
}
