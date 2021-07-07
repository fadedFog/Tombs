package ru.fadedfog.tombs.asset.character;

import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Character <T extends MoveBehavior> implements Runnable {
	private String name;
	private int hearts;
	private T moveBehavior;
	
	public Character() {
		super();
	}

	public Character(String name, int hearts, T moveBehavior) {
		this.name = name;
		this.hearts = hearts;
		this.moveBehavior = moveBehavior;
	}
	
	@Override
	public void run() {
	}
	
	public void interrupt() {
		Thread.currentThread().interrupt();
	}

	public Point move(int x, int y, Point point) {
		return moveBehavior.move(x, y, point);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}

	public MoveBehavior getMoveBehavior() {
		return moveBehavior;
	}

	public void setMoveBehavior(T moveBehavior) {
		this.moveBehavior = moveBehavior;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hearts;
		result = prime * result + ((moveBehavior == null) ? 0 : moveBehavior.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Character other = (Character) obj;
		if (hearts != other.hearts)
			return false;
		if (moveBehavior == null) {
			if (other.moveBehavior != null)
				return false;
		} else if (!moveBehavior.equals(other.moveBehavior))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", hearts=" + hearts + ", moveBehavior=" + moveBehavior + "]";
	}

}
