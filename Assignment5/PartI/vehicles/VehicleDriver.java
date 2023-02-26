package vehicles;

public class VehicleDriver {

	public static void main(String[] args) {
		try{
			Vehicle v = new Vehicle(2, "red", 9);
		}
		catch(VehicleException ve){
			System.out.println(ve.getMessage());
		}
		
		Bicycle b = null;
		try{
			b = new Bicycle("red", false);
		}
		catch(VehicleException ve){
			System.out.println(ve.getMessage());
		}

		try {
			b.setWheels(0);
		} catch (VehicleException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(b);
		
		Motorcycle m = null;
		String[] ma = {"seat", "things"};
		try{
			m = new Motorcycle("red", ma);
		}
		catch(VehicleException ve){
			System.out.println(ve.getMessage());
		}
		
		try{
			m.setWheels(3);;
		}
		catch(VehicleException ve){
			System.out.println(ve.getMessage());
		}

		System.out.println(m);
		
	}

}
