package ru.fadedfog.tombs.asset.character.behavior.move;

import ru.fadedfog.tombs.settings.SettingsGame;

public enum TypeMove {
	MOVABLE {
		@Override
		public MoveBehavior getMoveBehavior(SettingsGame settingsGame) {
			return new Movable(settingsGame);
		}
	},
	IMMOVABLE {
		@Override
		public MoveBehavior getMoveBehavior(SettingsGame settingsGame) {
			return new Immovable(settingsGame);
		}
	};
	
	public abstract MoveBehavior getMoveBehavior(SettingsGame settingsGame);
	
	public static TypeMove getTypeMove(MoveBehavior moveBehavior) {
		TypeMove typeMove;
		if (moveBehavior instanceof Movable) {
			typeMove = TypeMove.MOVABLE;
		} else {
			typeMove = TypeMove.IMMOVABLE;
		}
		return typeMove;
	}
}
