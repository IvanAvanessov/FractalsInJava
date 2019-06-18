package complex;

public class Complex {

	private double a; // real coefficient
	private double b; // imaginary coefficient

	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double magnitude() {
		return Math.sqrt(magnitudeSquared());
	}

	public static Complex add(Complex c1, Complex c2) {
		return new Complex(c1.a + c2.a, c1.b + c2.b);
	}

	public static Complex multiply(Complex c1, Complex c2) {
		return new Complex(c1.a * c2.a - c1.b * c2.b,
				c1.a * c2.b + c2.a * c1.b);
	}

	public double magnitudeSquared() {
		return a * a + b * b;
	}

}

