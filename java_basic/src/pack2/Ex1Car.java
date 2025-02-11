package pack2;

// 클래스 형식 : [접근지정자] class 클래스명
public class Ex1Car { // Car 객체(Object)를 생산하기 위한 설계도 : 클래스
	// 새로운 타입(Type, 형)을 만들기 위함
	// field(속성)과 method(행위)를 멤버로 가질 수 있다.
	// 동일한 field와 method를 수행하는 객체의 집합을 설계

	int wheel; // 멤버 필드(전역 변수) 형식은 [접근지정자] type 필드명
	private int airBag = 1; // 캡슐화 : 멤버 접근 지정자가 private인 경우
	private int speed;
	public String irum;

	public Ex1Car() { // 특별한 메소드(클래스와 메소드명이 일치) -> 생성자(constructor)
		System.out.println("객체 생성 시 생성자가 가장 먼저 수행 : 초기화를 담당");
		wheel = 4;
		irum = "그랜저";
	}

	private void abc() { // 멤버 메소드, 형식은 [접근지정자] 반환형 메소드명(매개변수 ...) { }
		System.out.println("abc 메소드 실행");
	}

	void def() { // 메소드 수행 후 반환값이 없이 돌아갈 경우는 void
		System.out.println("def 메소드 실행");
		System.out.println("바퀴 수는 " + wheel);
		System.out.println("에어백 수는 " + airBag); // private 필드이나 현재 클래스 내에서 호출 가능하다.
	}

	public String driving() { // 메소드 수행 후 String 타입의 반환값이 있는 경우는 문자열 반환
		System.out.println("운전하기");
		return "현재 고속도로 달리는 중";
	}

	public int drivingStop() { // 메소드 수행후 int 타입의 반환값이 있는 경우는 int
		System.out.println("운전 멈추기");
		return 0; // return 정수
	}
	
	//참고 : 변수에 값을 저장하는 방법은 두 가지,
	// 1) 변수 = 값	ex) a = 5
	// 2) 매개변수를 이용	메서드명(타입 매개변수){...}하고 메서드명(값)
	public void drivingGood(int w) {	//매개변수(parameter)가 있는 메서드
		wheel = w;
		System.out.println(wheel + "개의 바위를 가진 이동 수단");
	}

}

//클래스를 공부하는 이유
//1) 직접 객체를 생성 후 사용하기 위함
//2) 다른 사람이 만든 클래스를 활용하기 위함