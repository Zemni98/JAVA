package lecture0715;

// Thread에 의해서 공유되는 공유객체를 생성하기 위한 class
class Account {
	private int balance = 1000; // 계좌 잔액

	public int getBalance() {
		return balance;
	}

	// 출금하는 method = 동기화 시켜야 문제를 해결할 수 있다.
	// synchronized method를 붙여주면
	// 두개의 Thread가 출금 method를 동시에 처리 할 수 없게 만든다.
	public synchronized void withDraw(int money) {
		synchronized (this) { // 어떤 객체를 동기화 시켜줄시 명시해준다
			// 동기화 시켜줄 block을 지정할 수 있다.
			if (balance >= money) {
				try {
					Thread.sleep(1000);
					// 잔액을 바로 빼지 않고 자고있어서 자는동안 다른 Thread가 조건을 만족하니까 if문을 타고 들어와서 잔액을 뺀다.
					// 즉 Logic은 남은 잔액이 출금할려는 잔액보다 커야만 출금을 할 수 있는데 남은 잔액이 -가 찍힐 수 있다.
					// 두개의 Thread가 동시에 돌게 되면 이런 오류가 발생할 수 있다.

				} catch (Exception e) {
					// TODO: handle exception
				}
				balance -= money;
			}
		}

	}

}

class ThreadEx_09 implements Runnable {
	Account acc = new Account();

	@Override
	public void run() {
		while (acc.getBalance() > 0) {
			int money = ((int) (Math.random() * 3 + 1) * 100); // 1 ~ 4 사이의 랜덤한 정수가 나온다.
			acc.withDraw(money);
			System.out.println("출금 액: " + money);
			System.out.println("남은 잔액은 : " + acc.getBalance());
		}
	}
}

public class ThreadExam09 {
	public static void main(String[] args) {
		ThreadEx_09 r = new ThreadEx_09(); // Runnable 객체 (공유객체 가지고 있다.)
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}
