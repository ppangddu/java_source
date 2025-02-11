package pack2;

public class Ex2Student {

	public static void main(String[] args) {
		Student student = new Student("gd", 13, 23.4);

		student.printStudentInfo();

		student.setName("gdgd");
		student.setGrade(123);
		student.setScore(123.123);

		student.printStudentInfo();
	}
}
