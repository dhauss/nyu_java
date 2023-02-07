class WireCapacitance {
	
	public static void main(String[] arguments) {
		double absolutePermittivity = 8.85E-12;
		double initialDistance = .01;
		double finalDistance = .005;
		double wireLength = 0.5;
		double wireRadius = .002053;
		double capacitanceDifference = 0;
				
		double capInitial = getCapacitance(absolutePermittivity, initialDistance, wireRadius, wireLength);
		double capFinal = getCapacitance(absolutePermittivity, finalDistance, wireRadius, wireLength);
		
		capacitanceDifference = capFinal - capInitial;
				
		System.out.println("The wires' change in capacity when moved from a distance of "
		 		+  initialDistance + "m to " + finalDistance + "m is " + capacitanceDifference + " farads");
	}
	
	public static double getCapacitance(double abPerm, double dist, double radius, double length) {
		double capacitance = 0;
		
		double numerator = (Math.PI * abPerm * length);
		double denominator = Math.log((dist/(2 * radius)) + 
				Math.sqrt((Math.pow(dist,  2))/(4 * Math.pow(radius, 2)) - 1));
		
		capacitance  = numerator/denominator;
		
		return capacitance;
	}
}