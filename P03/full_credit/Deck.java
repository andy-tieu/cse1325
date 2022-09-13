import java.util.Stack;
import java.util.Collections;

public class Deck
{
	Stack<Card> deck = new Stack<>();
	int i, j;
	
	public Deck()
	{
		for(i = 0; i < 3; i++)
		{
 			for(j = 0; j < 9; j++)
			{
				Suit s = Suit.values()[i];	
				Rank r = new Rank(j);
				Card c = new Card(r, s);
				deck.push(c);
				System.out.print(" " + c);
			}
		}
	}
	
	/*Collections.shuffle(deck);
	public boolean isEmpty
	public Card deal()*/
}
