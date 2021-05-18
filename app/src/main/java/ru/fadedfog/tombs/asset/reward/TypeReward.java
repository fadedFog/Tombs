package ru.fadedfog.tombs.asset.reward;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public enum TypeReward {
	
	NOTHING {
		@Override
		public Reward createReward(Point point) {
			Reward reward = new Reward(NOTHING, point);
			initHitBox(reward, BOTTOM_LEFT, TOP_RIGHT_NOTHING);
			return reward;
		}
	},
	BULLET {
		@Override
		public Reward createReward(Point point) {
			Reward reward = new Reward(BULLET, point);
			initHitBox(reward, BOTTOM_LEFT, TOP_RIGHT_BULLET);
			return reward;
		}
	},
	HEART {
		@Override
		public Reward createReward(Point point) {
			Reward reward = new Reward(HEART, point);
			initHitBox(reward, BOTTOM_LEFT, TOP_RIGHT_HEART);
			return reward;
		}
	},
	JEWEL {
		@Override
		public Reward createReward(Point point) {
			Reward reward = new Reward(JEWEL, point);
			initHitBox(reward, BOTTOM_LEFT, TOP_RIGHT_JEWEL);
			return reward;
		}
	},
	POITION_PROTECTION {
		@Override
		public Reward createReward(Point point) {
			Reward reward = new Reward(POITION_PROTECTION, point);
			initHitBox(reward, BOTTOM_LEFT, TOP_RIGHT_POITION_PROTECTION);
			return reward;
		}
	},
	TROPHY {
		@Override
		public Reward createReward(Point point) {
			Reward reward = new Reward(TROPHY, point);
			initHitBox(reward, BOTTOM_LEFT, TOP_RIGHT_TROPHY);
			return reward;
		}
	};
	
	private static final Point BOTTOM_LEFT = new Point(0, 0);
	private static final Point TOP_RIGHT_NOTHING = new Point(0, 0);
	private static final Point TOP_RIGHT_BULLET = new Point(1, 1);
	private static final Point TOP_RIGHT_HEART = new Point(1, 1);
	private static final Point TOP_RIGHT_JEWEL = new Point(1, 1);
	private static final Point TOP_RIGHT_POITION_PROTECTION = new Point(1, 1);
	private static final Point TOP_RIGHT_TROPHY = new Point(1, 1);
	
	public abstract Reward createReward(Point point);
	
	private static void initHitBox(Reward reward, Point bottomLeft, Point topRight) {
		Hitbox hitbox = new Hitbox(bottomLeft, topRight);
		reward.setHitbox(hitbox);
	}
	
}
