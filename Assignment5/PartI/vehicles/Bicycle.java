package vehicles;

public class Bicycle extends Vehicle {
	private boolean isElectric;
	private final String pedaling = "pedaling";

	public Bicycle() throws VehicleException{
		super(2, "unknown", 0);
		setElectric(false);
	}

	public Bicycle(String color, boolean isElectric) throws VehicleException{
		super(2, color, 0);
		setElectric(isElectric);
	}

	public String pedal() {
		return pedaling;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Bicycle) {
			return super.equals(o) && ((Bicycle) o).isElectric() == this.isElectric();
		}
		return false;
	}
	
	@Override
	public void setWheels(int wheels) throws VehicleException{
		if(this instanceof CargoCycle) {
			if(wheels >= 2 && wheels <= 4)
				super.setWheels(wheels);
			else {
				throw new VehicleException("Cargo cycle can only have 2-4 wheels");
			}
		}
		else {
			if(wheels == 2)
				super.setWheels(wheels);
			else {
				throw new VehicleException("Bicycle can only have 2 wheels");
			}
		}				
	}
	
	@Override
	public void setCargoSpace(double cargoSpace) throws VehicleException{
		if(this instanceof CargoCycle)
			super.setCargoSpace(cargoSpace);
		else {
			super.setCargoSpace(0);
			if(cargoSpace > 0)
				throw new VehicleException("Bicycles have no cargo space");
		}
	}
	
	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}

	@Override
	public String toString() {
		return "Bicycle [isElectric=" + isElectric + ", pedaling=" + pedaling +
				"] which is a subclass of " + super.toString();
	}

}
