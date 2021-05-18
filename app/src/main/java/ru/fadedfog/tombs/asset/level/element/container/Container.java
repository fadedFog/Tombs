package ru.fadedfog.tombs.asset.level.element.container;

import java.util.Random;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.reward.FactoryReward;
import ru.fadedfog.tombs.asset.reward.Reward;
import ru.fadedfog.tombs.asset.reward.TypeReward;

public class Container {
	private boolean isOpened;
	private Hitbox hitbox;
	private Point point;
	private Reward reward;
	private TypeContainer typeContainer;
	
	public Container(TypeContainer typeContainer, boolean isOpened, Point point) {
		this.setTypeContainer(typeContainer);
		this.isOpened = isOpened;
		this.point = point;
		this.reward = getRandomReward();
	}
	
	private Reward getRandomReward() {
		int numberRewards = TypeReward.values().length;
		int randomIdReward = getRandomNumberTo(numberRewards);
		initRewarFromFactory(randomIdReward);
		return reward;
	} 
	
	private int getRandomNumberTo(int bound) {
		Random random = new Random();
		return random.nextInt(bound);
	}
	
	private void initRewarFromFactory(int idReward) {
		TypeReward typeReward = TypeReward.values()[idReward];
		reward =  FactoryReward.makeReward(typeReward, point);
	}

	
	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public TypeContainer getTypeContainer() {
		return typeContainer;
	}

	public void setTypeContainer(TypeContainer typeContainer) {
		this.typeContainer = typeContainer;
	}
	
}
