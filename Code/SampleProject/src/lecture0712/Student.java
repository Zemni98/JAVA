package lecture0712;

class Person {
	String name; // 이름
	String mobile; // 전화번호
}

// tightly coupled (강하게 결합 되었다)
class Student extends Person {
	String dept; // 학과
}

class Teacher extends Person {

	String subject; // 과목
}

class Staff extends Person {

	int salary; // 월급
}
