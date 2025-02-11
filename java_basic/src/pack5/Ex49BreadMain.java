package pack5;

public class Ex49BreadMain {
    public static void main(String[] args) {
        //스레드 동기화 중 협력관계 처리
        //스레드 간 협력 작업 중 스레드를 비활성화(wait())ㅎ 다시 활성화(notify()) 상태로 되돌리기 작업
        try {
            Ex49BreadPlate breadPlate = new Ex49BreadPlate();

            Ex49BreadMaker maker = new Ex49BreadMaker(breadPlate);
            Ex49BreadEater eater = new Ex49BreadEater(breadPlate);
            maker.setPriority(9); //우선 순위
            maker.start();
            eater.start();

            System.out.println("현재 실행 중인 스레드 수 : " + Thread.activeCount());
        } catch (Exception e) {

        }
// 실행 중인 모든 스레드 출력
//        System.out.println("현재 실행 중인 스레드 수: " + Thread.activeCount());
//        Thread[] threads = new Thread[Thread.activeCount()];
//        Thread.enumerate(threads); // 현재 실행 중인 모든 스레드 정보를 배열에 저장
//        for (Thread thread : threads) {
//            System.out.println("스레드 이름: " + thread.getName());
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }


    }
}
