//Tara Moses
//Class for Assignment 6.1: Blackjack, part 1
//September 12, 2013

public class Card
{
	String faceValue;
	String suit;
	int points;
	
	public Card(String inFaceValue,String inSuit)
	{
		this.faceValue=faceValue;
		this.suit=suit;
		this.points=points;
		
		faceValue=inFaceValue;
		suit=inSuit;
		
		if (faceValue=="Jack" || faceValue=="Queen" || faceValue=="King") points=10;
		else points=11;
		try
		{
			points=Integer.parseInt(faceValue);
		}
		catch (Exception e)
		{
			//faceValue is not a number
		}
	}
	
	public boolean compareCardValue(Card cardToCompare)
	{
		if (cardToCompare.points==points) return true;
		return false;
	}
	
	public String figureName(int n)
	{
		switch (n)
		{
			case 1: return "Jack";
			case 2: return "Queen";
			case 3: return "King";
			case 4: return "Ace";
			default: return String.valueOf(n);
		}
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public String figureSuit(int n)
	{
		switch (n)
		{
			case 1: return "Hearts";
			case 2: return "Diamonds";
			case 3: return "Spades";
			case 4: return "Clubs";
			default: return "Invalid Suit";
		}
	}
	
	public String toString(int n)
	{
		return String.valueOf(n);
	}
	
	public String getFaceValue()
	{
		return faceValue;
	}
	
	public String getSuit()
	{
		return suit;
	}
}
