package pack4;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex28FrameInnerClass extends Frame {
    int x, y; //되도록 지역 변수 선언 권장

    public Ex28FrameInnerClass() {
        setTitle("내부 클래스 사용");
        setSize(400, 500);
        setLocation(250, 350);
        setVisible(true);

//        Wevent wevent = new Wevent();
//        addWindowListener(wevent); //WindowListener는 WindowAdapter가 갖고 있다, 포함 관계처럼 내부 클래스의 객체를 인스턴스한다.
        addWindowListener(new Wevent()); //위 두 줄과 같은 의미
        addMouseListener(new Mevent());
    }

    class Wevent extends WindowAdapter { //내부 클래스
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    class Mevent extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
//            setBackground(new Color(255,255,0));
//            System.out.println(e.getX() + " " + e.getY());
//            setTitle(e.getX() + " " + e.getY()); //외부 클래스 멤버는 마음대로 부를 수 있음. (여기에서 super. 찍으면 MouseAdapter를 가리키는 거라서 찍으면 안 된다.)

            x = e.getX();
            y = e.getY();

            paint(getGraphics()); //마우스 클릭할 때마다 paint()를 부른다.
        }
    }

    @Override
    public void paint(Graphics g) {  //Frame(혹은 Component의 자식 클래스들)은 paint()를 처음 실행 시 한번 호출
        g.drawString("홍길동", x, y);
    }

    public static void main(String[] args) {
        new Ex28FrameInnerClass();
    }
}
