package fractals;
 import javax.swing.JFrame;

 @SuppressWarnings("serial")
 public class MandelbrotViewer extends JFrame implements Runnable {

	 private MandelbrotCanvas view;

	 public MandelbrotViewer(MandelbrotCanvas view) {
		 super("Mandelbrot Viewer");
		 this.view = view;
	 }

 /**
 * Create the GUI and show it. For thread safety,
 * this method should be invoked from the
 * event-dispatching thread.
 */
	 private void createAndShowGUI() {
		 setDefaultCloseOperation(EXIT_ON_CLOSE);

		 add(view);
		 pack();
		 setVisible(true);
	 }

	 public static void main(String[] args) {
 //Schedule a job for the event-dispatching thread
 //creating and showing this application’s GUI.
		 MandelbrotSet model = new MandelbrotSet(500);
		 MandelbrotCanvas view = new MandelbrotCanvas(model);
		 MandelbrotViewer app = new MandelbrotViewer(view);

		 javax.swing.SwingUtilities.invokeLater(app);
	 }

	@Override
	public void run() {
		 createAndShowGUI();
 	}

 }
