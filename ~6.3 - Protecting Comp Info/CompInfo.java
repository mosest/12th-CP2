//Tara Moses
//Assignment 6.3: Protecting Computer Information
//September 12, 2013

import java.util.Scanner;
import java.io.File;

public class CompInfo
{
	public static String encode(String word,int key)
	{
		String codedWord="";
		String lower="abcdefghijklmnopqrstuvwxyz";
		String upper=lower.toUpperCase();
		String preferredAlphabet=lower;
		
		for (int i=0;i<word.length();i++)
		{
			if (word.substring(i,i+1).equals(word.substring(i,i+1).toUpperCase())) preferredAlphabet=upper;
			else preferredAlphabet=lower;
			int letterIndex=preferredAlphabet.indexOf(word.substring(i,i+1));
			if (letterIndex!=-1)
			{
				if (letterIndex+key+1<=preferredAlphabet.length()) codedWord+=preferredAlphabet.substring(letterIndex+key,letterIndex+key+1);
				else codedWord+=preferredAlphabet.substring(letterIndex+key-26,letterIndex+key-25);
			}
			else codedWord+=word.substring(i,i+1);
		}
		return codedWord;
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner filescan=new Scanner(new File("inCompInfo.txt"));
		
		int numOfMessages=filescan.nextInt();
		filescan.nextLine();
		for (int i=0;i<numOfMessages;i++)
		{
			String currentLine=filescan.nextLine();
			int key=Integer.parseInt(currentLine);
			currentLine=filescan.nextLine();
			while (filescan.hasNext() && !currentLine.equals("STOP"))
			{
				String[] words=currentLine.split(" ");
				for (String word : words)
				{
					System.out.print(encode(word,key)+" ");
				}
				System.out.println();
				currentLine=filescan.nextLine();	
			}
			System.out.println();
		}
	}
}
