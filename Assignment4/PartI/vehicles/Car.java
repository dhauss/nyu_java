package vehicles;

public class Car extends Vehicle {
	private int id;
	private int wheels;
	private String color;
	private double cargoSpace;
	private int doors;

	public Car() {
		super();
		this.id = super.getNextID();
	}

	public Car(String color, double cargoSpace, int doors) {
		super(4, color, cargoSpace);
		setDoors(doors);
		this.id = super.getNextID();
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCargoSpace() {
		return cargoSpace;
	}

	public void setCargoSpace(double cargoSpace) {
		if(cargoSpace >= 0)
			this.cargoSpace = cargoSpace;
		else
			System.out.println("cargo space must be >= 0");
	}

	public int getWheels() {
		return wheels;
	}

	public String pressGasPedal() {
		return "accelerating";
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		if(doors == 2 || doors == 4)
			this.doors = doors;
		else {
			System.out.println("Invalid number of doors: must be 2 or 4.");
			this.doors = -1;
		}
	}

	public int getId() {
		return id;
	}
	
	

}
