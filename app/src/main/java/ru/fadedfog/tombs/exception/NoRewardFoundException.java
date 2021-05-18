package ru.fadedfog.tombs.exception;

import ru.fadedfog.tombs.asset.reward.TypeReward;

public class NoRewardFoundException extends Exception{
	private static final long serialVersionUID = -7575397676394992451L;
	private TypeReward typeReward;
	
	public NoRewardFoundException(TypeReward typeReward) {
		this.typeReward = typeReward;
	}
	
	@Override
	public String getMessage() {
		return "No reward found. " + typeReward;
	}

}
