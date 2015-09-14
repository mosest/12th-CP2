/**
 * This class holds the object methods for Assignment 3: Tic-Tac-Toe.
 * @author Tara Moses
 * @version Updated on August 29, 2013
 */
public class TicTacToeGrid
{
	String[] nums;
	/**
	 * This constructor initiates the nums array as 9 slots.
	 */
	public TicTacToeGrid()
	{
		this.nums=nums;
		nums=new String[9];
	}
	/**
	 * This method prints out the TicTacToe board 
	 * including all previous moves.
	 */
	public void drawGrid()
	{
		System.out.println();
		for (int i=0;i<3;i++)
		{
			System.out.print("|");
			for (int j=0;j<3;j++)
			{
				System.out.print("   |");
			}
			
			System.out.print("\n|");
			for (int j=0;j<3;j++)
			{
				System.out.print(" "+nums[i*3+j]+" |");
			}
			
			System.out.print("\n|");
			for (int j=0;j<3;j++)
			{
				System.out.print("   |");
			}
			
			System.out.print("\n+");
			for (int k=0;k<3;k++)
			{
				System.out.print("---+");
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * This method writes to the nums[] array in the place of someone's move
	 * and with their marker (i.e. "x" or "o").
	 * @param marker Either an "x" or "o" depending on player.
	 * @param place Number where player has selected their move to go.
	 * @exception InterruptedException ie This allows another method it is calling to finish without going on.
	 * @see InterruptedException ie
	 */
	public void putMarkerIn(String marker, int place) 
	{
		try
		{
			nums[place]=marker;
			drawGrid();
			Thread.sleep(1000);
		}
		catch(InterruptedException ie)
		{
			
		}
	}
	/** 
	 * This method returns whether or not a place is available to put a move in.
	 * @param place Number where player has selected their move to go.
	 * @return boolean determining if the parameter place is available.
	 */
	public boolean isAvailable(int place)
	{
		if (place<0 || place>8) return false;
		if (!nums[place].equals(String.valueOf(place))) return false;
		return true;
	}
	/**
	 * This method checks to see if either player has won or not.
	 * @return the status of the winner or that the game has not finished.
	 */
	public String findWinner()
	{
		String winner="none";
		
		if (isFull()) winner="Cat";
		
		//check Xs
		for (int i=0;i<3;i++)
		{
			if (nums[i*3].equals(nums[i*3+1]) && nums[i*3+1].equals(nums[i*3+2]) && nums[i*3+2].equals("X")) winner="X";
			if (nums[i].equals(nums[i+3]) && nums[i+3].equals(nums[i+6]) && nums[i+6].equals("X")) winner="X";
		}
		if (nums[0].equals(nums[4]) && nums[4].equals(nums[8]) && nums[8].equals("X")) winner="X";
		if (nums[2].equals(nums[4]) && nums[4].equals(nums[6]) && nums[6].equals("X")) winner="X";
		
		//now check Os
		for (int i=0;i<3;i++)
		{
			if (nums[i*3].equals(nums[i*3+1]) && nums[i*3+1].equals(nums[i*3+2]) && nums[i*3+2].equals("O")) winner="O";
			if (nums[i].equals(nums[i+3]) && nums[i+3].equals(nums[i+6]) && nums[i+6].equals("O")) winner="O";
		}
		if (nums[0].equals(nums[4]) && nums[4].equals(nums[8]) && nums[8].equals("O")) winner="O";
		if (nums[2].equals(nums[4]) && nums[4].equals(nums[6]) && nums[6].equals("O")) winner="O";
		
		return winner;
	}
	/**
	 * This method finds the best place for the AI to move.
	 * @return the number of the place where the AI's move will go.
	 */
	public int makeASmartMove()
	{
		int bestPlace=0;
		
		for (int i=0;i<9;i++)
		{
			if (isAvailable(i)) bestPlace=i;
		}
		
		if (findWinner().equals("none"))
		{
			//block opponent and try to win
			for (int i=0;i<3;i++)
			{
				if (nums[i*3].equals(nums[i*3+1]) && isAvailable(i*3+2)) bestPlace=i*3+2; 
				if (nums[i*3].equals(nums[i*3+2]) && isAvailable(i*3+1)) bestPlace=i*3+1; 
				if (nums[i*3+1].equals(nums[i*3+2]) && isAvailable(i*3)) bestPlace=i*3; 
				if (nums[i].equals(nums[i+3]) && isAvailable(i+6)) bestPlace=i+6;
				if (nums[i].equals(nums[i+6]) && isAvailable(i+3)) bestPlace=i+3;
				if (nums[i+3].equals(nums[i+6]) && isAvailable(i)) bestPlace=i;
			}
			if (nums[0].equals(nums[4]) && isAvailable(8)) bestPlace=8;
			if (nums[0].equals(nums[8]) && isAvailable(4)) bestPlace=4;
			if (nums[4].equals(nums[8]) && isAvailable(0)) bestPlace=0;
			if (nums[2].equals(nums[4]) && isAvailable(6)) bestPlace=6;
			if (nums[2].equals(nums[6]) && isAvailable(4)) bestPlace=4;
			if (nums[4].equals(nums[6]) && isAvailable(2)) bestPlace=2;
		}
		return bestPlace;
	}
	/**
	 * This method fills the nums array with numbers representing where players can move.
	 */
	public void fill()
	{
		for (int i=0;i<9;i++)
		{
			nums[i]=String.valueOf(i);
		}
	}
	/**
	 * This method detects if there are any moves left to make in the game.
	 * @return a boolean value of whether or not the board is full or not.
	 */
	public boolean isFull()
	{
		for (int i=0;i<9;i++)
		{
			if (nums[i].equals(String.valueOf(i))) return false;
		}
		return true;
	}
}
