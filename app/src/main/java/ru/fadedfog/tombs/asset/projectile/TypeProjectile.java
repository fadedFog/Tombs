package ru.fadedfog.tombs.asset.projectile;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public enum TypeProjectile {
	ARROW {
		@Override
		public Projectile createProjectile(Point point) {
			Projectile projectile = new Projectile(ARROW, START_VELOCITY, START_VELOCITY, point);
			initParameters(projectile, BOTOM_LEFT, TOP_RIGHT_ARROW, START_VELOCITY, START_VELOCITY);
			return projectile;
		}
	},
	BOULDER {
		@Override
		public Projectile createProjectile(Point point) {
			Projectile projectile = new Projectile(BOULDER, START_VELOCITY, START_VELOCITY, point);
			initParameters(projectile, BOTOM_LEFT, TOP_RIGHT_BOULDER, START_VELOCITY, START_VELOCITY);
			return projectile;
		}
	},
	BULLET_FIRED {
		@Override
		public Projectile createProjectile(Point point) {
			Projectile projectile = new Projectile(BULLET_FIRED, START_VELOCITY, START_VELOCITY, point);
			initParameters(projectile, BOTOM_LEFT, TOP_RIGHT_BULLET_FIRED, START_VELOCITY, START_VELOCITY);
			return projectile;
		}
	},
	DART {
		@Override
		public Projectile createProjectile(Point point) {
			Projectile projectile = new Projectile(DART, START_VELOCITY, START_VELOCITY, point);
			initParameters(projectile, BOTOM_LEFT, TOP_RIGHT_DART, START_VELOCITY, START_VELOCITY);
			return projectile;
		}
	};
	
	private static final double START_VELOCITY = 0;
	private static final Point BOTOM_LEFT = new Point(0, 0);
	private static final Point TOP_RIGHT_ARROW = new Point(0.5, 0.25);
	private static final Point TOP_RIGHT_BOULDER = new Point(0.75, 0.75);
	private static final Point TOP_RIGHT_BULLET_FIRED = new Point(0.25, 0.25);
	private static final Point TOP_RIGHT_DART = new Point(0.5, 0.25);
	
	public abstract Projectile createProjectile(Point point);
	
	private static void initParameters(Projectile projectile,  Point borromLeft, Point topRight, double xVelocity, double yVelocity) {
		Hitbox hitbox = new Hitbox(borromLeft, topRight);
		projectile.setHitbox(hitbox);
		projectile.setxVelocity(xVelocity);
		projectile.setyVelocity(yVelocity);
	}
}
