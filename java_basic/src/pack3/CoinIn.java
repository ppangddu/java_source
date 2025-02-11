package pack3;

import java.util.Scanner;

public class CoinIn {
	private int coin;
	private int jandon;
	
	
	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	public int getJandon() {
		return jandon;
	}
	
	public String calc(int cupCount) {
		 String result = "";
		 if (coin < 200) {
			 result = "요금이 부족합니다.";
		 }else if (cupCount * 200 > coin) {
			 result = "요금이 부족합니다.";
		 }else {
			 jandon = coin - (200 * cupCount);
			 result = "커피 " + cupCount + "잔과 잔돈 " + jandon + "원";
		 }
		 return result;
	}
	
}
