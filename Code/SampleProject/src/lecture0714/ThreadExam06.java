package lecture0714;

class ThreadEx_06 implements Runnable {
	volatile boolean suspended = false; // volatile 캐시메모리에서 변수값 가져오지말고 memory에서 직접 땡겨오게하는 명령어
	volatile boolean stopped = false;

	@Override
	public void run() {
		while (!stopped) {
			if (!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

	}

	public void suspend() {
		suspended = true;
	}

	public void stop() {
		stopped = true;
	}

	public void resume() {
		suspended = false;
	}
}

public class ThreadExam06 {
	public static void main(String[] args) {
		ThreadEx_06 r1 = new ThreadEx_06();
		ThreadEx_06 r2 = new ThreadEx_06();
		ThreadEx_06 r3 = new ThreadEx_06();

		Thread T1 = new Thread(r1, "*");
		Thread T2 = new Thread(r2, "**");
		Thread T3 = new Thread(r3, "***");

		T1.start();
		T2.start();
		T3.start();
		try {
			Thread.sleep(2000);
			r1.suspend(); // T1 일시정지
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(2000);
			r1.resume(); // T1 다시 동작
			Thread.sleep(3000);
			r2.stop();
			Thread.sleep(2000);
			r3.suspend();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
