package ru.fadedfog.tombs.exception;

import ru.fadedfog.tombs.asset.level.element.container.TypeContainer;

public class NoContainerFoundException extends Exception {
	private static final long serialVersionUID = -4488062596204408879L;
	private TypeContainer typeContainer;
	
	public NoContainerFoundException(TypeContainer typeContainer) {
		this.typeContainer = typeContainer;
	}
	
	@Override
	public String getMessage() {
		return "No container found. " + typeContainer;
	}
	
}
