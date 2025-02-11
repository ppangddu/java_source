package pack;

import java.util.Scanner;

public class Test9While {

	public static void main(String[] args) {
		//반복문 while : while(조건){ 반복 처리 대상 ... }
		int w = 1;
		while (w <= 5) {
			System.out.println("w = " + w + " ");
			w += 1;	//조건이 거짓이 되는 명령문 필요
		}
		System.out.println("탈출 후 w : " + w);
		
		int count = 0;
		while (count < 10) {
			count++;
			System.out.println("count = " + count);
			if (count == 10) {
				System.out.println("count가 10이라서 반복문 종료" + count);
			}
		}
		//다중 while
		int a = 1;
		while (a <= 3) {
			System.out.println("a = " + a);
			int b = 1;
			while(b <= 4) {
				System.out.println("b = " + b);
				b++;
			}
			a++;
			System.out.println();
		}
		
		//do while 문
		int m = 0;
		do {	//최소 1번은 반드시 수행
			System.out.println("do while의 m = " + m);
			m++;
		} while (m <= 5);
		
		System.out.println("continue, break ...");
		int x = 0;
		while (x <= 10) {
			x += 1;
			if (x == 3) continue;
			if (x == 7) break;
			
			System.out.println("x = " + x);
		}
		
		//무한 루프(looping)
		int y = 1;
		while (true) {
			System.out.println("y = " + y);
			y++;
			if (y == 5) break;
		}
		
		System.out.println("문제1 : 1 ~ 10사이의 정수 중 짝수만 출력하고 그 갯수도 출력");
		int aa = 0;
		int aaCount = 0;
		while (aa <= 10) {
			aa++;
			if (aa % 2 == 0) {
				System.out.println(aa);
				aaCount++;
			}
		}
		System.out.println("짝수의 갯수 = " + aaCount);
		
//		System.exit(0); //현재 실행 중인 프로그램 무조건 종료
		
		System.out.println("문제2 : 키보드로 정수를 입력받아 1부터 그 입력받은 수까지의 합을 출력하기");
		//조건 : 이 작업을 계속 반복할지 여부를 묻고 탈출 결정
		Scanner sc = new Scanner(System.in);
		
		while (true) {	//무한 반복 (break를 만날 때까지)
			System.out.print("양의 정수를 입력하세요. : ");
			int num = sc.nextInt();
//			System.out.println(num);
			if (num <= 1) {	//1 이하의 값이 입력되면 작업 종료
				System.out.println("2 이상의 정수를 입력하세요.");
				continue;
			}
			//해당 숫자까지의 합 출력
			int n = 1, total = 0;
			while (n <= num) {	//키보드에서 입력한 숫자보다 작은 동안 반복
				total += n;
				n++;
			}
			System.out.println("입력받은 수까지의 총합은 " + total + "입니다.");
			
			System.out.println("계속 할까요?(1/0)");
			int imsi = sc.nextInt();
			if (imsi != 1) {	//! -> 조건 부정
				System.out.println("종료합니다.");
				break;	
			}
		}
		
		sc.close(); //사용 중인 자원 해제
		
		
		
		
		
	}
}
