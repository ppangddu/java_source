package pack;

import java.util.Scanner;

public class Test6_1 {

	public static void main(String[] args) {
		// 조건 판단문 if
		System.out.println("뭔가를 수행 후 if문 만나기");
		int num = 2;

		if (num >= 1) {
			System.out.println("크구나");
			System.out.println("진짜로 크네");
		}

		System.out.println("계속1");
		
		if (num >= 5) {	//조건이 true
			System.out.println("크구나");
			System.out.println("진짜로 크네");
		}else {	//조건이 false
			System.out.println("크지 않네");
		}
		
		System.out.println("계속2");
		int jumsu = 40;
		
		if(jumsu >= 70) { //다중 if
			if(jumsu >= 90) {
				System.out.println("우수");
			}else {
				System.out.println("보통");
			}
		}else {
			if(jumsu >= 50) {
				System.out.println("저조");
			}else {
				System.out.println("매우 저조");
			}
		}
		
		System.out.println("계속3");
		int jumsu2 = 100;
		String result = "";
		
		if(jumsu2 >= 90) {
			result = "수";
		}else if(jumsu2 >= 80) {
			result = "우";
		}else if(jumsu2 >= 70) {
			result = "미";
		}else if(jumsu2 >= 60) {
			result = "양";
		}else {	//if(jumsu2 < 50) 생략 권장
			result = "가";
		}
		System.out.println("평과 결과는 '" + result + "'입니다.");
		
		
		
		System.out.println("계속4");
		//어느 공원의 입장료가 8세 이하, 65세 이상인 경우 무료
		//9세 이상 20세 미만은 3000원
		//그 외 5000원
		int age = 10;
		if(8 >= age || age >= 65 ) {
			System.out.println("입장료 무료");
		}
		if(9 <= age && age < 20 ) {
			System.out.println("입장료 3000원");
		}
		if(20 <= age && age < 65) {
			System.out.println("입장료 5000원");
		}
		//다중 if 문으로 변경, if가 한 블록에 있으니 속도가 빠르다.
		int price = 0;
		if(9 <= age && age < 20 ) {
			price = 3000;
		}else if(20 <= age && age < 65) {
			price = 5000;
		}else {
			price = 0;
		}
		System.out.println("입장료는 " + price + "원 입니다.");
		
		System.out.println("야구장에 입장하기 : 로그인 성공");
		String id = "kbs";
		String pwd = "ok123";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요.");
		String inputId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요.");
		String inputPwd = sc.nextLine();
//		if(inputId == id && inputPwd == pwd) {	//기본형 비교
		if(inputId.equals(id) && inputPwd.equals(pwd)) {
			System.out.println("로그인 성공하였습니다.");
		}else {
			System.out.println("로그인 실패하였습니다.");
		}
		

	}
}
