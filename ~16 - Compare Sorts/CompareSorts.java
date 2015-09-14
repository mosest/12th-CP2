//Tara Moses
//Assignment 16: Compare Sorts
//December 15, 2013

public class CompareSorts {
	//array that prints out all elements of an array
	public static void printArray(int[] numsArray) {
		for (int i=0;i<numsArray.length;i++) {
			System.out.println(i+". "+numsArray[i]);
		}
	} 
	
	public static void main(String[] args) {
		int randomNum=0;
		int bubbleComparisons=0;
		int bubbleSwapsTotal=0;
		int bubbleSwapsTemp=0;
		int selectionIterations=0;
		int selectionComparisons=0;
		int firstNum=0;
		int secondNum=0;
		int lowestNum;
		int currentNum;
		int index;
		int numToSwitchWithLowest;
		
		//generate random numbers
		int[] originalNums=new int[10];
		for (int i=0;i<originalNums.length;i++) {
			randomNum=(int)(Math.random()*10+1);
			originalNums[i]=randomNum;
		}
		System.out.println("Original Array:");
		printArray(originalNums);
		System.out.println();
		
		//bubblesort originalNums
		int[] bubbleNums=new int[originalNums.length];
		System.arraycopy(originalNums,0,bubbleNums,0,originalNums.length);
		do {
			bubbleSwapsTemp=0;
			for (int i=1;i<bubbleNums.length;i++) {
				firstNum=bubbleNums[i-1];
				secondNum=bubbleNums[i];
				bubbleComparisons++;
				if (firstNum>secondNum) {
					bubbleNums[i-1]=secondNum;
					bubbleNums[i]=firstNum;
					bubbleSwapsTemp++;
					bubbleSwapsTotal++;
				}
			}
		} while (bubbleSwapsTemp!=0);
		System.out.println("Bubble-Sorted Array:");
		printArray(bubbleNums);
		System.out.println("There were "+bubbleComparisons+" comparisons and "+bubbleSwapsTotal+" assignments total.\n");
		
		//selectionsort originalNums
		int[] selectionNums=new int[originalNums.length];
		System.arraycopy(originalNums,0,selectionNums,0,originalNums.length);
		do {
			lowestNum=selectionNums[selectionIterations];
			currentNum=selectionNums[selectionIterations];
			index=selectionIterations;
			numToSwitchWithLowest=currentNum;
			for (int i=selectionIterations;i<selectionNums.length;i++) {
				currentNum=selectionNums[i];
				if (currentNum<lowestNum) {
					numToSwitchWithLowest=lowestNum;
					lowestNum=currentNum;
					index=i;
				}
				selectionComparisons++;
			}
			selectionNums[selectionIterations]=lowestNum;
			selectionNums[index]=numToSwitchWithLowest;
			selectionIterations++;
		} while (selectionIterations!=selectionNums.length);
		System.out.println("Selection-Sorted Array:");
		printArray(selectionNums);
		System.out.println("There were "+selectionComparisons+" comparisons and "+selectionIterations+" assignments total.\n");
	}
}
