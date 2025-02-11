package pack5;

import java.util.ArrayList;

public class Ex35DtoTest1 {
    private ArrayList<Ex35Student> list = new ArrayList<Ex35Student>();
    //DTO 사용 전 방식
    public void aa() {
        String[] persons = new String[3]; //사람 이름을 기억하기 위한 배열
        persons[0] = "홍길동";
        persons[1] = "나길동";
        persons[2] = "고길동";

        for (String s : persons) {
            System.out.println(s);
        }
    }

    //세 명의 학생(학번, 이름, 점수) 정보를 Dto에 저장하기
    public void insertData() {
        Ex35Student student = null;

        //첫 번째
        student = new Ex35Student(); //Dto 객체 생성
        student.setHakbun("acorn1");
        student.setIrum("홍길동");
        student.setJumsu(90);
        list.add(student);// 리스트에 학생 객체 추가

        //두 번째
        student = new Ex35Student(); //Dtd 객체 초기화
        student.setHakbun("acorn2");
        student.setIrum("나길동");
        student.setJumsu(80);
        list.add(student);// 리스트에 학생 객체 추가

        //세 번째
        student = new Ex35Student(); //Dtd 객체 초기화
        student.setHakbun("acorn3");
        student.setIrum("고길동");
        student.setJumsu(70);
        list.add(student);// 리스트에 학생 객체 추가

        //3명의 학생이 list라는 컬렉션에 들어갔다.
    }

    public void showData() {
        System.out.println("list의 크기 : " + list.size());
        System.out.println("첫 번째 학생 : " + list.get(0)); //쌓은 필통중에 맨첨에 넣은 필통만 꺼냄
        System.out.println("두 번째 학생 : " + list.get(1));
        System.out.println("세 번째 학생 : " + list.get(2));
        System.out.println(list.get(2).getHakbun() + list.get(2).getIrum() + list.get(2).getJumsu()); //필통 안에 있는 것들 뱀

        System.out.println("반복문을 사용해 컬렉션에 저장된 Dto의 내용 출력");
        for (int i = 0; i < list.size(); i++) {
            Ex35Student studentDto = new Ex35Student();
            studentDto = list.get(i);
            System.out.println(studentDto.getHakbun() + " " + studentDto.getIrum() + " " + studentDto.getJumsu());
        }

    }

    public static void main(String[] args) {
        Ex35DtoTest1 test1 = new Ex35DtoTest1();
        test1.aa();
        System.out.println();
        test1.insertData();
        test1.showData();
    }
}
