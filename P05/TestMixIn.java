import java.util.Scanner;

public class TestMixIn
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("New Mixin flavor:");
		System.out.print("Name ");
		String name = in.nextLine();
		System.out.print("Description ");
		String desc = in.nextLine();
		System.out.print("Price ");
		int price = in.nextInt();
		System.out.print("Cost ");
		int cost = in.nextInt();
		
		MixInFlavor m1 = new MixInFlavor(name, desc, cost, price);
		System.out.println(m1);
	}
}
