//Tara Moses
//Assignment 11: Language
//September 27, 2013

import java.util.Scanner;
import java.io.PrintWriter;

public class Language
{
	public static boolean isInLanguage(String str)
	{
		CharStack stack=new CharStack(str);
		int dollarIndex=str.length()/2;
		String lastHalf=str.substring(dollarIndex+1);
		String firstHalfBackwards="";
		String letter="";
		
		if (str.length()%2==0) return false;
	
		for (int i=0;i<dollarIndex;i++)
		{
			letter=str.substring(i,i+1);
			stack.push(letter);
		}
		
		for (int i=0;i<dollarIndex;i++)
		{
			firstHalfBackwards+=stack.pop();
		}
		
		if (!lastHalf.equals(firstHalfBackwards)) return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		String again="y";
		
		System.out.print("Specify output file name: ");
		String outFileName=scan.nextLine();
		PrintWriter writer=new PrintWriter(outFileName,"UTF-8");
		
		writer.write("Tara Moses\n");
		writer.write("CPII\n");
		writer.write("Assignment 11: Language\n\n");
		
		while (again.equalsIgnoreCase("y"))
		{
			System.out.print("\nEnter a string: ");
			String inWord=scan.next();
			
			if (isInLanguage(inWord)) 
			{
				System.out.println("\""+inWord+"\" in language.");
				writer.write("\""+inWord+"\" in language.\n");
			}
			else
			{
				System.out.println("\""+inWord+"\" not in language.");
				writer.write("\""+inWord+"\" not in language.\n");
			}
			
			System.out.print("Enter another string? (y/n): ");
			again=scan.next();
		}
		System.out.println();
		writer.close();
	}
}
