package ru.fadedfog.tombs.asset.level.element.trap;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.atack.AtackNoWay;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.shot.ShootBoulder;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.spawn.SpawnBoulder;
import ru.fadedfog.tombs.asset.projectile.Boulder;

public class BoulderHolder extends Trap {
	private Boulder boulder;
	
	public BoulderHolder() {
		super();
		this.atackBehavior = new AtackNoWay();
		this.shootBehavior = new ShootBoulder();
		this.spawnBehavior = new SpawnBoulder();
	}
	
	public BoulderHolder(Point point, Turned turned) {
		super(point, turned);
		this.atackBehavior = new AtackNoWay();
		this.shootBehavior = new ShootBoulder();
		this.spawnBehavior = new SpawnBoulder();
	}
	
	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 1);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void shoot() {
		shootBehavior.shoot();
	}

	@Override
	public void atack() {
		atackBehavior.atack();
	}
	
	@Override
	public void spawn() {
		spawnBehavior.spawn();
	}
	
	public Boulder getBoulder() {
		return boulder;
	}

	public void setBoulder(Boulder boulder) {
		this.boulder = boulder;
	}

}
