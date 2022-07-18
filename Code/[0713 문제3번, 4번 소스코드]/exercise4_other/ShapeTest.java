package exercise4_other;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		
		List<Shape> list = new ArrayList<Shape>();
		list.add(new Rectangle(4, 7, 5));
		list.add(new Rectangle(5, 4, 6));
		list.add(new Circle(6, 6, 7));
		list.add(new Circle(7, 8, 3));
		
		for(Shape s : list) {
			if( s instanceof Circle ) {
				System.out.println(
					String.format("%10s %5s %5s %5s", s.getClass().getSimpleName(),
						((Circle)s).getRadius(), s.getPoint().getX(), s.getPoint().getY()) + "\t"
					+ String.format("%.0f", s.getArea()) + "\t"
					+ String.format("%.0f", s.getCircumference())
				);
			} else {
				System.out.println(
						String.format("%10s %5s %5s %5s", s.getClass().getSimpleName(),
							((Rectangle)s).getWidth(), s.getPoint().getX(), s.getPoint().getY()) + "\t"
						+ String.format("%.0f", s.getArea()) + "\t"
						+ String.format("%.0f", s.getCircumference())
					);				
			}
		}

		for(Shape s : list) {
			((Movable)s).move(10, 10);
		}
		
		System.out.println();
		
		for(Shape s : list) {
			if( s instanceof Circle ) {
				System.out.println(
					String.format("%10s %5s %5s %5s", s.getClass().getSimpleName(),
						((Circle)s).getRadius(), s.getPoint().getX(), s.getPoint().getY())
				);
			} else {
				System.out.println(
						String.format("%10s %5s %5s %5s", s.getClass().getSimpleName(),
							((Rectangle)s).getWidth(), s.getPoint().getX(), s.getPoint().getY())
					);				
			}			
		}
	}
	
}
