package exercise4_other;

public class Circle extends Shape implements Movable {

	private int radius;
	
	public Circle() {
	
	}

	public Circle(int radius, int x, int y) {		
		super(new Point(x,y));
		this.radius = radius;
	}

	@Override
	public void move(int x, int y) {
		getPoint().setX(getPoint().getX() + (x+1));  
		getPoint().setY(getPoint().getY() + (y+1));
	}

	@Override
	public double getArea() {		
		return Math.PI * Math.pow(this.getRadius(),2);
	}

	@Override
	public double getCircumference() {
		return Math.PI * this.getRadius() * 2;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return String.format("%10s %5s %5s %5s", this.getClass().getSimpleName(),
				this.getRadius(), this.getPoint().getX(), this.getPoint().getY());		  				
	}
	
	
}
