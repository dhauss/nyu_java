
public class SquarePyramid {
	private static int nextID = 0;
	private int id;
	private double side;
	private double height;
	
	public double getVolume() {
		return (Math.pow(side,  2) * height)/3.0;
	}
	
	public double getSurfaceArea() {
		double aSq = Math.pow(side, 2);
		double hSq = Math.pow(height, 2);
		double rootTerm = Math.sqrt((aSq/4) + hSq);
		
		return aSq + (2 * height * rootTerm);
	}
	
	
	public SquarePyramid() {
		this.id = nextID++;
		
	}


	public SquarePyramid(double side, double height) {
		this.side = side;
		this.height = height;
		
		this.id = nextID++;
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
	
}
