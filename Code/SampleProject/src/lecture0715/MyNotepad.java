package lecture0715;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// Notepad를 만들어 보아요!
// JavaFX를 이용할 겁니다!
public class MyNotepad extends Application {
	TextArea textarea;
	Button openBtn, saveBtn;
	File file;

	private void printMsg(String msg) {
		Platform.runLater(() -> { // JavaFx가 가지고 있는 Thread 동기화 기능을 사용
			// 이것을 안쓸려면 따로 동기화 설정을 해줘야한다.
			textarea.appendText(msg + "\n");
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		// 화면을 구성하는 전체 핀.

		root.setPrefSize(700, 500);
		// BorderPane의 가로,세로 길이

		// TextArea 생성
		textarea = new TextArea();
		root.setCenter(textarea);

		// Button 생성
		openBtn = new Button("File Open");
		openBtn.setPrefSize(150, 40);
		openBtn.setOnAction(e -> {
			// Open할 File을 찾아서 그 내용을 TextArea에 출력시킨다.
			textarea.clear(); // 새로운 내용을 넣어야 하기 때문에 Textarea의 내용을 다 지운다.
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open File Choose!!");
			file = fileChooser.showOpenDialog(primaryStage);
			try {
				FileReader fr = new FileReader(file); // File로부터 문자열 단위로 읽어오는 Stream
				BufferedReader br = new BufferedReader(fr); // FileReader를 가지고 더 좋은 통로를 만든다.
				String line = "";
				while ((line = br.readLine()) != null) {
					printMsg(line);
				}
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {

			}
			System.out.println(file);
		});
		/*
		 * openBtn.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent arg0) {
		 * System.out.println("Button Clicked!");
		 * 
		 * } });
		 */

		saveBtn = new Button("File Save");
		saveBtn.setPrefSize(150, 40);
		saveBtn.setOnAction(e -> {
			String text = textarea.getText();
			try {
				FileWriter fw = new FileWriter(file); // 얘는 그냥 쓸만한 Stream이다.
				fw.write(text);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10); // 컴포넌트간의 간격

		// flowPane에 Button 붙이기
		flowPane.getChildren().add(openBtn);
		flowPane.getChildren().add(saveBtn);

		root.setBottom(flowPane);

		// Scene 객체를 생성
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Notepan");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
