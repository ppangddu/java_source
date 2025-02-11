package pack;

public class Test7Switch {
	public static void main(String[] args) {
		
		//switch : 조건 판단문의 좀 더 정형화된 문법으로 값에 따라 여러 방향으로 분기하는 경우 효과적임
		//길게 늘어진 if 문에 비해 코드가 짧고 의미 파악이 쉽다.
		int nai = 33;
		nai = nai / 10 * 10;	//나이가 10대인지 .. 등 확인하려면 이렇게 사용하면 된다.
		System.out.println(nai);
		
		switch (nai) {
		case 20:
			System.out.println("20대");
		break;
		case 30:
			System.out.println("30대");
			System.out.println("ㅎㅎㅎㅎ");
		}
		
		System.out.println("계속1");
		switch (nai) {
		case 10:
		case 20:
			System.out.println("hihi");
		break;
		case 30:
		case 40:
		case 50:
			System.out.println("hehehe");
			break;
		default:
			System.out.println("그 외 기타");
			break;
		}
		
		System.out.println("계속2");
		
//		System.out.println((int)(Math.random() * 10)); //난수 발생(다음 수 예측 불가)
//		int sigan = (int)(Math.random() * 10);
		int sigan = (int)(Math.random() * 4) + 8;	//8~11 사이의 정수가 나온다.
		System.out.println("sigan = " + sigan);	//궁금하면 찍어보자 초급이라면 해야할 습관
		switch (sigan) {
		case 0:
			System.out.println("출근 준비");
			break;
		case 9:
			System.out.println("출근 완료");
		case 11:
			System.out.println("팀 회의");
			break;
		default:
			System.out.println("개인 활동");
		}
		
		System.out.println("계속3");
		String jik = "과장";
		
		switch (jik) {
		case "사원":
			System.out.println("사원 업무");
			break;
		case "과장":
			System.out.println("과장 업무");
			break;
		default:
			System.out.println("기타 직급");
			break;
		}
		
	}
}
