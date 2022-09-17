//Andy Tieu - 1001635126
//CSE1325-002

public class GasVehicle
{
	public GasVehicle(int year, String make, String model, BodyStyle bodyStyle, double milesPerGallon, double gallonsInTank)
	{
		this.year = year;
		this.make = make;
		this.model = model;
		this.bodyStyle = valueOf.bodyStyle;
		this.milesPerGallon = milesPerGallon;
		this.gallonsInTank = gallonsInTank;
	}
	
	class gasVehicleRange extends range
	{
		@Override
		public double range()
		{
			gallonsInTank * milesPerGallon;
		}
	}
	
	class gasVehicleFuelConsumed extends fuelConsumed
	{
		@Override
		public double fuelConsumed(double miles)
		{
			miles / milesPerGallon;
		}
	}
	
	class gasVehicleDollarsToTravel extends dollarsToTravel
	{
		@Override
		public double dollarsToTravel(double miles)
		{
			fuelConsumed(miles) * dollarsPerGallonOfGas;
		}
	}
	
	public static double dollarsPerGallonOfGas = Double.NaN;
	private double milesPerGallon;
	private double gallonsInTank;
}
