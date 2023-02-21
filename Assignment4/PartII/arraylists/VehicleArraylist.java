package arraylists;
import java.util.ArrayList;

import vehicles.*;

public class VehicleArraylist {
	
	public static double getAveCargo(ArrayList<Vehicle> vehiclesArrayList) {
		double totalCargo = 0;
		int numCars = 0;
		for(Object o: vehiclesArrayList)
			if(o instanceof Car) {
				numCars++;
				totalCargo += ((Car)o).getCargoSpace();
			}
		
		return totalCargo/numCars;
	}
	
	public static void removeDuplicateCars(ArrayList<Vehicle> vehiclesArrayList, Car carCopy) {
		ArrayList<Vehicle> removeList = new ArrayList<>();
		for(Vehicle v: vehiclesArrayList) {
			if(v == carCopy) {
				System.out.println("Same car: " + v);
				removeList.add(v);
			}
			else if(v.equals(carCopy)) {
				System.out.println("Duplicate car: " + v);
				removeList.add(v);
			}
			else {
				continue;
			}
			
		}
		vehiclesArrayList.removeAll(removeList);
	}

	public static void main(String[] args) {
		ArrayList<Vehicle> vehiclesArrayList = new ArrayList<>();
		
		String[] redMotoAccessories = {"grip warmers", "usb charger"}; 
		Motorcycle redMoto = new Motorcycle("red", redMotoAccessories);
		Car blueCar = new Car("blue", 20, 4);
		Car blueCar2 = new Car("blue", 20, 4);
		Bicycle bike = new Bicycle("black", false);
		CargoCycle greenCargo = new CargoCycle("green", 10, 3, true);
		CargoCycle greenCargo2 = new CargoCycle("green", 10, 3, true);
		Car grayCar = new Car("gray", 10, 2);
		Car whiteCar = new Car("white", 25, 4);

		
		vehiclesArrayList.add(redMoto);
		vehiclesArrayList.add(blueCar);
		vehiclesArrayList.add(blueCar2);
		vehiclesArrayList.add(bike);
		vehiclesArrayList.add(greenCargo);
		vehiclesArrayList.add(greenCargo2);
		vehiclesArrayList.add(grayCar);
		vehiclesArrayList.add(whiteCar);

		
		
		System.out.println("***********Part b************\n");				
		System.out.println("Average cargo space in cars: " + getAveCargo(vehiclesArrayList));
		
		System.out.println("\n***********Part c************\n");
		Car blueCarCopy = blueCar;
		removeDuplicateCars(vehiclesArrayList, blueCarCopy);

		System.out.println("\n***********Part d************\n");		
		for(Object o: vehiclesArrayList) {
			System.out.println("Remaining: " + o);
		}
		
				








	}

}
