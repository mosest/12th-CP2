//Tara Moses
//Class for Assignment 11: Language
//September 27, 2013

public class CharStack
{
	String[] stack;
	int nextIndex;
	
	public CharStack(String str)
	{
		stack=new String[str.length()];
		nextIndex=str.length()-1;
	}
	
	public void push(String a)
	{
		stack[nextIndex]=a;
		nextIndex--;
	}
	
	public String pop()
	{
		String thingToPop=stack[nextIndex+1];
		nextIndex++;
		return thingToPop;
	}
}
