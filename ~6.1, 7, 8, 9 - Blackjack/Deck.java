//Tara Moses
//Class for Assignment 8: Blackjack, part 2
//September 16, 2013

public class Deck
{
	Card[] cardDeck=new Card[52];
	int nextCardIndex;
	
	public Deck()
	{
		int suitCount=1;
		String suit="";
		int faceCount=2;
		String face="";
		nextCardIndex=-1;
		
		for (int i=0;i<52;i++)
		{
			switch (suitCount)
			{
				case 1: 
				{
					suit="Hearts";
					break;
				}
				case 2: 
				{
					suit="Diamonds";
					break;
				}
				case 3: 
				{
					suit="Spades";
					break;
				}
				default: 
				{
					suit="Clubs";
					break;
				}
			}
			
			if (faceCount>1 && faceCount<11) face=String.valueOf(faceCount);
			else
			{
				switch (faceCount)
				{
					case 11: 
					{
						face="Jack";
						break;
					}
					case 12: 
					{
						face="Queen";
						break;
					}
					case 13: 
					{
						face="King";
						break;
					}
					default: 
					{
						face="Ace";
						break;
					}
				}
			}
				
			Card card=new Card(face,suit);
			cardDeck[i]=card;
			
			faceCount++;
			if (faceCount>14)
			{
				faceCount=2;
				suitCount++;
			}
			if (suitCount>4) suitCount=0;
		}
	}
	
	public void printDeck()
	{
		for (int i=0;i<52;i++)
		{
			System.out.println(i+") "+cardDeck[i].getFaceValue()+" of "+cardDeck[i].getSuit());
		}
	}
	
	public void shuffle()
	{
		for (int i=0;i<1000;i++)
		{
			int randomIndex1=(int)(Math.random()*52);
			int randomIndex2=(int)(Math.random()*52);
			
			Card holder=cardDeck[randomIndex1];
			cardDeck[randomIndex1]=cardDeck[randomIndex2];
			cardDeck[randomIndex2]=holder;
		}
	}
	
	public Card getNextCard()
	{
		nextCardIndex++;
		return cardDeck[nextCardIndex];		
	}
}
