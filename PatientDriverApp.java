package holder;

import java.util.Scanner;
import java.util.ArrayList;

public class PatientDriverApp {
	
	static void displayPatient(Patient p) {
		System.out.println(p.toString());
	}
	
	static void displayProcedure(Procedure p) {
		System.out.println(p.toString());
	}
	
	static void calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
		System.out.print("\nTotal charges: $");
		System.out.println(p1.getCharge() + p2.getCharge() + p3.getCharge());
	}

	 public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Patient person = new Patient();
		
		ArrayList<Procedure> med = new ArrayList<>(); 
		med.add(new Procedure());
		med.add(new Procedure());
		med.add(new Procedure());
		
		System.out.print("What is the patient's first name? ");
		person.setFirstName(in.next());
		System.out.print("What is the patient's middle name? ");
		person.setMidName(in.next());
		System.out.print("What is the patient's last name? ");
		person.setLastname(in.next());
		in.nextLine(); //buffer
		System.out.print("What is the patient's address? ");
		person.setAddress(in.nextLine());
		System.out.print("What is the patient's city? ");
		person.setCity(in.nextLine());
		System.out.print("What is the patient's state? ");
		person.setState(in.nextLine());
		System.out.print("What is the patient's ZIP code? ");
		person.setZIP(in.next());
		System.out.print("What is the patient's phone number? ");
		person.setNumber(in.next());
		in.nextLine(); //buffer
		System.out.print("What is the emergency contact's name? ");
		person.setContactName(in.nextLine());
		System.out.print("What is the emergency contact's number? ");
		person.setContactNumber(in.next());
		
		for (Procedure temp : med) { //loops to get all the data needed to fill up the class
			in.nextLine(); //buffer
			System.out.print("\nWhat is the procedure? ");
			temp.setProcedure(in.nextLine());
			System.out.print("What is the date for the procedure? ");
			temp.setDate(in.nextLine());
			System.out.print("Who is the practitioner? ");
			temp.setPractitioner(in.nextLine());
			System.out.print("How much is the procedure? ");
			temp.setCharge(in.nextDouble());
			while (temp.getCharge() < 0) {
				System.out.print("Can't be less than zero\nRe-enter the price: ");
				temp.setCharge(in.nextDouble());
			}
		}
		
		displayPatient(person);
		displayProcedure(med.get(0));
		displayProcedure(med.get(1));
		displayProcedure(med.get(2));
		calculateTotalCharges(med.get(0), med.get(1), med.get(2));
		
		System.out.print("\nStudent Name: Leo Chen\nM#: M21191889\nDue Date: 09/30/2025");
		in.close();
		System.exit(0);
	}

}
