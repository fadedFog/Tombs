package ru.fadedfog.tombs.asset.level.element;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;

public class FactorySurface {
	
	public static Surface makeSurface(TypeSurface typeSurface, Point point) {
		return typeSurface.createSurface(point);
	}
	
}
