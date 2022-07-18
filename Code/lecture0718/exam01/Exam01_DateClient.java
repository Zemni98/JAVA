package lecture0718.exam01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javafx.application.Application;
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
		root.setPrefSize(700, 500); // window 크기
		
		textarea = new TextArea();
		root.setCenter(textarea);  // 화면 center에 textarea를 붙여요!
		
		connBtn = new Button("Date 서버 접속");
		connBtn.setPrefSize(150, 40); // 버튼의 크기
		connBtn.setOnAction(e -> {
			textarea.clear();
			try {
				// 서버 process에 접속을 시도
				Socket socket = new Socket("localhost",5678);
				// 접속이 성공했으니 이제 stream을 열어보아요!
				InputStreamReader ir = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(ir);
				
				String msg = br.readLine();  // blocking
				
				textarea.appendText(msg + "\n");  // 나중에 문제생길 수 있어요!
				
				// 사용한 자원을 반납
				br.close();
				ir.close();
				socket.close();
				
				textarea.appendText("서버와의 연결이 종료되었어요!");
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10)); // 여백을 줘요!
		flowPane.setPrefSize(700,40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn);   // 버튼 부착
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}





