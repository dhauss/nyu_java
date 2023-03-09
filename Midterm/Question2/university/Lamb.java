package university;

@FunctionalInterface
public interface Lamb {
	public double abs(double x, double y);
				
	public default String notAbs() {
		return "Hiya";
	}
	
	public default double notAbs2() {
		return 10.0;
	}
}
