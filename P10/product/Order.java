package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Order
{
	public Order(BufferedReader in) throws IOException
	{
		this.servings = new ArrayList<>();
	}
	
	public save(BufferedWriter out) throws IOException
	{
		out.write("" + mixins.size() + '\n');
		for(Serving se : servings)
		{
			se.save(out);
		}
	}
	
	public addServing(Serving serving)
	{
		servings.add(serving);
	}
	
	protected ArrayList<Serving> servings;
}
