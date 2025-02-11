package pack4;

public class Ex24FlyerBird implements Ex24Flyer {

    @Override
    public void fly() {
        System.out.println("날개를 저으며 멀리 날아가는 새 한 마리");
    }

    @Override
    public boolean isAnimal() {
        return true;
    }
}
