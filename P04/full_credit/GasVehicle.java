//Andy Tieu - 1001635126
//CSE1325-002

public class GasVehicle extends Vehicle
{
	public GasVehicle(int year, String make, String model, BodyStyle bodyStyle, double milesPerGallon, double gallonsInTank)
	{
		super(year, make, model, bodyStyle);
		this.milesPerGallon = milesPerGallon;
		this.gallonsInTank = gallonsInTank;
	}
	
	@Override
	public double range()
	{
		return gallonsInTank * milesPerGallon;
	}

	@Override
	public double fuelConsumed(double miles)
	{
		if(miles / milesPerGallon > gallonsInTank)
		{
			throw new ArithmeticException("Trip takes more fuel than stored in the tank.");
		}
		return miles / milesPerGallon;
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
		return fuelConsumed(miles) * dollarsPerGallonOfGas;
	}
	
	public static double dollarsPerGallonOfGas = Double.NaN;
	private double milesPerGallon;
	private double gallonsInTank;
}
