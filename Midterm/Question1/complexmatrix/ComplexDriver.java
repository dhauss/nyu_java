package complexmatrix;


public class ComplexDriver {
	
	public static void main(String[] args) {
		/*
		Complex a = new Complex();
		Complex b = new Complex(2239);
		Complex c = new Complex(5, 2);
		Complex d = new Complex(3, 2);

		
		System.out.println(a + "\n" + b + "\n" + c);
		System.out.println(c.divide(a));
		*/
		
		ComplexMatrix a = new ComplexMatrix(3, 4);
		Complex[][] b = {{new Complex(0, 0), new Complex(0, 1), new Complex(0, 2)}, {new Complex(1, 1),new Complex(1, 2), new Complex(1, 3)}};
		ComplexMatrix c = new ComplexMatrix(b);
		System.out.println(c);		
	}

}
