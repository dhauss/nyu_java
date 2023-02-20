package vehicles;

public class CargoCycle extends Bicycle{

	public CargoCycle() {
		super();
		setElectric(false);
	}

	
	public CargoCycle(String color, double cargoSpace, int wheels, boolean isElectric) {
		super();
		setColor(color);
		setCargoSpace(cargoSpace);
		setWheels(wheels);
		setElectric(isElectric);
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof CargoCycle)
			return super.equals(o);
		
		return false;
	}

	@Override
	public String toString() {
		return "CargoCycle [] which is a subclass of " + super.toString();
	}
	
}
