package CA3;

public class Customer {
	
	// Variables 
	protected int customerID;
	protected String firstName;
	protected String lastrName;
	protected double price;
	protected String address;
	protected String country;
	
	// Getters & Setters
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastrName() {
		return lastrName;
	}
	public void setLastrName(String lastrName) {
		this.lastrName = lastrName;
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
