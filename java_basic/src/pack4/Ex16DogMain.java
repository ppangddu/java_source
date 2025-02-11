package pack4;

public class Ex16DogMain {
	public static void main(String[] args) {
		Ex16Dog dog = new Ex16Dog("개");
		dog.print();
		System.out.println(dog.callName());
		
		System.out.println();
		Ex16HouseDog houseDog = new Ex16HouseDog("집 개");
		houseDog.print();
		System.out.println(houseDog.callName());
		houseDog.show();
		
		System.out.println();
		Ex16wolfDog wolfDog = new Ex16wolfDog("늑대");
		wolfDog.print();
		System.out.println(wolfDog.callName());
		wolfDog.show();
		
		System.out.println("= = = = = = = = = =");
		Ex16wolfDog bushdog = wolfDog; //주소를 치환(타입이 같은 경우 치환 성공)
		wolfDog.print();	
		bushdog.print();
		
		//promotion
		Ex16Dog dog2 = wolfDog; //주소를 치환(타입이 다른 경우에도 불구하고 치환 성공 - 자식의 주소를 부모 객체 변수에 주는 경우)
		dog2.print(); //오버라이딩 된 메서드만 부모 객체 변수명으로 호출 가능
//		dog2.show(); //자식이 가진 고유 메서드는 부모 객체 변수명으로 호출할 수 없음
//		Ex16wolfDog hidog = dof2; //Type mismatch
		Ex16wolfDog hidog = (Ex16wolfDog)dog2;	//casting하면 들어갈 수 있다.
		hidog.print();
		
		System.out.println(" = = = = = = ");
		Ex16Dog coyote = new Ex16Dog("코요테"); //부모 클래스
		coyote.print();
		System.out.println(coyote.callName());
		
		Ex16wolfDog wolfDog2 = new Ex16wolfDog("늑대2"); //Dog의 자식 클래스
		wolfDog2.print();
		wolfDog2.show();
		
		coyote = wolfDog2; //promotion : 자식 객체 주소를 부모 객체 변수에 치환
		coyote.print(); //오버라이딩 된 메서드는 허용
//		coyote.show(); //자식 고유 메서드는 호출 불가
		System.out.println(coyote.getName()); //부모 클래스에 있는 메서드는 사용 가능하다.
		Ex16wolfDog wolfDog3 = null;
//		wolfDog3.show(); //java.lang.NullPointerException
		wolfDog3 = wolfDog2; //타입이 같으므로 성공
//		wolfDog3 = houseDog; //타입이 다르므로 실패
//		wolfDog3 = coyote; //타입이 다르므로 실패, 하지만 부모 타입인 coyote 변수는 자식의 주소를 기억 중이다.
		wolfDog3 = (Ex16wolfDog) coyote; //그러므로 casting을 통해 치환할 수 있다. -> coyote 변수는 자식의 주소를 기억중이라는 게 중요함!!!!!!!!!!
		wolfDog3.print();
		
	}
}
