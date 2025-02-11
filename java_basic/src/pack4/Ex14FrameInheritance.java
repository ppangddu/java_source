package pack4;

import java.awt.Frame;

public class Ex14FrameInheritance extends Frame {
	
		public Ex14FrameInheritance() {
//			super();
			super("상속 연습용");
		}
		
		public void frameVisible() {
			setSize(500, 300);
//			super.setSize(500, 300);
			setLocation(1000, 300);
			setVisible(true);
		}
		
		public static void main(String[] args) {
			Ex14FrameInheritance frameInheritance = new Ex14FrameInheritance();
			frameInheritance.frameVisible();
		
	}
}
