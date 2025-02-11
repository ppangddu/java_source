package pack;

public class Test2 {
	public static void main(String[] args) {
		/*
		 여러 줄 주석
		 */
		String irum = "신기행"; //문자열을 변수에 기억
		System.out.print(irum);
		System.out.print(irum);
		System.out.println();
		
		//변수 : 값(데이터)을 저장할 수 있는 메모리 공간(새로운 값을 입력하면 덮어쓰기 됨)
		//변수명 : 변수에 대한 임의의 이름, 형식: 타입 변수명 = 리터럴(문자, 숫자 ...)
		//상수 : 처음에 입력한 값이 계속 유지되는 메모리 공간
		
		//변수 기본형 타입 : bcbsilfd
		//기본형처럼 사용하는 참조형 타입 : String 
		
		//byte type
		byte var1; //1바이트(-128 ~ 127) 정수 기억장소
		var1 = 10;
		var1 = 5;
		System.out.println(var1);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		byte var2 = 123;	//대입(치환) 연산자
		System.out.println("var2 = " + var2);
		//byte var3 = 128;
		//System.out.println("var3 = " + var3);
		
		System.out.println();
		//short type
		short var4 = 10; //2바이트
		var4 = 32000;
		System.out.println("var4 = " + var4);
		
		System.out.println();
		//int type
		int var5 = 10; //4바이트
		var5 = 215455643;
		System.out.println("var5 = " + var5);
		
		System.out.println("형변환에 대하여");
		byte aa = 10; //자동 형변환 ((promotion) int 타입의 10을 byte 타입으로 자동 형변환 후 기억)
		aa = (byte)10; //강제 형변환 (cast 연산자를 이용해 casting 함)
		aa = (byte)200;
		aa = 5;
		int imsi = 7; //믿을 수 있음
//		byte bb = imsi; //믿을 수 없음
		byte cc = (byte)imsi;
		System.out.println("aa = " + aa);
//		System.out.println("bb = " + bb);
		
		//long
		long var6; //8바이트 정수 기억장소
		var6 = 10;
		var6 = 484798747L; //long type의 데이터
		var6 = 123L;
		System.out.println("var6 = " + var6);
		
		System.out.println("실수에 대하여");
		float f1 = 3; //실수형 기억함수(4byte)
		//정수는 실수로 자동 형변환(promotion)
		//f1 = 123.12; arr
		f1 = 123.12f; //123.12f float type의 데이터
		f1 = (float)123.12;
		System.out.println("f1 = " + f1);
		
		double d1 = 123; //실수형 기억함수(8byte) : 소수 이하 15자리 정밀도 보장
		d1 = 123.12;
		System.out.println("d1 = " + d1);
		
		System.out.println();
//		int aa1 = 3.5; // arr
		int aa1 = (int)3.5; //소수 이하 버리고 정수만 기억함
		System.out.println("aa1 = " + aa1);
		
		int aa2 = 12 + (int)10.5;
		aa2 = (int)(12 + 10.5); //바이트 들어가는 거 주의
		System.out.println("aa2 = " + aa2);
		double aa3 = 12 + 10.5; //정수는 실수화 후 연산됨
		System.out.println("aa3 = " + aa3);
		
		System.out.println("논리형(boolean, 참 또는 거짓 결과의 자료형)에 대하여");
		boolean bu1 = true;
//		boolean bu1 = false; //이렇게 하면 에러가 난다. 같은 것을 두 개 만들 수 없음
		bu1 = false;
		System.out.println("bu1 = " + bu1);
		
		System.out.println("문자형(char, 한 개의 문자 기억)에 대하여");
		char c1 = 'A';
		//c1 = 'bc';  
		//c1 = "b";
		System.out.println("c1 = " + c1 + " " + (int)c1 + " " + (char)65);
		//ASCII 코드에서 'A'는 10진수로 65, 'a'는 97, '0'은 48 ...
		
		System.out.println("안녕" + (char)13 + "반갑");
		int abc = 0x0f; //16진수(0x리터럴) 10진수를 int형으로 저장, 0x리터럴
		System.out.println("abc = " + abc + " " + Integer.toHexString(15));
		System.out.println("abc = " + abc + " " + Integer.toBinaryString(15));
		int abc2 = 007; //8진수(0리터럴) 10진수를 int형으로 저장, 0리터럴
		System.out.println("abc = " + abc2);
		
		System.out.println();
		final double PI = 3.14;
//		PI = 5.6;
		System.out.println("PI = " + PI);
	}
	
	
}
