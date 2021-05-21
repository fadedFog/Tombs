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
}
