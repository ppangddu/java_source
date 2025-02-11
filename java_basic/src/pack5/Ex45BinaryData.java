package pack5;

import java.io.Serializable;

//자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바시스템에서도
//사용할 수 있도록 바이트(byte) 형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를
//다시 객체로 변환하는 기술(역 직렬화)를 어울러서 이야기 함
//객체를 파일에 저장하거나 파일에서 꺼내오기 위해서또는객체를 네트워크를 통해 전송하기 위해서는
//미리 객체를 직렬화 해야 한다. 네트워크 처리에서 주로 사용!!!!

public class Ex45BinaryData implements Serializable {
    int i = 100;
    double d = 123.4;
    String ss1 = "good";
    String ss2 = "오늘은 금요일";


}
