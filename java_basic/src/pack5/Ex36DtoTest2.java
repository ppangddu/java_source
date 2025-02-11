package pack5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex36DtoTest2 {
    ArrayList<Ex36StudDto> list = new ArrayList<Ex36StudDto>();
    private String name;
    private int kor, eng;

    public void insertData() {
        while (true) {
        Scanner sc = new Scanner(System.in);
            System.out.println("이름 입력 : ");
            name = sc.next();
            System.out.println("국어 점수 입력 : ");
            kor = sc.nextInt();
            System.out.println("영어 점수 입력 : ");
            eng = sc.nextInt();

            Ex36StudDto studDto = new Ex36StudDto();//넣을 때 이 타입으로 넣는다
            studDto.setIrum(name);
            studDto.setKor(kor);
            studDto.setEng(eng);
            list.add(studDto); //각 학생 정보 컬렉션에 저장

            System.out.println("계속 할까요?(y/n)");
            String s1 = sc.next();
//            if (s1.equals("n")) break;
          if (!s1.equals("y")) break;
        }
    }
    public void showData() {
        for (int i = 0; i < list.size(); i++) { //향상된 for 문도 가능함
//            Ex36StudDto studDto = new Ex36StudDto(); //뺄 때도 이 타입으로 뺀다
//            studDto = list.get(i);
            Ex36StudDto studDto = list.get(i); //위 두 줄과 동일
            System.out.println(studDto.getIrum() + studDto.getKor() + studDto.getEng()
                    + (studDto.getKor() + studDto.getEng()));
        }
        System.out.println("응시 인원 : " + list.size()); //count 쓰는 것과 동일
    }

    public static void main(String[] args) {
        Ex36DtoTest2 test2 = new Ex36DtoTest2();
        test2.insertData();
        test2.showData();
    }
}
