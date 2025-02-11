package pack5;

//하나의 프로그램은 하나의 Process에 해당한다.이러한 process를 실제로 실행하기 위한
//실행 단위를 Thread라고 한다.
//Thread 하나는 한개의 실행을 담당하므로 결국, 여러 개의 Thread를 이용하면 여러 개의 작업(task)을 할 수 있게 된다.
//single thread는 single tasking, multi thread는 multi tasking을 하게 된다.
//여러 개의 응용 프로그램을 실행하고 싶을 때 또는 네트워크 작업을 효율적으로 운영하려면 Thread 처리는 필수적이다.
public class Ex46Thread implements Runnable{
    public Ex46Thread() {

    }
    public Ex46Thread(String name) {
        Thread tt = new Thread(this, name);
        tt.start();

    }
    @Override
    public void run() {
        //start()에 의해 호출되며 run 처리가 끝나면 Thread가 종료됨
        for (int i = 0; i <= 50; i++) {
            System.out.println(i + Thread.currentThread().getName());
            try {
                Thread.sleep(500); //1000ms : 1s
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) { //기본적으로 모든 프로그램은 main thread가 자동 실행됨

        try {
            //사용자 정의 thread를 사용하지 않은 경우
//        Ex46Thread my1 = new Ex46Thread();
//        Ex46Thread my2 = new Ex46Thread();
//        my1.run(); //처음 요청이 모두 처리되면
//        my2.run(); //다음 요청이 처리됨

//        사용자 정의 thread를 사용한 경우
            //첫번째 생성자 호출
            Ex46Thread my1 = new Ex46Thread();
            Ex46Thread my2 = new Ex46Thread();
            Thread t1 = new Thread(my1, "하나");
            Thread t2 = new Thread(my2, "둘");
            t1.start(); //run 메서드 호출
            t2.start();

            t2.setPriority(5); //스레드 스케줄러에 우선 순위를 신청
            t1.setPriority(Thread.MAX_PRIORITY); //t1은 t2보다 더 높은 우선순위를 가지므로 스케줄러에 의해
            //t2가 먼저 실행될 가능성이 크다. 하지만 실제 실행 순서는 운영 체제의 스케줄러에 따라 다를 수 있다.

            t1.join(); //사용자 정의 스레드가 종료될 때까지 메인 스레드를 대기 시킴
            t2.join(); //그래서 "프로그램 종료"가 맨 마지막에 출력됨
            //t1, t2 두 스레드가 모두 종료될 때까지 main thread는 대기하고, 그 후에 "프로그램 종료" 메시지가 한 번만 출력된다.


            //두번째 생성자 호출
//        new Ex46Thread("하나"); //스레드 스케줄러에 의해 순차적인 처리가 아니라 랜덤하게 요청
//        new Ex46Thread("둘");
            System.out.println("프로그램 종료");

        } catch (Exception e) {

        }


    }
}
