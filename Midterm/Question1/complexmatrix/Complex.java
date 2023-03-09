package complexmatrix;

public class Complex implements Comparable<Complex>{
	private double a;
	private double b;
	
	public Complex() {
		this(0, 0);
	}
	
	public Complex(double a) {
		this(a, 0);
	}
	
	public Complex(double a, double b) {
		setReal(a);
		setImaginary(b);
	}
	
	public double getMagnitude() {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
	public Complex add(Complex c) {
		Complex res = new Complex();
		res.setReal(this.getReal() + c.getReal());
		res.setImaginary(this.getImaginary() + c.getImaginary());
		
		return res;
	}
	
	public Complex subtract(Complex c) {
		Complex res = new Complex();
		res.setReal(this.getReal() - c.getReal());
		res.setImaginary(this.getImaginary() - c.getImaginary());
		
		return res;
	}
	
	public Complex multiply(Complex c) {
		Complex res = new Complex();
		res.setReal((this.getReal() * c.getReal()) - (this.getImaginary() * c.getImaginary()));
		res.setImaginary((this.getReal() * c.getImaginary()) + (this.getImaginary() * c.getReal()));
		
		return res;
	}
	
	public Complex divide(Complex c) {
		Complex res = new Complex();
		double denominator = Math.pow(c.getReal(), 2) + Math.pow(c.getImaginary(), 2);
				
		double realNumerator = (this.getReal() * c.getReal()) + (this.getImaginary() * c.getImaginary());
		res.setReal(realNumerator/denominator);
		
		double imaginaryNumerator = (this.getImaginary() * c.getReal()) - (this.getReal() * c.getImaginary());
		res.setImaginary(imaginaryNumerator/denominator);

		return res;
	}
	
	@Override
	public int compareTo(Complex o) {
		
		if(this.getMagnitude() > o.getMagnitude()) {
			return 1;
		}
		else if(this.getMagnitude() < o.getMagnitude()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		if(this.getImaginary() >= 0){
			return String.format("%,.2f + i%,.2f ", a, b);
		}
		else {
			return String.format("%,.2f - i%,.2f ", a, Math.abs(b));
			}
	}

	public double getReal() {
		return a;
	}
	public double getImaginary() {
		return b;
	}
	public void setReal(double a) {
		this.a = a;
	}
	public void setImaginary(double b) {
		this.b = b;
	}
}
