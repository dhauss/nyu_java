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

	public static Vehicle createVehicle(String vehicleName) throws VehicleException {
		
		/* if vehicleName is "Motorcycle" return Motorcycle();
		 * if vehicleName is "Car" return Car();
		 * if vehicleName is "Bicycle" return Bicycle();
		 * if vehicleName is "CargoCycle" return CargoCycle();
		 * if it is not any one of these, it should throw
		 * a VehicleException
		 */
		Vehicle res = null;
		
		switch(vehicleName) {
			case "Motorcycle":
				res = new Motorcycle();
				return res;
			case "Car":
				res = new Car();
				return res;
			case "Bicycle":
				res = new Bicycle();
				return res;
			case "CargoCycle":
				res = new CargoCycle();
				return res;
			default:
				throw new VehicleException("Invalid Vehicle: " + vehicleName);
			
		}
		
		

	}
	
	public static void main(String[] args) {

		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		File f = new File("vehicles.txt");
		String inString = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		/* create a loop to read the file line-by-line */
		try {
			fr = new FileReader(f);
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("File not found: " + fnfe.getMessage());
			System.exit(1);
		}
		br = new BufferedReader(fr);

		try {
			String curLine = br.readLine();
			while(curLine != null) {
				try {
					Vehicle vehicle = createVehicle(curLine.trim());
					vehicleList.add(vehicle);
				}
				catch (VehicleException ve) {
					System.err.println("Cannot create Vehicle: " + curLine);
				}
				curLine = br.readLine();
			}
			fr.close();
		}
		catch(IOException ioe){
			System.err.println("Error reading file: " + ioe.getMessage());
		}
		
		for(Vehicle v: vehicleList)
			System.out.println(v);
		
		
	}
}
