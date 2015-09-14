//Tara Moses
//Node Class for Assignment 14: Linked List
//October 18, 2013

public class Node
{
	int value;
	Node connectsTo;
	
	public Node(int num, Node next)
	{
		value=num;
		connectsTo=next;
	}
	
	public void setNextNode(Node next)
	{
		connectsTo=next;
	}
}
