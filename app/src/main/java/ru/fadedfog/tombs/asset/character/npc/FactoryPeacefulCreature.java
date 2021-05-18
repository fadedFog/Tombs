package ru.fadedfog.tombs.asset.character.npc;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.npc.peaseful.Mouse;
import ru.fadedfog.tombs.asset.character.npc.peaseful.TypePeacefulCreature;
import ru.fadedfog.tombs.exception.NoPeacefulCreatureFoundException;

public class FactoryPeacefulCreature {

	public static Character makePeacefulCreature(TypePeacefulCreature typePeacefulCreature) 
			throws NoPeacefulCreatureFoundException {
		switch (typePeacefulCreature) {
			case MOUSE:
				return new Mouse();
			default: throw new NoPeacefulCreatureFoundException(typePeacefulCreature);
		}
	}
	
}
