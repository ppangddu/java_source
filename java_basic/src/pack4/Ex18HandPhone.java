package pack4;

public class Ex18HandPhone extends Ex18Jepum {
    @Override
    public void volumeControl() {
        System.out.println("핸드폰 소리 조절하기");
    }

    @Override
    public void volumeShow() {
        //부모의 일반 메서드는 오버라이딩 선책적이다.
        volume = 10;
        System.out.println("볼륨 크기 : " + volume);
    }
}
