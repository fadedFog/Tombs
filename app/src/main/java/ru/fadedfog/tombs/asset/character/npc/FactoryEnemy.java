package ru.fadedfog.tombs.asset.character.npc;

import ru.fadedfog.tombs.asset.character.behavior.attack.TypeAttack;
import ru.fadedfog.tombs.asset.character.behavior.death.TypeKill;
import ru.fadedfog.tombs.asset.character.behavior.jump.TypeJump;
import ru.fadedfog.tombs.asset.character.behavior.move.TypeMove;
import ru.fadedfog.tombs.asset.character.npc.enemy.Enemy;
import ru.fadedfog.tombs.asset.character.npc.enemy.TypeEnemy;
import ru.fadedfog.tombs.asset.geometry.Point;

public class FactoryEnemy {
	
	public static Enemy makeEnemy(TypeEnemy typeEnemy, TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point) {
		return typeEnemy.createEnemy(typeAttack, typeKill, typeJump, typeMove, point);
	}
	
}
