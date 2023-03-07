package vehicles;

public class Car extends Vehicle {
	private int doors;

	public Car() throws VehicleException{
		super(4, "unknown", 0);
		setDoors(4);
	}

	public Car(String color, double cargoSpace, int doors) throws VehicleException {
		super(4, color, cargoSpace);
		setDoors(doors);
	}
	
	public String pressGasPedal() {
		return super.getAccelerating();
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) throws VehicleException {
		if(doors == 2 || doors == 4)
			this.doors = doors;
		else {
			this.doors = 4;
			throw new VehicleException("Invalid number of doors: must be 2 or 4.");
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Car) {
			return super.equals(o) && ((Car) o).getDoors() == this.getDoors();
		}
		return false;	
	}

	@Override
	public String toString() {
		return "Car [doors=" + doors + "] which is a subclass of " + super.toString();
	}
	
	@Override
	public void setWheels(int wheels) throws VehicleException{
		if(wheels == 4)
			super.setWheels(wheels);
		else{
			throw new VehicleException("Number of car wheels must be 4");
		}	
	}
}
	 

	
	


