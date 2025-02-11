package pack4;

public class Ex24FlyerAirplane implements Ex24Flyer {

    @Override
    public void fly() {
        System.out.println("커다란 엔진 소리와 함께 날고 있는 비행기");
    }

    @Override
    public boolean isAnimal() {
        return false;
    }
}
