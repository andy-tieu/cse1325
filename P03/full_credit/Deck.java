//Andy Tieu 1001635126
//CSE1325-002

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
 			for(j = 0; j < 10; j++)
			{
				Suit s = Suit.values()[i];	
				Rank r = new Rank(j);
				Card c = new Card(r, s);
				deck.push(c);
			}
		}
		Collections.shuffle(deck);
		System.out.println(deck); //best way to show that deck was created and shuffled since deal did 										not work
	}
	
	public boolean isEmpty()
	{
		if(deck.empty() == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public Card deal() //could not get deal to work and print out the deck
	{
		if(deck.isEmpty() == true)
		{
			throw new IllegalArgumentException("Deck is empty!");
		}
		while(deck.isEmpty() == false)
		{
			System.out.print(" " + deck.pop());
			return deck.pop();
		}
		return deck.pop();
	}
}
