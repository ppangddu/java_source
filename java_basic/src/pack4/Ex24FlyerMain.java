package pack4;

public class Ex24FlyerMain {
    public static void main(String[] args) {
        //인터페이스의 추상 메서드는 모두 오버라이딩 해야 함(집중)
        System.out.println(Ex24Flyer.FAST); //static이니까 클래스 dot 메서드 가능
        //Ex24Flyer.FAST = 150; //final 이므로 err

        Ex24FlyerBird bird = new Ex24FlyerBird();
        bird.fly();

        Ex24FlyerAirplane airplane = new Ex24FlyerAirplane();
        airplane.fly();
    }
}
