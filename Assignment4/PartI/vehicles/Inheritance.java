package vehicles;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Employee objects
		// note-- do not use this particular class for anything. the intent
		// is to use this main method to write some scratch code.
		
		Car v = new Car();
		Car c = new Car("red", 5, 2);
		String[] acc = {"helmet clip", "grip warmers", "usb charger"};
		Motorcycle m = new Motorcycle("black", acc);
		Bicycle b = new Bicycle();
		CargoCycle cc = new CargoCycle();
		System.out.println(b.pedal());
		System.out.println(cc.pedal());
		System.out.println(cc);


		
		System.out.println(v.getId());
		System.out.println(c.getId());
		System.out.println(m.getId());
		System.out.println(m.getAccessories()[0]);
		System.out.println(m.twistThrottle());
		System.out.println(c.getWheels());
		System.out.println(c.getColor());
		System.out.println(c.getDoors());
		System.out.println(c.getCargoSpace());
		System.out.println(v.pressGasPedal());
		 
		
	}

}
