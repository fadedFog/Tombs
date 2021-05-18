package ru.fadedfog.tombs.asset.projectile;

import ru.fadedfog.tombs.exception.NoProjectileFoundException;

public class FactoryProjectile {
	
	public static Projectile makeProjectile(TypeProjectile typeProjectile) 
			throws NoProjectileFoundException {
		switch (typeProjectile) {
			case ARROW:
				return new Arrow();
			case BOULDER:
				return new Boulder();
			case BULLET_FIRED:
				return new BulletFired();
			case DART:
				return new Dart();
			default:
				throw new NoProjectileFoundException(typeProjectile);
		}
	}
	
}
