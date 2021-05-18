package ru.fadedfog.tombs.asset.character.npc;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.npc.enemy.TypeEnemy;
import ru.fadedfog.tombs.asset.character.npc.enemy.boss.DireMiner;
import ru.fadedfog.tombs.asset.character.npc.enemy.boss.KeeperDesret;
import ru.fadedfog.tombs.asset.character.npc.enemy.boss.KeeperJungle;
import ru.fadedfog.tombs.asset.character.npc.enemy.boss.StoneElemental;
import ru.fadedfog.tombs.asset.character.npc.enemy.usual.Bat;
import ru.fadedfog.tombs.asset.character.npc.enemy.usual.Skeleton;
import ru.fadedfog.tombs.asset.character.npc.enemy.usual.SkeletonBow;
import ru.fadedfog.tombs.asset.character.npc.enemy.usual.SkeletonShield;
import ru.fadedfog.tombs.asset.character.npc.enemy.usual.Slime;
import ru.fadedfog.tombs.exception.NoEnemyFoundException;

public class FactoryEnemy {
	
	public static Character makeEnemy(TypeEnemy typeEnemy) throws NoEnemyFoundException {
		switch (typeEnemy) {
			case BAT:
				return new Bat();
			case SLIME:
				return new Slime();
			case SKELETON:
				return new Skeleton();
			case SKELETON_SHIELD:
				return new SkeletonShield();
			case SKELETON_BOW:
				return new SkeletonBow();
			case BOSS_KEEPER_JUNGLE:
				return new KeeperJungle();
			case BOSS_KEEPER_DESERT:
				return new KeeperDesret();
			case BOSS_DIRE_MINER:
				return new DireMiner();
			case BOSS_STONE_ELEMENTAL:
				return new StoneElemental();
			default:
				throw new NoEnemyFoundException(typeEnemy);
		} 
	}
	
}
