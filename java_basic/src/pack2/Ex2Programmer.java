package pack2;

public class Ex2Programmer {
	public String nickName;	//초기값이 없으면 참조형이므로 null이 됨
	private int age;	//초기값이 없으면 0 기억, 은닉화된 필드(멤버 변수, 전역 변수)
	//private int age = 0;	//위와 같은 의미
	String spec ="정보처리 자격증";
	
	public static String motto = "자바에 미치자";	//정적 필드, static 영역에 저장됨
	public final double WEIGHT = 66.78;	//final 멤버 필드는 값 수정 불가, 이름은 대문자로만 쓰기를 권장함
	public static final double PI = 3.14;	//정적 필드이고 수정 불가
	
	public Ex2Programmer() {
		//생성자는 내용이 없는 경우에 적지 않으면 컴파일러가 내부적으로 만들어 준다.
		System.out.println("난 생성자. 객체 생성 시 1회만 호출 가능");
		int number = 20;	//지역변수(메서드 내에서 선언한 변수는 메서드 내에서만 호출)
		age = number + 5;	
		nickName = "시마자키 하루키";
	}
	
	public void displayData() {
		String mySpec = responseSpec();	//메서드가 다른 메서드를 호출
		System.out.println(mySpec);	//이게 언젠가 이 변수를 쓴 것
		System.out.println("별명은 " + nickName + "이고 나이는 " + age + "이고 스펙은 " + mySpec + "입니다.");
	}
	
	private String responseSpec() {
		return "내가 가진 기술은 " + spec;
	}
	
	//private 멤버 외부에서 제어하기 위한 메서드 작성
	public int getAge() {	//메소드 이름은 약속, get 멤버 변수(첫 글자는 대문자) <== getter
		return age;	//age 변수 자체를 리턴하는 것이 아니라 age에 기억된 정수를 반환함
	}
	
	public void setAge(int age) {	//메서드 이름은 약속, set 멤버 변수(첫글자는 대문자) <== setter
		this.age = age;
	}
	
	public void setAgeEx(int age, int pwd) {
		if (pwd == 123) {
			this.age = age;
			System.out.println("age 수정 성공하였습니다.");
		}
		else {
			System.out.println("비밀번호가 틀리므로 age를 수정할 수 없습니다.");
		}
		
	}
	
}
