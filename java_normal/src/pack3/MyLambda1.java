package pack3;

@FunctionalInterface	// 함수형 인터페이스임을 강조, 함수형 인터페이스는 추상 메서드 하나만 있어야 함
interface HelloInter {
	int calcData(int a, int b);
//	int calcData2(int a, int b);
}

public class MyLambda1 implements HelloInter {
	@Override
	public int calcData(int a, int b) {
		// 인터페이스의 추상 메서드 오버라이드 : 전통적 방법
		return a + b;
	}
	
//	@Override
//	public int calcData2(int a, int b) {
//		return 0;
//	}
	
	public static void main(String[] args) {
		MyLambda1 my1 = new MyLambda1();
		System.out.println(my1.calcData(3, 4));
		
		System.out.println("람다식으로 표현");
		HelloInter inter = (a, b) -> a + b; 	// 추상 클래스나 인터페이스는 객체 변수를 가질 수 있다.
		System.out.println(inter.calcData(3, 4));
		
		HelloInter inter2 = (kbs, mbc) -> kbs * mbc;
		System.out.println(inter2.calcData(3, 4));
	}
}
