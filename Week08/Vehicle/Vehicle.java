package Week08.Vehicle;

abstract public class Vehicle {
	private String make;
	private String model;
	private int year;
	 
	public Vehicle(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	abstract public void drive();
	
	public String getMake() {
		return this.make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return String.format("%d %s %s", year, make, model);
	}
}
