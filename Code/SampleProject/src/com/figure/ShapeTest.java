package com.figure;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {

		List<Shape> list = new ArrayList<Shape>();
		list.add(new Rectangle(4, 7, 5));
		list.add(new Rectangle(5, 4, 6));
		list.add(new Circle(6, 6, 7));
		list.add(new Circle(7, 8, 3));
		System.out.println("    구분\t      길이   X좌표  Y좌표  Area  Circumference");
		for (Shape s : list) {
			System.out.println(s.toString() + "\t" + String.format("%.0f", s.getArea()) + "\t"
					+ String.format("%.0f", s.getCircumference()));
		}

		for (Shape s : list) {
			((Movable) s).move(10, 10);
		}

		System.out.println("이동후...");

		for (Shape s : list) {
			System.out.println(s);
		}
	}

}