package vehicles;

public class VehicleDriver {

	public static void main(String[] args) {
		Vehicle v = null;
		try{
			v = new Vehicle(2, "red", 9);
		}
		catch(VehicleException ve){
			System.out.println(ve.getMessage());
		}
		System.out.println(v);
		
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
		
		CargoCycle cc = null;
		try{
			cc = new CargoCycle();
		}
		catch(VehicleException ve){
			System.out.println(ve.getMessage());
		}

		try {
			cc.setWheels(1);
		} catch (VehicleException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(cc);
		System.out.println(m.twistThrottle());
		
		Car c = null;
		try{
			c = new Car("red", 9, 4);
		}
		catch(VehicleException ve){
			System.out.println(ve.getMessage());
		}
		try {
			c.setDoors(2);
		} catch (VehicleException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(c);
		
	}

}
