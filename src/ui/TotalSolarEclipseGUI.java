package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Moon;

public class TotalSolarEclipseGUI {

	@FXML
	private Circle sun;

	@FXML
	private AnchorPane moon;

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

//	@FXML
//	public void moveBackward(ActionEvent event) {
//		double x = moon.getLayoutX();
//		x = x - STEP;
//		moon.setLayoutX(x);
//	}
//
//	@FXML
//	public void moveForward(ActionEvent event) {
//		double x = moon.getLayoutX();
//		x = x + STEP;
//		moon.setLayoutX(x);
//	}

	public void updateMoon(double x) {
		moon.setLayoutX(x);
	}
}
