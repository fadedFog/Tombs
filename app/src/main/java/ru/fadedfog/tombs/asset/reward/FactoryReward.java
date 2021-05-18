package ru.fadedfog.tombs.asset.reward;

import ru.fadedfog.tombs.asset.geometry.Point;

public class FactoryReward {

	public static Reward makeReward(TypeReward typeReward, Point point) {
		return typeReward.createReward(point);
	}
	
}
