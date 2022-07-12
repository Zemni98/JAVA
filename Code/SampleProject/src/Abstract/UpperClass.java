package Abstract;

// 추상클래스 (abstract class)
public abstract class UpperClass {
	String name;
	int age;

	// method
	public abstract void printAll(); // abstract method
}

class subClass extends UpperClass {
	@Override
	public void printAll() {
		// TODO Auto-generated method stub

	}
}