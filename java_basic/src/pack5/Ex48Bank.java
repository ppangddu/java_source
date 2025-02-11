package pack5;

public class Ex48Bank {
    private int money = 10000; //스레드가 공유할 자원

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

//      public void saveMoney(int mon) { //입금
        public synchronized void saveMoney(int mon) {
        //synchronized가 적용된 메서드 내의 멤버 필드는 스레드에서 공유가 가능
        //어떤 스레드가 멤버 필드 money를 사용하는 동안 Lock이 걸림
        //saveMoney 메서드 수행이 끝나면 자동으로 Lock이 풀림
        //synchronized쓰기 전에는 2초 3초 똑같이 시작해서 3초짜리가 2초하고 1초뒤에 찍히는데 synchronized를 쓰고나서는 2초 끝나고 3초 실행한다.
        int m = this.getMoney();
        try {
            Thread.sleep(2000); //입금 지연 시간 2초
        } catch (Exception e) {

        }
        this.setMoney(m + mon);
    }
    public synchronized void minusMoney(int mon) { //출금
        int m = this.getMoney();
        try {
            Thread.sleep(3000); //출금 지연 시간 2초
        } catch (Exception e) {

        }
        this.setMoney(m - mon);
    }


}
