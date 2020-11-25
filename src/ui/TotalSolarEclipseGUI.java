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
    public void moveBack(ActionEvent event) {
    	double x = sun.getLayoutX();
    	x = x - STEP;
    	sun.setLayoutX(x);
    	
    }

    @FXML
    public void moveRight(ActionEvent event) {
    	double x = sun.getLayoutX();
    	x = x + STEP;
    	sun.setLayoutX(x);
    }


}
