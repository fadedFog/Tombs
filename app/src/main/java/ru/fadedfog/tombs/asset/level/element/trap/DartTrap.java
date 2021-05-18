package ru.fadedfog.tombs.asset.level.element.trap;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.atack.AtackNoWay;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.shot.ShootDart;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.spawn.SpawnDart;
import ru.fadedfog.tombs.asset.projectile.Dart;

public class DartTrap extends Trap {
	private Dart dart;
	
	public DartTrap() {
		super();
		this.atackBehavior = new AtackNoWay();
		this.shootBehavior = new ShootDart();
		this.spawnBehavior = new SpawnDart();
	}
	
	public DartTrap(Point point, Turned turned) {
		super(point, turned);
		this.atackBehavior = new AtackNoWay();
		this.shootBehavior = new ShootDart();
		this.spawnBehavior = new SpawnDart();
	}
	
	@Override
	public void initHitbox() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(0.5, 0.5);
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
	
	public Dart getDart() {
		return dart;
	}

	public void setDart(Dart dart) {
		this.dart = dart;
	}
	
}
