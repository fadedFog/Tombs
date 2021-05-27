package ru.fadedfog.tombs.asset.level.element.surface;


public class Surface<T extends TypeSurface> implements Runnable {
	private T typeSurface;
	
	public Surface() {
		
	}
	
	public Surface(T typeSurface) {
		this.typeSurface = typeSurface;
	}
	
	@Override
	public void run() {
		
	}

	public TypeSurface getTypeSurface() {
		return typeSurface;
	}

	public void setTypeSurface(T typeSurface) {
		this.typeSurface = typeSurface;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeSurface == null) ? 0 : typeSurface.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Surface other = (Surface) obj;
		if (typeSurface == null) {
			if (other.typeSurface != null)
				return false;
		} else if (!typeSurface.equals(other.typeSurface))
			return false;
		return true;
	}
	
}
