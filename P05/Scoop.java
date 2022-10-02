public class Scoop
{
	public Scoop(IceCreamFlavor flavor)
	{
		this.flavor = flavor;
	}
	
	public addMixIn(MixIn mixins)
	{
	
	}

	@Override
	public String toString()
	{
		return flavor;
	}
	
	private IceCreamFlavor flavor;
	private MixIn[] mixins;
}
