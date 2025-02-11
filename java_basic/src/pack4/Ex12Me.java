package pack4;

public final class Ex12Me extends Ex12Father{ //Me는 자식 클래스 생성 불가
	
	public Ex12Me() {
		System.out.println("내 생성자");
	}
	
	@Override
	public void say() {
		System.out.println("인생은 아름다워");
	}
	
	public final void Biking() { //Me의 자식 클래스는 Biking() override 불가
		System.out.println("자전거로 전국 일주");
	}
}