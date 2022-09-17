//Andy Tieu - 1001635126
//CSE1325-002

public class Vehicle
{
	public Vehicle(int year, String make, String model, BodyStyle bodyStyle)
	{
		this.year = year;
		this.make = make;
		this.model = model;
		this.bodyStyle = BodyStyle.value();
	}
	
	abstract class range
	{
		public abstract double void range();
	}	
	abstract class fuelConsumed
	{
		public abstract double void fuelConsumed(double miles);
	}
	abstract class dollarsToTravel
	{
		public abstract double void dollarsToTravel(double miles);
	}
	
	@Override
	public String toString()
	{
		return year + " " + make + " " + model + " " + bodyStyle;
	}
	
	private int year;
	private String make;
	private String model;
	private BodyStyle bodyStyle;
}
