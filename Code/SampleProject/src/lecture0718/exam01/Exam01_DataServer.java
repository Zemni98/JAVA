package lecture0718.exam01;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Server Process
public class Exam01_DataServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5678);
			System.out.println("Date Server Start = PortNumber(5678)");
			Socket socket = serverSocket.accept(); // blocking
			// 접속이 성공했어요!
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			// 현재 날짜를 구해보아요!

			Date date = new Date();
			pr.println(date.toLocaleString()); // 버퍼를 이용한 스트림
			// 버퍼안에 들어가 있는 데이터를 스트림을 통해 내보내는 시점은
			// 1. 스트림이 강제로 종료될 경우 (close)
			// 2. 버퍼의 공간이 다 찰 경우
			// 3. method를 이용해서 flush()시킬 경우

			pr.flush();
			pr.close();
			socket.close();
			serverSocket.close();
			System.out.println("Date Server 종료");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
