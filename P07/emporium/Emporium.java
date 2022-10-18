package emporium;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

import java.util.ArrayList;

public class Emporium
{
	public Emporium() {}	
	public Emporium(BufferedReader in)
	{
		
	}
	public void save(BufferedWriter out) throws IOException
	{
		out.write("" + mixInFlavors.size() + '\n');
		for(int i : mixInFlavors.size())
		{
			mixInFlavors.get(i).save(out);
			//out.write("" + mixInFlavors.get(i).MixInFlavor.name() + '\n');
			//out.write("" + mixInFlavors.get(i).MixInFlavor.description() + '\n');
			//out.write("" + mixInFlavors.get(i).MixInFlavor.cost() + '\n');
			//out.write("" + mixInFlavors.get(i).MixInFlavor.price() + '\n');
		}
		out.write("" + iceCreamFlavors.size() + '\n');
		for(int i : iceCreamFlavors.size())
		{
			iceCreamFlavors.get(i).save(out);
			//out.write("" + iceCreamFlavors.get(i).IceCreamFlavor.name() + '\n');
			//out.write("" + iceCreamFlavors.get(i).IceCreamFlavor.description() + '\n');
			//out.write("" + iceCreamFlavors.get(i).IceCreamFlavor.cost() + '\n');
			//out.write("" + iceCreamFlavors.get(i).IceCreamFlavor.price() + '\n');
		}
		out.write("" + scoops.size() + '\n');
		for(int i : scoops.size())
		{
			scoops.get(i).save(out);
			//out.write("" + scoops.get(i).Scoop.name() + '\n');
			//out.write("" + scoops.get(i).Scoop.description() + '\n');
			//out.write("" + scoops.get(i).Scoop.cost() + '\n');
			//out.write("" + scoops.get(i).Scoop.price() + '\n');
		}
	}
	public void addMixInFlavor(MixInFlavor flavor)
	{
		mixInFlavors.add(flavor);
	}
	public void addIceCreamFlavor(IceCreamFlavor flavor)
	{
		iceCreamFlavors.add(flavor);
	}
	public void addScoop(Scoop scoop)
	{
		scoops.add(scoop);
	}
	public Object[] mixInFlavors()
	{
		return this.mixInFlavors.toArray();
	}
	public Object[] iceCreamFlavors()
	{
		return this.iceCreamFlavors.toArray();
	}
	public Object[] scoops()
	{
		return this.scoops.toArray();
	}
	
	private ArrayList<MixInFlavor> mixInFlavors = new ArrayList<>();
	private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList<>();
	private ArrayList<Scoop> scoops = new ArrayList<>();
}
