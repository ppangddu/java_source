package pack4;

public class Car extends Vehicle {
	private int fuelCapacity;
	
	
	public Car(String brand, int speed, int fuelCapacity) {
		super(brand, speed);
		this.fuelCapacity = fuelCapacity;
	}
	
	@Override
	public void describe() {
		System.out.println("This is a car of brand " +  brand +" with a fuel "
				+ "capacity of "+ fuelCapacity + " liters");
	}
	
}
