package pack3;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// List, Thread 에서 람다 사용
public class MyLambda3 {
	public MyLambda3() {
		// 람다 표현식 사용하는 방법
		System.out.println("\n리스트 사용---------");
		test1();
		System.out.println("\n스레드 사용---------");
		test2();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("\n파일 필터링 사용---------");
		test3();
	}

	private void test1() {
		// 리스트 컬렉션의 각 요소를 출력하기
		List<String> list = Arrays.asList("Apple","Banana","Cherry");
		System.out.println(list.getClass().getName());
		System.out.println(list instanceof List);
		
		// 전통저긴 for 문 사용
		for (String i : list) {
			System.out.println(i);
		}
		System.out.println("람다를 사용해 출력"); // Consumer는 람다 표현식과 결합하여 간결하게 코드를 작성할 수 있다는 장점이 있다. 특히 컬렉션의 forEach와 같은 메서드에서 자주 사용된다.
		list.forEach(i -> System.out.println(i)); // 위에 세 줄을 이렇게 한 줄로 줄일 수 있다.
		
		// 참고 : Cunsumer Interface는 매개변수 1개이고 반환값이 없는 accept 메서드를 가짐
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String t) { // 추상 메서드 하나
				System.out.println(t);
				
			}
		};
		consumer.accept("사과");
		String ss[] = {"Apple","Banana","Cherry"};
		for (String f : ss) {
			consumer.accept(f);
		}
	}

	// 스레드에서 람다 사용
	// 내부 클래스
	class ThreadTest {
		public ThreadTest() {
			
		}
		public void sendData(String friend) {
			System.out.println(friend + "에게 문자를 전송");
		}
		void m1() { // 전통적 방법
//			Thread th = new Thread();
//			th.start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					sendData("홍길동");
					
				}
			}).start();
			
		}
		void m2() { // 람다 사용
			Runnable runnable = () -> sendData("이기자");
			runnable.run();
		}
		
		void m3() {
			Thread thread = new Thread(() -> sendData("신기해"));
			thread.start();
		}
		
		void m4() {
			new Thread(() -> sendData("공기밥")).start();
		}
		
		
	}
	private void test2() {
		ThreadTest threadTest = new ThreadTest();
		threadTest.m1();
		threadTest.m2();
		threadTest.m3();
		threadTest.m4();
	}

	private void test3() {
		// 특정 디렉토리에 있는 파일들을 필터링하여, 조건에 맞는 파일을 찾기
		File direc = new File("c:/ssu");
		// FileFilter 인터페이스를 람다식으로 구현, 확장자 txt 파일만 출력
		File[] files = direc.listFiles((File file) -> file.isFile() && file.getName().endsWith(".txt"));
		if (files != null) {
			for (File file : files) {
				System.out.println(file.getName());
			}
		}
	}

	public static void main(String[] args) {
		new MyLambda3();
	}
}
