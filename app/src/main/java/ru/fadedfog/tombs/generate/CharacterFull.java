package ru.fadedfog.tombs.generate;


import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.behavior.move.TypeMove;
import ru.fadedfog.tombs.asset.geometry.Point;

public class CharacterFull {
	private Point point;
	private Character<MoveBehavior> character;
	private TypeMove typeMove;
	
	public CharacterFull() {
	}

	public CharacterFull(Point point, Character<MoveBehavior> character, TypeMove typeMove) {
		super();
		this.point = point;
		this.character = character;
		this.typeMove = typeMove;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Character<MoveBehavior> getCharacter() {
		return character;
	}

	public void setCharacter(Character<MoveBehavior> character) {
		this.character = character;
	}

	public TypeMove getTypeMove() {
		return typeMove;
	}

	public void setTypeMove(TypeMove typeMove) {
		this.typeMove = typeMove;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + ((typeMove == null) ? 0 : typeMove.hashCode());
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
		if (typeMove != other.typeMove)
			return false;
		return true;
	}
	
}