package pack5;

import javax.swing.*;
import java.io.*;

public class Ex38File1 {
    public static void main(String[] args) throws Exception {
        //1바이트 단위의 입출력
        System.out.print("1바이트 입력: ");
        int a = System.in.read(); //한글 등의 2바이트 문자는 입력 불가
        System.out.println("a : " + a + " " + (char)a);

        System.out.println("\n문자열 출력");
        OutputStreamWriter os = new OutputStreamWriter(System.out);
//        byte b = 97;
//        os.write(b);
//        os.flush(); //메모리가 깨끗하게 지워짐

        //버퍼를 사용(파일 입출력(i/o) 성능을 향상시킴, 속도가 빨라짐)
        BufferedWriter bw = new BufferedWriter(os, 1024); //입출력은 기본이 1025byte(1kb) 단위로 처리됨, 생략 가능
        PrintWriter out = new PrintWriter(bw);
        out.println(123);
        out.println("문자열 출력");
        out.close(); //자원 해제(메모리 반납, GC의 대상)
        bw.close();

        System.out.println("파일 단위의 출력"); //file을 저장할 때
        File f = new File("c:/ssu/iotest.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw1 = new BufferedWriter(fw);
        PrintWriter out1 = new PrintWriter(bw1); //보기 쉽게 여러 줄로 씀 한줄로 쓰기 가능
        out1.println(1234);
        out1.println("좋아 여기까지");
        out1.println("좋아 여기까지좋아 여기까지좋아 여기까지좋아 여기까지 \\r 아 여기까지좋아 여기까지좋아 여기까\r지좋아 여기까지좋아 여기까지좋아 여기까지좋아 여기까지좋아 여기까지좋아 여기까지");
        out1.close();
        bw1.close();
        fw.close();





    }
}
