//Tara Moses
//Assignment 13: Postfix
//October 14, 2013

import java.util.Scanner;
import java.io.PrintWriter;

public class PostFix
{
	public static void main(String[] args) throws Exception
	{
		String digits="0123456789";
		String ops="^*/%+-";
		Scanner scan=new Scanner(System.in);
		String again="y";
		
		System.out.print("Specify output file name: ");
		String outFileName=scan.next();
		PrintWriter writer=new PrintWriter(outFileName,"UTF-8");
		
		writer.write("Tara Moses\n");
		writer.write("CPII\n");
		writer.write("Assignment 13: PostFix\n\n");
		
		while (again.equalsIgnoreCase("y"))
		{
			String postfix="";
			
			System.out.print("\nEnter an expression: ");
			String infix=scan.next();
			CharStack stack=new CharStack(infix);
			
			stack.push("(");
			infix+=")";
			
			for (int i=0;i<infix.length() && !stack.isEmpty();i++)
			{
				String character=infix.substring(i,i+1);
				if (digits.indexOf(character)!=-1) postfix+=character;
				else if (character.equals("(")) stack.push(character);
				else if (ops.indexOf(character)!=-1)
				{
					int currentOpIndex=ops.indexOf(character);
					int stackOpIndex=ops.indexOf(stack.getTopOfStack());
					if (stackOpIndex!=-1 && stackOpIndex<=currentOpIndex) postfix+=stack.pop();
					stack.push(character);
				}
				else if (character.equals(")")) 
				{
					while (!stack.getTopOfStack().equals("(")) postfix+=stack.pop();
					stack.pop();
				}
			}
			System.out.println("Before: "+infix.substring(0,infix.length()-1));
			writer.write("Before: "+infix.substring(0,infix.length()-1)+"\n");
			System.out.println("After: "+postfix+"\n");
			writer.write("After: "+postfix+"\n\n");
			
			System.out.print("Enter another string? (y/n): ");
			again=scan.next();
		}
		System.out.println();
		writer.close();
	}
}
