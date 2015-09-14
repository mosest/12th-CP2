//Tara Moses
//Assignment 9: Blackjack, part 4
//October 1, 2013

import java.util.Scanner;

public class BlackJackFinal
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		Deck deck=new Deck();
		Hand dealerHand=new Hand(deck);
		Hand playerHand=new Hand(deck);
		
		System.out.println("Welcome to BlackJack!\n");
		
		System.out.println();
		
		System.out.println("Dealer's Hand (partial):");
		System.out.println(dealerHand.showOneCard());
			
		System.out.println("Player's Hand:");
		System.out.println(playerHand.showAllCards());
		
		System.out.print("Would you like another card? (y/n): ");
		String anotherCard=scan.nextLine();
		System.out.println();
		
		while (!playerHand.hasBusted() && anotherCard.equalsIgnoreCase("y") && playerHand.numCards<4) //while the game's not over
		{
			System.out.println("Dealer's Hand (partial):");
			System.out.println(dealerHand.showOneCard());
			
			System.out.println("Player's Hand:");
			playerHand.hit();
			System.out.println(playerHand.showAllCards());
			
			if (!playerHand.hasBusted() && playerHand.numCards<4)
			{
				System.out.print("Would you like another card? (y/n): ");
				anotherCard=scan.nextLine();
				System.out.println();
			}
		}
		
		System.out.println("Dealer's Hand:");
		System.out.println(dealerHand.showAllCards());
			
		System.out.println("Player's Hand:");
		System.out.println(playerHand.showAllCards());
		
		if (!playerHand.hasBusted())	//if player didn't bust (if player doesn't want/can't take any more cards)
		{
			String winner="";
			if (Math.abs(playerHand.calculateHandValue()-21)>Math.abs(dealerHand.calculateHandValue()-21)) winner="Dealer";
			else if (Math.abs(playerHand.calculateHandValue()-21)<Math.abs(dealerHand.calculateHandValue()-21)) winner="Player";
			else winner="Nobody";			
			System.out.println(winner+" wins!\n");
		}
		else System.out.println("Player busted! Dealer wins.\n");	//if player busted just print that (s)he busted
		
	}
}
