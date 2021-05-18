package ru.fadedfog.tombs.exception;

import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;

public class NoSurfaceFoundException extends Exception {
	private static final long serialVersionUID = -26952085673926386L;
	private TypeSurface typeSurface;
	
	public NoSurfaceFoundException(TypeSurface typeSurface) {
		this.typeSurface = typeSurface;
	}
	
	@Override
	public String getMessage() {
		return "No surface found. " + typeSurface;
	}

}
