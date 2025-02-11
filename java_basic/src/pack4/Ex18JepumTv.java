package pack4;

//추상 클래스를 오버라이딩 안하면 Ex18JepumTv는 추상클래스다. 부모가 가지고 있는 빚을 갚아야 한다.(오버라이딩) 오버라이딩을 하게되면 추상클래스가 아님
public class Ex18JepumTv extends Ex18Jepum {

    public Ex18JepumTv() {
        //super();
        System.out.println("TV 생성자");
    }

    @Override
    public void volumeControl() {
        //메서드 오버라이딩 강요 당했음
        System.out.println("TV 소리 조절");
    }
}
