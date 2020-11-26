package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TotalSolarEclipseGUI {

    @FXML
    private Circle sun;
    
    @FXML
    private AnchorPane moon;
    
    @FXML
    private AnchorPane realSun;
    

    @FXML
    private Pane mainPane;

    
    public final static double STEP = 25; 

    @FXML
    public void moveBackward(ActionEvent event) {
    	double x = moon.getLayoutX();
    	x = x - STEP;
    	moon.setLayoutX(x);

    	changes();


    }


	@FXML
    public void moveForward(ActionEvent event) {
    	double x = moon.getLayoutX();
    	x = x + STEP;
    	moon.setLayoutX(x);

    	changes();

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
