package pack4;

public class Ex16HouseDog extends Ex16Dog{
	private String where = "집";
	
	public Ex16HouseDog(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	public void show() {
		System.out.println("어디 사니? " + where + "에 산다.");
	}
	
	@Override
	public void print() {
		System.out.println(getName() + " : "+ where + "에서 잘 지내고 있어.");
	}
		
}
