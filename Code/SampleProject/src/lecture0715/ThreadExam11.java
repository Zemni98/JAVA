package lecture0715;

class Shared {
	public synchronized void printName(String toName) {

		try {
			for (int i = 0; i < 12; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
				notify();
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace(); // 에러 메세지의 발생 근원지를 찾아 단계별로 에러 출력
		}

		// System.out.println(Thread.currentThread().getName());
	}
}

class ThreadEx_11 implements Runnable {
	Shared tn = new Shared();

	@Override
	public void run() {
		tn.printName(Thread.currentThread().getName());
	}
}

public class ThreadExam11 {
	public static void main(String[] args) throws InterruptedException {
		ThreadEx_11 r = new ThreadEx_11();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);

		t1.setName("첫번째 Thread!!");
		t2.setName("두번째 Thread!!");
		t3.setName("세번째 Thread!!");

		t1.start();
		// t1.join(10);

		t2.start();
		// t2.join(10);

		t3.start();
		// t3.join(10);
	}
}