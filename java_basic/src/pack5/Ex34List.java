package pack5;

import java.util.ArrayList;
import java.util.List;

//List : 데이터를 순서에 따라 관리, 중복 허용
public class Ex34List {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(); //자식의 객체를 만들어서 부모 객체 변수에 치환한다.
        list.add("볼펜");
        list.add("연필");
        list.add("볼펜+");
        list.add("볼펜");
        list.add("마우스");
        System.out.println("list 크기 : " + list.size()); //배열과 달리 size()를 사용한다.
        list.remove("볼펜");
        list.remove(1);
        System.out.println("list 크기 : " + list.size()); //배열과 달리 size()를 사용한다.
        System.out.println("list의 0번째는 " + list.get(0));

        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
