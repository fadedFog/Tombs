package ru.fadedfog.tombs.asset.character.user;


import ru.fadedfog.tombs.asset.character.Character;

public class TreasureHunter extends Character {
	private int totalScore;
	private int levelScore;
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getLevelScore() {
		return levelScore;
	}

	public void setLevelScore(int levelScore) {
		this.levelScore = levelScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + levelScore;
		result = prime * result + totalScore;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreasureHunter other = (TreasureHunter) obj;
		if (levelScore != other.levelScore)
			return false;
		if (totalScore != other.totalScore)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TreasureHunter [totalScore=" + totalScore + ", levelScore=" + levelScore + "]";
	}

}
