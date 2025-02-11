package pack2;

public class Ex4Main {

    public static void main(String[] args) {
        System.out.println("메서드 오버로딩 연습");
        Ex4Animal tiger = new Ex4Animal();
        tiger.display();
        tiger.display(3);
        tiger.display("호랑이");
        tiger.display(8, "호랭이");
        tiger.display("호돌이", 2);

        System.out.println("\n생성자 오버로딩 연습");
        Ex4Animal dog = new Ex4Animal();
        dog.display();
        Ex4Animal hen = new Ex4Animal(2);
        hen.display();
        Ex4Animal wolf = new Ex4Animal("늑대", 7);
        wolf.display();




    }
}
