//Tara Moses
//Assignment 2: Magic Squares
//August 23, 2013

import java.util.Scanner;

public class MagicDriver
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.print("What size square? (Enter an odd number 1-15): ");
		int size=scan.nextInt();
		
		while (size%2==0 || size>15)
		{
			System.out.print("Unacceptable size. Enter an odd number 1-15: ");
			size=scan.nextInt();
		}
		
		Magic square=new Magic(size);
		square.fill();
		square.putNumsIn();
		square.drawSquare();
	}
}
