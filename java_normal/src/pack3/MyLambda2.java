package pack3;

interface MyInter {
	void aaa(); // 기본형, 파라미터 X, 반환값 X
}

interface MyInterArg {
	void bbb(int a, int b); // 매개변수가 있는 메서드
}

interface MyInterArgReturn {
	int ccc(int a, int b); // 반환 값이 있는 메서드
}

public class MyLambda2 {

	public static void main(String[] args) {
		// 1) 인자가 없는 추상 메서드 처리
		MyInter inter1 = new MyInter() {
			@Override
			public void aaa() {
				System.out.println("익명 클래스의 메서드 오버라이딩"); // 인터페이스 안에 있는 추상 메서드를 오버라이딩
			}
		};
		inter1.aaa();

		// 람다식으로 표현, 람다식은 함수형 인터페이스와 함께 사용된다.(함수형 인터페이스는 하나의 추상 메서드만 가진 인터페이스이다.)
		MyInter inter2 = () -> System.out.println("익명 클래스의 메서드 오버라이딩");
		inter2.aaa();

		// 람다식으로 표현
		MyInter inter3 = () -> { // 수행할 문장이 복수면 중괄호 안에다 쓰기
			System.out.println("익명 클래스의 메서드 오버라이딩");
			int imsi = 1;
			System.out.println("익명 클래스의 메서드 오버라이딩 : " + imsi);
		};
		inter3.aaa();
		
		System.out.println("=================");
		// 2) 인자가 있는 추상 메서드 처리
		MyInterArg interArg = new MyInterArg() {
			@Override
			public void bbb(int a, int b) {
				System.out.println("두 수의 합은 " + (a + b));
			}
		};
		interArg.bbb(5, 4);
		
		// 람다식으로 표현 : 매개 변수가 1개일 때는 (a)를 괄호를 빼고 a -> 도 가능함
		MyInterArg interArg2 = (a, b) -> System.out.println("람다 두 수의 합은 " + (a + b));
		interArg2.bbb(5, 4);
		
		System.out.println("=================");
		// 3) 반환값이 있는 추상 메서드 처리
		MyInterArgReturn argReturn = new MyInterArgReturn() {
			
			@Override
			public int ccc(int a, int b) {
				System.out.println("ccc 처리");
				return a + b;
			}
		};
		int result = argReturn.ccc(2, 3);
		System.out.println("두 수를 더한 결과 : " + result);
		
		// 람다식으로 표현
		MyInterArgReturn argReturn2 = (a, b) -> a + b;
		int result2 = argReturn2.ccc(2, 3);
		System.out.println("두 수를 더한 결과 : " + result2);
	}
}
