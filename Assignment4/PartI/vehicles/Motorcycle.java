package vehicles;

public class Motorcycle extends Vehicle {
	private int id;
	private int wheels;
	private String color;
	private double cargoSpace;
	private String[] accessories;
	

	public Motorcycle() {
		super();
		this.id = super.getNextID();
		setAccessories(new String[0]);
	}

	public Motorcycle(String color, String[] accessories) {
		super(2, color, 0);
		setAccessories(accessories);
		this.id = super.getNextID();
	}
	
	public String twistThrottle() {
		return "accelerating";
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String[] getAccessories() {
		return accessories;
	}

	public void setAccessories(String[] accessories) {
		this.accessories = accessories;
	}

	public int getId() {
		return id;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = 2;
	}
	
	public double getCargoSpace() {
		return cargoSpace;
	}

	public void setCargoSpace(double cargoSpace) {
		this.cargoSpace = 0;
	}

}
