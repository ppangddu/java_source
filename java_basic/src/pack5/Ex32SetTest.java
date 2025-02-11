package pack5;

//Collection : 객체를 담을 수 있는 기억 장소
//많은 수의 데이터를 그사용 목적에 적합한 자료구조로 묶어 하나로 그룹화한 객체를 말함
//자바에서는 이러한 컬렉션을 위한 인터페이스와 클래스들이 있음
//컬렉션의 종류는 ArrayList, LinkedList, Vector, Stack, HashSet, TreeSet, HashMap,LinkedHashSet 등이 있다.
//List : 이름과 같이 목록처럼 데이터를 순서에 따라 관리, 중복 허용
//Set : 중복이 허용되지 않는 데이터를 관리
//Map : 데이터를 Key와 Value로 짝을 이루어 관리하며, Key 값은 중복을 허용하지 않음
//Queue : 데이터 In / Out 순서를 FIFO 방식으로 관리함
//Stack : 데이터 In / Out 순서를 LIFO 방식으로 관리함

import com.sun.security.jgss.GSSUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex32SetTest { //중복 불허, 순서 없다.
    public static void main(String[] args) {
        //컬렉션타입클래스<제네릭> : 제네릭은 컬렉션에 저장할 객체의 타입을 제한하는 역할
//        HashSet<Object> hlist = new HashSet<Object>();
        HashSet<String> hlist = new HashSet<String>();
//        hlist.add(1); //1은 기본형 int인데 컬렉션에 넣으면 자동으로 Integer 클래스로 변환되어 저장됨
        //기본 자료타입(primitive type)을 객체로 다루기 위해서 사용하는 클래스들을 래퍼 클래스(wrapper class)라고 함
//        hlist.add(1.5); //1은 기본형 double인데 컬렉션에 넣으면 자동으로 Double 클래스로 변환되어 저장됨
        hlist.add("첫번째");
        hlist.add("세번째");
        hlist.add("두번째");
        hlist.add("첫번째");
        hlist.add("두번째");
        System.out.println("hlist 크기 : " + hlist.size()); //중복을 허락하지 않기 때문에 유니크 한 것만 해서 크기는 3이 나온다.
        hlist.remove("두번째");
        System.out.println("hlist 크기 : " + hlist.size());

        //Iterator 반복자는 객체 지향적 프로그래밍에서 배열이나 그와 유사한자료구조의 내부 요소를 순환하는 객체디.
        //출력방법1
        Iterator iter = hlist.iterator();
        while (iter.hasNext()) {
            String str = (String) iter.next();
            System.out.println(str);
        }

        //출력방법2
        System.out.println();
        Object[] obj = hlist.toArray();    //컬렉션을 배열로 변환
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }

        //출력방법3
        System.out.println();
        for (Object o : hlist) {
            System.out.println(o);
        }

    }
}
