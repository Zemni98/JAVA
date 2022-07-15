package lecture0715;

class ThreadEx_08_01 extends Thread {
	final static int MAX_MEMORY = 1000;
	// 상수 만들때는 모두 대문자,Snake 표기법이 일반적이다.
	int usedMemory = 0;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10000); // 10초 동안 잔다.
			} catch (Exception e) {
				System.out.println("interrupt( )에 의해서 깨어났습니다.");
			}
			gc();
			System.out.println("Memory 청소 완료!  " + "현재 사용가능한 Memory :" + freeMemory());
		}
	}

	private void gc() {
		// 내부에서만 사용하는 logic용 method이기 때문에 private로 쓰는게 좋다.
		usedMemory -= 300;
		if (usedMemory < 0) {
			usedMemory = 0;
		}
	}

	public int totalMemory() {
		return MAX_MEMORY;
	}

	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}
}

public class ThreadExam08 {
	public static void main(String[] args) {
		ThreadEx_08_01 t1 = new ThreadEx_08_01();
		t1.setDaemon(true);
		t1.start();

		int requiredMemory = 0;
		for (int i = 0; i < 20; i++) {
			requiredMemory = (int) (Math.random() * 10) * 20;
			// Math.random() => 0.0보다 크거나 같고 1.0보다는 작은 랜덤한 실수가 나온다.
			// Math.random() * 10 => 10을 곱하니까 0 ~ 10 사이의 랜덤한 실수가 나온다.
			// 거기에 * 20 하니까 0 ~ 200 사이의 랜덤한 실수가 나오게 된다.
			// (int)로 type casting했으니까 0 ~ 200사이의 정수가 나온다.

			// 필요한 Memory가 사용할 수 있는 양보다 크거나
			// 현재의 전체 Memory양의 60%이상을 사용하고 있을때 gc를 실행
			if (requiredMemory > t1.freeMemory() || t1.freeMemory() < t1.totalMemory() * 0.4) {
				t1.interrupt(); // gc()실행이 끝날때까지 기다리지 않는다.
				try {
					t1.join();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			t1.usedMemory += requiredMemory;
			System.out.println("사용된 Memory : " + t1.usedMemory);
		}
	}
}
