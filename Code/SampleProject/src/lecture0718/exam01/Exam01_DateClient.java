package lecture0718.exam01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_DateClient extends Application {

	TextArea textarea;
	Button connBtn;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // Window Size

		textarea = new TextArea();
		root.setCenter(textarea); // 화면 Center에 textarea를 붙인다!

		connBtn = new Button("Date 서버 접속");
		connBtn.setPrefSize(150, 40); // 버튼 크기
		connBtn.setOnAction(e -> {
			textarea.clear();

			try {
				// Server Process에 접속 시도
				Socket socket = new Socket("localhost", 5678);
				// 접속이 성공했으니 이제 Stream을 열어보아요!
				InputStreamReader ir = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(ir);

				String msg = br.readLine(); // blocking method => 자신이 읽을게 있을 때까지 대기한다.

				textarea.appendText(msg + "\n"); // 나중에 문제생길 수 있어요!

				// 사용이 종료되면 사용한 자원을 반납해야한다.
				br.close();
				ir.close();
				socket.close();

				textarea.appendText("서버와의 연결이 종료되었어요!");

			} catch (Exception e2) {

			}
		});

		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.setColumnHalignment(HPos.CENTER);

		// flowPane에 Button 붙이기
		flowPane.getChildren().add(connBtn);

		root.setBottom(flowPane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}
