//Tara Moses
//Assignment 6.2: Acronym
//September 12, 2013

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Acronym
{
	public static void main(String[] args) throws Exception
	{
		Scanner filescan=new Scanner(new File("inAcronym.txt"));
		PrintWriter writer=new PrintWriter("outAcronym.txt","UTF-8");	
		
		while (filescan.hasNext())
		{
			String line=filescan.nextLine();
			line=line.substring(1,line.length());
			String acronym="";
			String[] words=line.split(" ");	
			
			for (String word : words)
			{
				if (!word.equals("the") && !word.equals("and") && !word.equals("of")) acronym+=word.substring(0,1).toUpperCase();
			}
			
			acronym=acronym.trim();		
			writer.write(acronym+"\n");
		}
		System.out.println("The acronyms have been written to outAcronym.txt.\n");
		writer.close();
	}
}
