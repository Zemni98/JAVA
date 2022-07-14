package com.figure;

public abstract class Shape {
	protected Point point;

	public Shape() {
		super();
	}

	public Shape(Point point) {
		super();
		this.point = point;
	}

	public abstract double getArea();

	public abstract double getCircumference();

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

}
