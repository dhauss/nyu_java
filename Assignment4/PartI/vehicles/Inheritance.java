package vehicles;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Employee objects
		// note-- do not use this particular class for anything. the intent
		// is to use this main method to write some scratch code.
		
		Car v = new Car();
		Car c = new Car("red", 5, 2);
		Car c2 = new Car("red", 5, 2);
		Bicycle b = new Bicycle();
		Bicycle b2 = new Bicycle("red", true);
		Bicycle b3 = new Bicycle("REd", true);
		CargoCycle cc = new CargoCycle("red", 5.5, 3, true);
		CargoCycle cc2 = new CargoCycle("red", 5.5, 3, true);
		
		String[] acc = {"helmet clip", "grip warmers", "usb charger"};
		String[] acc2 = {"helmet clip", "grip warmers"};
		String[] acc3 = {"usb charger", "GRIP warmers", "helmet clip"};

		Motorcycle m = new Motorcycle("black", acc);
		Motorcycle m2 = new Motorcycle("black", acc3);
		System.out.println(cc.equals(cc2));
		
		System.out.println(m2);

		/*
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
		*/
		
	}

}
