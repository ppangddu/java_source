package pack4;

public class Ex17PolyMain {
    public static void main(String[] args) {
        Ex17PolyCar car1 = new Ex17PolyCar();
        Ex17PolyBus bus1 = new Ex17PolyBus();
        Ex17PolyTaxi taxi1 = new Ex17PolyTaxi();

        System.out.println();
        car1.displayData();
        System.out.println(car1.getSpeed());
        System.out.println();
        
        System.out.println();
        System.out.println("버스에 대해..");
        bus1.displayData();
        System.out.println(bus1.getSpeed());
        bus1.show();

        System.out.println();
        System.out.println("택시에 대해..");
        taxi1.displayData();
        System.out.println(taxi1.getSpeed());

        System.out.println("\n= = = = = = 주소 치환 = = = = = =");
        Ex17PolyCar car2 = new Ex17PolyBus(); //promotion - 자식의 객체를 부모 타입에 줌, 버스 객체의 주소를 갖고 있다. 자식의 주소 부모에게 치환함
        car2.displayData();
//      car2.show(); //show()는 버스 고유 메서드라서 불가능하다. 오버라이딩 된 메서드만 부모 타입의 객체 변수로 자식의 메서드를 부를 수 있다.
        System.out.println();
        Ex17PolyCar car3 = taxi1; //promotion, 택시 객체의 주소를 갖고 있다, 자식의 주소 부모에게 치환함
        car3.displayData();

        System.out.println("\n= = = = = = 다형성 = = = = = =");
//      Ex17PolyBus bus2 = new Ex17PolyCar(); //X, 부모의 객체를 자식 타입에게 줄수는 없음
//      Ex17PolyBus bus2 = car2; //car2는 자식의 객체를 부모 타입에 준것이니 (자식의 주소를 가지고 있다) casting하면 가능함
        Ex17PolyBus bus2 = (Ex17PolyBus) car2;
        bus2.displayData();
        bus2.show();

        System.out.println();
//      Ex17PolyTaxi taxi2 = new Ex17PolyCar(); //X, 아예 안됨
//      Ex17PolyTaxi taxi2 = car3; //X, casting가능
        Ex17PolyTaxi taxi2 = (Ex17PolyTaxi) car3;
        taxi2.displayData();

//      Ex17PolyTaxi taxi3 = car1; //부모 타입이지만 자식의 객체를 갖고 있으면 casting 가능한데 처음부터 부모 객체를 갖고 있으니 아예 안됨
        System.out.println("= = = = = = = = = = = = = = = = =");
        Ex17PolyCar p[] = new Ex17PolyCar[3]; //Car 타입의 배열 선언
        p[0] = car1;
        p[1] = bus1;
        p[2] = taxi1;

//        p[0].displayData();
//        p[1].displayData();
//        p[2].displayData();

        System.out.println();
        for (int i = 0; i < p.length; i++) {
            p[i].displayData();
        }

        for (Ex17PolyCar car : p) {
            car.displayData();
        }











    }
}
