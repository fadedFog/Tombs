package ru.fadedfog.tombs.asset.character.behavior.jump;

public enum TypeJump {
	CANT_JUMPABLE {
		@Override
		public JumpBehavior getSpecificJump() {
			return new CantJumpable();
		}
	},
	JUMPABLE {
		@Override
		public JumpBehavior getSpecificJump() {
			return new Jumpable();
		}
	};
	
	public abstract JumpBehavior getSpecificJump();
}
