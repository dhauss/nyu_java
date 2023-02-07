
public class WireCapacitance {

	public static double calculateWireCapacitance(double abPerm, double d_0, double d_1, double a, double l) {
		double capacitance = 0;
		double d = Math.abs(d_1 - d_0);
		
		double numerator = (Math.PI * abPerm * l);
		double denominator = Math.log((d/(2 * a)) + 
				Math.sqrt((Math.pow(d,  2))/(4 * Math.pow(a, 2)) - 1));
		
		capacitance  = numerator/denominator;
		
		return capacitance;
	}
	
	public static void main(String[] args) {
		double absolutePermittivity = 8.85E-12;
		double initialDistance = .01;
		double finalDistance = .005;
		double wireLength = 0.5;
		double wireRadius = .002053;
		
		double changeInCapacitance = calculateWireCapacitance(absolutePermittivity, initialDistance,
				finalDistance, wireRadius, wireLength);
		
		System.out.println("The wires' change in capacity when moved from a distance of "
		 		+  initialDistance + "m to " + finalDistance + "m is " + changeInCapacitance + " farads");
	}
		
}

				
