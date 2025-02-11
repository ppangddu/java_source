package pack4;

public class Ex17PolyBus extends Ex17PolyCar {
//    private Ex17PolyCar = new Ex17PolyCar(); //클래스 포함을 사용해도 되지만 다형성을 이용하려고 extends 사용 중
    private int passenger = 10;

    public Ex17PolyBus() {
        System.out.println("난 Car의 자식인 Bus 생성자입니다.");
    }

    @Override //똑같은 내용이면 오버라이드를 할 필요가 없다. 부모 클래스에 있는 메서드를 재정의하기 위해서 오버라이드한다.
    public void displayData() {
        System.out.println("버스 승객 인원 수 : " + passenger);
        System.out.println("버스 속도는 : " + speed); //speed 없으니까 부모 클래스에서 찾는다.
    }

    public void show() {
        System.out.println("버스 고유 메서드 show");
    }

}
