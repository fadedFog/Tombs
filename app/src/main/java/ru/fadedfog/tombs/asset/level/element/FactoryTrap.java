package ru.fadedfog.tombs.asset.level.element;

import ru.fadedfog.tombs.asset.level.element.trap.BoulderHolder;
import ru.fadedfog.tombs.asset.level.element.trap.DartTrap;
import ru.fadedfog.tombs.asset.level.element.trap.Spike;
import ru.fadedfog.tombs.asset.level.element.trap.Trap;
import ru.fadedfog.tombs.asset.level.element.trap.TypeTrap;
import ru.fadedfog.tombs.exception.NoTrapFoundException;

public class FactoryTrap {

	public static Trap makeTrap(TypeTrap typeTrap) throws NoTrapFoundException {
		switch (typeTrap) {
			case BOUDLER_HOLDER:
				return new BoulderHolder();
			case DART_TRAP:
				return new DartTrap();
			case SPIKE:
				return new Spike();
			default:
				throw new NoTrapFoundException(typeTrap);
		}
	}
	
}
