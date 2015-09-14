//Tara Moses
//Class for Assignment 2: Magic Squares
//August 23, 2013

public class Magic
{
	int size;
	int[][] nums;
	
	public Magic(int size)
	{
		this.size=size;
		this.nums=nums;
		nums=new int[size][size];
	}
	
	public void fill()													//DO THIS OKAY
	{
		for (int i=0;i<size;i++)
		{
			for (int j=0;j<size;j++)
			{
				nums[i][j]=999;
			}
		}
	}
	
	public String format(int n)
	{
		String num=String.valueOf(n);
		if (n<10) num="00"+n;
		else if (n<100) num="0"+n;
		return num;
	}
	
	public boolean isFull()
	{
		for (int col=0;col<size;col++)
		{
			for (int row=0;row<size;row++)
			{
				if (nums[row][col]==999) return false;
			}
		}
		return true;
	}
	
	public void drawSquare()
	{
		System.out.println();
		for (int i=0;i<size;i++)
		{
			System.out.print("|");
			for (int j=0;j<size;j++)
			{
				System.out.print("     |");
			}
			
			System.out.print("\n|");
			for (int j=0;j<size;j++)
			{
				System.out.print(" "+format(nums[i][j])+" |");
			}
			
			System.out.print("\n|");
			for (int j=0;j<size;j++)
			{
				System.out.print("     |");
			}
			
			System.out.print("\n+");
			for (int k=0;k<size;k++)
			{
				System.out.print("-----+");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void putNumsIn()
	{
		int col=size/2;
		int row=0;
		int count=2;
		
		nums[row][col]=1;
		
		while (!isFull())
		{
			row--;
			col++;
			if (row<0) row=row+size;
			if (col>size-1) col=col-size;
			if (nums[row][col]!=999)	//if the place is already filled
			{
				col=col-1;
				if (col<0) col=col+size;
				
				row=row+2;
				if (row>size-1) row=row-size;
			}
			nums[row][col]=count;
			count++;
		}
	}
}
