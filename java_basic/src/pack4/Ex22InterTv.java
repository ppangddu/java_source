package pack4;

//public class Ex22InterTv implements Ex22InterVolume, Ex22InterAdvanceVolume {
public class Ex22InterTv implements Ex22InterAdvanceVolume {
    private int v = 0;

    //4개의 추상 메서드를 오버라이드 했다는 게 중요하다.
    @Override
    public void volResume() {
        v = 1;
        System.out.println("라디오 소리 켜기");
    }

    @Override
    public void volUp(int v) {
        this.v += v;
    }

    @Override
    public void volDown(int v) {
        this.v -= v;
    }

    @Override
    public void volOff() {
        v = 0;
        System.out.println("라디오 소리 끄기");
    }

}
