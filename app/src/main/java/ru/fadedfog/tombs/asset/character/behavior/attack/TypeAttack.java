package ru.fadedfog.tombs.asset.character.behavior.attack;

public enum TypeAttack {
	ATTACKABLE {
		@Override
		public AttackBehavior getAttackBehavior() {
			return new Attackable();
		}
	},
	CANT_ATTACKABLE {
		@Override
		public AttackBehavior getAttackBehavior() {
			return new CantAttackable();
		}
	};
	
	public abstract AttackBehavior getAttackBehavior();
}
