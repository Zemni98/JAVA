package lecture0714;

// Daemon Thread에 대해서 알아보아요!
public class ThreadExam02 implements Runnable {
	static boolean autoSave = false;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

			}
			if (autoSave) {
				System.out.println("자동저장 되었습니다!");
			}
		}

	}

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadExam02());
		t.setDaemon(true);

		t.start();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			System.out.println(i);

			if (i == 5) {
				autoSave = true;
			}
		}
	}

}
