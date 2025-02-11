package pack2;

//method overloading : 클래스 내에 동일 이름이 메소드를 복수로 만듬
public class Ex4Animal { //동물이 가져야 할 속성(field)과 행위(method)를 클래스로 설계
    private int leg = 4;
    private int age;
    private String name;
    public final static int MOUTH = 1;  //final일 때는 대문자로 쓴다. static은 객체 안 민들어도 된다.

    public Ex4Animal() {    //생성자도 메서드이다. 생성자도 오버로딩 가능(빈 손)
        //내용이 없는 생성자는 안 적으면 컴파일러가 자동으로 만들어준다.
        System.out.println("내용이 없는 생성자");
    }
    public Ex4Animal(int leg) {    //생성자 오버로딩 //정수 하나(보기 좋으라고 leg라고 쓴거임)
        this.leg = leg;
        System.out.println("정수 1개를 받는 생성자");

    }
    public Ex4Animal(String name, int age) {    //생성자 오버로딩(문자열 하나 정수 하나)
        this.name = name;
        this.age = age;
        System.out.println("2개의 매개변수가 있는 생성자");

    }

    public void display() {
        System.out.println("leg = " + leg);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
    }

    //오버로딩 성립 조건 : 매개변수의 갯수, 순서, 타입이 달라야 함
    public void display(int age) {  //메소드 오버로딩
//        this.age = age;
        System.out.println("leg = " + leg);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
    }

    public void display(String name) {  //메소드 오버로딩
        System.out.println("leg = " + leg);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
    }

    public void display(int age, String name) {  //메소드 오버로딩
        System.out.println("leg = " + leg);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
    }

    public void display(String name, int age) {  //메소드 오버로딩
        System.out.println("leg = " + leg);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
    }

    //오버로딩 성립 안 되는 경우
//    public void display(int leg) {  //메소드 오버로딩 불가, 갯수와 타입이 같다. 위에서 int age가 있기 때문에 X
//        System.out.println("leg = " + leg);
//        System.out.println("age = " + age);
//        System.out.println("name = " + name);
//    }
//    public void display(String name, int leg) {  //메소드 오버로딩 불가, 매개변수의 이름으로 보지말고 타입과 갯수와 순서가 중요하다.
//        System.out.println("leg = " + leg);
//        System.out.println("age = " + age);
//        System.out.println("name = " + name);
//    }
//    public int display(int leg) {  //메소드 오버로딩 불가
//        System.out.println("leg = " + leg);
//        System.out.println("age = " + age);
//        System.out.println("name = " + name);
//        return 5;
//    }


}
