package ru.fadedfog.tombs.asset.level.element;

import ru.fadedfog.tombs.asset.level.element.container.Barrel;
import ru.fadedfog.tombs.asset.level.element.container.Box;
import ru.fadedfog.tombs.asset.level.element.container.Chest;
import ru.fadedfog.tombs.asset.level.element.container.Container;
import ru.fadedfog.tombs.asset.level.element.container.TypeContainer;
import ru.fadedfog.tombs.exception.NoContainerFoundException;

public class FactoryContainer {

	public static Container makeContainer(TypeContainer typeContainer) 
			throws NoContainerFoundException{
		switch (typeContainer) {
			case BARREL:
				return new Barrel();
			case BOX:
				return new Box();
			case CHEST: 
				return new Chest();
			default:
				throw new NoContainerFoundException(typeContainer);
		}
	}
	
}
