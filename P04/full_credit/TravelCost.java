//Andy Tieu - 1001635126
//CSE1325-002

import java.util.Scanner;

public class TravelCost
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("What is the price per gallon gas (dollars)? ");
		dollarsPerGallonOfGas = in.nextDouble();
		
		System.out.print("What is the price per kWh of electricity (cents)? ");
		centsPerKwhOfElectricity = in.nextDouble();
		
		System.out.print("How many miles is your trip? ");
		miles = in.nextDouble();
	}
}
