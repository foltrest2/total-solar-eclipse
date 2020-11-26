package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	private TotalSolarEclipseGUI tsegui;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		tsegui = new TotalSolarEclipseGUI(primaryStage);
		
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("eclipsing.fxml"));
		fxmll.setController(tsegui);
		Parent root = fxmll.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("A beautiful eclipse");
		primaryStage.show();
	}

}
