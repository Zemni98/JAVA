package lecture0712;

public class Main {
	public static void main(String[] args) {

		InstanceTest test; // 지역변수, method내에서 선언이 이루어졌다.
		System.out.println("3번");
		int k = InstanceTest.myCall("4번");
		test = new InstanceTest();
		test.printMsg("5번");
	}
}
