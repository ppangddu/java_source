package pack3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStream1 {

	public MyStream1() {
		test1(); // Stream 생성
		test2(); // List에 Stream 적용
		test3(); // Dto 사용
	}

	private void test1() {
		// Stream API를 사용하려면 Stream을 생성해야 함.
		// 1. Collection의 Stream 생성
		// Collection 인터페이스는 stream()이 정의되어 있기 때문에 Collection을 구현한
		// 객체(List, Set ...)는 이를 이용해 Stream 생성

		// List로부터 Stream 생성하기
		List<String> list = Arrays.asList("air", "book", "cat");
		Stream<String> listStream = list.stream();

		// 배열의 Stream 생성하기
		Stream<String> stream1 = Stream.of("a", "b", "c");
		Stream<String> stream2 = Stream.of(new String[] { "a", "b", "c" });
		Stream<String> stream3 = Arrays.stream(new String[] { "a", "b", "c" });
		Stream<String> stream4 = Arrays.stream(new String[] { "a", "b", "c" }, 0, 3);
		// 시작 인덱스 0부터 시작하여 끝 인덱스 3바로 전까지의 배열 요소를 포함한 스트림 반환

		// 원시 Stream 생성하기 : 원시 자료형을 대상으로 함
		IntStream iStream = IntStream.range(5, 10);
		int hap = 0;
		iStream.forEach(para -> {
			System.out.print(para + " ");
		});
		System.out.println();
	}

	private void test2() {
		List<String> list = Arrays.asList("레밍스", "팩맨", "마리오"); // 배열 ==> list
//		list.add("소닉"); // UnsupportedOperationException, 기존 요소 추가, 삭제 불가

		Iterator<String> iter = list.iterator(); // 전통적인 방법 : 외부 반복자를 사용
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		for (String ss : list) { // 전통적 : 향상된 for 문 사용 가능
			System.out.println(ss);
		}
		System.out.println();
		// 스트림(Stream)은 컬렉션 데이터에 대해 함수형 프로그래밍 스타일로 처리할 수 있는 강력한 도구임.
		Stream<String> stream = list.stream(); // Stream 객체 얻기(람다로 처리 가능한 반복자 역할)
		stream.forEach(str -> System.out.println(str)); // str이라는 이름 내 마음대로 준거임, 내부 반복으로 처리됨
//		stream.forEach(str -> System.out.println(str)); // IllegalStateException : stream has already been operated upon or closed, 스트림은 일회용 객체이다.
		list.stream().forEach(System.out::println); // :: 메서드 참조 연산 (매개 변수를 출력하는 경우 사용 가능)

		System.out.println("\n스트림을 사용해 체이닝 작업 수행 : 여러 작업을 단일 스트림 파이프라인으로 처리");
		// 파이프라인 : 여러 개의 작업을 연속적으로 처리 가능,
		// 예 : 어떤 스트림의 요소들을 중간에 출력학를 원할 때 사용해 보기
		int sum = IntStream.of(1, 3, 5, 7, 9).peek(System.out::println).sum();

		System.out.println("합은 " + sum);
		// peek() : 스트림의 각 요소에 대해 지정된 작업을 수행하고 요소를 변경하지 않은 채 다음
		// 작업으로 전달, 다양한 작업을 한 번의스트림에서 연속적으로 체이닝하여 수행할 경우에 사용함.

		list.stream().peek(System.out::println).forEach(System.out::println);

		System.out.println("병렬 처리");
		// parallelStream() : 컬렉션의 스트림을 병렬 모드로 처리, 대량의 자료를 출력할 때 유용하다. 내부적으로 스테드를 사용함,
		// 작업 처리 시간을 단축할 수 있음
		Stream<String> streamPar = list.parallelStream();
		streamPar.forEach(ss -> System.out.println(ss));

		System.out.println("정렬");
		Stream<String> streamSort = list.stream().sorted(); // 오름차순
		streamSort.forEach(System.out::println);

		System.out.println("정렬---");
		Stream<String> streamSort2 = list.stream().sorted(Comparator.reverseOrder()); // 내림차순
		streamSort2.forEach(System.out::println);
	}

	private void test3() {
		System.out.println("\nStudent type의 DTO 클래스로 컬렉션 작성");
		List<Student> slist = Arrays.asList(new Student("한국인", "남", 20), new Student("일본인", "여", 21),
				new Student("중국인", "남", 22), new Student("태국인", "여", 23), new Student("대만인", "남", 24));

		Stream<Student> stream = slist.stream();
		stream.forEach(p -> System.out.println(p.getName() + " " + p.getGender() + " " + p.getAge()));
		// 여기서 **p**는 Student 객체입니다. 즉, p는 한 번에 하나의 Student 객체를 가리키고 있으며,
		// 그 객체에서 getName(), getGender(), getAge() 메서드를 호출하여 정보를 출력하고 있습니다.
		// 객체 타입 매개변수와 데이터 타입 매개변수 둘 다 람다식에서 사용하려면 인터페이스를 통해 처리함.
		// 람다식은 인터페이스를 통해 처리해야만 사용 가능함. 람다식은 인터페이스의 메서드를 구현하는 방식으로 동작함.

		// stream 활용 : 나이 평균 출력 1
		double avg = slist.stream().mapToInt(Student::getAge) // Student 객체를 age 값으로 매핑 age로 stream 생성
				.average() // age 요소의 평균을 OptionalDouble 타입(null 관련 에러를 회피)으로 저장
				.getAsDouble();
		System.out.println("학생 평균 나이 : " + avg);

		// stream 활용 : 나이, 평균 출력 2
		Double avg2 = slist.stream().collect(Collectors.averagingDouble(Student::getAge));
		System.out.println("학생 평균 나이 : " + avg2);

		// stream 활용 : 나이 평균 출력 3
		OptionalDouble result = slist.stream().mapToDouble(Student::getAge).average();
		result.ifPresent(res -> System.out.println("학생 평균 나이 : " + res));

		// 필터(filter) 처리
		double avgResult = slist.stream().filter(d -> d.getGender().equals("남")).mapToDouble(Student::getAge).average()
				.getAsDouble(); // 다시 double로 바꿔주기
		System.out.println("남학생 평균 나이 : " + avgResult);

		slist.stream().filter(ir -> ir.getName().startsWith("한")).forEach(i -> System.out.println(i.getName()));
	}

	// 내부 클래스
	class Student {
		private String name;
		private String gender;
		private int age;

		public Student(String name, String gender, int age) {
			this.name = name;
			this.gender = gender;
			this.age = age;
		}

		public int getAge() {
			return age;
		}

		public String getName() {
			return name;
		}

		public String getGender() {
			return gender;
		}
	}

	public static void main(String[] args) {
		new MyStream1();
	}
}
