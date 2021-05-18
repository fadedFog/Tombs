package ru.fadedfog.tombs.asset.level.element.surface;


public class Surface<T extends TypeSurface> {
	private T typeSurface;
	
	public Surface(T typeSurface) {
		this.typeSurface = typeSurface;
	}

	public TypeSurface getTypeSurface() {
		return typeSurface;
	}

	public void setTypeSurface(T typeSurface) {
		this.typeSurface = typeSurface;
	}
	
}
