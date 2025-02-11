package pack4;

public class Ex17PolyTaxi extends Ex17PolyCar {
    private int passenger = 2;


    public Ex17PolyTaxi() {
        System.out.println("난 Car의 자식인 Taxi 생성자입니다.");
    }

    @Override //똑같은 내용이면 오버라이드를 할 필요가 없다. 부모 클래스에 있는 메서드를 재정의하기 위해서 오버라이드한다.
    public void displayData() {
        String msg = "택시 안 인원 수 : " + passenger;
        System.out.println(msg);

    }



}
