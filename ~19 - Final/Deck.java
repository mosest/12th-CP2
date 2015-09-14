//52 cards
//make array of 52 cards with the static methods in cards (in deck constructor)
//suffle method, switch two random generated numbers
public class Deck
{
	Card []card=new Card[52];
	int nextToDeal=-1;
	
	Deck()
	{
		int counter=0;
		for(int j=1;j<=4;j++)
		{
			for(int i=1;i<=13;i++)
			{
				card[counter]=new Card(Card.figureName(i),Card.figureSuit(j));
				counter++;
			}
		}
		
	}
	public void printDeck()
	{
		for(int k=0;k<52;k++)
		{
			System.out.println(card[k]);
		}
	}
	public void shuffle()
	{
		int x;
		Card temp;
		int num1,num2;
		for(x=0; x<1000; x++)
		{
			num1 = (int)(Math.random() * 52);
			num2 = (int)(Math.random() * 52);
			temp = card[num1];
			card[num1]=card[num2];
			card[num2]=temp;
		}
	}
	public Card dealOne()
	{
		nextToDeal++;
		return card[nextToDeal];
	}
}
