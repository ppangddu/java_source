package pack5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Ex39File2 {
    public static void main(String[] args) throws Exception{
        //Console을 이용한 입력
        Scanner scanner = new Scanner(System.in);
        System.out.print("나이 : ");
        int nai = scanner.nextInt();
        System.out.println("나이는 " + nai + "살");

        System.out.println("파일 단위의 입력(읽기)");
        File f = new File("c:/ssu/iotest2.txt"); //"c:\\ssu\\otest.txt" 같은 경로 의미
        FileReader fr = new FileReader(f);
        BufferedReader br1 = new BufferedReader(fr);

        while (true) { //파일의 끝을 만날 때까지 반복
            String str = br1.readLine();
            if (str == null) break;
            System.out.println(str);

        }
        br1.close();
        fr.close();


    }
}
