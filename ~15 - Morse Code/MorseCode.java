//Tara Moses
//Assignment 15: Morse Code
//November 13, 2013

import java.util.Scanner;
import java.io.PrintWriter;

public class MorseCode
{
	public static String engToMorse(String phrase, String[] eng, String[] morse)
	{
		String endPhrase="";
		int letterIndex=0;
		
		for (int i=0;i<phrase.length();i++)
		{
			letterIndex=getIndex(eng,phrase.substring(i,i+1));
			endPhrase+=morse[letterIndex]+" ";
		}
		
		return endPhrase;
	}
	
	public static String morseToEng(String phrase, String[] morse, String[] eng)
	{
		String endPhrase="";
		int letterIndex=0;
		String[] morseLetters=phrase.split(" ");
		
		for (int i=0;i<morseLetters.length;i++)
		{
			letterIndex=getIndex(morse,morseLetters[i]);
			endPhrase+=eng[letterIndex];
		}
		
		return endPhrase;
	}
	
	public static int getIndex(String[] array, String value)
	{
		for (int i=0;i<array.length;i++)
		{
			if (array[i].equals(value)) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		PrintWriter writer=new PrintWriter("outputMorse.txt","UTF-8");
		boolean again=true;
		String phrase="";
		String[] morseCode={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","/","-----",".----","..---","...--","....-",".....","-....","--...","---..","----.",".-.-.-","--..--","---...","..--..",".----.","-....-","-..-.",".-..-.",".--.-.","-...-"};
		String[] english={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," ","0","1","2","3","4","5","6","7","8","9",".",",",":","?","'","-","/","\"","@","="};
		String newPhrase="";
		
		while (again)
		{
			System.out.println("1. English to Morse Code");
			System.out.println("2. Morse Code to English");
			System.out.print("Choose an option (1/2): ");
			int option=scan.nextInt();
			
			if (option==1)
			{
				System.out.print("\nInput an English phrase: ");
				scan.nextLine();
				phrase=scan.nextLine();
				writer.write("English: "+phrase+"\n");
				
				newPhrase=engToMorse(phrase.toLowerCase(),english,morseCode);
				System.out.println(newPhrase+"\n");
				writer.write("Morse Code: "+newPhrase+"\n\n");
				
				System.out.print("Translate something else? (y/n): ");
				if (!scan.nextLine().equalsIgnoreCase("y")) again=false;
			}
			else if (option==2)
			{
				System.out.print("\nInput a Morse Code phrase: ");
				scan.nextLine();
				phrase=scan.nextLine();
				writer.write("Morse Code: "+phrase+"\n");
				
				newPhrase=morseToEng(phrase.toLowerCase(),morseCode,english);
				System.out.println(newPhrase+"\n");
				writer.write("English: "+newPhrase+"\n\n");
				System.out.print("Translate something else? (y/n): ");
				if (!scan.nextLine().equalsIgnoreCase("y")) again=false;
			}
			else System.out.println("\nThat is not an option. Please try again.\n");
		}
		System.out.println("\nYour phrases and translations have been written to outputMorse.txt.\n");
		writer.close();
	}
}
