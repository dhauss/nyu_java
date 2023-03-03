import java.io.*;
import java.util.ArrayList;

import vehicles.*;

public class ReadVehicleFile {

	public static Vehicle createVehicle(String vehicleName) throws VehicleException {
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
		FileReader fr = null;
		BufferedReader br = null;
		
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
					System.err.println(ve.getMessage());
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
