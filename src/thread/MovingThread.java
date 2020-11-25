package thread;

import javafx.application.Platform;

public class MovingThread extends Thread{

	
	
	
	public MovingThread() {
		
	}
	
	public void run() {
		
		while(true) {
			
			//advance
//			clock.rotateHands();
			
			Platform.runLater(new Thread() {
				public void run() {
					
					//clase cotroladora de la GUI actualiza el movimiento
//					clockGUI.updateClock();
				}
			});
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
