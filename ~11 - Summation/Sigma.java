//Tara Moses
//Assignment 13: Sigma (Recursive Summation)
//October 4, 2013

import java.util.Scanner;

public class Sigma
{
	public static int addRecursively(int n)
	{
		int sum=0;
		while (n>0)
		{
			sum+=n;
			n--;
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		String again="y";
		
		while (again.equalsIgnoreCase("y"))
		{
			System.out.print("Number to add: ");
			int n=scan.nextInt();
			
			System.out.println("The number "+n+" sums up to "+addRecursively(n)+".");
			System.out.print("Sum another number? (y/n): ");
			again=scan.next();
			System.out.println();
		}
	}
}
