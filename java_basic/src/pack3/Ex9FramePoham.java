package pack3;

import java.awt.Frame;

public class Ex9FramePoham {
	String name = "신기해";
	private Frame frame;	//외부 클래스를 사용
	
	public Ex9FramePoham() { 
		frame = new Frame("포함 연습용"); //클래스의 포함 관계
//		
//		frame.setSize(500, 300); //너비와 높이를 지정
//		frame.setLocation(200, 150);
//		frame.setVisible(true);
		
	}
	//생성자는 초기화 및 전체 윤곽만 적고 나머지(처리 로직)는 별도 메서드로 작성하는 것이 좋음
	public void frameVisible() { 
		frame.setSize(500, 300); //너비와 높이를 지정
		frame.setLocation(200, 150);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//Ex9FramePoham framePoham = new Ex9FramePoham();
//		new Ex9FramePoham(); //객체 변수가 굳이 필요하지 않음. 생성자에서 모든 일이 처리된다.
		Ex9FramePoham framePoham = new Ex9FramePoham();
		framePoham.frameVisible();
		//위 두 줄을 한 줄로 표현
//		new Ex9FramePoham().frameVisible(); //객체 변수가 있을 수도 있고 없을 수도 있다.
	}
}
