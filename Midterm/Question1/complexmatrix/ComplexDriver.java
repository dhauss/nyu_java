package complexmatrix;


public class ComplexDriver {
	
	public static void main(String[] args) {
		Complex a = new Complex();
		Complex b = new Complex(2239);
		Complex c = new Complex(5, 2);
		Complex d = new Complex(3, 2);

		
		System.out.println(a + "\n" + b + "\n" + c);
		System.out.println(c.divide(a));

		
		//CHECK ZERO DIVISION WITHIN DIVISION

		
		
	}

}
