package ru.fadedfog.tombs.asset.projectile;

import ru.fadedfog.tombs.asset.geometry.Point;

public class FactoryProjectile {
	
	public static Projectile makeProjectile(TypeProjectile typeProjectile, Point point)  {
		return typeProjectile.createProjectile(point);
	}
	
}
