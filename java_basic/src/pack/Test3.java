package pack;

public class Test3 {
	
	public static void main(String[] args) {
		//산술 연산자
		int a = 5;	//=(대입 연산자)의 기능 : a 변수에 리터럴 5를 기억 시킨다.
		int b = 3;	
		int c = a + b;
		
		System.out.println("c = " + c);
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);	//몫
		System.out.println(a % b);	//나머지	
		System.out.println(a / (double)b);	//몫과 나머지
		
		System.out.println();
//		System.out.println(a / 0);	//불능. runtime error(실행 오류)
		System.out.println(a / 0.0); //Infinity(무한대)
		System.out.println(a % 0.0); //NaN(Not a number): 숫자가 아니라서 숫자로 표현할 수 없는 상태
		
		System.out.println("산술 연산자 우선 순위");
		System.out.println(3 + 4 * 5);
		System.out.println((3 + 4) * 5);
		
		System.out.println("문자열 더하기");
		String ss1 = "대한";	//String은 기본형이 아니라 참조형 변수임. 사용 방법은 기본형과 같다.
		String ss2 = "민국";
		String ss3 = ss1 + ss2; //문자열은 더하기 말고 다른 연산은 안 된다.
		System.out.println(ss3); //이때는 문자열 더하기
		System.out.println(ss3 + " " + 2025);	//2005 정수는 문자열로 자동 형변환 후 문자열 더하기를 함
		System.out.println(ss3 + " " + 2000 + 25);
		System.out.println(ss3 + " " + (2000 + 25));
		
		String ss4 = "5" + 6;
		System.out.println("ss4 = " + ss4);
		
		System.out.println("5" + 6);
		System.out.println(5 + 6);
		System.out.println(Integer.toString(5) + 6); //"5" + 6
		System.out.println(Integer.parseInt("5") + 6);
		
		System.out.println("누적");
		int no = 1;
		no = no + 1;
		no += 1;	//no -= 2, no += 2, no /=2
		no++;	//증감 연산자(후위)	no--;
		++no;	//증감 연산자(전위)
		System.out.println("no = " + no);
		
		System.out.println();
		int imsi = 5;
		int result = ++imsi + 1;	//다른 연산자와 함께 쓰면 헷갈리니까 단독으로 쓰자
		System.out.println("result = " + result);
		System.out.println("imsi = " + imsi);

		int imsi2 = 5;
		int result2 = imsi2++ + 1; 
		System.out.println("result2 = " + result2);
		System.out.println("imsi2 = " + imsi2);
		
		System.out.println("부호에 대해");
		int imsi3 = 7;
		System.out.println("imsi3 = " + imsi3);
		System.out.println("imsi3 = " + -imsi3);
		System.out.println("imsi3 = " + (-1 * imsi3));
		int imsi4 = -1 * imsi3;
		System.out.println("imsi4 = " + imsi4);
		
		// \n \b \t ...escape 문자
		System.out.println("여기까지 산술 연잔자" + (char)10 + "및 기타 \n연습\n\n 끝");
	}
}
