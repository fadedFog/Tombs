package ru.fadedfog.tombs.asset.level.element;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.container.Container;
import ru.fadedfog.tombs.asset.level.element.container.TypeContainer;

public class FactoryContainer {

	public static Container makeContainer(TypeContainer typeContainer, Point point, boolean isOpened) {
		return typeContainer.createContainer(isOpened, point);
	}
	
}
