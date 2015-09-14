//Tara Moses
//Assignment 5.1: Your Data's Safe With Us
//September 6, 2013

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Safedata
{
	public static void main(String[] args) throws Exception
	{
		Scanner filescan=new Scanner(new File("safedata.txt"));
		PrintWriter writer=new PrintWriter("saferdata.txt","UTF-8");
		int count=1;
		
		while (filescan.hasNext())
		{
			String line=filescan.nextLine();
			if (line.trim().equals("")) count=0;
			if (count==10 || count==11) line="          ";
			writer.write(line+"\n");
			count++;
		}
		writer.close();
	}
}
