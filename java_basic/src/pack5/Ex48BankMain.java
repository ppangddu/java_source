package pack5;

public class Ex48BankMain {
    public static Ex48Bank hanaBank = new Ex48Bank();

    public static void main(String[] args) {
        //스레드 동기화
        //공유 자원에 Lock을 걸어 하나의 스레드가 공유 자원을 사용 중인 경우
        //다른 스레드는 공유 자원을 사용하지 못하고 대기 상태에 빠뜨릴 수 있다.
        //synchronized를 이용(내부적으로 Lock을 건다.)
        System.out.println("원금 : " + hanaBank.getMoney()); //static은 static만 부를 수 있다.

        Ex48Park park = new Ex48Park();
        park.start();

        Ex48ParkWife wife = new Ex48ParkWife();
        wife.start();


    }
}
