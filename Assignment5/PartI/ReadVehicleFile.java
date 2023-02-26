import java.io.*;
import java.util.ArrayList;

import vehicles.*;

/* your tasks:
 * create a class called VehicleException
 * createVehicle should throw a VehicleException
 * in main(), you should catch the VehicleException
 * 
 */
public class ReadVehicleFile {

	public static Vehicle createVehicle(String vehicleName) {
		
		/* if vehicleName is "Motorcycle" return Motorcycle();
		 * if vehicleName is "Car" return Car();
		 * if vehicleName is "Bicycle" return Bicycle();
		 * if vehicleName is "CargoCycle" return CargoCycle();
		 * if it is not any one of these, it should throw
		 * a VehicleException
		 */
		return null;
	}
	
	public static void main(String[] args) {
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		File f = new File("vehicles.txt");
		
		String inString = null;
		
		/* create a loop to read the file line-by-line */
		
		try {
			
			Vehicle vehicle = createVehicle(inString);
		} catch (/* your exception */ ) {
			System.err.println("Cannot create Vehicle: " + inString);
		}

		System.out.println(vehicleList);
		
	}
}
