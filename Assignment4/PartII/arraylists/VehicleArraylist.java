package arraylists;
import java.util.ArrayList;

import vehicles.*;

public class VehicleArraylist {

	public static void main(String[] args) {
		// this ArrayList MUST be parameterized
		ArrayList<Vehicle> vehiclesArrayList = new ArrayList<>();
		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
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
		
		
		System.out.println("***********Part a************\n");
		
		double totalCargo = 0;
		int numCars = 0;
		for(Vehicle o: vehiclesArrayList)
			if(o instanceof Car) {
				numCars++;
				totalCargo += ((Car)o).getCargoSpace();
			}
		System.out.println("Average cargo space in cars: " + totalCargo/numCars);
		
		System.out.println("\n***********Part b************\n");
		
		ArrayList<Vehicle> keepList = new ArrayList<>();
		for(Vehicle o: vehiclesArrayList) {
			if(!keepList.contains(o)){
				keepList.add(o);
			}
			else {
				System.out.println("Duplicate: " + o);
			}
		}
		
		System.out.println("\n***********Part c************\n");

		vehiclesArrayList = keepList;
		for(Vehicle o: vehiclesArrayList) {
			System.out.println("Remaining: " + o);
		}
		
				








	}

}
