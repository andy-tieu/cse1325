//Andy Tieu 1001635126
//CSE1325-002

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
		return rank + "";
	}

	public static final int MIN = 0;
	public static final int MAX = 9;
	
	private int rank;
}
