package pack4;

//전자 제품 관련 부모 클래스 (추상), abstract 메서드가 없어도 abstract를 써서 추상 클래스가 가능한데 new를 못한다. 자기 스스로 객체를 생성하지 않겠다는 의미
abstract public class Ex18Jepum { //전자 제품이 공통으로 가져야 할 멤버 선언
    public int volume = 0;

    public Ex18Jepum() {
        System.out.println("Jepum 추상 클래스 생성자");
    }

    abstract public void volumeControl(); //추상 메서드 - body가 없음

    public void volumeShow() {
        System.out.println("소리 크기 : " + volume);
    }
}
