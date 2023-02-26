package vehicles;

public class Car extends Vehicle {
	private int doors;

	public Car() {
		super(4, "unknown", 0);
	}

	public Car(String color, double cargoSpace, int doors) {
		super(4, color, cargoSpace);
		setDoors(doors);
	}
	
	public String pressGasPedal() {
		return super.getAccelerating();
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		if(doors == 2 || doors == 4)
			this.doors = doors;
		else {
			System.out.println("Invalid number of doors: must be 2 or 4.");
			this.doors = 4;
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
	public void setWheels(int wheels) {
		if(wheels == 4)
			super.setWheels(wheels);
		else{
			System.out.println("Number of car wheels must be 4");
		}
		
	}
}
	 

	
	


