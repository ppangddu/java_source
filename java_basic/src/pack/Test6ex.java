package pack;

import java.util.Scanner;

public class Test6ex {
	public static void main(String[] args) {
		int kum;
		double sekum;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명을 입력하세요.");
		String sang = sc.nextLine();
		System.out.println("수량을 입력하세요.");
		int su = sc.nextInt();
		System.out.println("단가를 입력하세요.");
		int dan = sc.nextInt();
		
		kum = su * dan;
		if(kum >= 50000) {
			sekum = kum * 0.1;
		} else if(kum >= 30000) {
			sekum = kum * 0.05;
		} else {
			sekum = kum * 0.03;
		}
		
		System.out.println("상품명 " + sang + "은 금액 " + kum + "원이고 " + "세금은 " + sekum + "원");
			
	}
}
