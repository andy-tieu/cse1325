//Andy Tieu - 1001635126
//CSE1325-002

import java.util.Scanner;
import java.util.ArrayList;
import vehicles.Vehicle;
import vehicles.GasVehicle;
import vehicles.ElectricVehicle;
import vehicles.BodyStyle;

public class TravelCost
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("What is the price per gallon gas (dollars)? ");
		GasVehicle.dollarsPerGallonOfGas = in.nextDouble();
		
		System.out.print("What is the price per kWh of electricity (cents)? ");
		ElectricVehicle.centsPerKwhOfElectricity = in.nextDouble();
		
		System.out.print("How many miles is your trip? ");
		double miles = in.nextDouble();
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new ElectricVehicle(2022, "Telsa", "Model S Plaid", BodyStyle.Sedan, 297, 100));
        vehicles.add(new ElectricVehicle(2022, "Telsa", "Model 3 LR", BodyStyle.Sedan, 242, 82));
        vehicles.add(new ElectricVehicle(2022, "GM", "Bolt", BodyStyle.Hatchback, 286, 66));
        vehicles.add(new ElectricVehicle(2022, "Nissan", "LEAF", BodyStyle.Hatchback, 269, 60));
        vehicles.add(new ElectricVehicle(2022, "Ford", "Mustang Mach-E",  BodyStyle.SUV, 347, 88));
        vehicles.add(new ElectricVehicle(2022, "Ford", "F-150 Lightning", BodyStyle.Truck, 511, 131));
        vehicles.add(new GasVehicle(2022, "Ford", "F-150", BodyStyle.Truck, 25, 23));
        vehicles.add(new GasVehicle(2022, "Toyota", "Prius Hybrid", BodyStyle.Hatchback, 55, 11.4));
        vehicles.add(new GasVehicle(2022, "Toyota", "RAV4", BodyStyle.Crossover, 31, 14.5));
        vehicles.add(new GasVehicle(2022, "Nissan", "Rogue", BodyStyle.Hatchback, 33, 14.5));
        vehicles.add(new GasVehicle(2022, "Chrysler", "Pacifica", BodyStyle.Minivan, 24, 19));
        vehicles.add(new GasVehicle(2022, "Chrysler", "Pacifica Hybrid", BodyStyle.Minivan, 30, 16.5));
        
        for(int i = 0; i < vehicles.size(); ++i)
        {
        	if(vehicles.get(i).dollarsToTravel(miles) < 10)
        	{
        		System.out.print(String.format("$  %.2f", vehicles.get(i).dollarsToTravel(miles)));
        	}
        	else
        	{
        		System.out.print(String.format("$ %.2f", vehicles.get(i).dollarsToTravel(miles)));
        	}
        	System.out.print(String.format(" (range %.0f)", vehicles.get(i).range()));
        	System.out.println(" " + vehicles.get(i));
        }
	}
}
