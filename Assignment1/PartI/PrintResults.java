import static java.lang.System.out;


public class PrintResults {

	public static void main(String[] args) {
		
		//System.out.println("The value of 1+1 is " + (1+1));
		int a = 10 + 5;
		int b = 50 - 23;
		int c = 12 * 13;
		double d = 20.0 / 3.0;
		int e = 100 % 7;
		double f = Math.pow(4, 3);
		
		/*
		 * Got bored during OH and made it slightly more fun, but didn't want to hand in a version where all the ints were cast to doubles 
		
		double[] vars = {a, b, c, d, e, f};
		int lowA = 97;

		for(int i = 0; i < 6; i++)
			out.println("The value of " + (char)(lowA + i) + " is " + vars[i]);
		
		*/
		 out.println("The value of a is " + a);
		 out.println("The value of b is " + b);
		 out.println("The value of c is " + c);
		 out.println("The value of d is " + d);
		 out.println("The value of e is " + e);
		 out.println("The value of f is " + f);
		 
	}
}
