package pack4;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex23FrameInterface extends Frame implements WindowListener, MouseListener {
    public Ex23FrameInterface() {
        super.setTitle("이벤트 처리 창"); //super. 안써도 찾아간다.

        setSize(400, 300);
        setLocation(200, 200);
        setVisible(true);

        //윈도우 관련 이벤트 처리를 하려면 윈도우 리스너를 프레임에다가 장착
        addWindowListener(this); //super. 생략함
        //마우스 관련 이벤트 처리를 하려면 윈도우 리스너를 프레임에다가 장착
        addMouseListener(this);

    }

    public static void main(String[] args) {
//        Ex23FrameInterface ex23FrameInterface = new Ex23FrameInterface();
        new Ex23FrameInterface(); //생성과 동시에 호출
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpend");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("윈도우 종료 처리 메서드");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified");
    }

    //마우스 이벤트 관련
    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("mouseClicked 메서드 수행");
//        setBackground(new Color(155,250,40));
//        System.out.println((int) (Math.random() * 255)); //Math 클래스는 java.lang 패키지에 속하므로 자동으로 임포트됩니다.
//        //Math.random()은 static 메소드이므로, 인스턴스를 생성하지 않고 Math 클래스 이름을 통해 바로 호출할 수 있습니다.
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        setBackground(new Color(r,g,b));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
