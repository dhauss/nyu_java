package vehicles;

import java.util.Arrays;


public class Motorcycle extends Vehicle {
	private String[] accessories;
	
	public Motorcycle() throws VehicleException{
		super(2, "unknown", 0);
		setAccessories(new String[0]);
	}

	public Motorcycle(String color, String[] accessories) throws VehicleException{
		super(2, color, 0);
		setAccessories(accessories);
	}
	
	public String twistThrottle() {
		return super.getAccelerating();
	}

	public String[] getAccessories() {
		return accessories;
	}

	public void setAccessories(String[] accessories) {
		this.accessories = accessories;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Motorcycle) {
			if(!super.equals(o)) {
				return false;
			}
			
			for(String thisAccessory: this.getAccessories()) {
				boolean accessoriesEqual = false;
				for(String oAccessory: ((Motorcycle)o).getAccessories()){
					if(thisAccessory.equalsIgnoreCase(oAccessory)) {
						accessoriesEqual = true;
						break;
					}
				}
				if(!accessoriesEqual) {
					return false;
				}
			}
			
			for(String oAccessory: ((Motorcycle)o).getAccessories()){
				boolean accessoriesEqual = false;
				for(String thisAccessory: this.getAccessories()) {
					if(thisAccessory.equalsIgnoreCase(oAccessory)) {
						accessoriesEqual = true;
						break;
					}
				}
				if(!accessoriesEqual) {
					return false;
				}

			}
			return true;
		}
		return false;
	}
	
	@Override
	public void setWheels(int wheels)  throws VehicleException{
		if(wheels == 2)
			super.setWheels(wheels);
		else{
			throw new VehicleException("Number of motorcycle wheels must be 2");
		}
	}

	@Override
	public String toString() {
		return "Motorcycle [accessories=" + Arrays.toString(accessories) +
				"] which is a subclass of " + super.toString();
	}
}
