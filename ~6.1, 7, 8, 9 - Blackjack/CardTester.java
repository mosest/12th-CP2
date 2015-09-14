//Tara Moses
//Assignment 6.1: Blackjack, part 1
//September 12, 2013

public class CardTester
{
	public static void main(String[] args)
	{
		Card card1=new Card("Ace","Hearts");
		
		//deal a random card
		
		System.out.println("Your card is the "+card1.getFaceValue()+" of "+card1.getSuit()+".");
		System.out.println("It is worth "+card1.getPoints()+" points.");
		
		System.out.println();
	}
}
