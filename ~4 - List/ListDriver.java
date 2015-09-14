//Tara Moses
//Assignment 4: List
//September 3, 2013

import java.util.Scanner;

public class ListDriver
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		List list=new List();
		
		System.out.println("(1) Add a number to the list");
		System.out.println("(2) Delete a number from the list");
		System.out.println("(3) Search for a number in the list");
		System.out.println("(4) Print the list");
		System.out.println("(5) Exit");
		System.out.print("\nChoose an option: ");
		int option=scan.nextInt();
		
		while (option<1 || option>5)
		{
			System.out.print("Unacceptable option. Please choose again: ");
			option=scan.nextInt();
		}
		
		while (option!=5)
		{
			if (option==1)
			{
				if (list.size==25) System.out.println("The list is full!");
				else
				{
					System.out.print("Number to add: ");
					int numToAdd=scan.nextInt();
					if (!list.isADuplicate(numToAdd))
					{
						list.add(numToAdd);
						System.out.println(numToAdd+" was added.");
					}
					else System.out.println(numToAdd+" is already in the list.");
				}
			}
			else if (option==2)
			{
				System.out.print("Number to delete: ");
				int numToDelete=scan.nextInt();
				if (list.search(numToDelete)==-1) System.out.println("Cannot find number to delete.");
				else
				{
					list.delete(numToDelete);
					System.out.println(numToDelete+" was deleted.");
				}
			}
			else if (option==3)
			{
				System.out.print("Number to search for: ");
				int numToSearchFor=scan.nextInt();
				if (list.search(numToSearchFor)!=-1) System.out.println(numToSearchFor+" was found.");
				else System.out.println(numToSearchFor+" wasn't found.");
			}
			else if (option==4)
			{
				System.out.println("Printing list...\n");
				list.print();
			}
			System.out.print("\nWhat would you like to do next? ");
			option=scan.nextInt();
		}
		System.out.println("Goodbye.");
	}
}
