
public class LoopSum {
	
	public static void estimateExponential(int exp) {
		for(int z = 0; z <= exp; z++) { 	//exponent, estimations from 0 to exp where diff <= .001
			for(int k = 0; ; k++) {			//number of iterations, breaks when result is within .001
				double eZ = Math.pow(Math.E, z);
				double eSum = getSummation(k, z);
				if(Math.abs(eZ - eSum) <= .001) {
					System.out.println("e^" + z + " is " + eZ);
					System.out.println("result for " + k + " iterations: " + eSum);
					System.out.println("It requires " + k + " iterations to estimate e^0 within .001");
					System.out.println();
					break;
				}
			}
		}
	}
	
	public static double getSummation(int k, int z) {
		double eZ = 0;
		double kFac = 0;
		
		for(int i = 0; i < k; i++) {
			kFac = getFactorial(i);
			eZ += (Math.pow(z, i))/kFac;
		}
		
		return eZ;
	}
	
	public static double getFactorial(int k) {
		double res = 1;
		
		for(int i = k; i > 1; i--) {
			res *= i;
		}
		
		return res;
	}
	
	public static void main(String[] args) {	
		estimateExponential(15);
	}
	
}
