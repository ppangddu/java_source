package pack;

public class Test10Array {

	public static void main(String[] args) {
		/*
		 * 배열 : 타입(성격과 크기)이 일치하는 여러 개의 기억 장소(변수)를 대표명 하나만 주고 첨자(색인)로 각 기억 장소를 구분함. 반복
		 * 처리에 효과적이다.
		 */

		// 3과목 점수의 합 구하기
		int kor, eng, mat; // 단순 변수 : 모든 기억 장소를 독립적으로 선언
		kor = 90;
		eng = 80;
		mat = 100;
		int total = kor + eng + mat;
		System.out.println("세 과목 점수의 총합은 " + total + "입니다.");

		// 배열을 사용해 3과목 점수의 합 구하기
		int[] score = new int[3];
		score[0] = 90;
		score[1] = 80;
		score[2] = 100;
		int total2 = 0;
		for (int i = 0; i < 3; i++) {
			total2 += score[i];
		}
		System.out.println("세 과목 점수의 총합은 " + total2 + "입니다.");

//		int[] ar;	//배열로 선언(아직 기억 장소를 확보하지 못함)
//		ar = new int[5];	//5개의 기억 장소가 확보됨
		int[] ar = new int[5]; // 대표형 ar인 int type의 변수 5개를 선언

		System.out.println("배열의 크기 " + ar.length);
		ar[0] = 10;
		ar[1] = 20;
		ar[2] = ar[0] + ar[1];
		System.out.println("ar[2] : " + ar[2]);
		System.out.println("ar[3] : " + ar[3]); // 기본값 0을 기억
//		System.out.println("ar[5] : " + ar[5]);	//배열의 인덱스는 0부터 시작한다.
		// 배열의 인덱스(첨자)는 0부터 출발, 양의 정수만 가능
		int kbs = 2;
		System.out.println("ar[2] : " + ar[2] + " " + ar[kbs] + " " + ar[kbs + 1 - 1]);
		// ar[kbs] //kbs를 첨자 변수 또는 색인 변수, index variable이라고 부른다.

		// 배열 선언 후 초기값 저장
		int[] ar2 = { 1, 2, 3, 4, 5 }; // 내부적으로 new를 한다.
		System.out.println(ar2[0] + " " + ar2[4]);

		for (int i = 0; i < ar2.length; i++) { // 배열 요소값 반복문으로 출력
			System.out.println(ar2[i] + " ");
		}
		System.out.println();

		for (int k = 0; k < ar2.length; k++) { // 반복문으로 배열 요소에 값을 저장
			ar2[k] = k + 10;
			System.out.println(ar2[k] + " ");
		}

		// 배열을 이용한 반복처리 시 향상된 for를 사용할 수 있다.
		for (int no : ar2) { // ar2 배열 요소가 차례대로 no에 치환되면서 반복 처리
			System.out.println(no + " ");
		}

		double[] silsu = { 3.5, 2.1, 6.4 };
		for (int i = 0; i < silsu.length; i++) {
			System.out.println(silsu[i]);
		}

		String[] city = { "서울", "제주", "원주" };
		for (int i = 0; i < city.length; i++) {

			System.out.println(city[i]);
		}

		for (String no : city) { // 향상된 for 문(String)
			System.out.println(no + " ");
		}

		System.out.println("5명의 사람 키(정수)를 배열에 저장하고 평균 키 출력");
		int[] heights = { 170, 123, 145, 159, 180 };
		int hap = 0;
		for (int i = 0; i < heights.length; i++) {
			hap += heights[i];
		}
		double heightAvg = (double) hap / heights.length; // 155.4
//		double heightAvg = hap/heights.length;	//155.0, 정수/정수니까 소수점 이하 버림
		System.out.println(heights.length + "명의 평균키는 " + heightAvg);
		// heights 기억 장소는 1차원 배열 : 한 행에 요소(열)로만 구성된 배열

		System.out.println("2차원(다차원) 배열 = = = = = = = = = = = = = = =");
//		int su;	//한 개의 독립 변수
//		int[] su;	//열로만 구성된 집합 변수 : 1차원 배열
//		int[][] su;	//행과 열로 구성된 집합 변수 : 2차원 배열
		int[][] su = new int[3][4]; // 1차원 배열로 선언하면 int su = new int[12];
		System.out.println("행의 갯수 : " + su.length);
		System.out.println("열의 갯수 : " + su[0].length);
		su[0][0] = 7; // 2차원 su의 0행 0열에 7을 기억
		System.out.println("su[0][0] : " + su[0][0]);

		// 2차원 배열 su에 값 저장
		int num = 10;
		for (int i = 0; i < su.length; i++) {
			for (int j = 0; j < su[i].length; j++) {
				su[i][j] = num++; // su[i][j] = ++num; 하면 11부터 시작
			}
		}
		System.out.println("su[0][0] : " + su[0][0]);

		// 2차원 배열 su의 값 출력
		for (int i = 0; i < su.length; i++) {
			for (int j = 0; j < su[i].length; j++) {
				System.out.print(su[i][j] + " ");
			}
			System.out.println();
		}

		// 문제1) 1차원 배열 요소에서 홀수와 짝수의 합 각각 출력
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int sum1 = 0;	//evenSum
		int sum2 = 0;	//oddSum
		for (int i = 0; i < arr.length; i++) {
//		for(int i : arr) {	향상된 for 문을 사용할 때!
//			System.out.println(i);
//		} 
			if (arr[i] % 2 == 0) {
				sum1 += arr[i];
			} else {
				sum2 += arr[i];
			}
		}
		System.out.println("짝수의 합 : " + sum1);
		System.out.println("홀수의 합 : " + sum2);

		// 문제2) 2차원 배열 전체 요소의 합을 출력
		int[][] arr2 = { { 1, 2 }, { 3, 4 } };
		int sum = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				sum += arr2[i][j];
			}
		}
		System.out.println("arr2 배열 요소의 총합은 : " + sum);

	}

	

}
