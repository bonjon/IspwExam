package logic;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view.fxml.fxml")); 
			Scene mainScene = new Scene(root,350,350);
			primaryStage.setTitle("CalculatorFXML");
			primaryStage.setScene(mainScene);
			primaryStage.setMaxWidth(350);
			primaryStage.setMaxHeight(370);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
