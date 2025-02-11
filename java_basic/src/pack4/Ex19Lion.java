package pack4;

public class Ex19Lion extends Ex19Animal {
    @Override
    public String name() {
        return "사자";
    }

    @Override
    public String eat() {
        return "고기";
    }

    @Override
    public String action() {
        return "밤에 돌아다님";
    }

    public void eatOther() { //Lion 고유 메서드
        System.out.println("가끔은 소세지도 먹음");
    }
}
