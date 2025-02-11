package pack2;

public class Test1 {

    public void printAge(String name, int age) {
        System.out.println("이름은 '" + name + "'이고 나이는 " + age + "살 입니다.");
    }

    public void printAge(String name) {
        System.out.println("이름은 '" + name + "'이고 나이는 알 수 없습니다.");
    }

    public void printAge() {
        System.out.println("이름과 나이가 모두 없습니다.");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.printAge("하루카", 18);
        test1.printAge("하루카");
        test1.printAge();

    }

}
