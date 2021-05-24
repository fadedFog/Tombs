package ru.fadedfog.tombs.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.asset.level.map.room.Room;

public class Surfaces {
	private List<Point> pointsSurfaces;
	private List<Surface> surfaces;
	
	public static Surfaces initSurfaces(Room room) {
		Surfaces result = new Surfaces();
		List<Point> points = new ArrayList<>();
		List<Surface> surfaces = new ArrayList<>();
		Map<Point, Surface<TypeSurface>> surfacesMap = room.getSurfaces();
		
		for (Map.Entry<Point, Surface<TypeSurface>> surface: surfacesMap.entrySet()) {
			points.add(surface.getKey());
			surfaces.add(surface.getValue());
		}	
		
		result.setSurfaces(surfaces);
		result.setPointsSurfaces(points);
		
		return result;
	}

	public List<Point> getPointsSurfaces() {
		return pointsSurfaces;
	}

	public void setPointsSurfaces(List<Point> pointsSurfaces) {
		this.pointsSurfaces = pointsSurfaces;
	}

	public List<Surface> getSurfaces() {
		return surfaces;
	}

	public void setSurfaces(List<Surface> surfaces) {
		this.surfaces = surfaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointsSurfaces == null) ? 0 : pointsSurfaces.hashCode());
		result = prime * result + ((surfaces == null) ? 0 : surfaces.hashCode());
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
		Surfaces other = (Surfaces) obj;
		if (pointsSurfaces == null) {
			if (other.pointsSurfaces != null)
				return false;
		} else if (!pointsSurfaces.equals(other.pointsSurfaces))
			return false;
		if (surfaces == null) {
			if (other.surfaces != null)
				return false;
		} else if (!surfaces.equals(other.surfaces))
			return false;
		return true;
	} 

	
	
}
