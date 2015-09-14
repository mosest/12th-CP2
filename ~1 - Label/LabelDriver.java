//Tara Moses
//Assignment 1: Labels
//August 22, 2013

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class LabelDriver
{
	public static void main(String[] args) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		Scanner filescan=new Scanner(System.in);

		while (true)
		{
			try
			{
				System.out.print("Input file name: ");
				String inFileName=scan.nextLine();
				
				filescan=new Scanner(new File(inFileName));
				break;
			}
			catch (Exception e)
			{
				System.out.print("File not found! ");
			}
		}
		
		System.out.print("Output file name: ");
		String outFileName=scan.nextLine();
		
		PrintWriter writer=new PrintWriter(outFileName, "UTF-8");
		
		while (filescan.hasNext())
		{
			String line=filescan.nextLine();
			String name=line.substring(0,24).trim();
			String address=line.substring(24,45).trim();
			String city=line.substring(45,61).trim();
			String state=line.substring(61,63).trim();
			String zipcode=line.substring(63,68).trim();
			
			writer.write(name+"\n");
			writer.write(address+"\n");
			writer.write(city+", "+state+"  "+zipcode+"\n");
			writer.write("\n\n");
		}
		writer.close();
	}
}
