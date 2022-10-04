public class Scoop
{
	public Scoop(IceCreamFlavor flavor)
	{
		this.flavor = flavor;
	}
	
	public addMixIn(MixIn mixin)
	{
		int i = 0;
		mixins = new MixIn[i];
		i++;
	}

	@Override
	public String toString()
	{
		if(i.equals(1))
		{
			return flavor + " with " + mixins[0];
		}
		else if(i > 1)
		{
			return flavor + " with " + mixins[i];
		}
		return flavor;
	}
	
	private IceCreamFlavor flavor;
	private MixIn[] mixins;
}
