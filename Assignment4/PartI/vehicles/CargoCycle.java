package vehicles;

public class CargoCycle extends Bicycle{

	public CargoCycle() {
		super();
		setElectric(false);
	}

	
	public CargoCycle(String color, double cargoSpace, boolean isElectric) {
		super();
		setColor(color);
		setCargoSpace(cargoSpace);
		setElectric(isElectric);
	}


	@Override
	public String toString() {
		return "CargoCycle [] which is a subclass of " + super.toString();
	}
	
}
