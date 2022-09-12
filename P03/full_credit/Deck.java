import java.util.Stack;
//import java.util.Collections.shuffle;

public class Deck
{
	Stack<Card> deck = new Stack<>();
	
	public Deck()
	{
		for(int i = 0; i < 3; i++)
		{
 			for(int j = 0; j < 9; j++)
			{
				Rank r = new Rank(j);
				Suit s = Suit.U;
				Card c = new Card(r, s);
				deck.push(c);
				System.out.print(" " + c);
			}
		}
	}
}
