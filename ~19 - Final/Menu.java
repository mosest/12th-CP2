/*
	CP2 FINAL: MENU PROTOTYPE
*/
import java.util.Scanner;
public class Menu
{
	public static void main(String[] args) throws Exception
	{
		//AW YEAH
		Scanner sc = new Scanner(System.in);
		
		blackJackDriver BlackJack = new blackJackDriver();
		//BlackJack.run();
		Dedjail Maze = new Dedjail();
		//Maze.run();
		hangman hang = new hangman();
		//hang.run();
		Tag TurtleTag = new Tag();
		//TurtleTag.run();
		elevenboom boom11 = new elevenboom();
		//booom11.run();
		Game TheGame = new Game();
		//TheGame.run();
		TicTacToeDriver TTT = new TicTacToeDriver();
		//TTT.run();
		System.out.println("YOU HAVE REACHED THE GAME MENU");
		String choice = "";
		boolean play = true;
		while (play == true)
		{
			choice = "";
			System.out.println("PLEASE ENTER WHICH GAME YOU WOULD LIKE TO PLAY OR \"Q\" TO QUIT.");
			System.out.println("BLACKJACK\nMAZE\nHANGMAN\nTAG\nELEVENBOOM\nTHE GAME\nTICTACTOE");
			choice = sc.nextLine();
			if (choice.trim().equalsIgnoreCase("q")) play = false;
			else if (choice.trim().equalsIgnoreCase("blackjack")) BlackJack.run();
			else if (choice.trim().equalsIgnoreCase("maze")) Maze.run();
			else if (choice.trim().equalsIgnoreCase("hangman")) hang.run();
			else if (choice.trim().equalsIgnoreCase("tag")) TurtleTag.run();
			else if (choice.trim().equalsIgnoreCase("elevenboom")) boom11.run();
			else if (choice.trim().equalsIgnoreCase("TRON")) TheGame.run();
			else if (choice.trim().equalsIgnoreCase("tictactoe")) TTT.run();
			if (play == true) System.out.println("EAGESA");
		}
	}
}