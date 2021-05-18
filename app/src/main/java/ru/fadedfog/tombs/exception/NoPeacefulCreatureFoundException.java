package ru.fadedfog.tombs.exception;

import ru.fadedfog.tombs.asset.character.npc.peaseful.TypePeacefulCreature;

public class NoPeacefulCreatureFoundException extends Exception{
	private static final long serialVersionUID = -1726386363974143935L;
	private TypePeacefulCreature typePeacefulCreature;
	
	public NoPeacefulCreatureFoundException(TypePeacefulCreature typePeacefulCreature) {
		this.typePeacefulCreature = typePeacefulCreature;
	}
	
	@Override
	public String getMessage() {
		return "No peaceful creature found. " + typePeacefulCreature;
	}
}
