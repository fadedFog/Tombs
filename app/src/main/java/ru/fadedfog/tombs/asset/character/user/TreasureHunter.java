package ru.fadedfog.tombs.asset.character.user;


import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;

public class TreasureHunter<T extends MoveBehavior> extends Character<MoveBehavior> {
	private int totalScore;
	private int levelScore;
	private int numberStepsUser;
	
	public TreasureHunter() {
		super();
	}

	public TreasureHunter(String name, int hearts, MoveBehavior moveBehavior, int numberStepsUser) {
		super(name, hearts, moveBehavior);
		this.numberStepsUser = numberStepsUser;
	}
	
	public void increaseNumberSteps() {
		this.numberStepsUser += 1;
	}

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
	
	public int getNumberStepsUser() {
		return numberStepsUser;
	}
	
	public void setNumberStepsUser(int numberStepsUser) {
		this.numberStepsUser = numberStepsUser;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + getHearts();
		result = prime * result + levelScore;
		result = prime * result + ((getMoveBehavior() == null) ? 0 : getMoveBehavior().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
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
		if (getHearts() != other.getHearts())
			return false;
		if (levelScore != other.levelScore)
			return false;
		if (getMoveBehavior() == null) {
			if (other.getMoveBehavior() != null)
				return false;
		} else if (!getMoveBehavior().equals(other.getMoveBehavior()))
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (totalScore != other.totalScore)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TreasureHunter [name=" + getName() + ", hearts=" + getHearts() + ", moveBehavior=" + getMoveBehavior() + " totalScore=" + totalScore + ", levelScore=" + levelScore + "]";
	}
	
}
