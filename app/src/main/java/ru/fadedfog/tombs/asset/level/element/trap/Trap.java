package ru.fadedfog.tombs.asset.level.element.trap;

import ru.fadedfog.tombs.asset.geometry.Hitbox;
import ru.fadedfog.tombs.asset.geometry.Point;

public class Trap  {
	private Hitbox hitbox;
	private Point point;
	private Turned turned;
	private TypeTrap typeTrap;
	
	public Trap() {
	}
	
	public Trap(TypeTrap typeTrap, Point point) {
		this.typeTrap = typeTrap;
		this.point = point;
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

	public TypeTrap getTypeTrap() {
		return typeTrap;
	}

	public void setTypeTrap(TypeTrap typeTrap) {
		this.typeTrap = typeTrap;
	}
	
}
