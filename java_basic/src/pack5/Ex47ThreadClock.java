package pack5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Ex47ThreadClock extends Frame implements Runnable, ActionListener {
    Label lblMessage;
    Thread thread;
    Boolean b = false;


    public Ex47ThreadClock() {
        lblMessage = new Label("show datatime", Label.CENTER);
        add("Center", lblMessage);

        Button button = new Button("click");
        add("South", button);
        button.addActionListener(this);

        setTitle("스레드 시계");
        setSize(300, 200);
        setLocation(200, 200);
        setVisible(true);

        //내부 무명 클래스 사용해서 창 닫기
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                b = true; //윈도우 종료 시 run 메서드의 무한 루프를 끝내기 위함
                System.exit(0);

            }
        });

        thread = new Thread(this); //사용자 정의 스레드 생성
    }

    @Override
    public void run() {
        while (true) {
            if (b == true) break; //그냥 b라고만 써도 된다.
            showSigan();

            //showSigan을 1초에 한 번씩 호출할 수 있도록 스레드 1초간 비활성화
            try {
                Thread.sleep(1000); //1000ms = 1s
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { //click 버튼을 누르면 이 메서드로 오게 되어있다.
//        System.out.println("button click");
//        showSigan();
        if (thread.isAlive()) return; //thread가 활성화 된 상태인 경우 메서드 탈출, 처음에는 활성화된 상태가 아님. 버튼을 눌렀을 때 한번만 start()를 만날 수 있게 해준다.
        thread.start(); //run()을 호출
    }


    private void showSigan() {
        LocalDate date = LocalDate.now(); //singleton 객체
        int y = date.getYear();
        int m = date.getMonthValue();
        int d = date.getDayOfMonth(); //365일을 기준으로

        LocalTime localTime = LocalTime.now();
        int h = localTime.getHour();
        int mi = localTime.getMinute();
        int s = localTime.getSecond();

        String imsi = y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s;
        lblMessage.setText(imsi);

    }

    public static void main(String[] args) {
        new Ex47ThreadClock();
    }
}
