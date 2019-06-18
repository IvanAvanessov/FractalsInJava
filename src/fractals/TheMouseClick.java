package fractals;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TheMouseClick implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int i = arg0.getX()-8;
		int j = arg0.getY()-30;
		System.out.println("WOW!!"+ i + " !!! " + j);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
