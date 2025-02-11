package pack4;

public class Bicycle extends Vehicle {
	public int gearCount;
	
	public Bicycle(String brand, int speed, int gearCount) {
		super(brand, speed);
		this.gearCount = gearCount;
	}
	
	@Override
	public void describe() {
		System.out.println("This is a bicycle of brand " + brand + 
		 " with " + gearCount + " gears");
	}
	
}
