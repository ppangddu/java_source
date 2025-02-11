package pack4;

public class Ex12MyGajok {

	public static void main(String[] args) {
		Ex12GrandFa grandFa = new Ex12GrandFa();
		System.out.println("가보 : " + grandFa.gabo);
		System.out.println("가훈 : " + grandFa.gahun);
		grandFa.say();
		System.out.println("할아버지 나이는 " + grandFa.getNai());
			
		System.out.println();
		Ex12GrandFa grandFa2 = new Ex12GrandFa(12);
		System.out.println("나이 : " + grandFa2.getNai());
		
		System.out.println("= = = = = = = = = = = =");
		Ex12Father father = new Ex12Father();
		System.out.println("가보 : " + father.gabo);
		System.out.println("가훈 : " + father.gahun);
		father.say();
		System.out.println("아버지 나이는 " + father.getNai());
		father.eat(); // 아버지 객체에는 eat이 없으므로, 부모 클래스인 할아버지 클래스에서 찾는다.
		System.out.println("집 : " + father.getHouse());
		father.showData();
		
		System.out.println("* * * * * * * * * * * * * * *");
		Ex12Me me = new Ex12Me();
		System.out.println("가보 : " + me.gabo);
		System.out.println("가훈 : " + me.gahun);
		me.say();
		System.out.println("내 나이는 " + me.getNai());
		me.eat(); // 아버지 객체에는 eat이 없으므로, 부모 클래스인 할아버지 클래스에서 찾는다.
		System.out.println("집 : " + me.getHouse());
		me.Biking();
		
	}
	

}
