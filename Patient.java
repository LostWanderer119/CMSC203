package holder;

public class Patient {
	private String first_name;
	private String mid_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private String ZIP;
	private String number;
	private String contact_name;
	private String contact_number;
	
	Patient () {
		first_name = "John";
		mid_name = "";
		last_name = "Doe";
		address = "1234 weird St.";
		city = "Nowhere";
		state = "Tennessee";
		ZIP = "12345";
		number = "(111)-111-1111";
		contact_name = "Jan Doe";
		contact_number = "(222)-222-2222";
	}
	
	Patient (String first_name, String mid_name, String last_name) {
		this.first_name = first_name;
		this.mid_name = mid_name;
		this.last_name = last_name;
		address = "1234 weird St.";
		city = "Nowhere";
		state = "Tennessee";
		ZIP = "12345";
		number = "(111)-111-1111";
		contact_name = "Jan Doe";
		contact_number = "(222)-222-2222";
	}
	
	Patient (String first_name, String mid_name, String last_name, String address, String city, String state, String ZIP, String number, String contact_name, String contact_number) {
		this.first_name = first_name;
		this.mid_name = mid_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.ZIP = ZIP;
		this.number = number;
		this.contact_name = contact_name;
		this.contact_number = contact_number;
	}
	
	public void setFirstName(String temp) {
		first_name = temp;
	}
	
	public void setMidName(String temp) {
		mid_name = temp;
	}
	
	public void setLastname(String temp) {
		last_name = temp;
	}

	public void setAddress(String temp) {
		address = temp;
	}

	public void setCity(String temp) {
		city = temp;
	}	

	public void setState(String temp) {
		state = temp;
	}
	public void setZIP(String temp) {
		ZIP = temp;
	}
	
	public void setNumber(String temp) {
		number = temp;
	}

	public void setContactName(String temp) {
		contact_name = temp;
	}

	public void setContactNumber(String temp) {
		contact_number = temp;
	}	

	
	public String getFirstName() {
		return first_name;
	}
	
	public String getMidName() {
		return mid_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	
	public String getZIP() {
		return ZIP;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getContactName() {
		return contact_name;
	}
	
	public String getContactNumber() {
		return contact_number;
	}
	
	public String buildFullName() {
		return (first_name + " " + mid_name + " " + last_name);
	}
	
	public String buildFullAddress() {
		return (address+ " " + city + " " + state + ", " + ZIP);
	}
	
	public String buildEmergecyContact() {
		return (contact_name + " " + contact_number);
	}
	
	@Override
	public String toString() {
		return ("\n\nPatient info\n  Name: " + buildFullName() + "\n  Number: " + number + "\n  Address: " + buildFullAddress() + "\n  Emergency Contact: " + buildEmergecyContact());
	}
}
