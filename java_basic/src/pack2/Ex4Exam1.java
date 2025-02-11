package pack2;

//숫자의 제곱을 출력하는 메서드 오버로딩
//정수를 매개변수로 받는 메서드
//실수를 매개변수로 받는 메서드
public class Ex4Exam1 { //메서드 오버로딩 연습용

    //정수 제곱 계산용
    public int square(int num) {
        return num * num;
    }

    //실수
    public double square(double num) {
        return num * num;
    }

    public static void main(String[] args) {
        Ex4Exam1 exam1 = new Ex4Exam1();
        int reslut1 = exam1.square(5);
        double result2 = exam1.square(5.5);
        System.out.println("result1 = " + reslut1);
        System.out.println("result2 = " + result2);

    }
}
