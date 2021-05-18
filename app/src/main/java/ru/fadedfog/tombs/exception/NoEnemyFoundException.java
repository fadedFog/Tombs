package ru.fadedfog.tombs.exception;

import ru.fadedfog.tombs.asset.character.npc.enemy.TypeEnemy;

public class NoEnemyFoundException extends Exception{
	private static final long serialVersionUID = -5931926831925673554L;
	private TypeEnemy typeEnemy;
	
	
	public NoEnemyFoundException(TypeEnemy typeEnemy) {
		this.typeEnemy = typeEnemy;
	}
	
	@Override
	public String getMessage() {
		return "No enemy found. " + typeEnemy;
	}
}
