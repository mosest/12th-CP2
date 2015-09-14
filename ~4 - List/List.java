//Tara Moses
//Class for Assignment 4: List
//September 3, 2013

import java.util.Arrays;

public class List
{
	int[] nums;
	int size=0;
	
	public List()
	{
		this.nums=nums;
		nums=new int[25];
		this.size=size;
		
		for (int i=0;i<25;i++)
		{
			nums[i]=0;
		}
	}
	
	public void add(int numToAdd)
	{
		nums[size]=numToAdd;
		Arrays.sort(nums,0,size+1);
		size++;
	}
	
	public void delete(int numToDelete)
	{
		int index=search(numToDelete);
		for (int i=index;i<size;i++)
		{
			nums[i]=nums[i+1];
		}
		size--;
	}
	
	public int search(int searchNum)
	{
		for (int i=0;i<size;i++)
		{
			if (nums[i]==searchNum) return i;
		}
		return -1;
	}
	
	public void print()
	{
		for (int i=0;i<size;i++)
		{
			System.out.println(i+") "+nums[i]);
		}
	}
	
	public boolean isADuplicate(int num)
	{
		for (int i=0;i<size;i++)
		{
			if (num==0 || nums[i]==num) return true;
		}
		return false;
	}
}
