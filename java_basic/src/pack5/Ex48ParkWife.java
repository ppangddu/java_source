package pack5;

public class Ex48ParkWife extends Thread { //은행을 이용하는 박씨 클래스
    @Override
    public void run() { //어디선가 start()하면 실행
        Ex48BankMain.hanaBank.minusMoney(3000);
        System.out.println("박씨 아내 출금 후 잔고 : " + Ex48BankMain.hanaBank.getMoney());


    }
}
