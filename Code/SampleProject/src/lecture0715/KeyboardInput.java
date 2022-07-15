package lecture0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardInput {

	public static void main(String[] args) {
		System.out.println("키보드로 한 줄을 입력하세요!");

		// 키보드(표준입력 - System.in)을 통해 데이터를 1줄 입력받을거에요!
		// 이 System.in 이라는 제공된 Stream은 사용하기 너무 힘들다.
		InputStreamReader isr = new InputStreamReader(System.in);
		// 한 줄을 읽어들이는 기능이 없는 통로이다.
		// 얘를 이용해서 다른 통로를 만든다.
		BufferedReader br = new BufferedReader(isr);
		// 이 통로가 가지고있는 method를 이용해서 연결되어 있는 주체의 data를 읽어들인다.

		try {
			String input = br.readLine();
			System.out.println("입력받은 문자열은: " + input);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
