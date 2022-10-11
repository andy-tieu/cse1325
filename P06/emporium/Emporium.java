import java.util.ArrayList;

public class Emporium
{
	public addMixInFlavor(MixInFlavor flavor)
	{
		mixInFlavors.add(flavor);
	}
	public addIceCreamFlavor(IceCreamFlavor flavor)
	{
		iceCreamFlavors.add(flavor);
	}
	public addScoop(Scoop scoop)
	{
		scoops.add(scoop);
	}
	public mixInFlavors()
	{
		return mixInFlavors;
	}
	public iceCreamFlavors()
	{
		return iceCreamFlavors;
	}
	public scoops()
	{
		return scoops;
	}
	
	private ArrayList<MixInFlavor> mixInFlavors;
	private ArrayList<IceCreamFlavor> iceCreamFlavors;
	private ArrayList<Scoop> scoops;
}
