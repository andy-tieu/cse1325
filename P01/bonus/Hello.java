import java.util.Scanner;

public class Hello
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name here: ");
		String s;
		s = in.nextLine();
		System.out.println("Hello, " + s);
	}
};
