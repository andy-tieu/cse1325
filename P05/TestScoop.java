import java.util.Scanner;
import java.util.ArrayList;

public class TestScoop
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<IceCreamFlavor> iFlavor = new ArrayList<>();
		ArrayList<MixInFlavor> mFlavor = new ArrayList<>();
		ArrayList<Scoop> scoop = new ArrayList<>();
		
		while(input != q)
		{
			System.out.print("Create new (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit? ");
			char input = in.nextChar();
			
			if(input == m)
			{
				System.out.println("\nCreating new MixIn Flavor!\n");
				System.out.print("Name? ");
				String name = in.nextLine();
				System.out.print("Description? ");
				String desc = in.nextLine();
				System.out.print("Price? ");
				int price = in.nextInt();
				System.out.print("Cost? ");
				int cost = in.nextInt;
				
				mFlavor.add(new MixInFlavor(name, desc, price, cost));
			}
			else if(input == 'i')
			{
				System.out.println("\nCreating new Ice Cream Flavor!\n");
				System.out.print("Name? ");
				String name = in.nextLine();
				System.out.print("Description? ");
				String desc = in.nextLine();
				System.out.print("Price? ");
				int price = in.nextInt();
				System.out.print("Cost? ");
				int cost = in.nextInt;
				
				iFlavor.add(new IceCreamFlavor(name, desc, price, cost));
			}
			else if(input == 's')
			{
				int iInput, mInput, aInput;
				for(int i = 0; i < iFlavor.size(); ++i)
				{
					System.out.println(i + ") " + iFlavor.get(i));
				}
				System.out.print("\nFlavor? ");
				iInput = in.nextInt;
				
				for(int j = 0; j < mFlavor.size(); ++j)
				{
					System.out.println(j + ") " + mFlavor.get(j));
				}
				System.out.print("\nMixin? ");
				mInput = in.nextInt;
				
				for(int k = 0; k < 4; ++k)
				{
					System.out.println(k + ") " + MixInAmount.valueOf(k));
				}
				System.out.print("\nAmount? ");
				aInput = in.nextInt;
				
				
				Scoop s1 = new Scoop(iFlavor.get(iInput));
			}
		}
	}
}
