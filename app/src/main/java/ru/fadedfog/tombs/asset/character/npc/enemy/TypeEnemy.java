package ru.fadedfog.tombs.asset.character.npc.enemy;

import ru.fadedfog.tombs.asset.character.CharacterTurned;
import ru.fadedfog.tombs.asset.character.behavior.attack.TypeAttack;
import ru.fadedfog.tombs.asset.character.behavior.death.TypeKill;
import ru.fadedfog.tombs.asset.character.behavior.jump.TypeJump;
import ru.fadedfog.tombs.asset.character.behavior.move.TypeMove;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public enum TypeEnemy {
	BAT {
		@Override
		public Enemy createEnemy(TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point) {
			Enemy enemy = new Enemy(BAT, START_VELOCITY, START_VELOCITY, point);
			initBehavior(enemy, typeAttack, typeKill, typeJump, typeMove);
			initParameters(enemy, HEARTS_BAT, BOTTOM_LEFT, TOP_RIGHT_BAT, START_VELOCITY, START_VELOCITY);
			return enemy;
		}
	},
	SLIME {
		@Override
		public Enemy createEnemy(TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point) {
			Enemy enemy = new Enemy(SLIME, START_VELOCITY, START_VELOCITY, point);
			initBehavior(enemy, typeAttack, typeKill, typeJump, typeMove);
			initParameters(enemy, HEARTS_SLIME, BOTTOM_LEFT, TOP_RIGHT_SLIME, START_VELOCITY, START_VELOCITY);
			return enemy;
		}
	},
	SKELETON {
		@Override
		public Enemy createEnemy(TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point) {
			Enemy enemy = new Enemy(SKELETON, START_VELOCITY, START_VELOCITY, point);
			initBehavior(enemy, typeAttack, typeKill, typeJump, typeMove);
			initParameters(enemy, HEARTS_SKELETON, BOTTOM_LEFT, TOP_RIGHT_SKELETON, START_VELOCITY, START_VELOCITY);
			return enemy;
		}
	},
	BOSS_KEEPER_JUNGLE {
		@Override
		public Enemy createEnemy(TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point) {
			Enemy enemy = new Enemy(BOSS_KEEPER_JUNGLE, START_VELOCITY, START_VELOCITY, point);
			initBehavior(enemy, typeAttack, typeKill, typeJump, typeMove);
			initParameters(enemy, HEARTS_KEEPER_JUNGLE, BOTTOM_LEFT, TOP_RIGHT_KEEPER_JUNGLE, START_VELOCITY, START_VELOCITY);
			return enemy;
		}
	},
	BOSS_KEEPER_DESERT {
		@Override
		public Enemy createEnemy(TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point) {
			Enemy enemy = new Enemy(BOSS_KEEPER_DESERT, START_VELOCITY, START_VELOCITY, point);
			initBehavior(enemy, typeAttack, typeKill, typeJump, typeMove);
			initParameters(enemy, HEARTS_KEEPER_DESERT, BOTTOM_LEFT, TOP_RIGHT_KEEPER_DESERT, START_VELOCITY, START_VELOCITY);
			return enemy;
		}
	},
	BOSS_DIRE_MINER {
		@Override
		public Enemy createEnemy(TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point) {
			Enemy enemy = new Enemy(BOSS_DIRE_MINER, START_VELOCITY, START_VELOCITY, point);
			initBehavior(enemy, typeAttack, typeKill, typeJump, typeMove);
			initParameters(enemy, HEARTS_DIRE_MINER, BOTTOM_LEFT, TOP_RIGHT_DIRE_MINER, START_VELOCITY, START_VELOCITY);
			return enemy;
		}
	},
	BOSS_STONE_ELEMENTAL {
		@Override
		public Enemy createEnemy(TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point) {
			Enemy enemy = new Enemy(BOSS_STONE_ELEMENTAL, START_VELOCITY, START_VELOCITY, point);
			initBehavior(enemy, typeAttack, typeKill, typeJump, typeMove);
			initParameters(enemy, HEARTS_STONE_ELEMENTAL, BOTTOM_LEFT, TOP_RIGHT_STONE_ELEMENTAL, START_VELOCITY, START_VELOCITY);
			return enemy;
		}
	};
	
	private static final int HEARTS_BAT = 1;
	private static final int HEARTS_SLIME = 2;
	private static final int HEARTS_SKELETON = 3;
	private static final int HEARTS_KEEPER_DESERT = 15;
	private static final int HEARTS_KEEPER_JUNGLE = 20;
	private static final int HEARTS_DIRE_MINER = 25;
	private static final int HEARTS_STONE_ELEMENTAL = 35;
	private static final Point BOTTOM_LEFT = new Point(0, 0);
	private static final Point TOP_RIGHT_BAT = new Point(0.5, 0.5);
	private static final Point TOP_RIGHT_SLIME = new Point(1, 1);
	private static final Point TOP_RIGHT_SKELETON = new Point(1, 1.85);
	private static final Point TOP_RIGHT_KEEPER_DESERT = new Point(3, 3.5);
	private static final Point TOP_RIGHT_KEEPER_JUNGLE = new Point(3.25, 3);
	private static final Point TOP_RIGHT_DIRE_MINER = new Point(2, 2.5);
	private static final Point TOP_RIGHT_STONE_ELEMENTAL = new Point(3, 3.5);
	private static final double START_VELOCITY = 0;
	
	public abstract Enemy createEnemy(TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove, Point point);
	
	private static void initBehavior(Enemy enemy, TypeAttack typeAttack, TypeKill typeKill, TypeJump typeJump, TypeMove typeMove) {
		enemy.setAttackBehavior(typeAttack.getAttackBehavior());
		enemy.setKillBehavior(typeKill.getSpecificKill());
		enemy.setJumpBehavior(typeJump.getSpecificJump());
		enemy.setMoveBehavior(typeMove.getSpecificMove());
	}
	
	private static void initParameters(Enemy enemy, int hearts, Point bottomLeft, Point topRight, double xVelocity, double yVelocity) {
		enemy.setHearts(hearts);
		Hitbox hitbox = new Hitbox(bottomLeft, topRight);
		enemy.setHitbox(hitbox);
		enemy.setxVelocity(xVelocity);
		enemy.setyVelocity(yVelocity);
		enemy.setTurned(CharacterTurned.LEFT);
	}
}
