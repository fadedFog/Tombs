package ru.fadedfog.tombs.exception;

import ru.fadedfog.tombs.asset.level.element.trap.TypeTrap;

public class NoTrapFoundException extends Exception{
	private static final long serialVersionUID = -1521520351375168934L;
	private TypeTrap typeTrap;
	
	public NoTrapFoundException(TypeTrap typeTrap) {
		this.typeTrap = typeTrap;
	}
	
	@Override
	public String getMessage() {
		return "No trap found. " + typeTrap;
	}

}
