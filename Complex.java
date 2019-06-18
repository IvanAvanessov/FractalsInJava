package complex;

public class Complex {
	
	private double rp; //real part
	private double ip; //imaginary part
	
	public Complex(Complex number){
		this.rp=number.rp;
		this.ip=number.ip;
	}
	public Complex(double rp1, double ip1){
		rp=rp1;
		ip=ip1;
	}
	public Complex(String S){
		int separator=S.indexOf('+');
		int indexI=S.indexOf('i');
		//get imaginary part
		if (S.charAt(separator+1)==' '){
			ip = Double.parseDouble(S.substring(separator+2, indexI));
		}
		else
			ip = Double.parseDouble(S.substring(separator+1, indexI));
		//get real part
		if (S.charAt(separator-1)==' '){
			rp = Double.parseDouble(S.substring(0, separator-1));
		}
		else
			rp = Double.parseDouble(S.substring(0, separator));	
	}
	public Complex sum (Complex thisNumber, Complex otherNumber){
		double temp_rp;
		double temp_ip;
		
		temp_rp=thisNumber.rp + otherNumber.rp;
		temp_ip=thisNumber.ip + otherNumber.ip;
		
		Complex answer = new Complex(temp_rp,temp_ip);
		return answer;		
	}
	public Complex multiply (Complex thisNumber, Complex otherNumber){
		double temp_ip;
		double temp_rp;
		temp_rp=thisNumber.rp * otherNumber.rp - thisNumber.ip * otherNumber.ip;
		temp_ip=thisNumber.rp * otherNumber.ip + thisNumber.ip * otherNumber.rp;
		Complex answer = new Complex(temp_rp,temp_ip);
		return answer;	
	}
	
	public String toString(){
		String answer = "" + rp + " + " + ip + 'i';
		return answer;
	}
	/*
	public static void main(String[] args){
		Complex huj = new Complex("3.66 + 2.631i");
		String try2="1234567890";
		System.out.println(huj);
		int try1=Integer.parseInt(try2);
		System.out.println(try1+5);
	}*/
	public boolean bigger(double threshold) {
		if(rp>threshold || ip>threshold)
			return true;
		return false;
	}	
}
