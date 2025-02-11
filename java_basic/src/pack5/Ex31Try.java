package pack5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//예외처리 : 키보드 입력, 파일 입출력, 네트워크, DB 처리 중 외부 장치와 연결해 사용하는 경우
//예기치못한 장치에러가 발생ㅏㄹ 수 있는데 이블 방지할 목적으로 사용한다
//형식 : try{} catch{} finally {} <== 에러를 내가 잡아 에외 처리
//throws로 예외를 JVM에게 던져버릴 수도 있다.

public class Ex31Try {
    public String name = "tom";

    public void test() {
        try {
            int[] a = {1, 2, 3};
//        System.out.println("배열값 출력 : " + a[1]);
            System.out.println("배열값 출력 : " + a[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 오류 - 지역이 우선함");
        }
    }

    public void test2() throws Exception { //던지는 건 좋은 방법 아님, try catch문은 쓰긴 싫고 그냥 에러 무시하고 통과함
        FileReader fileReader = new FileReader("c:/ssu/kbs.txt");
    }


    public static void main(String[] args) {
        try {
            //파일 작업은 강제로 예외처리를 요구함
            //aa.txt가 없는 경우에만 catch 블록을 수행
            FileReader fr = new FileReader("c:/ssu/aaa.txt");//이 문장이 에러가 없기 때문에 통과 //파일 처리니까 강요하는 중?
        } catch (FileNotFoundException e) {
            System.out.println("파일 읽기 오류");
        }

        try {
            int su = 0; //키보드로 변수값을 기억한다고 가정
//            int su = 2;
            int result = 10 / su;
            System.out.println("result : " + result);

            Ex31Try ex31try = new Ex31Try();
//            Ex31Try ex31try = null;
            System.out.println("이름은 " + ex31try.name);
            ex31try.test();

            ex31try.test2(); //에러가 나지만 그냥 통과

        } catch (ArithmeticException e) {
            System.out.println("나누기 오류 : 0으로 나누기 불가");
        } catch (NullPointerException e) {
            System.out.println("참조 변수 오류(변수가 주소를 참조하지 않네요" + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 참조 에러 : " + e.getMessage());
        } catch (Exception e) { //다른 Exception이랑 있을 때 얘가 맨 위에 있으면 다른 Exception은 실행 안 된다.
            System.out.println("위 catch 이외의 나머지 모든 오류는 여기서 처리");
            //Exception을 가장 먼저 적으면 모든 예외처리는 Exception 블럭에서 처리
        } finally {
            System.out.println("에러 유무에 상관없이 반드시 수행");
        }

        System.out.println("프로그램 종료");

    }

}
