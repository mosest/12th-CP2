//Tara Moses
//Assignment 3: Tic-Tac-Toe
//August 29, 2013
//OBJECT VERSION

import java.util.Scanner;

public class TicTacToeDriver
{
	TicTacToeDriver()
	{
		int i = 0;
	}
	
	public void run() throws Exception
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("-----3: TIC TAC TOE-----\n");
		
		System.out.print("(1) Player vs Computer\n(2) Player vs Player\n\nChoose game type: ");
		int gameType=scan.nextInt();
		System.out.print("\nWho's going first: (1) X, or (2) O? ");
		int first=scan.nextInt();
		
		String marker1=(first==1)?"X":"O";
		String marker2=(first==1)?"O":"X";
		
		TicTacToeGrid grid=new TicTacToeGrid();
		
		grid.fill();
		grid.drawGrid();
		
		if (gameType==1)												//if it's player vs computer
		{
			while (grid.findWinner().equals("none"))
			{
				System.out.print(marker1+"'s turn. Where would you like? ");
				int place=scan.nextInt();
				
				while (!grid.isAvailable(place))
				{
					System.out.print("That place isn't available. Where would you like? ");
					place=scan.nextInt();
				}
				
				grid.putMarkerIn(marker1,place);						//user places his token
				
				int compPlace=grid.makeASmartMove();
				if (grid.findWinner().equals("none"))
				{
					System.out.println("Computer's turn. Computer chooses position "+compPlace+".");
					grid.putMarkerIn(marker2,compPlace);
				}
			}
			System.out.println("\n-----"+grid.findWinner()+" wins! GAME OVER!-----\n");
		}
		
		else															//if it's player vs player
		{
			int count=0;
			String marker=marker1;
			while (grid.findWinner().equals("none"))
			{
				System.out.print(marker+"'s turn. Where would you like? ");
				int place=scan.nextInt();
				
				while (!grid.isAvailable(place))
				{
					System.out.print("That place isn't available. Where would you like? ");
					place=scan.nextInt();
				}
				
				grid.putMarkerIn(marker,place);
				count++;
				marker=(count%2==0)?marker1:marker2;
			}
			System.out.println("\n-----"+grid.findWinner()+" wins! GAME OVER!-----\n");
		}
	}
}
