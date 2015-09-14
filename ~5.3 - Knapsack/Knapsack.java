//Tara Moses
//Assignment 5.3: Knapsack
//September 9, 2013

import java.util.Arrays;

public class Knapsack
{
	
	public static void main(String[] args) throws Exception
	{
		String[] name={"Cosmic Rays","Weightless Vines","Binary Stars","Mice Tumors","Space Dust","Solar Power","Relativity","Seed Viability","Sun Spots","Speed of Light","Cloud Patterns","Yeast"};
		int[] weight={80,25,224,65,127,188,104,7,92,324,36,22};
		int[] rating={6,3,4,8,7,7,8,5,2,8,6,4};
		String combo="";
		int comboRating=0;
		int comboWeight=0;
		int numCombos=0;
		int workingRating=0;
		int workingWeight=0;
		String workingCombo="";
		
		//get rid of no tests
		for (int k=0;k<12;k++)
		{
			combo+=name[k]+"\n";
			comboRating+=rating[k];
			comboWeight+=weight[k];	
		}
		if (comboWeight<=700 && comboRating>=workingRating)
		{
			workingRating=comboRating;
			workingWeight=comboWeight;
			workingCombo=combo;
		}
		
		//get rid of 1 test
		for (int j=0;j<12;j++)
		{
			combo="";
			comboRating=0;
			comboWeight=0;
			for (int k=0;k<12;k++)
			{
				if (j!=k)
				{
					combo+=name[k]+"\n";
					comboRating+=rating[k];
					comboWeight+=weight[k];
				}
			}
			if (comboWeight<=700 && comboRating>=workingRating)
			{
				workingRating=comboRating;
				workingWeight=comboWeight;
				workingCombo=combo;
			}
		}
		
		//get rid of 2 tests
		for (int j=0;j<12;j++)
		{
			for (int k=0;k<12;k++)
			{
				if (j!=k)
				{
					combo="";
					comboRating=0;
					comboWeight=0;
					for (int l=0;l<12;l++)
					{
						if (j!=l && k!=l)
						{
							combo+=name[l]+"\n";
							comboRating+=rating[l];
							comboWeight+=weight[l];
						}
					}
					if (comboWeight<=700 && comboRating>=workingRating)
					{
						workingRating=comboRating;
						workingWeight=comboWeight;
						workingCombo=combo;
					}
				}
			}
		}
		
		//get rid of 3 tests
		for (int j=0;j<12;j++)
		{
			for (int k=0;k<12;k++)
			{
				if (j!=k)
				{
					for (int l=0;l<12;l++)
					{
						if (j!=l && k!=l)
						{
							combo="";
							comboRating=0;
							comboWeight=0;
							for (int m=0;m<12;m++)
							{
								if (j!=m && k!=m && l!=m)
								{
									combo+=name[m]+"\n";
									comboRating+=rating[m];
									comboWeight+=weight[m];
								}
							}
							if (comboWeight<=700 && comboRating>=workingRating)
							{
								workingRating=comboRating;
								workingWeight=comboWeight;
								workingCombo=combo;
							}
						}
					}
				}
			}
		}
		System.out.println("\nThe best combination is: \n\n"+workingCombo+"\nwith a rating of "+workingRating+" and a weight of "+workingWeight+" kg.\n");
	}
}
