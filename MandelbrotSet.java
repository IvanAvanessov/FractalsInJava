package fractals;
import complex.*;

public class MandelbrotSet {
	int maxEscape;
	final double threshold = 2; //the mandelbrot threshold value, change if necessary
	public MandelbrotSet(int number){
		maxEscape=number;
	}
	
	public int escapeValue(Complex number){
		Complex number1 = new Complex (number);
		//System.out.println(number1);
		for (int i=1; i<=maxEscape; i++){
			number1=number1.sum(number, number1.multiply(number1, number1));
			if(number1.bigger(threshold)){
				//System.out.println(number1);
				//System.out.println(i);
				//System.out.println("---------------");
				return i;
			}
		}
		return maxEscape;
	}
}
