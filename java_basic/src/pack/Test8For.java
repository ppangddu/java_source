package pack;

public class Test8For {
	public static void main(String[] args) {
		System.out.println("뭔가를 하다가 반복문 만나기");
		//반복문 for
		int a;
		int hap = 0;
		for(a = 1; a <= 5; a++) { // for(변수 초기화; 조건; 증감치) {반복 내용}
			System.out.print(a + "\t");
//			a = 7; //반복문 내에서 for 문에 사용 중인 변수는 갱신 비권장
			hap = hap + a;
			
		}
		
		System.out.println("\nfor 탈출1 = " + a);
		System.out.println("합 = " + hap);
		
		System.out.println();
		for(int i = 65; i <= 90; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println("\nfor 탈출2 ");
		for(int i= 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\nfor 탈출3");
		System.out.println();
		for(int i = 10; i >= 1; i -= 2) {
			System.out.print(i + " ");
		}
		System.out.println("\nfor 탈촐4");
		
		System.out.println();
		for(int ytn = 0, tvn = 5; ytn <= 6; ytn++, tvn++) {
			System.out.println(ytn + ", " + tvn + " ");
		}
		System.out.println("\nfor 탈촐5");
		System.out.println();
		int aa = 1;
		for(; aa <= 5; aa++) {
			System.out.print(aa + " ");
		}
		System.out.println("\nfor 탈출6");
		System.out.println();
		for(int sbs = 1; sbs <= 10; sbs++) {
			if(sbs % 2 == 0) {	//짝수만 출력
				System.out.println(sbs + " ");
			}
			if(sbs == 6) break;	//반복문 무조건 탈출
		}
		
		System.out.println("\nfor탈출7");
		System.out.println();
		//다중 for = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
		for(int m = 1; m <= 3; m++) {
			System.out.println("m = " + m);
			for(int n = 1; n <= 4; n++) {
				System.out.println("n = " + n + " ");
			}
			System.out.println();
		}
		
		System.out.println("\nfor탈출8");
		System.out.println();
		
		for(char i = 65; i <= 90; i++) {	//다중 for 문
			System.out.print(i + " : ");
			for(char j = i ; j <= 'Z'; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println("문제");
		//문1) 구구단 3단 출력
		for(int dan = 1; dan < 10; dan++) {
			System.out.println("3 * " + dan + " = " + (3 * dan));
		}
		System.out.println();
		
		//뮨2) 2 ~ 9단까지 출력
		for(int m = 2; m <= 9; m++) {
			System.out.println(m + "단");
			for(int dan = 1; dan < 10; dan++) {
				System.out.println(m +" * " + dan + " = " + (m * dan));
			}
			System.out.println();
		}
		System.out.println();
		
		//문3) 1~100 사이의 정수 중 3의 배수이면서 5의 배수를 출력하고 건수와 그들의 총합을 출력하라.
		int sum = 0;
		int count = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
				System.out.println(i + " ");	
				sum += i;
				count++;
			}
		}
		System.out.println(sum);
		System.out.println(count);
		
		//continue, break...
		for(int i = 1; i <= 10; i++) {
//			if (i == 3)	continue;	//continue : 자신과 대응되는 for 문으로 무조건 이동
//			if (i == 5)	continue;
			if (i == 3 || i == 5) continue;
			System.out.println(i);
			if (i == 7) break;
		}
		
		//무한 반복문
		int kk = 0;
		for (;;) {
			kk++;
			System.out.println("kk");
			if (kk == 5) break;
		}
	}
}



