package pack4;

//public class Ex13Student { //아래와 동일함
public class Ex13Student extends Object { // 모든 클래스는 object를 상속받음
	public String name;

	public Ex13Student() {
		name = "tom";
	}

	@Override
	public String toString() {
		System.out.println("원래 의미 싫어 바꿀 거야");
		return "이 클래스의 사용자는 " + name;
	}

	public static void main(String[] args) {
		Ex13Student student = new Ex13Student();
		System.out.println(student);
		System.out.println(student.toString()); // toString() - 객체 변수의 주소를 찍어준다.
	}
}
