package pack2;

public class Ex2Main {
	
	public static void main(String[] args) {
		Ex2Programmer programmer1 = new Ex2Programmer();
		System.out.println("보유 기술 : " + programmer1.spec);
		programmer1.displayData();
		
		programmer1.nickName = "웹 전문가"; //public 멤버 필드이므로 외부에서 수정 가능
		programmer1.spec = "1종 보통 운전면허";	//default 멤버 필드이므로 외부에서 값을 수정
		programmer1.displayData();
		
		//캡슐화된 멤버를 해당 클래스 밖에서 제어하기
		//programmer1.age;	// 에러 : 접근 불가
		int nai = programmer1.getAge();	//public 메서드이므로 접근 가능
		System.out.println("programmer1 객체의 age " + nai);
		
		programmer1.setAge(33);	//public 메서드 setter를 이용해 private 필드에 값을 전달
		System.out.println("programmer1 객체의 age " + programmer1.getAge());
		programmer1.displayData();
		programmer1.setAgeEx(33, 123);
		
		System.out.println("static, final 괸련 ...");
		System.out.println("motto : " + programmer1.motto);
		System.out.println("motto : " + Ex2Programmer.motto);	//static 멤버는 클래스 이름으로 접근한다.
//		programmer1.WEIGHT = 77.8;	//err : WEIGHT는 final이므로 수정 불가, 참조만 가능
		System.out.println("WEIGHT : " + programmer1.WEIGHT);
		System.out.println("PI : " + Ex2Programmer.PI);
		
		
		
		
		Ex2Programmer programmer2 = new Ex2Programmer();	//새로운 객체 생성
		programmer2.displayData();
		
		System.out.println("\n객체 변수가 참조하는 주소에 대해(참고)...");
		System.out.println(programmer1.toString() + " " + programmer2.toString());
		System.out.println(programmer1.hashCode() + " " + programmer2.hashCode());
		//toString()을 쓰면 주소값을 알 수 있다. 안 쓰는 것이랑 똑같음
		
		System.out.println(Integer.MAX_VALUE); //Integer라는 클래스이름으로 MAX_VALUE라는 final값을 바로 불렀다는 것을 알 수 있다.
		
		
		
		
//		Ex2Programmer programmer2 = new Ex2Programmer();	//인스턴스가 두 개가 됐다.
//		programmer2.displayData();
		
		
	}
}
