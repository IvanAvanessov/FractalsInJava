package fractals;
import java.awt.BorderLayout;
import javax.swing.*;

public class MandelbrotViewer {
	/**
	 * For an explanation of how to
	 * use the Swing examples as-is from the command line, see
	 * http://docs.oracle.com/javase/javatutorials/tutorial/uiswing/start/compile.html#package
	 */
	

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	 private static void mandelbrotGUI() {
	     //Create and set up the window.
		 JFrame frame = new JFrame("My Mandelbrot Set");
		 MandelbrotCanvas myCanvas = new MandelbrotCanvas();
		 
		 frame.setSize(512, 384);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     JLabel label = new JLabel("My Mandelbrot Set");
	     frame.getContentPane().add(label, BorderLayout.CENTER);
	     frame.addMouseListener(new TheMouseClick(myCanvas));
	     frame.addKeyListener(new TheKeyPress(myCanvas));
	     frame.add(myCanvas);
	     
	     frame.setVisible(true);
	 }
	 
	 public static void main(String[] args) {
	     //Schedule a job for the event-dispatching thread:
	     //creating and showing this application's GUI.
	     javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	             mandelbrotGUI();
             }
         });
    }
}
