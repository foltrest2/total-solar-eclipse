package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class TotalSolarEclipseGUI {

    @FXML
    private Circle sun;
    
    @FXML
    private AnchorPane moon;
    
    public final static double STEP = 25; 

    @FXML
    public void moveBackward(ActionEvent event) {
    	double x = moon.getLayoutX();
    	x = x - STEP;
    	moon.setLayoutX(x);
    }

    @FXML
    public void moveForward(ActionEvent event) {
    	double x = moon.getLayoutX();
    	x = x + STEP;
    	moon.setLayoutX(x);
    }

}
