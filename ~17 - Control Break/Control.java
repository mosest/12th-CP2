//Tara Moses
//Assignment 17: Control Break
//December 17, 2013

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Control {
	public static void main(String[] args) {
		Scanner filescan=null;
		PrintWriter writer=null;
		EmployeeRecord[] records;
		EmployeeRecord currentRecord=null;
		EmployeeRecord prevRecord=null;
		int recordCount=0;
		String currentLine="";
		int employeeID1;
		int employeeID2;
		int swaps=0;
		int deptID1;
		int deptID2;
		double employeeTotal=0.00;
		double deptTotal=0.0;
		
		try {
			filescan=new Scanner(new File("Employee.txt"));
		} catch (Exception e) {}
		try {
			writer=new PrintWriter("Salesrpt.txt","UTF-8");
		} catch (Exception e) {}
		
		//find out how many lines are in the file
		while (filescan.hasNextLine()) {
			filescan.nextLine();
			recordCount++;
		}
		records=new EmployeeRecord[recordCount];
		
		//put all records in records[]
		filescan.close();
		try {
			filescan=new Scanner(new File("Employee.txt"));
		} catch (Exception e) {}
		for (int i=0;i<recordCount;i++) {
			currentLine=filescan.nextLine();
			currentRecord=new EmployeeRecord(currentLine);
			records[i]=currentRecord;
		}
		
		//bubble-sort arrays by ascending department #, then descending employee #
		do {
			swaps=0;
			for (int i=1;i<records.length;i++) {
				deptID1=records[i-1].getDeptID();
				deptID2=records[i].getDeptID();
				if (deptID1>deptID2) {
					EmployeeRecord temp=records[i-1];
					records[i-1]=records[i];
					records[i]=temp;
					swaps++;
				}
			}
		} while (swaps!=0);
		do {
			swaps=0;
			for (int i=1;i<records.length;i++) {
				employeeID1=records[i-1].getEmployeeID();
				employeeID2=records[i].getEmployeeID(); //flutterbutterexe or toomuchcaffeine
				deptID1=records[i-1].getDeptID();
				deptID2=records[i].getDeptID();
				if (deptID1==deptID2 && employeeID2>employeeID1) {
					EmployeeRecord temp=records[i-1];
					records[i-1]=records[i];
					records[i]=temp;
					swaps++;
				}
			}
		} while (swaps!=0);
		
		//print records
		for (int i=1;i<records.length;i++) {
			currentRecord=records[i];
			prevRecord=records[i-1];
			writer.write(prevRecord.getRecord()+"\n");
			employeeTotal+=prevRecord.getPrice();
			deptTotal+=prevRecord.getPrice();
			if (currentRecord.getEmployeeID()!=prevRecord.getEmployeeID()) {
				writer.write("\n"+prevRecord.getEmployeeName().trim()+"'s Total: $"+String.format("%.2f",employeeTotal)+"\n");
				employeeTotal=0;
			}
			if (currentRecord.getDeptID()!=prevRecord.getDeptID()) {
				writer.write("\n\nDEPARTMENT TOTAL: $"+String.format("%.2f",deptTotal)+"\n");
				deptTotal=0;
			}
		}
		
		writer.close();
	}
}
