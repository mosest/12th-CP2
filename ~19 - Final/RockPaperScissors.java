//Tara Moses
//CP2 Final Game: Rock, Paper, Scissors
//December 16, 2013

import java.util.Scanner;

public class RockPaperScissors{
	RockPaperScissors()
	{
		int i = 0;
	}
	public void run()
	{
		Scanner sc=new Scanner(System.in);
		Item user=new Item("Rock");
		Item comp;
		String again="y";
		int choice;
		
		System.out.println("LET'S PLAY ROCK PAPER SCISSORS, EVERYBODY!!");
		do {
			do {
				System.out.print("\nChoose (1) rock, (2) paper, or (3) scissors: ");
				choice=sc.nextInt();
				if (choice==1) {
					user=new Item("Rock");
				} else if (choice==2) {
					user=new Item("Paper");
				} else if (choice==3) {
					user=new Item("Scissors");
				} else {
					System.out.println("Not a valid choice. Please enter a 1, 2, or 3.");
				}
			} while (choice>3 || choice<1);
			
			//GENERATE RANDOM COMPUTER CHOICE
			int compChoice=(int)(Math.random()*3+1);
			if (compChoice==1) {
				comp=new Item("Rock");
			} else if (compChoice==2) {
				comp=new Item("Paper");
			} else {
				comp=new Item("Scissors");
			}
			System.out.print("\nComputer chose "+comp.getName()+". ");
			System.out.println(user.announceWinner(user,comp)+"\n");
			
			System.out.print("Play again? (y/n): ");
			again=sc.next();
		} while (again.equalsIgnoreCase("y"));
		System.out.println("\nOkay. Goodbye!\n");
	}
}

