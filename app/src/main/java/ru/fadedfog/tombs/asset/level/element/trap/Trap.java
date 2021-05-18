package ru.fadedfog.tombs.asset.level.element.trap;

import ru.fadedfog.tombs.asset.action.Atackable;
import ru.fadedfog.tombs.asset.action.Shootable;
import ru.fadedfog.tombs.asset.action.Spawnable;
import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.atack.AtackBehavior;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.shot.ShootBehavior;
import ru.fadedfog.tombs.asset.level.element.trap.behavior.spawn.SpawnTrapProjectileBehavior;

public abstract class Trap implements Atackable, Shootable, Spawnable {
	protected AtackBehavior atackBehavior;
	protected ShootBehavior shootBehavior;
	protected SpawnTrapProjectileBehavior spawnBehavior;
	private Hitbox hitbox;
	private Point point;
	private Turned turned;
	
	public Trap() {
		setTurned(Turned.DOWN);
	}
	
	public Trap(Point point, Turned turned) {
		this.point = point;
	}
	
	public abstract void initHitbox();
	
	public AtackBehavior getAtackBehavior() {
		return atackBehavior;
	}

	public void setAtackBehavior(AtackBehavior atackBehavior) {
		this.atackBehavior = atackBehavior;
	}
	
	public ShootBehavior getShootBehavior() {
		return shootBehavior;
	}

	public void setShootBehavior(ShootBehavior shootBehavior) {
		this.shootBehavior = shootBehavior;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Turned getTurned() {
		return turned;
	}

	public void setTurned(Turned turned) {
		this.turned = turned;
	}
	
}
