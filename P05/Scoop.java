import java.util.ArrayList;

public class Scoop
{
	int i = 0;
	public Scoop(IceCreamFlavor flavor)
	{
		this.flavor = flavor;
		this.mixins = new ArrayList<>();
	}
	
	public addMixIn(MixIn mixin)
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
