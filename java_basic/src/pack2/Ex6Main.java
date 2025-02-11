package pack2;

import java.time.LocalDate;

public class Ex6Main {
	public static void main(String[] args) {
		Ex6Singleton ex1 = new Ex6Singleton();
		Ex6Singleton ex2 = new Ex6Singleton();
		System.out.println(ex1 + " "  + ex2); //두 개의 객체 변수(인스턴스) 주소가 다름
		System.out.println(ex1.name + " " + ex2.name);
		ex1.name = "홍길동";
		System.out.println(ex1.name + " " + ex2.name);
		
		System.out.println("싱글톤 패턴을 적용");
		Ex6Singleton my1 = Ex6Singleton.getInstance();
		Ex6Singleton my2 = Ex6Singleton.getInstance();
		Ex6Singleton my3 = Ex6Singleton.getInstance();
		System.out.println(my1 + " " + my2 + " " + my3);
		System.out.println(my1.name + " " + my2.name + " " + my3.name);
		my1.name = "일본인";
		System.out.println(my1.name + " " + my2.name + " " + my3.name);
		
		System.out.println();
		LocalDate localDate = LocalDate.now();	// now()는 static 메서드라 객체를 새로 생성하지 않고도 호출 가능
		LocalDate localDate2 = LocalDate.now();
		System.out.println(localDate.hashCode() + " " + localDate2.hashCode());
		System.out.println(localDate);
		
	}
}
