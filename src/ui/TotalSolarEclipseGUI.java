package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Moon;

public class TotalSolarEclipseGUI {

	@FXML
	private AnchorPane moon;

	@FXML
	private Pane mainPane;

	private Stage window;

	private Moon m;

	boolean bouncing;

	public TotalSolarEclipseGUI(Stage st) {
		window = st;
		bouncing = true;
	}

	public final static double STEP = 25; 

	public void initialize() {
		m = new Moon(moon.getLayoutX(), 96);

		window.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				bouncing = false;
				System.out.println("Closing the window!");
			}
		});

	}

	@FXML
	public void move(ActionEvent event) {
		m.setMax(window.getWidth());
		new Thread() {
			public void run() {
				while(bouncing) {
					m.move();
					changes();
					Platform.runLater(new Thread() {
						public void run() {
							updateMoon(m.getX());
						}
					});

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

	}

	public void updateMoon(double x) {
		moon.setLayoutX(x);
	}

	private void changes() {
		//primera mitad
		if((moon.getLayoutX() >= 162 &&  moon.getLayoutX() < 182)|| (moon.getLayoutX() >= 330 &&  moon.getLayoutX() < 341)) {	
			mainPane.setBackground(new Background(new BackgroundFill(Color.web("#48D1CC"), null, null)));
		}else if((moon.getLayoutX() >= 182 &&  moon.getLayoutX() < 202)||(moon.getLayoutX() >= 310 &&  moon.getLayoutX() < 330)) {	
			mainPane.setBackground(new Background(new BackgroundFill(Color.web("#BEBEBE"), null, null)));
		}else if((moon.getLayoutX() >= 202 &&  moon.getLayoutX() < 220)||(moon.getLayoutX() >= 290 &&  moon.getLayoutX() < 310)) {	
			mainPane.setBackground(new Background(new BackgroundFill(Color.web("#191970"), null, null)));
		}else if((moon.getLayoutX() >= 220 &&  moon.getLayoutX() < 240)||(moon.getLayoutX() >= 270 &&  moon.getLayoutX() < 290)) {	
			mainPane.setBackground(new Background(new BackgroundFill(Color.web("#000080"), null, null)));
		}else if(moon.getLayoutX() >= 240 &&  moon.getLayoutX() < 270) {	
			mainPane.setBackground(new Background(new BackgroundFill(Color.web("#000000"), null, null)));
		}
		else {
			mainPane.setBackground(new Background(new BackgroundFill(Color.web("#FFFF00" ), null, null)));
		}
	}
}
