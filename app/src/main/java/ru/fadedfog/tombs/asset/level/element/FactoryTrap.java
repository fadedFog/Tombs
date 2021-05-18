package ru.fadedfog.tombs.asset.level.element;

import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.trap.Trap;
import ru.fadedfog.tombs.asset.level.element.trap.TypeTrap;

public class FactoryTrap {

	public static Trap makeTrap(TypeTrap typeTrap, Point point) {
		return typeTrap.createTrap(point);
	}
	
}
