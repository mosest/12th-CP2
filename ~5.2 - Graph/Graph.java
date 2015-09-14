//Tara Moses
//Assignment 5.2: Report Graph
//September 6, 2013

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Graph
{
	public static void main(String[] args)  throws Exception
	{
		Scanner filescan=new Scanner(new File("GraphData.txt"));
		PrintWriter writer=new PrintWriter("Graph.txt", "UTF-8");
		
		while (filescan.hasNext())
		{
			String line=filescan.nextLine();
			String question=line.substring(0,49);
			int score=Integer.parseInt(line.substring(50,53));
			String asterisks="";
			for (int i=0;i<score/2;i++)
			{
				asterisks+="*";
			}
			if (score%2==1) asterisks+="*";
			writer.write(question+" "+asterisks+"\n");
		}
		writer.close();
	}
}
