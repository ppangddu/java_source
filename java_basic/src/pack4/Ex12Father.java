package pack4;

public class Ex12Father extends Ex12GrandFa{
	private final int nai = 50;
	private int house = 1; //할아버지 클래스에서는 접근할 수 없다.
	public String gabo = "청자 비슷한 물병";
	
	public Ex12Father() {
//		super(); //부모 생성자 호출	//안 써도 된다.
		super(89);
		System.out.println("아버지 생성자");
	}
	
	@Override //어노테이션(뭔가를 처리하는 기능)
	public int getNai() {
		//메서드 오버라이딩 : 부모와 똑같은 메서드를 자식에서 만듬. 내용은 다르게 적을 수 있다.
		int imsi = 0;	//부모와 다른 코드를 적을 수 있다.(재정의)
		return nai;
	}
	
	@Override
	public void say() {
		String ss = "아버지 말씀 : 풀스텍 개발자로 ㄱㄱㅆ";
		System.out.println(ss);
	}
	
	public int getHouse() {
		return house;
	}
	
	public void showData() {
		String gabo = "맥북";
		System.out.println(gabo);	//지역변수 먼저 찾는다.
		System.out.println(this.gabo);	//바로 현재 클래스의 멤버를 먼저 찾는다.
		System.out.println(super.gabo);	
		
		say();
		this.say();
		super.say();
	}
	
}
