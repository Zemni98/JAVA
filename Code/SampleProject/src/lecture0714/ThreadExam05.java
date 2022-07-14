package lecture0714;

class ThreadEx_05 implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName());
			try {
				System.out.println("---------------------");
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}

public class ThreadExam05 {
	public static void main(String[] args) {
		ThreadEx_05 r = new ThreadEx_05();
		Thread T1 = new Thread(r, "*");
		Thread T2 = new Thread(r, "**");
		Thread T3 = new Thread(r, "***");

		T1.start();
		T2.start();
		T3.start();
		try {
			Thread.sleep(2000);
			// T1.suspend(); // T1 일시정지
			Thread.sleep(2000);
			// T2.suspend();
			Thread.sleep(2000);
			// T1.resume(); // T1 다시 동작
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
