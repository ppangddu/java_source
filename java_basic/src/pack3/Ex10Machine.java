package pack3;

import java.util.Scanner;

public class Ex10Machine {
	
	private int cupCount;
	CoinIn coinIn = new CoinIn();
	
	public void showData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("동전을 입력하세요. : ");
		coinIn.setCoin(sc.nextInt());
		System.out.println("몇잔을 원하세요 : ");
		cupCount = sc.nextInt();
		System.out.println(coinIn.calc(cupCount)); 
		}
	
	
	

}
