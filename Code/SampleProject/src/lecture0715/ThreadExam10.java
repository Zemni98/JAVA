package lecture0715;

class toName {
	public synchronized void printName(String toName) {

		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
				notify();
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace(); // 에러 메세지의 발생 근원지를 찾아 단계별로 에러 출력
		}

	}
}

class ThreadEx_10 implements Runnable {
	toName tn = new toName();

	@Override
	public void run() {
		tn.printName(Thread.currentThread().getName());
	}
}

public class ThreadExam10 {
	public static void main(String[] args) throws InterruptedException {
		ThreadEx_10 r = new ThreadEx_10();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.setName("첫번째 Thread!!");
		t2.setName("두번째 Thread!!");

		t1.start();
		t1.join(10);
		t2.start();

	}
}
