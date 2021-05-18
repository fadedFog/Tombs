package ru.fadedfog.tombs.exception;

import ru.fadedfog.tombs.asset.level.element.climb.TypeClimbItem;

public class NoClimbItemFoundException extends Exception{
	private static final long serialVersionUID = 768234281715844029L;
	private TypeClimbItem typeClimbItem;
	
	public NoClimbItemFoundException(TypeClimbItem typeClimbItem) {
		this.typeClimbItem = typeClimbItem;
	}
	
	
	@Override
	public String getMessage() {
		return "No climb item found. " + typeClimbItem;
	}
}
