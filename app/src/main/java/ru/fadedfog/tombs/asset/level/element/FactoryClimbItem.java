package ru.fadedfog.tombs.asset.level.element;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.climb.ClimbItem;
import ru.fadedfog.tombs.asset.level.element.climb.TypeClimbItem;

public class FactoryClimbItem {
	
	public static ClimbItem makeClimbItem(TypeClimbItem typeClimbItem, Point point) {
		return typeClimbItem.createClimbItem(point);
	}
	
}
