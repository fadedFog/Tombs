package ru.fadedfog.tombs.asset.character.behavior.move;

public enum TypeMove {
	MOVEABLE {
		@Override
		public MoveBehavior getMoveBehavior() {
			return new Moveable();
		}
	},
	CANT_MOVEABLE {
		@Override
		public MoveBehavior getMoveBehavior() {
			return new CantMoveable();
		}
	};
	
	public abstract MoveBehavior getMoveBehavior();
	
	public static TypeMove getTypeMove(MoveBehavior moveBehavior) {
		TypeMove typeMove;
		if (moveBehavior instanceof Moveable) {
			typeMove = TypeMove.MOVEABLE;
		} else {
			typeMove = TypeMove.CANT_MOVEABLE;
		}
		return typeMove;
	}
}
