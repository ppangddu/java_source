package pack4;

public class Ex29Kildong {
    public Ex29Saram getSaram() {
//        return new Ex29Saram();

        return new Ex29Saram()
        { //내부 무명(익명) 클래스
            public String getIrum() { //Ex29Saram 클래스의 메서드를 오버라이딩
                String ir = "홍길동";
                return ir;
            }
        };
    }
}
