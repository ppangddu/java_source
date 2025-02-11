package pack4;

public class Vehicle {
	protected String brand;
	protected int speed;
	
	public Vehicle(String brand, int speed) {
		this.brand = brand;
		this.speed = speed;
	}
	
	public void describe() {
		System.out.println("This is a vehicle");
	}
	
}
