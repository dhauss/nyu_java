package vehicles;

public class Vehicle {
	private final String ACCELERATING = "accelerating";
	private static int nextID = 1;
	private int id;
	private int wheels;
	private String color;
	private double cargoSpace;


	public Vehicle() {
		setWheels(0);
		setColor("unknown");
		setCargoSpace(0);
		this.id = nextID++;
	}
	
	public Vehicle(int wheels, String color, double cargoSpace) {
		setWheels(wheels);
		setColor(color);
		setCargoSpace(cargoSpace);
		this.id = nextID++;
	}

	public String getAccelerating() {
		return ACCELERATING;
	}

	public int getWheels() {
		return wheels;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	
	public double getCargoSpace() {
		return cargoSpace;
	}
	
	public void setCargoSpace(double cargoSpace) {
		if(cargoSpace >= 0)
			this.cargoSpace = cargoSpace;
		else {
			System.out.println("Cargo space must be nonnegative");
			this.cargoSpace = 0;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Vehicle) {
			return ((Vehicle) o).getCargoSpace() == this.getCargoSpace()
					&& ((Vehicle) o).getColor().equalsIgnoreCase(this.getColor()) 
					&& ((Vehicle) o).getWheels() == this.getWheels();
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", wheels=" + wheels + ", color=" + color + ", cargoSpace=" + cargoSpace
				+ ", nextID=" + nextID + ", accelerating=" + ACCELERATING + "]";
	}
	
}
