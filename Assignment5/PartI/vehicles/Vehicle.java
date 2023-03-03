package vehicles;

public class Vehicle {
	private final String ACCELERATING = "accelerating";
	private static int nextID = 1;
	private int id;
	private int wheels;
	private String color;
	private double cargoSpace;


	public Vehicle() throws VehicleException{
		setWheels(0);
		setColor("unknown");
		setCargoSpace(0);
		this.id = nextID++;
	}
	
	public Vehicle(int wheels, String color, double cargoSpace) throws VehicleException{
		setColor(color);
		this.id = nextID++;
		setCargoSpace(cargoSpace);
		setWheels(wheels);
	}

	public String getAccelerating() {
		return ACCELERATING;
	}

	public int getWheels() {
		return wheels;
	}
	
	public void setWheels(int wheels) throws VehicleException{
		if(wheels >= 2) {
			this.wheels = wheels;
		}
		else {
			throw new VehicleException("Vehicle must have at least 2 wheels");
		}
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
	
	public void setCargoSpace(double cargoSpace) throws VehicleException{
		if(cargoSpace >= 0)
			this.cargoSpace = cargoSpace;
		else {
			throw new VehicleException("Vehicle cargo space must be nonnegative.");
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
