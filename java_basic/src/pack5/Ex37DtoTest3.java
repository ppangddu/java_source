package pack5;

//여러개의 필드로 구성된 데이터가 문자열로 입력될 경우 필드별 문자 분리 후 레코드 처리
//조건 : 문자열은 콤마(,) 등의 구분자로 구별되어 있다.
//출력은 이름 총점 평균

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex37DtoTest3 {
    private ArrayList<Ex37HaksangDto> list = new ArrayList<Ex37HaksangDto>();

    public void stringSplitTest() {
        String imsi = "kbs,mbc,sbs";
        StringTokenizer tokenizer = new StringTokenizer(imsi, ",");
        String s1 = tokenizer.nextToken();
        String s2 = tokenizer.nextToken();
        String s3 = tokenizer.nextToken();
        System.out.println(s1 + " " + s2 + " " + s3);


    }

    public void insertData(String[] datas) {
//        System.out.println(datas.length); //넘어왔는지 확인을 하고 짜는 습관 들이면 좋음
        for (int i = 0; i < datas.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(datas[i], ",");
            String irum = tokenizer.nextToken();
            int kor = Integer.parseInt(tokenizer.nextToken()); //wrapper 클래스
            int eng = Integer.parseInt(tokenizer.nextToken()); //wrapper 클래스
            int mat = Integer.parseInt(tokenizer.nextToken()); //wrapper 클래스

            Ex37HaksangDto dto = new Ex37HaksangDto(irum, kor, eng, mat); //이렇게만 하면 마지막 거만 기억함.
//            dto.setName(irum); //setter로 값 입력
            list.add(dto); //생성자로 값 입력
        }
    }

    public void showData() {
//        System.out.println(list.size());
        System.out.println("이름\t총점\t평균");

        for (int i = 0; i < list.size(); i++) {
//            Ex37HaksangDto dto = new Ex37HaksangDto();
//            dto = list.get(i); //0번째 주소가 넘어갔다.
            Ex37HaksangDto dto = list.get(i);
            int tot = dto.getKor() + dto.getEng() + dto.getMat();
            double avg = tot / 3.0; //3으로 나누면 정수 나누기라서 나머지를 버린다.
            System.out.println(dto.getName() + "\t" + tot + "\t" + avg);

        }

        System.out.println("\n향상된 for 사용");
        for (Ex37HaksangDto dto : list) {
            int tot = dto.getKor() + dto.getEng() + dto.getMat();
            double avg = tot / 3.0;
            System.out.println(dto.getName() + "\t" + tot + "\t" + avg);

        }
    }


    public static void main(String[] args) {
        String[] datas = new String[3];
        datas[0] = "김밥,100,100,100"; //데이터 넣을 때 띄어쓰기 하면 안 된다. ,로 구별함
        datas[1] = "공기밥,90,100,80";
        datas[2] = "주먹밥,50,90,100";

        Ex37DtoTest3 test3 = new Ex37DtoTest3();
        //참고 : 문자열 분리 클래스 결험하기
        test3.stringSplitTest();
        System.out.println();
        test3.insertData(datas);
        test3.showData();

    }
}
