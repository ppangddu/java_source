package pack2;

public class Student {
	private String name;	//인스턴스 변수(객체의 속성)
	private int grade;	//인스턴스 변수
	private double score;	//인스턴스 변수

	public Student(String name, int grade, double score) { // 특별한 메소드(클래스와 메소드명이 일치) -> 생성자(constructor) //매개변수(외부에서 전달되는 값)는 지역변수
		this.name = name; // 인스턴스 변수 'name'에 매개변수 'name' 값을 할당
		this.grade = grade;	 // 인스턴스 변수 'name'에 매개변수 'grade' 값을 할당
		this.score = score;	 // 인스턴스 변수 'name'에 매개변수 'score' 값을 할당
	}
	
//	public Student() { // 특별한 메소드(클래스와 메소드명이 일치) -> 생성자(constructor)
//		name = "신기해";	//생성자 값을 주면 값이 고정됨
//		grade = 2;
//		score = 99.9;
//	}
	
//	public Student(String a, int b, double c) {	//매개변수는 지역변수
//		name = a;
//		grade = b;
//		score = c;
//	}
//	위 코드 a,b,c를 보기 좋게 히려고 a, b, c를 name, grade, score로 바꾼다.
//	name, grade, score는 인스턴스 변수(객체의 속성)이고, 생성자의 매개변수 name, grade, score는 지역 변수입니다.
//	메소드 내부에서 this.name, this.grade, this.score와 같은 구문을 사용하여, 지역 변수와 인스턴스 변수를 구분합니다.
//	this.name은 인스턴스 변수 name을 가리키고, name은 지역 변수로, 생성자에서 전달된 값을 가리킵니다.
//	따라서 this 키워드는 지역 변수와 인스턴스 변수의 이름이 같을 때, 인스턴스 변수를 명확하게 지정해 주기 위해 사용됩니다.

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void printStudentInfo() {
		System.out.println("이름 : " + name + ", 학년 : " + grade + ", 평균 점수 : " + score);
	}

	
	
	public static void main(String[] args) {	//연습할 때 이렇게 메인메소드 밑에 쓰고 해도 된다. 좋은 방법은 아님. 그저 연습
//		Student stu = new Student();
//		stu.printStudentInfo();
		
//		Student stu1 = new Student();
//		stu.printStudentInfo();
		
		
		Student tom = new Student("gdgd", 123, 120.1);
		tom.printStudentInfo();

		Student james = new Student("gg", 1234, 1202.1);
		james.printStudentInfo();
		james.setScore(123.123);
		james.printStudentInfo();
		
//
//		student.setName("gg");
//		student.setGrade(0);
//		student.setScore(1.1);
//
//		student.printStudentInfo();
	}
}
