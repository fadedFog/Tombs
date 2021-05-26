package ru.fadedfog.tombs.asset.character.behavior.move;

public enum TypeMove {
	MOVABLE {
		@Override
		public MoveBehavior getMoveBehavior() {
			return new Movable();
		}
	},
	IMMOVABLE {
		@Override
		public MoveBehavior getMoveBehavior() {
			return new Immovable();
		}
	};
	
	public abstract MoveBehavior getMoveBehavior();
	
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
