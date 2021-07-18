package ru.fadedfog.tombs.generate;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.behavior.move.TypeMove;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;

public class TreasureHunterFull {
	private TreasureHunter<MoveBehavior> treasureHunter;
	private Point point;
	private TypeMove typeMove;
	private int numberStepsUser;

	public TreasureHunterFull(Point point, Character<MoveBehavior> character, TypeMove typeMove, int numberStepsUser) {
		this.point = point;
		this.treasureHunter = (TreasureHunter<MoveBehavior>) character;
		this.typeMove = typeMove;
		this.numberStepsUser = numberStepsUser;
	}

	public TreasureHunterFull() {
		super();
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public TreasureHunter<MoveBehavior> getTreasureHunter() {
		return treasureHunter;
	}

	public void setTreasureHunter(TreasureHunter<MoveBehavior> treasureHunter) {
		this.treasureHunter = treasureHunter;
	}

	public TypeMove getTypeMove() {
		return typeMove;
	}

	public void setTypeMove(TypeMove typeMove) {
		this.typeMove = typeMove;
	}
	
	public int getNumberStepsUser() {
		return numberStepsUser;
	}

	public void setNumberStepsUser(int numberStepsUser) {
		this.numberStepsUser = numberStepsUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + ((treasureHunter == null) ? 0 : treasureHunter.hashCode());
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
		TreasureHunterFull other = (TreasureHunterFull) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		if (treasureHunter == null) {
			if (other.treasureHunter != null)
				return false;
		} else if (!treasureHunter.equals(other.treasureHunter))
			return false;
		if (typeMove != other.typeMove)
			return false;
		return true;
	}

}
