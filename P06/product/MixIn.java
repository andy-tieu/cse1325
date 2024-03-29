package product;

public class MixIn
{
	public MixIn(MixInFlavor flavor, MixInAmount amount) //constructor
	{
		this.flavor = flavor;
		this.amount = amount;
	}
	
	@Override
	public String toString()
	{
		return flavor.toString() + (!amount.equals(MixInAmount.Normal) ? " (" + amount + ")" : "");
	}
	
	private MixInFlavor flavor;
	private MixInAmount amount;
}
