package pack4;

//public abstract class Ex21Volume {
//    public abstract void volumeUp(int level);
//    public abstract void volumeDown(int level);

    public interface Ex21Volume { //인터페이스 : 추상 클래스의 다른 형태, 다중 상속 가능
        void volumeUp(int level);
        void volumeDown(int level);

//        public void print() { //추상 클래스는 일반 클래스도 가질 수 있는데 인터페이스는 추상 메서드만 구성되어야 한다.
//            System.out.println("일반 메서드");
//        }


    }

