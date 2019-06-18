package fractals;
import complex.*;

public class MandelbrotSet {

	private static final double DIVERGE_THRESHOLD = 2.0;
	private static final double DIVERGE_THRESHOLD_SQUARED =
			DIVERGE_THRESHOLD * DIVERGE_THRESHOLD;

	private int maxEscape;

	public MandelbrotSet(int maxEscapeVal) {
		this.maxEscape = maxEscapeVal;
	}

	public double escapeVelocity(Complex c) {
		return 1 - ((double) escapeValue(c) / maxEscape);
	}

	int escapeValue(Complex c) {
		Complex tmp = c;

		for (int i = 0; i < maxEscape; i++) {
			if (tmp.magnitudeSquared() > DIVERGE_THRESHOLD_SQUARED) {
				return i;
			}
			tmp = Complex.add(Complex.multiply(tmp, tmp), c);
		}

		return maxEscape;
	}

	public boolean contains(Complex z) {
		return escapeValue(z) == maxEscape;
	}
}

