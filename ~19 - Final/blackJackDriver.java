//OBJECT VERSION
import java.util.Scanner;

public class blackJackDriver
{
	blackJackDriver()
	{
		int i = 0;
	}
	public void run()
	{
		Scanner sc=new Scanner(System.in);
		boolean wantToPlay=true;
		String answer="";
		while(wantToPlay)
		{
			boolean hitMe=true;
			boolean didBust=false;
			boolean twentyOne=false;
			String hit="";
			Deck myDeck=new Deck();
			myDeck.shuffle();
			Hand myHand=new Hand(myDeck.dealOne(),myDeck.dealOne());
			Hand DealerHand=new Hand(myDeck.dealOne(),myDeck.dealOne());
			System.out.println("Dealers Hand: "+DealerHand.showOneCard());
			while (hitMe)
			{
				System.out.print("Your Hand: "+myHand.showAllCards());
				System.out.println("Your value is "+myHand.calculateHandValue());
				if (myHand.calculateHandValue()>21)
				{
					System.out.println("\nYou busted, Dealer wins!\n");
					hitMe=false;
					didBust=true;
				}
				if (myHand.calculateHandValue()==21)
				{
					System.out.println("You got 21!\n");
					hitMe=false;
					twentyOne=true;
				}
				if (didBust==false && twentyOne==false)
				{
					System.out.println("Hit me? (y/n)");
					hit=sc.next();
					hit=hit.substring(0,1);
					hit=hit.toLowerCase();
					System.out.println();
					if (hit.equals("y"))
					{
						myHand.hit(myDeck.dealOne());
					}
					if (hit.equals("n"))
					{
						hitMe=false;
					}
				}
			}
			if (didBust==false)
			{
				System.out.print("Dealers Hand: "+DealerHand.showAllCards());
				System.out.println("His hand value is "+DealerHand.calculateHandValue());
				while(DealerHand.calculateHandValue()<myHand.calculateHandValue() || DealerHand.calculateHandValue()<17)
				{
					DealerHand.hit(myDeck.dealOne());
					System.out.print("\nDealers Hand: "+DealerHand.showAllCards());
					System.out.println("His hand value is "+DealerHand.calculateHandValue());
				}
				if (DealerHand.calculateHandValue()>21)
				{
					System.out.println("\nDealer busted, You wins!\n");
				}
				else if (DealerHand.calculateHandValue()==myHand.calculateHandValue())
				{
					System.out.println("\nNo win, split pot.\n");
				}
				else if (DealerHand.calculateHandValue()>myHand.calculateHandValue())
				{
					System.out.println("\nDealer wins\n");
				}
				else
				{
					System.out.println("\nCongrates, you win!");
				}
			}
			System.out.println("Would you like to play again? (y/n)");
			answer=sc.next();
			answer=answer.substring(0,1);
			answer=answer.toLowerCase();
			if (answer.equals("n"))
			wantToPlay=false;
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		
	}
}
