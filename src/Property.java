/*
* Class: CMSC 203 CRN 22608
* Instructor: Ahmed Tarek
* Description: A property management company manages individual properties they will build to rent, and charges
them a management fee as the percentages of the monthly rental amount. The properties cannot overlap
each other, and each property must be within the limits of the management company’s plot. Write an
application that lets the user create a management company and add the properties managed by the
company to its list.
* Due: 10/28/2025
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Leo Chen
*/

public class Property {
	 private String property_name;
	 private String city;
	 private double rent_amount;
	 private String owner;
	 private Plot plot;

	public Property() {
		property_name = "";
		city = "";
		rent_amount = 0;
		owner = "";
		plot = new Plot();
	}
	
	public Property(String property_name, String city, double rent_amount, String owner) {
		this.property_name = property_name;
		this.city = city;
		this.rent_amount = rent_amount;
		this.owner = owner;
		plot = new Plot();
	}
	
	public Property(String property_name, String city, double rent_amount, String owner, int x, int y, int depth, int width) {
		this.property_name = property_name;
		this.city = city;
		this.rent_amount = rent_amount;
		this.owner = owner;
		plot = new Plot(x, y, depth, width);
	 }
	 
	public Property(Property other) { //copy constructor
		property_name = other.getPropertyName();
		city = other.getCity();
		rent_amount = other.getRentAmount();
		owner = other.getOwner();
		plot = other.getPlot();
	 }
		
	public String getPropertyName() {return property_name;}
	
	public String getCity() {return city;}
	 
	public double getRentAmount() {return rent_amount;}
	 
	public String getOwner() {return owner;}
	 
	public Plot getPlot() {return plot;}
	
	public String toString() {return property_name + "," + city + "," + owner + "," + rent_amount;} 

}