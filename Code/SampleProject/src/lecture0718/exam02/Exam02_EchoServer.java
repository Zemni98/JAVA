package lecture0718.exam02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Server Process
public class Exam02_EchoServer {

	public static void main(String[] args) {
		PrintWriter pr = null;
		BufferedReader br = null;
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(1998);
			System.out.println("Date Server Start = 클라이언트 접속 대기");
			socket = serverSocket.accept(); // blocking
			// 접속이 성공했어요!
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pr = new PrintWriter(socket.getOutputStream());

			String msg = null;

			while (true) {
				msg = br.readLine();
				if (msg.equals("/exit") || (msg == null)) {
					break;
				}
				pr.println(msg);
				pr.flush();
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 사용된 resourcer 해제

			try {
				if (br != null)
					br.close();
				if (pr != null)
					pr.close();
				if (socket != null)
					socket.close();
				if (serverSocket != null)
					serverSocket.close();
				System.out.println("Echo Server 종료!!");
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
}
