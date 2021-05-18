package ru.fadedfog.tombs.asset.geometry;

public class Hitbox {
	private Point bottomLeft;
	private Point bottomRight; 
	private Point topLeft;
	private Point topRight;
	
	public Hitbox(Point bottomLeft, Point bottomRight, 
			Point topLeft, Point topRight) {
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
		this.topLeft = topLeft;
		this.topRight = topRight;
	} 
	
	public Hitbox(Point bottomLeft, Point topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
		this.bottomRight = getPointCorner(bottomLeft, topRight);
		this.topLeft = getPointCorner(topRight, bottomLeft);
	}
	
	private Point getPointCorner(Point first, Point last) {
		double yFirst = first.getY();
		double xLast = last.getX();
		return new Point(xLast, yFirst);
	}

	public Point getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(Point bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(Point bottomRight) {
		this.bottomRight = bottomRight;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}

	public Point getTopRight() {
		return topRight;
	}

	public void setTopRight(Point topRight) {
		this.topRight = topRight;
	}
	
	
}
