package pack4;

public class Ex12GrandFa {
	private int nai = 70;
	public String gabo = "청자";
	protected String gahun = "바르게 살자";
	
	public Ex12GrandFa() {
		System.out.println("할아버지 생성자");
	}
	
	public Ex12GrandFa(int nai) {
		this();
		this.nai = nai;
	}
	
	public void say() {
		System.out.println("할아버지 말씀 : 자바에 집중 ㄱㄱㅆ");
	}
	
	public void eat() {
		System.out.println("햄부기");
	}
	
	public int getNai() {
		return nai;
	}
	
}
