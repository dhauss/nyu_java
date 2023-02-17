
public class SquarePyramid {
	private static int nextID = 1;
	private int id;
	private double side;
	private double height;
	
	public SquarePyramid() {
		this(1.0, 1.0);	
	}
	
	public SquarePyramid(double side, double height) {
		setSide(side);
		setHeight(height);
		
		id = nextID++;
	}
	
	public double getVolume() {
		return (Math.pow(side,  2) * height)/3.0;
	}
	
	public double getSurfaceArea() {
		double aSq = Math.pow(side, 2);
		double hSq = Math.pow(height, 2);
		double rootTerm = Math.sqrt((aSq/4) + hSq);
		
		return aSq + (2 * side * rootTerm);
	}

	public double getSide() {
		return side;
	}


	public void setSide(double side) {
		this.side = side;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public int getId() {
		return id;
	}
	
	public static void main(String[] args) {
		SquarePyramid sp1 = new SquarePyramid();
		SquarePyramid sp2 = new SquarePyramid(5, 10);
		
		System.out.printf("sp1 id: %d height: %.2f side: %.2f\nsp2 id: %d, height: %.2f, side: %.2f\n",
				sp1.getId(), sp1.getHeight(), sp1.getSide(),
				sp2.getId(), sp2.getHeight(), sp2.getSide());
		
		System.out.printf("sp1 surface area: %f, volume: %.2f\n",
				sp1.getSurfaceArea(), sp1.getVolume());
		System.out.printf("sp2 surface area: %f, volume: %.2f\n",
				sp2.getSurfaceArea(), sp2.getVolume());
		
		sp1.setSide(3);
		sp1.setHeight(5);
		System.out.printf("sp1 side: %.2f, height: %.2f", sp1.getSide(), sp1.getHeight());

	}
	
}


