package fractals;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TheMouseClick implements MouseListener {
	MandelbrotCanvas myCanvas;
	
	public TheMouseClick(MandelbrotCanvas theCanvas){
		myCanvas=theCanvas;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		double coordX = (arg0.getX()-200)/100;
		double coordY = (arg0.getY()-150)/100;
		//System.out.println("WOW!!"+ i + " !!! " + j);
		myCanvas.changeCenter(coordX, coordY);
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
