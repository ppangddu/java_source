package pack4;

public class Main {
	public static void main(String[] args) {
		Car car = new Car("Kia", 100, 50);
		car.describe();
		Bicycle bicycle = new Bicycle("Giant", 200, 50);
		bicycle.describe();
	}
}
