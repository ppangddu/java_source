package pack4;

public class Ex21VolumeMain {
    public static void main(String[] args) {
//        Ex21Volume myvolume = new Ex21Volume(); //X, 추상클래스는 new 할 수 없다와 같은 맥락임
        Ex21Volume myvolume;

        Ex21Radio radio = new Ex21Radio();
        Ex21Tv tv = new Ex21Tv();

        radio.volumeUp(10);
        radio.volumeDown(5);

        tv.volumeUp(6);
        tv.volumeDown(2);

        System.out.println();
        myvolume = radio;
        myvolume.volumeUp(3);
        myvolume = tv;
        myvolume.volumeUp(2);
    }
}
