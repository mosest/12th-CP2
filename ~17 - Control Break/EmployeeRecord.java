//Tara Moses
//Class for Assignment 17: Control Break
//December 18, 2013

public class EmployeeRecord {
	int employeeID;
	String employeeName;
	int deptID;
	String deptName;
	int itemID;
	String itemDescription;
	int numSold;
	double price;

	public EmployeeRecord(String line) {
		employeeID=Integer.parseInt(line.substring(0,3));
		employeeName=line.substring(3,27);
		deptID=Integer.parseInt(line.substring(27,30));
		deptName=line.substring(30,45);
		itemID=Integer.parseInt(line.substring(45,50));
		itemDescription=line.substring(50,65);
		numSold=Integer.parseInt(line.substring(65,70));
		price=Integer.parseInt(line.substring(70,78));
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public int getDeptID() {
		return deptID;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
	
	public int getNumSold() {
		return numSold;
	}
	
	public double getPrice() {
		return price/100.0;
	}
	
	public String getRecord() {
		return getDeptID()+" "+getEmployeeID()+" "+getEmployeeName()+" $"+String.format("%.2f", getPrice());
	}
}
