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

public class ManagementCompany {
	 private final int MAX_PROPERTY = 5;
	 private final int MGMT_WIDTH = 10;
	 private final int MGMT_DEPTH = 10;
	 private Property[] properties;
	 private String mgmt_name;
	 private String tax_ID;
	 private double mgmt_fee;
	 private Plot plot;
	 private int num_of_properties;



	public ManagementCompany() {
		properties = new Property[MAX_PROPERTY];
		mgmt_name = "";
		tax_ID = "";
		mgmt_fee = 0;
		plot = new Plot();
		num_of_properties = 0;
	}
	
	public ManagementCompany(String mgmt_name, String tax_ID, double mgmt_fee) {
		properties = new Property[MAX_PROPERTY];
		this.mgmt_name = mgmt_name;
		this.tax_ID = tax_ID;
		this.mgmt_fee = mgmt_fee;
		plot = new Plot(0, 0, MGMT_DEPTH, MGMT_WIDTH);
		num_of_properties = 0;
	}
	
	public ManagementCompany(String mgmt_name, String tax_ID, double mgmt_fee, int x, int y, int width, int depth) {
		properties = new Property[MAX_PROPERTY];
		this.mgmt_name = mgmt_name;
		this.tax_ID = tax_ID;
		this.mgmt_fee = mgmt_fee;
		plot = new Plot(x, y, depth, width);
		num_of_properties = 0;
	}
	
	public ManagementCompany(ManagementCompany other) {
		properties = new Property[MAX_PROPERTY];
		mgmt_name = other.getName();
		tax_ID = other.getTaxID();
		mgmt_fee = other.getFee();
		plot = new Plot(other.getPlot());
		num_of_properties = other.getPropertiesCount();
	
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		Property newProp = new Property(name, city, rent, owner);
        return addProperty(newProp);
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property newProp = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(newProp);
	}
	
	public int addProperty(Property property) {
		if (isPropertiesFull()) //full array
			return -1; 
		
		if (property == null) //property object is null
			return -2;
		
		if (!this.plot.encompasses(property.getPlot())) //not encompass the property plot
			return -3;
		
		for (int i = 0; i < num_of_properties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot()))
                return -4;
        }
		
		properties[num_of_properties] = property;
		num_of_properties++;
        return num_of_properties - 1;
	}
	
	public void removeLastProperty() {
		properties[--num_of_properties] = null;
	}
	
	public boolean isPropertiesFull() {
		return num_of_properties >= MAX_PROPERTY;
	}
	
	public int getPropertiesCount() {
		return num_of_properties;
	}
	
	public double getTotalRent() {
		double total = 0;
		
		for (int i = 0; i < num_of_properties; i++) {
			total += properties[i].getRentAmount();
		}
		
		return total;
	}
	
	public Property getHighestRentPropperty() {
		
		if (num_of_properties == 0) 
			return null;
		
        Property highest = properties[0];
        
        for (int i = 1; i < num_of_properties; i++) {
            if (properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
	}
	
	public boolean isMangementFeeValid() {
		return mgmt_fee >= 0 && mgmt_fee <= 100;
	}
	
	public void setName(String mgmt_name) {this.mgmt_name = mgmt_name;}
	
	public void setTaxID(String tax_ID) {this.tax_ID = tax_ID;}
	
	public void setFee(double mgmt_fee) {this.mgmt_fee = mgmt_fee;}
	
	public void setPlot(Plot plot) {this.plot = new Plot(plot);}
	
	public String getName() {return mgmt_name;}
	
	public String getTaxID() {return tax_ID;}
	
	public double getFee() {return mgmt_fee;}
	
	public Plot getPlot() {return plot;}
	
	public Property[] getProperties() {return properties;}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public String toString() {return mgmt_name + "," + tax_ID + "," + mgmt_fee;}

}