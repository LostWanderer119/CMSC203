package holder;

public class Procedure {
	private String procedure;
	private String date;
	private String practitioner;
	private double charge;
	
	Procedure() {
		procedure = "Plastic surgery";
		date = "01/01/2019";
		practitioner = "Dr. Bob";
		charge = 10000.00;
	}
	
	Procedure(String procedure, String date) {
		this.procedure = procedure;
		this.date = date;
		practitioner = "Dr. Bob";
		charge = 10000.00;
	}
	
	Procedure(String procedure, String date, String practitioner, double charge) {
		this.procedure = procedure;
		this.date = date;
		this.practitioner = practitioner;
		this.charge = charge;
	}
	
	public void setProcedure(String temp) {
		procedure = temp;
	}
	public void setDate(String temp) {
		date = temp;
	}
	
	public void setPractitioner(String temp) {
		practitioner = temp;
	}

	public void setCharge(double temp) {
		charge = temp;
	}
	
	public String getProcedure() {
		return procedure;
	}
	
	public String getdate() {
		return date;
	}
	
	public String getPractitioner() {
		return practitioner;
	}
	
	double getCharge() {
		return charge;
	}
	
	@Override
	public String toString() {
		return ("\n\t Procedure: " + procedure + "\n\t Procedure Date: " + date + "\n\t Practitoner: " + practitioner + "\n\t Charge: $" + charge);
	}
}
