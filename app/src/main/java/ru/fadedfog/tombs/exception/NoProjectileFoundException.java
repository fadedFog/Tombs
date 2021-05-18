package ru.fadedfog.tombs.exception;

import ru.fadedfog.tombs.asset.projectile.TypeProjectile;

public class NoProjectileFoundException extends Exception {
	private static final long serialVersionUID = -3426608379346844690L;
	private TypeProjectile typeProjectile;
	
	public NoProjectileFoundException(TypeProjectile typeProjectile) {
		this.typeProjectile = typeProjectile;
	}
	
	@Override
	public String getMessage() {
		return "NNo projectile found. " + typeProjectile;
	}
	
}
