package thread;

import javafx.application.Platform;
import model.Moon;
import ui.TotalSolarEclipseGUI;

public class MovingThread extends Thread{

	private Moon moon;
	private TotalSolarEclipseGUI tsegui;

	public MovingThread(Moon m, TotalSolarEclipseGUI t) {
		moon = m;
		tsegui = t;
	}

	public void run() {	
		while(tsegui.isGo()) {
			moon.move();
			Platform.runLater(new Thread() {
				public void run() {
					tsegui.updateMoon(moon.getX());
				}
			});
			try {
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}


