package Week08.Vehicle;

public class VehicleDriver {

	public static void main(String[] args) {
//		Vehicle aVehicle = new Vehicle();  // not allowed
		
		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = new Car("Toyota", "Camry", 2022, 4);
		vehicles[1] = new Car("Nissan", "Kick", 2023, 4);
		vehicles[2] = new Car("Suzuki", "Swift", 2020, 4);
		
		for (Vehicle v:vehicles) {
			System.out.println(v);
		}
		
		for (Vehicle v:vehicles) {
			v.drive();
		}
		
	}

}
