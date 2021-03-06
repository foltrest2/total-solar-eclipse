package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

	@FXML
	private Circle mars;

	@FXML
	private Circle venus;

	@FXML
	private Circle jupiter;

	@FXML
	private Circle star1;

	@FXML
	private Circle star2;

	@FXML
	private Circle star3;

	@FXML
	private Circle star4;

	@FXML
	private Circle star5;

	@FXML
	private Circle star6;

	@FXML
	private Circle star7;

	@FXML
	private Circle star8;

	@FXML
	private Circle star9;

	@FXML
	private Circle star10;

	@FXML
	private Circle star11;

	@FXML
	private Circle star12;

	@FXML
	private Slider slider;

	private boolean go;

	public boolean isGo() {
		return go;
	}

	public TotalSolarEclipseGUI(Stage st) {
		window = st;
		go = true;
	}

	public final static double STEP = 25; 

	public void initialize() {
		m = new Moon(moon.getLayoutX(), 96);

		window.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				go = false;
				System.out.println("Closing the window!");
			}
		});

	}

	@FXML
	public void move(ActionEvent event) {
		go = true;
		if(go) {
			m.setMax(window.getWidth());
			new Thread() {
				public void run() {
					while(go) {
						m.move();
						changes();
						Platform.runLater(new Thread() {
							public void run() {
								updateMoon(m.getX());
							}
						});

						try {
							Thread.sleep((long)( slider.getMax() - slider.getValue()));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
	}

	@FXML
	void stop(ActionEvent event) {
		go = false;
	}
	public void updateMoon(double x) {
		if(go) {
			moon.setLayoutX(x);
		}
	}

	private void changes() {
		//primera mitad
		if((moon.getLayoutX() >= 162 &&  moon.getLayoutX() < 182)|| (moon.getLayoutX() >= 330 &&  moon.getLayoutX() < 341)) {	
			mainPane.setBackground(new Background(new BackgroundFill(Color.web("#48D1CC"), null, null)));
		}
		else if((moon.getLayoutX() >= 182 &&  moon.getLayoutX() < 202)||(moon.getLayoutX() >= 310 &&  moon.getLayoutX() < 330)) {	
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
		if(moon.getLayoutX() >= 162 &&  moon.getLayoutX() < 351) {
			makePlanetsAndStars();
		} else {
			hidePlanetsAndStars();
		}
	}
	public void makePlanetsAndStars() {
		mars.setVisible(true);
		venus.setVisible(true);
		jupiter.setVisible(true);
		star1.setVisible(true);
		star1.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star2.setVisible(true);
		star2.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star3.setVisible(true);
		star3.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star4.setVisible(true);
		star4.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star5.setVisible(true);
		star5.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star6.setVisible(true);
		star6.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star7.setVisible(true);
		star7.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star8.setVisible(true);
		star8.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star9.setVisible(true);
		star9.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star10.setVisible(true);
		star10.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star11.setVisible(true);
		star11.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		star12.setVisible(true);
		star12.setFill(Color.color(Math.random(), Math.random(), Math.random()));
	}

	public void hidePlanetsAndStars() {
		mars.setVisible(false);
		venus.setVisible(false);
		jupiter.setVisible(false);
		star1.setVisible(false);
		star2.setVisible(false);
		star3.setVisible(false);
		star4.setVisible(false);
		star5.setVisible(false);
		star6.setVisible(false);
		star7.setVisible(false);
		star8.setVisible(false);
		star9.setVisible(false);
		star10.setVisible(false);
		star11.setVisible(false);
		star12.setVisible(false);
	}
}
