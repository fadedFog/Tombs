package ru.fadedfog.tombs.asset.level.element;

import ru.fadedfog.tombs.asset.level.element.climb.ClimbItem;
import ru.fadedfog.tombs.asset.level.element.climb.Roap;
import ru.fadedfog.tombs.asset.level.element.climb.Stair;
import ru.fadedfog.tombs.asset.level.element.climb.TypeClimbItem;
import ru.fadedfog.tombs.exception.NoClimbItemFoundException;

public class FactoryClimbItem {
	
	public static ClimbItem makeClimbItem(TypeClimbItem typeClimbItem) 
			throws NoClimbItemFoundException {
			switch (typeClimbItem) {
			case ROAP:
				return new Roap();
			case STAIR:
				return new Stair();
			default:
				throw new NoClimbItemFoundException(typeClimbItem);
		}
	}
	
}
