public class Item
{
	public Item(String name, String description, int cost, int price)
	{
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.price = price;
	}
	
	public String name()
	{
	
	}
	
	public String description()
	{
	
	}
	
	public int price()
	{
	
	}

	public int cost()
	{
	
	}
	
	@Override
	public String toString()
	{
		return name;
	}
		
	private String name;
	private String description;
	private int cost;
	private int price;
}
