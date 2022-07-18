package lecture0718.exam02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {
	TextArea textarea;
	Button connBtn;
	TextField idfield, textfield;

	Socket socket;
	BufferedReader br;
	PrintWriter pr;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // Window Size

		textarea = new TextArea();
		root.setCenter(textarea); // 화면 Center에 textarea를 붙인다!

		connBtn = new Button("Echo 서버 접속");
		connBtn.setPrefSize(150, 40); // 버튼 크기
		connBtn.setOnAction(e -> {
			textarea.clear();
			try {
				socket = new Socket("localhost", 1998);
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pr = new PrintWriter(socket.getOutputStream());
				textarea.appendText("Echo Server 접속 성공!!" + "\n");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
		idfield = new TextField();
		idfield.setPrefSize(100, 40);

		textfield = new TextField();
		textfield.setPrefSize(200, 40);
		textfield.setOnAction(e -> {
			String msg = idfield.getText() + " : " + textfield.getText();
			pr.println(msg);
			pr.flush();

			if (textfield.getText().equals("/exit")) {
				textarea.appendText("서버와의 연결을 종료합니다!!");
				textfield.setDisable(true);
			} else {
				try {
					String serverMsg = br.readLine();
					textarea.appendText(serverMsg + "\n");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			textfield.clear();
		});

		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.setColumnHalignment(HPos.CENTER);

		// flowPane에 Button 붙이기
		flowPane.getChildren().add(connBtn);
		// flowPane에 idfield 붙이기
		flowPane.getChildren().add(idfield);
		// flowPane에 Textfield 붙이기
		flowPane.getChildren().add(textfield);

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
