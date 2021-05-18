package ru.fadedfog.tombs.asset.character.behavior.death;

public enum TypeKill {
	KILLABLE {
		@Override
		public KillBehavior getSpecificKill() {
			return new Killable();
		}
	},
	CANT_KILLABLE {
		@Override
		public KillBehavior getSpecificKill() {
			return new CantKillable();
		}
	};
	
	public abstract KillBehavior getSpecificKill();
}
