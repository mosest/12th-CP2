//Tara Moses
//Class for Assignment 8: Blackjack, part 3
//September 28, 2013

public class Hand
{
	int numCards;
	Card[] handOfCards;
	Deck tempDeck;
	
	public Hand(Deck d)
	{
		handOfCards=new Card[4];
		tempDeck=d;
		
		tempDeck.shuffle();
		handOfCards[0]=tempDeck.getNextCard();
		handOfCards[1]=tempDeck.getNextCard();
		
		numCards=2;
	}
	
	public int calculateHandValue()
	{
		int points=0;
		int pointSum=0;
		int finalPointSum=0;
		int aceCount=0;
		
		//the first time just go through and count aces
		for (int i=0;i<numCards;i++)
		{
			if (handOfCards[i].points==11) aceCount++;
			points=handOfCards[i].getPoints();
			pointSum+=points;
		}
		
		if (pointSum>21 && aceCount>0)
		{
			//go through and make all necessary aces=1
			for (int i=0;i<numCards;i++)
			{
				if (handOfCards[i].points==11 && pointSum>21) 
				{
					handOfCards[i].points=1;
					pointSum-=10;
				}
			}
		}
		return pointSum;
	}
	
	public String showAllCards()
	{
		String cardsInHand="";
		for (int i=0;i<numCards;i++)
		{
			cardsInHand+="The "+handOfCards[i].getFaceValue()+" of "+handOfCards[i].getSuit()+" has a value of "+handOfCards[i].getPoints()+"\n";
		}
		return cardsInHand;
	}
	
	public String showOneCard()
	{
		String cardToShow="The "+handOfCards[0].getFaceValue()+" of "+handOfCards[0].getSuit()+" has a value of "+handOfCards[0].getPoints()+"\n";
		return cardToShow;
	}
	
	public void hit()
	{
		numCards++;
		handOfCards[numCards-1]=tempDeck.getNextCard();
	}
	
	public boolean hasBusted()
	{
		if (calculateHandValue()>21) return true;
		return false;
	}
}
