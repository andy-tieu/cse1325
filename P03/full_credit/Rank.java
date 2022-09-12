public class Rank
{
	public Rank(int rank)
	{
		if(MIN <= rank && rank <= MAX)
		{
			this.rank = rank;
		}
	}
	@Override
	public String toString()
	{
		return rank;
	}
	final public static int MIN = 0;
	final public static int MAX = 9;
	
	private int rank;
}
