//Andy Tieu 1001635126
//CSE1325-002

import java.util.Scanner;

public class Clock
{
	public Clock(int hours, int minutes, int seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		rationalize();
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
		System.out.print("Minute? ");
		minute = in.nextInt();
		System.out.print("Second? ");
		second = in.nextInt();
		
		Clock c1 = new Clock(hour, minute, second); //leads to constructor
		System.out.println("The time is " + c1); //prints out the time inputted
	}
	private int rationalize()
	{
		if(59 < seconds || seconds < 0)
		{
			while(59 < seconds)
			{
				minutes = minutes + 1;
				seconds = seconds - 60;
			}
			while(seconds < 0)
			{
				minutes = minutes - 1;
				seconds = seconds + 60;
			}
		}
		if(59 < minutes || minutes < 0)
		{
			while(59 < minutes)
			{
				hours = hours + 1;
				minutes = minutes - 60;
			}
			while(minutes < 0)
			{
				hours = hours - 1;
				minutes = minutes + 60;
			}
		}
		if(23 < hours || hours < 0)
		{
			while(23 < hours)
			{
				hours = hours - 24;
			}
			while(hours < 0)
			{
				hours = hours + 24;
			}
		}
		return 0;
	}

	private int hours;
	private int minutes;
	private int seconds;
}
