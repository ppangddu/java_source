package pack4;

public class Ex22Main {
    public static void main(String[] args) {
        Ex22InterRadio interRadio = new Ex22InterRadio();
        interRadio.volUp(5);
        interRadio.volUp(3);
        interRadio.showRadio();

        System.out.println();
        Ex22InterTv interTv = new Ex22InterTv();
        interTv.volResume();
        interTv.volUp(3);
        interTv.volDown(1);
        interTv.volOff();

    }
}
