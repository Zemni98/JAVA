package lecture0714;

import javax.swing.JOptionPane;

class ThreadEx_04 extends Thread {
	/*
	 * @Override public void run() { int i = 10; while (i != 0 && !isInterrupted())
	 * { System.out.println(--i); try { Thread.sleep(4000); // for (long k = 0; k <
	 * 2500000000L; k++) ; // 일정량의 시간을 끄는 더미코드
	 * 
	 * } catch (Exception e) { interrupt(); System.out.println("Thread 상태값 2 : " +
	 * isInterrupted()); System.out.println("Count End!"); }
	 * 
	 * }
	 */
	// }
	@Override
	public void run() {

		for (long k = 0; k < 2500000000L; k++)
			;
	}

}

public class ThreadExam04 {
	public static void main(String[] args) {
		Thread t = new ThreadEx_04();
		t.run();
		String input = JOptionPane.showInputDialog("값을 입력하세요!"); // blocking method 이므로 수행자체가 값을 입력하고 OK 누르기전까지 멈춰있는다.
		System.out.println("입력값은 :" + input);

		t.interrupt();
		System.out.println("Thread 상태값 1 : " + t.isInterrupted());
	}
}
