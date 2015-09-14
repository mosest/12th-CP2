//Tara Moses
//List Class for Assignment 14: Linked List
//October 18, 2013

public class LinkedList
{
	Node head;
	Node currentNode;
	int size;
	
	public LinkedList()
	{
		head=null;
		currentNode=head;
		size=0;
	}
	
	public void add(int valueToAdd)
	{
		int count=0;
		currentNode=head;
		Node newNode;
		for (int i=0;i<size && currentNode.value<=valueToAdd;i++) 			//find node with larger value than valueToAdd
		{
			count++;
			currentNode=currentNode.connectsTo;
		}
		
		if (count==0) //node's being put at beginning
		{
			newNode=new Node(valueToAdd,head);
			head=newNode;
		}
		else //node's being put at the end or in the middle somewhere
		{
			newNode=new Node(valueToAdd,nodeAtPosition(count));
			nodeAtPosition(count-1).connectsTo=newNode;
		}
		size++;
	}
	
	public void delete(int valueToDelete)
	{
		int count=0;
		currentNode=head;
		Node deleteNode;
		for (int i=0;i<size && currentNode.value!=valueToDelete;i++) 			//find node with valueToDelete
		{
			count++;
			currentNode=currentNode.connectsTo;
		}
		
		if (count==0) //node's at beginning
		{
			head=nodeAtPosition(count+1);
		}
		else //node's at the end or in the middle somewhere
		{
			nodeAtPosition(count-1).connectsTo=nodeAtPosition(count+1);
			nodeAtPosition(count).connectsTo=null;
		}
		size--;
	}
	
	public boolean search(int valueToSearchFor)
	{
		for (int i=0;i<size;i++)
		{
			if (nodeAtPosition(i).value==valueToSearchFor) return true;
		}
		return false;
	}
	
	public void print()
	{
		for (int i=0;i<size;i++)
		{
			System.out.println(i+") "+nodeAtPosition(i).value);
		}
	}
	
	public Node nodeAtPosition(int index)
	{
		currentNode=head;
		if (index<size && index>=0)
		{
			for (int i=0;i<index;i++)
			{
				currentNode=currentNode.connectsTo;
			}
			return currentNode;
		}
		return null;
	}
}
