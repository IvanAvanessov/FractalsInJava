package fractals;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import complex.*;


@SuppressWarnings("serial")
public class MandelbrotCanvas extends JComponent {

	private static final int DEFAULT_HEIGHT = 384;
	private static final int DEFAULT_WIDTH = 512;
	private static final int WHITE_RGB = 0b111111111111111111111111;
	private static final int BLACK_RGB = 0;
	protected static final double ZOOM_FACTOR = 2;
	private static final int MAX_THREADS = 16;

	private double pxScale = 0.005;
	private double centreX = -0.75;
	private double centreY = 0;
	private BufferedImage image;
	private MandelbrotSet model;

	public MandelbrotCanvas(MandelbrotSet model) {
		super();
		this.model = model;

// re-centre on mouse click
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				centreX = getMinReal() + (e.getX() * pxScale);
				centreY = getMaxImaginary() - (e.getY() * pxScale);
				MandelbrotCanvas.this.repaint();
			}
		});

// zoom in on +
		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("typed +"), "zoomIn");
		getActionMap().put("zoomIn", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MandelbrotCanvas.this.pxScale /= ZOOM_FACTOR;
				MandelbrotCanvas.this.repaint();
			}
		});

// zoom out on -
		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("typed -"), "zoomOut");
		getActionMap().put("zoomOut", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MandelbrotCanvas.this.pxScale *= ZOOM_FACTOR;
				MandelbrotCanvas.this.repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int w = getWidth();
		int h = getHeight();
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

		List<Rectangle> areas = new LinkedList<>();
		areas.add(new Rectangle(w, h));

		for (int count = MAX_THREADS / 2; count > 0; count /= 2) {
			List<Rectangle> tmp = new LinkedList<>();

			for (Rectangle r : areas) {
					tmp.addAll(splitRect(r));
			}

			areas = tmp;
		}

		List<Thread> painters = new LinkedList<>();
		for (Rectangle r : areas) {
			Thread t = new TileThread(r);	
			painters.add(t);	
			t.start();	
		}	
	
		try {	
			for (Thread t 	: painters) { t.join(); }
		} catch (InterruptedException e) {	
			e.printStackTrace();	
		}	
	
		g.drawImage(image, 0, 0, null);	
 	}	
	
 	private Collection<Rectangle> splitRect(Rectangle r) {	
 		List<Rectangle> halves = new LinkedList<>();	
	
 		if (r.width > r.height) {	
 			halves.add(new Rectangle(	
 					r.x,	
					r.y,	
 					r.width / 2,	
 					r.height));	
 			halves.add(new Rectangle(	
 					r.x + r.width / 2,	
 					r.y,	
 					r.width - r.width / 2,	
 					r.height));	
 		} else {	
 			halves.add(new Rectangle(	
 					r.x,	
 					r.y,	
 					r.width,	
 					r.height / 2));	
 			halves.add(new Rectangle(	
 					r.x,	
 					r.y + r.height / 2,	
 					r.width,	
 					r.height - r.height / 2));	
 		}	
	
 		return halves;	
 	}	
	
 	private double getMaxImaginary() {	
 		return (centreY + ((1 - (getHeight() % 2)) * pxScale * 0.5))	
 				+ ((getHeight() / 2) * pxScale);	
 	}	
	
 	private double getMinReal() {	
 		return (centreX - ((1 - (getWidth() % 2)) * pxScale * 0.5))	
 				- ((getWidth() / 2) * pxScale);	
 	}	
	
 	@Override	
 	public Dimension getPreferredSize() {	
 		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);	
 	}	
	
 	private class TileThread extends Thread {	
 		private Rectangle rect;	
	
 		public TileThread(Rectangle r) {	
 			this.rect = r;	
 		}	
	
 		@Override	
 		public void run() {	
 			Complex z = null;	
 			double a0 = getMinReal();	
 			double b0 = getMaxImaginary();	
 			int xMax = rect.x + rect.width;	
 			int yMax = rect.y + rect.height;	
	
 			for (int x = rect.x; x < xMax; x++) {	
 				for (int y = rect.y; y < yMax; y++) {	
 					z = new Complex(a0 + x * pxScale, b0 - y * pxScale);	
	
 // * Basic Version *	
 // int rgb = model.contains(z) ? BLACK_RGB 	 WHITE_RGB;
	
 					int rgb = (int) (model.escapeVelocity(z) * WHITE_RGB);	
 					image.setRGB(x, y, rgb);	
 				}	
 			}	
 		}	
 	}	
	
 }	

