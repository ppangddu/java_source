package pack2;

public class Ex1Main {	//Ex1Main은 main 메소드를 실행하기 위한 클래스이다.
	public static void main(String[] args) {
		/* main은 응용 프로그램의 시작을 위해 정해진 메소드이다.
		Ex1Car 설계도로 객체를 생성, 이런 과정을 '객체를 인스턴스(instance)한다' 한다고 함
		다시말해 클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화라고 하여 
		어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스라고 한다.
		객체는 모든 인스턴스를 대표하는 포괄적인 의미이다.
		클래스 -- 인스턴스화 --> 객체 */
		
		//Ex1Car.class를 주기억장치로 읽은 후 car1 객체 변수를 선언
		//new 키워드로 인스턴스를 진행, 이 때 Ex1Car()이라는 생성자를 호출
		Ex1Car car1 = new Ex1Car();
		//Ex1Car 멤버 필드(전역 변수) 호출 - - - - -
		System.out.println(car1.wheel);	//접근 지정자가 default 이므로 호출 가능
//		System.out.println(car1.airbag);	//접근 지정자가 private 이므로 호출 불가
		System.out.println(car1.irum);	//접근 지정자가 public 이므로 호출 가능

		//Ex1Car 멤버 메소드 호출 - - - - -
//		car1.abc(); //private 메소드이므로 호출 불가
		car1.def();
		
		System.out.println();
		car1.driving();
		String ss = car1.driving();	//다회용
		ss = "와우" + ss;
		System.out.println(ss);
		
		System.out.println(car1.driving()); //일회용
		
		car1.drivingGood(2);	// 2->argument
		
		Ex1Car car2 = new Ex1Car(); //새로운 객체 생성
		//car1과 car2는 type이 같은 두 개의 객체 변수
		System.out.println(car2.wheel);
		car2.def();
		
	}
}
