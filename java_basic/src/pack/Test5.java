package pack;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		// 논리 연산자 처리할 때 주의할 점
		System.out.println("출발");
//		aa();	//aa 묶음(메서드)을 호출, 반환값이 void 일 때
		boolean bbb = aa(); // 반환값이 boolean 일 때
		System.out.println(bbb);
		System.out.println("계속");

		System.out.println("\n논리 연산자 처리할 때 주의할 점");
		boolean a = true, b = false, c;

		c = a || b;
		System.out.println("c는 " + c);
		c = a && b;
		System.out.println("c는 " + c);

		System.out.println("=============||============");
		c = abc() || def(); // abc()가 참이니까 def()는 실행 안 한다.
		System.out.println("묶음 수행 후 c는 " + c);
		c = def() || abc(); // def()가 거짓이니까 abc()를 실행한다.
		System.out.println("묶음 수행 후 c는 " + c);

		System.out.println("\n============&&=============");
		c = abc() && def(); // abc()가 참이니까 def()도 실행한다.
		System.out.println("묶음 수행 후 c는 " + c);
		c = def() && abc(); // def()가 거짓이니까 abc()는 실행 안 한다.
		System.out.println("묶음 수행 후 c는 " + c);

		System.out.println("\n============모두 수행하기=============");
		c = abc() | def();
		System.out.println("묶음 수행 후 c는 " + c);
		c = def() | abc();
		System.out.println("묶음 수행 후 c는 " + c);
		System.out.println();
		c = abc() & def();
		System.out.println("묶음 수행 후 c는 " + c);
		c = def() & abc();
		System.out.println("묶음 수행 후 c는 " + c);

		System.out.println("\n\n좀 다른 얘기를 실습 : 키보드(표준입력장치)");
		inputTest();

	}

//		public static void aa() {	//독립적(반복적)으로 실행되는 코드를 별도의 묶음으로 작성
	public static boolean aa() { // boolean -> aa 처리 후 돌아갈 때 boolean 값을 가지고 감, 반환값
		System.out.println("아자");
//		System.out.println("아자2");
//		System.out.println("아자3");
		return true;
	}

	public static boolean abc() {
		System.out.println("abc 출력, 한 줄 수행했지만 abc는 여러 행으로 구성된다고 가정");
		return true;
	}

	public static boolean def() {
		System.out.println("def 출력, 내용이 많다고 가정");
		return false;
	}

	public static void inputTest() {
		String ir = "손오공";
		int nai = 22;
		System.out.println(ir + "님의 나이는 " + nai);

		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("名前を入力してください : ");
		String name = sc.next();
		System.out.print("年齢を入力してください : ");
		int age = sc.nextInt();
		System.out.println(name + "さんの年は" + age + "歳です。");

	}
}
