package fractals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import complex.Complex;

public class MandelbrotCanvas extends JComponent {
	private double centreX;
	private double centreY;
	private double pxScale;
	private BufferedImage myPic;
	private double a00, b00;
	private MandelbrotSet threshold;
	private Complex complexNum;
	
	public MandelbrotCanvas (){
		centreX=0.4;
		centreY=0.85;
		pxScale=0.02;
		threshold = new MandelbrotSet (100);
	}
	
	@Override
	protected void paintComponent (Graphics myGr){
		a00=(centreX - (1 - (getWidth()%2*pxScale*0.5)) - ((getWidth()/2)*pxScale));
		b00=(centreY - (1 - (getHeight()%2*pxScale*0.5)) + ((getHeight()/2)*pxScale));
		myPic=new BufferedImage(getWidth(),getHeight(),1);
		for(int i=0; i<getWidth();i++){
			for(int j=0;j<getHeight();j++){
				complexNum = new Complex(a00+(i*pxScale), (b00-(j*pxScale)));
				int color=threshold.escapeValue(complexNum);
				if(color==100)
					myPic.setRGB(i, j, 0xFF007F);
				else
					myPic.setRGB(i, j, 1+255^10*color);
			}
		}
		myGr.drawImage(myPic, 0, 0, null );
	}
	
	public void changeScale(double scale){
		pxScale=pxScale+scale;
		this.repaint();
	}
	public void changeCenter(double coordX, double coordY){
		centreX=centreX + coordX;
		centreY=centreY + coordY;
		this.repaint();
	}
}
