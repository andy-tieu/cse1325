import java.util.Scanner;

public class Clock
{
	public Clock(int hours, int minutes, int seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	@Override
	public String toString()
	{
		return hours + ":" + minutes + ":" + seconds;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int hour, minute, second; //used to pass into the constructor in Clock.java
		
		System.out.print("Hour? ");
		hour = in.nextInt();
		if(0 > hour || hour > 23)
		{
			System.out.println("ERROR: Invalid hour(s) inputted!");
		} //ERROR messages used to let user know this would not show on actual clock
		
		System.out.print("Minute? ");
		minute = in.nextInt();
		if(0 > minute || minute > 59)
		{
			System.out.println("ERROR: Invalid minute(s) inputted!");
		}
		
		System.out.print("Second? ");
		second = in.nextInt();
		if(0 > second || second > 59)
		{
			System.out.println("ERROR: Invalid second(s) inputted!");
		}
		
		Clock c1 = new Clock(hour, minute, second); //leads to constructor
		System.out.println("The time is " + c1); //prints out the time inputted
	}

	private int hours;
	private int minutes;
	private int seconds;
}
