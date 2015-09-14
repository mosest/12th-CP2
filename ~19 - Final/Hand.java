public class Hand
{
	Card []card=new Card[100];
	int numCards =0;
	boolean haveAce;
	
	Hand(Card c1, Card c2)
	{
		haveAce=false;
		card[0] =c1;
		card[1] =c2;
		numCards =2;
	}
	
	public String showOneCard()
	{
		String s="\n";
		s+=card[0]+"\n";
		return s;
	}
	public int calculateHandValue()
	{
		int value=0;
		int tempvalue;
		for (int x=0;x<numCards;x++)
		{
			tempvalue=value;
			value+=card[x].getPoints();
			if (value-tempvalue==11)
			haveAce=true;
		}
		if (value>21 && haveAce==true)
		{
			value=value-10;
		}
		return value;		
	}
	public String showAllCards()
	{
		String hand="\n";
		for(int k=0;k<numCards;k++)
		{
			hand+=card[k]+"\n";
		}
		return hand;
	}
	public void hit(Card c)
	{
		card[numCards]=c;
		numCards++;
	}
}
