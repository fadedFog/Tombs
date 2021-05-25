package ru.fadedfog.tombs.generate;


import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.geometry.Point;

public class CharacterFull {
	private Point point;
	private Character character;
	
	
	public CharacterFull() {
	}

	public CharacterFull(Point point, Character character) {
		this.point = point;
		this.character = character;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
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
		CharacterFull other = (CharacterFull) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}
	
	
	
}
