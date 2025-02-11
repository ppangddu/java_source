package pack4;

//Adapter class는 특정 인터페이스의 추상 메더드를 오버라이딩한 추상 클래스를 말함
//인터페이스의 추상 메서드를 implements한 자식클래스는 메서드 모두를 오버라이딩 해야 하는 부담이 있다
//이를 개선하기 위한 목적으로 Adapter class를 사용할 수 있다.

public abstract class Ex25FlyerAdapter implements Ex24Flyer {

    @Override
    public void fly() {

    }

    @Override
    public boolean isAnimal() {
        return false;
    }
}
