//Andy Tieu - 1001635126
//CSE1325-002

public class ElectricVehicle
{
	public ElectricVehicle(int year, String make, String model, BodyStyle bodyStyle, double whPerMile, double kwhInBattery)
	{
		this.year = year;
		this.make = make;
		this.model = model;
		this.bodyStyle = valueOf.bodyStyle;
		this.whPerMile = whPerMile;
		this.kwhInBattery = kwhInBattery;
	}
	
	class electricVehicleRange extends range
	{
		@Override
		public double range()
		{
			kwhInBattery / (whPerMile / 1000);
		}
	}
	
	class electricVehicleFuelConsumed extends fuelConsumed
	{
		@Override
		public double fuelConsumed(double miles)
		{
			miles * (whPerMile / 1000);
		}
	}
	
	class electricVehicleDollarsToTravel extends dollarsToTravel
	{
		@Override
		public double dollarsToTravel(double miles)
		{
			fuelConsumed(miles) * (centsPerKwhOfElectricity / 100);
		}
	}
	
	public static double centsPerKwhOfElectricity = Double.NaN;
	private double whPerMile;
	private double kwhInBattery;
}
