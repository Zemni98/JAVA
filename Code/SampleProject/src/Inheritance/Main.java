package Inheritance;

class Person extends Object { // 최상위 클래스의 constructor를 호출해서 instance를 만든다.
								// Object를 감싸는 Person이라는 instance를 만든다.
	public Person() {
		super();
		System.out.println("AA");
	}

	String name;
	String mobile;
}

class Student extends Person {
	public Student() {
		super();
		System.out.println("BB");
	}

	String dept;
}

public class Main {
	public static void main(String[] args) {
//		Person p = new Person();
		Student s = new Student();
//		Person s = new Student();
//		Object s = new Student();
		// is-a relationship
		// subclass is a superclass
	}
}