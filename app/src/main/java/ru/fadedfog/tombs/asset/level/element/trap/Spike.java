package ru.fadedfog.tombs.asset.level.element.trap;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.atack.AtackIntant;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.shot.ShootNoWay;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.spawn.SpawnNoWay;

public class Spike extends Trap {

	public Spike() {
		super();
		this.atackBehavior = new AtackIntant();
		this.shootBehavior = new ShootNoWay();
		this.spawnBehavior = new SpawnNoWay();
	}
	
	public Spike(Point point, Turned turned) {
		super(point, turned);
		this.atackBehavior = new AtackIntant();
		this.shootBehavior = new ShootNoWay();
		this.spawnBehavior = new SpawnNoWay();
	}
	
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(0.5, 2);
		setHitbox(new Hitbox(point1, point2));
	}
	
	@Override
	public void atack() {
		atackBehavior.atack();
	}

	@Override
	public void shoot() {
		shootBehavior.shoot();
	}

	@Override
	public void spawn() {
		spawnBehavior.spawn();
	}

}
