package product;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixIn
{
	public MixIn(MixInFlavor flavor, MixInAmount amount) //constructor
	{
		this.flavor = flavor;
		this.amount = amount;
	}
	public MixIn(BufferedReader in) throws IOException
	{
		flavor = new MixInFlavor(in);
		amount = MixInAmount.valueOf(br.readLine());
	}
	public void save(BufferedWriter out)
	{
		flavor.save(out);
		out.write(amount.toString() + '\n');
	}
	
	@Override
	public String toString()
	{
		return flavor.toString() + (!amount.equals(MixInAmount.Normal) ? " (" + amount + ")" : "");
	}
	
	private MixInFlavor flavor;
	private MixInAmount amount;
}
