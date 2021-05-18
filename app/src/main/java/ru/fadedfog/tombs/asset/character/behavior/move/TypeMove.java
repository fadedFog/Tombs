package ru.fadedfog.tombs.asset.character.behavior.move;

public enum TypeMove {
	MOVEABLE {
		@Override
		public MoveBehavior getSpecificMove() {
			return new Moveable();
		}
	},
	CANT_MOVEABLE {
		@Override
		public MoveBehavior getSpecificMove() {
			return new CantMoveable();
		}
	};
	
	public abstract MoveBehavior getSpecificMove();
}
