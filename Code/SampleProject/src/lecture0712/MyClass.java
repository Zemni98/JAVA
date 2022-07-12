package lecture0712;

public class MyClass {
	int aaa;
	static int bbb = staticCall();

	// 생성자
	public MyClass() {

	}

	// static block
	static {
		System.out.println("static block");
	}
	// main이 실행되기 직전에 다른 library 같은것들을 loading할 필요가 있을 때

	static int staticCall() {
		System.out.println("호출되었어요!");
		return 100;
	}

	public static void main(String[] args) {
		System.out.println("Main 호출");
	}
}
