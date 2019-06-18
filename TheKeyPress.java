package fractals;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TheKeyPress implements KeyListener {
	MandelbrotCanvas myCanvas;
	
	public TheKeyPress(MandelbrotCanvas theCanvas){
		myCanvas=theCanvas;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN){ // down arrow
			myCanvas.changeScale(0.0001);
			
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_UP){ //up arrow
			myCanvas.changeScale(-0.0001);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
