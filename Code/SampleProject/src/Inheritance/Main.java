/*package Inheritance;

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
*/

/*class Person {
	String name;
	String mobile;

	public void printAll() {
		System.out.println("모두 출력!");
	}
}

class Student extends Person {

	public Student() {
		this.("홍길동"); // 이 뜻은 자신의 생성자중 다른 생성자를 가리킨다. 즉 밑에 name를 인자로 받는 Student로 간다.
	}
	
	public Student(String name) {
		
	}
	
	public void printAll() {
		System.out.println("오버라이딩!");
	}
}*/

public class Main {
	public static void main(String[] args) {
		Student s = new Student();

	}
}