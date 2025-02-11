package pack4;

public class Ex18JepumMain {
    public static void main(String[] args) {
        //추상 클래스는 스스로 객체 생성 불가, 자식의 생성자에 의해 객체 생성됨
//      Ex18Jepum jepum = new Ex18Jepum(); //java: pack.Ex18Jepum is abstract; cannot be instantiated
        Ex18Jepum jepum = null;

        Ex18JepumTv tv = new Ex18JepumTv();
        tv.volumeControl();
        tv.volumeShow();

        Ex18Radio radio = new Ex18Radio();
        radio.volumeControl();
        radio.volumeShow();

        Ex18HandPhone handPhone = new Ex18HandPhone();
        handPhone.volumeControl();
        handPhone.volumeShow();

        System.out.println();
        jepum = handPhone;
        jepum.volumeControl();
        jepum = radio;
        jepum.volumeControl(); //다양한 결과가 나올 수 있다 -> 다형성
        jepum = handPhone;
        jepum.volumeControl();

        System.out.println();
        Ex18Jepum j[] = {tv, radio, handPhone};
        for (Ex18Jepum ex18Jepum : j) {
            ex18Jepum.volumeControl();
        }
    }
}
