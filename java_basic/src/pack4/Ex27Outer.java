package pack4;

//내부 클래스
//클래스의 멤버로 필드, 메서드 외에 클래스를 가질 수 있다. 이를 내부 클래스라고 부름
//클래스 내에서 다른 클래스 객체를 사용해야 하는 경우가 있음 이때 구현하면 효과적임
//참고로 한 개의 클래스는 한 개의 extends 문을 가질 수 있다는 점을 기억하자.
public class Ex27Outer {
    private int kor;
    private Inner inner;

    public Ex27Outer() {
        kor = 10;
        inner = new Inner(); //내부 클래스도 객체 생성은 포함 관계처럼 해준다
    }

    public void aa() {
        System.out.println("외부 클래스 Outer의 aa 메서드");
        System.out.println("kor : " + kor);
        bb();
        inner.cc();
        System.out.println("eng : " + inner.eng);

    }

    public void bb() {
        System.out.println("외부 클래스 Outer의 bb 메서드 실행");
    }

    //내부 클래스 선언
    public class Inner {
        private int eng;

        public Inner() {
            eng = 20;
        }

        public void cc() {
            System.out.println("내부 클래스 Inner의 cc 메서드");
            bb(); //외부 클래스(외부 클래스라는 말은 없다.) Outer의 bb 메서드
            System.out.println("내부 eng : " + eng + "외부 kor : " + kor);
        }

        //내부 클래스 안에 다시 내부 클래스 선언 가능(비권장)
        public class InnerIner {

        }

    }


    public static void main(String[] args) {
        Ex27Outer outer = new Ex27Outer();
        outer.aa();
        outer.bb();

//        Inner inner = new Inner(); //내부 클래스는 독립적인 객체 생성(new) 불가
//        Ex27Outer.Inner inner = outer.new Inner(); //이렇게는 가능하나 비권장
//        inner.cc();

        System.out.println();
    }
}
