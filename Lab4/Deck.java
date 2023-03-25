/*
Joshua Genal
CS&145
Lab 4: Deck of Cards
Deck
*/
import java.util.Stack;

public class Deck 
{
    private Stack<Card> cards;

    public Deck() 
    {
        cards = new Stack<Card>();
        for (Suit suit : Suit.values()) 
        {
            for (Rank rank : Rank.values()) 
            {
                cards.push(new Card(rank, suit));
            }
        }
    }

    public void shuffle() 
    {
        for (int i = 0; i < cards.size(); i++) 
        {
            int j = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card drawCard() throws Exception 
    {
        if (cards.empty()) 
        {
            throw new Exception("Deck is empty");
        }
        return cards.pop();
    }
}
