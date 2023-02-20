package vehicles;

public abstract class Vehicle {
	private static int nextID = 0;
	
	public Vehicle() {
		setWheels(0);
		setColor("unknown");
		setCargoSpace(0);
		nextID++;
	}
	
	
	public Vehicle(int wheels, String color, double cargoSpace) {
		setWheels(wheels);
		setColor(color);
		setCargoSpace(cargoSpace);
		nextID++;
	}
	
	public int getNextID() {
		return nextID;
	}

	abstract int getWheels();
	
	abstract void setWheels(int wheels);
	
	abstract String getColor();
	
	abstract void setColor(String color);
	
	abstract int getId();
	
	abstract double getCargoSpace();
	
	abstract void setCargoSpace(double cargoSpace);
	
}
