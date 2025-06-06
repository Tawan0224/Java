package Week08.Vehicle;

public class Car extends Vehicle {
	private int numWheels;
	
	public Car(String make, String model, int year, int numWheels) {
		super(make, model, year);
		this.numWheels = numWheels;
	}
	
	@Override
	public void drive() {
		System.out.println("Driving " + getMake());
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %d", 
				getYear(),
				getMake(),
				getModel(),
				numWheels);
	}
}
