package lecture0715;

class ThreadEx_07_01 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
	}
}

class ThreadEx_07_02 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("|");
		}
	}
}

public class ThreadExam07 {
	public static void main(String[] args) {
		ThreadEx_07_01 t1 = new ThreadEx_07_01();
		ThreadEx_07_02 t2 = new ThreadEx_07_02();

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Main Thread 종료!");
	}
}
