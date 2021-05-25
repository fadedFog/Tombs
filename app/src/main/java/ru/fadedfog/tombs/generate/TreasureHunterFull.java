package ru.fadedfog.tombs.generate;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;

public class TreasureHunterFull {
//	private String name;
//	private int hearts;
//	private int totalScore;
//	private int levelScore;
	private TreasureHunter treasureHunter;
	private Point point;

	public TreasureHunterFull(Point point, Character character) {
		this.point = point;
		this.treasureHunter = (TreasureHunter) character;
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

	public TreasureHunter getTreasureHunter() {
		return treasureHunter;
	}

	public void setTreasureHunter(TreasureHunter treasureHunter) {
		this.treasureHunter = treasureHunter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + ((treasureHunter == null) ? 0 : treasureHunter.hashCode());
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
		return true;
	}

}
