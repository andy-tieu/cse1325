//Andy Tieu - 1001635126
//CSE1325-002

public class ElectricVehicle extends Vehicle
{
	public ElectricVehicle(int year, String make, String model, BodyStyle bodyStyle, double whPerMile, double kwhInBattery)
	{
		super(year, make, model, bodyStyle);
		this.whPerMile = whPerMile;
		this.kwhInBattery = kwhInBattery;
	}

	@Override
	public double range()
	{
		return kwhInBattery / (whPerMile / 1000);
	}

	@Override
	public double fuelConsumed(double miles)
	{
		if(miles * (whPerMile / 1000) > kwhInBattery)
		{
			throw new ArithmeticException("Trip takes more fuel than stored in the battery.");
		}
		return miles * (whPerMile / 1000);
	}
	
	@Override
	public double dollarsToTravel(double miles)
	{
		try
		{
			fuelConsumed(miles);
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		return fuelConsumed(miles) * (centsPerKwhOfElectricity / 100);
	}
	
	public static double centsPerKwhOfElectricity = Double.NaN;
	private double whPerMile;
	private double kwhInBattery;
}
