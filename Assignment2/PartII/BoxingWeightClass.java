import java.util.Scanner;

public class BoxingWeightClass {

	public static String findWeightClass(float weight) {
		// this is really only valid for weights greater than 0.
		String ret_str = null;
		
		if(weight <= 0) {
			ret_str = "invalid weight";
		}
		else if(weight <= 108) {
			ret_str = "Light Flyweight";
		}
		else if(weight <= 115) {
			ret_str = "Flyweight";
		}
		else if(weight <= 123) {
			ret_str = "Bantamweight";
		}
		else if(weight <= 132) {
			ret_str = "Lightweight";
		}
		else if(weight <= 141) {
			ret_str = "Light Welterweight";
		}
		else if(weight <= 152) {
			ret_str = "Welterweight";
		}
		else if(weight <= 165) {
			ret_str = "Middleweight";
		}
		else if(weight <= 178) {
			ret_str = "Light Heavyweight";
		}
		else if(weight <= 201) {
			ret_str = "Heavyweight";
		}
		else {
			ret_str = "Super Heavyweight";
		}
		
		return ret_str;
	}
	
	public static void main(String[] args) {
		
		/* you probably want to use user input for the
		 * income using Scanner because you will have to convert
		 * a command line argument to an float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "weight" variable
		 * to whatever you want in the code, and that's fine too
		 */
		
		System.out.print("Enter your weight: ");
		Scanner in = new Scanner(System.in);
		float weight = in.nextFloat();
		in.close();
		
		String weightClass = findWeightClass(weight);
		
		// if the digits are greater than zero print this out:
		if(weight > 0) {
			System.out.println("The weight class for the weight " + weight + " is " 
					+ weightClass);
		}
		else {
			System.out.println("Invalid weight.");
		}
		

		
	}
}
