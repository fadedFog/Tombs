package ru.fadedfog.tombs.asset.reward;

import ru.fadedfog.tombs.exception.NoRewardFoundException;

public class FactoryReward {

	public static Reward makeReward(TypeReward typeReward) 
			throws NoRewardFoundException {
		switch (typeReward) {
			case BULLET:
				return new Bullet();
			case HEART:
				return new Heart();
			case JEWEL:
				return new Jewel();
			case POITION_PROTECTION:
				return new PoitionProtection();
			case TROPHY:
				return new Trophy();
			default:
				throw new NoRewardFoundException(typeReward);
		}
	}
	
}
