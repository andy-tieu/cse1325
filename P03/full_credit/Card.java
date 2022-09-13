//Andy Tieu 1001635126
//CSE1325-002

public class Card
{
	public Card(Rank rank, Suit suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	@Override
	public String toString()
	{
		return rank + "" + suit;
	}
	
	private Rank rank;
	private Suit suit;
}
