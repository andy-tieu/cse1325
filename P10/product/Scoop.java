package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Scoop
{
	public Scoop(IceCreamFlavor flavor)
	{
		this.flavor = flavor;
		this.mixins = new ArrayList<>();
	}
	
	public Scoop(BufferedReader in) throws IOException
	{
		this.flavor = new IceCreamFlavor(in);
        this.mixins = new ArrayList<>();
        int numMixIns = Integer.parseInt(in.readLine());
        while(numMixIns-- > 0) mixins.add(new MixIn(in));
	}
	
	public void save(BufferedWriter out) throws IOException
	{
		flavor.save(out);
		out.write("" + mixins.size() + '\n');
		for(MixIn mi : mixins)
		{
			mi.save(out);
		}
	}
	
	public void addMixIn(MixIn mixin)
	{
		mixins.add(mixin);
	}

	@Override
	public String toString()
	{
		StringBuilder mixResult = new StringBuilder(flavor.toString());
		if(mixins.size() > 0)
		{
			String separator = " with ";
			for(MixIn m : mixins)
			{
				mixResult.append(separator + m.toString());
				separator = ", ";
			}
		}
		return mixResult.toString();
	}
	
	private IceCreamFlavor flavor;
	private ArrayList<MixIn> mixins;
}
