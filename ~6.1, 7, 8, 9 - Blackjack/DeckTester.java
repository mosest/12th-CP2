//Tara Moses
//Assignment 7: Blackjack, part 2
//September 23, 2013

public class DeckTester
{
	public static void main(String[] args)
	{
		Deck myDeck=new Deck();
		
		myDeck.printDeck();

		System.out.println("\nNOW THE DECK SHALL BE SHUFFLED:\n");
		myDeck.shuffle();
		
		myDeck.printDeck();
		System.out.println("\nTHE DECK HAS FINISHED SHUFFLING.\n");
		
		Card currentCard=myDeck.getNextCard();
		System.out.println("The 11th card is the "+currentCard.getFaceValue()+" of "+currentCard.getSuit()+".");
	}
}
