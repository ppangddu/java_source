package pack4;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex26FrameAdapter extends WindowAdapter { //상속
    private Frame frame; //클랫의 포함 관계

    public Ex26FrameAdapter() {
        frame = new Frame("어뎁터 사용");
        frame.setSize(400, 300);
        frame.setLocation(200, 300);
        frame.setVisible(true);

        frame.addWindowListener(this);
    }

    @Override
    public void windowClosing(WindowEvent e) { //윈도우 이벤트 관련 메서드 중 원하는 메서드만 오버라이딩 가능해진다. //내가 부르는 게 아님 이벤트가 발생할 때 부르는 거(callBack 메서드)
        //implements한게아니라 extends로 해서 모두 다 오버라이딩 하지 않아도 된다. adapter클래스로 Frame 클래스도 포함으로 사용
        System.exit(0);


    }

    public static void main(String[] args) {
        new Ex26FrameAdapter();
    }
}
