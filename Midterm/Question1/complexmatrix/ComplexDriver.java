package complexmatrix;


public class ComplexDriver {
	
	public static void main(String[] args) {
		
		Complex a1 = new Complex();
		Complex b1 = new Complex(2239);
		Complex c1 = new Complex(5, 2);
		Complex d1 = new Complex(3, 2);

		
		System.out.println(a1 + "\n" + b1 + "\n" + c1);
		System.out.println(c1.divide(d1));
		
		
		ComplexMatrix a = new ComplexMatrix(3, 4);
		Complex[][] b = {
				{new Complex(1, 2), new Complex(2, 2)},
				{new Complex(1, 2), new Complex(2, 2)},
				{new Complex(1, 2),new Complex(2, 2)}
				};
		Complex[][] b2 = {
				{new Complex(2, -2), new Complex(2, 2), new Complex(2, 2)},
				{new Complex(2, 2), new Complex(-2, 2), new Complex(2, 2)}
				};	
		ComplexMatrix c = new ComplexMatrix(b);
		ComplexMatrix d = new ComplexMatrix(b2);
		
		
		try {
			System.out.println(c.mult(d));
		} catch (MatrixDimensionException e) {
			System.out.println(e.getMessage());
		}	
		
		
		d.write("test.txt");
		
		try {
			System.out.println(ComplexMatrix.read("test.txt"));
		} catch (IncompatibleMatrixException e) {
			System.out.println(e.getMessage());
		}

	}

}
