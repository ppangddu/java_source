package pack2;

public class Ex3Singer {

    private String name = "무명 가수";
    private String titleSong = "아 대한민국";

    public Ex3Singer(String name, String titleSong) {
        //생성자
        this.name = name;
        this.titleSong = titleSong;
    }

    public void sing() {
        //String name = "하루카";    //지역변수, 변수가 있을 때 지역변수가 우선임
//        System.out.println(name + "의 노래 제목은 " + titleSong); //하루카의 노래 제목은 아 대한민국
        System.out.println(name + "의 노래 제목은 " + titleSong); //무명 가수의 노래 제목은 아 대한민국
    }

    public void setTitleSong(String titleSong) {    //setter
        this.titleSong = titleSong;
    }

    public static void main(String[] args) {    //외부임
        Ex3Singer bts = new Ex3Singer("방탄소년단", "봄날");
        bts.sing();
        bts.setTitleSong("방탄신곡");
        bts.sing();
        bts.setTitleSong("방탄신곡123");
        bts.sing();

        System.out.println();
        Ex3Singer blackPink = new Ex3Singer("블랙핑크", "마지막처럼");  //객체가 두 개 만들어짐
        blackPink.sing();


    }
}
