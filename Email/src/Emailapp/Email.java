package Emailapp;
import java.util.*;

public class Email {
	private String FirstName;
	private String LastName;
	private String Password;
	private String Dept;
	private String Email;
	private String AltEmail;
	private int DefaultPassLength = 6;
	private int Capacity = 500;
	private String CompanyName = "paramount.com";
	
	public Email(String FirstName, String LastName) {
		this.FirstName= FirstName; 
		this.LastName = LastName;
		
		this.Dept = setDept();
		
		this.Password = randomPass(DefaultPassLength);
		System.out.println("Your Password is: " + this.Password);
	
		Email = FirstName.toLowerCase() + "." + LastName.toLowerCase() + "@" + Dept.toLowerCase().replaceAll("\\s","") + "." + CompanyName;
		
	}
	
	private String setDept() {
		System.out.println("New Member: " + FirstName + " " + LastName + "\nDepartment Codes:\n1 for International Media\n2 for Industrial Relations\n3 for Physical Production\n0 for None\nEnter Department Code: ");
		Scanner in = new Scanner(System.in);
		int DeptChoice = in.nextInt();
		if(DeptChoice == 1) { return "International Media"; }
		else if(DeptChoice == 2) { return "Digital Marketing"; }
		else if(DeptChoice == 3) { return "Development"; }
		else { return ""; }
	}
	private String randomPass(int l) {
		String passSet = "ABCDEFGHIJKLMNOPQRSTXYZ12345678!@#$%^&*";
	char[] Password = new char[l];
	for(int i=0; i<l; i++) {	
		int r = (int) (Math.random() * passSet.length());
		Password[i]= passSet.charAt(r);
		}
	return new String (Password);
	}
	
	public void setMailboxCap(int cap) {
		this.Capacity = cap;
	}
	
	public void setAltEmail(String alt) {
		this.AltEmail = alt;
	}
	
	public void changePassword(String pass) {
		this.Password = pass;
	}
	
	public int getMailboxCap() { return Capacity; }
	public String getAltEmail() { return AltEmail; }
	public String getPassword() { return Password; }
	
	public String DisplayInfo() {
		return "NAME: " + FirstName + " " + LastName +
			   "\nCOMPANY EMAIL: " + Email +
			   "\nMAILBOX CAPACITY: " + Capacity + "mb";
	}
}
