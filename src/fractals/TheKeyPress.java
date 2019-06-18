package fractals;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TheKeyPress implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN) // down arrow
			System.out.println("NICHOSI");
		else if(arg0.getKeyCode() == KeyEvent.VK_UP) //up arrow
			System.out.println("This is UP");
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
