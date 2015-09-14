//Tara Moses
//Assignment 18: Spellcheck
//December 18, 2013

import java.util.Scanner;
import java.io.File;

public class Spellcheck {
	public static void main(String[] args) {
		Scanner userInput=null;
		Scanner filescan=null;
		String inFile="";
		String currentWord="";
		int choice=0;
		String wordToDelete="";
		String currentWord="";
		
		try {
			userInput=new Scanner(System.in);
		} catch (Exception e) {}
		
		do {
			System.out.print("Would you like to (1) input a file to be spellchecked, or (2) delete a word from the dictionary? ");
			choice=userInput.nextInt();
			if (choice!=1 && choice!=2 && choice!=3) System.out.println("That's not a valid choice. Please enter either 1 or 2.");
		} while (choice!=1 && choice!=2 && choice!=3);
		
		//do things
		if (choice==1) {
			System.out.print("What file would you like to spellcheck? ");
			inFile=userInput.next();
			
			try {
				filescan=new Scanner(new File(inFile));
			} catch (Exception e) {}
			
			while (filescan.hasNext()) {
				currentWord=filescan.next();
				//check to see if it's in the dictionary file
				System.out.println("HEY I'M LOOKING FOR THIS WORD IN THE DIC TREE");
				if (!searchDictionary(currentWord)) {
					System.out.print(currentWord+" doesn't exist. Would you like to add it to the dictionary? (y/n): ");
					addWord
				}
			}
			
			//spellcheck file
		} else if (choice==2) {
			System.out.print("What word would you like to delete? ");
			wordToDelete=userInput.next();
			//search for word and delete it
		} else if () {
			
		}
	}
}
