import java.util.Scanner;

public class Clock
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int hour, minute, second;
		
		System.out.print("Hour? ");
		hour = in.nextInt();
		if(0 > hour || hour > 24)
		{
			System.out.println("ERROR: Invalid hour(s) inputted!");
		}
		System.out.print("Minute? ");
		minute = in.nextInt();
		if(0 > minute || minute > 60)
		{
			System.out.println("ERROR: Invalid minute(s) inputted!");
		}
		System.out.print("Second? ");
		second = in.nextInt();
		if(0 > second || second > 60)
		{
			System.out.println("ERROR: Invalid second(s) inputted!");
		}
	}
}
