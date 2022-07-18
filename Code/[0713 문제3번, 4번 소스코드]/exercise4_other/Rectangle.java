package exercise4_other;

public class Rectangle extends Shape implements Movable {

	private int width;
	
	public Rectangle() {
	}
	
	public Rectangle(int width, int x, int y) {
		super(new Point(x,y));
		this.width = width;		
	}

	@Override
	public void move(int x, int y) {
		getPoint().setX(getPoint().getX() + (x+2));  
		getPoint().setY(getPoint().getY() + (y+2));		
	}

	@Override
	public double getArea() {
		return Math.pow(this.getWidth(),2);
	}

	@Override
	public double getCircumference() {
		return this.getWidth() * 4;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public String toString() {
		return String.format("%10s %5s %5s %5s", this.getClass().getSimpleName(),
				this.getWidth(), this.getPoint().getX(), this.getPoint().getY());	
	}	
}
