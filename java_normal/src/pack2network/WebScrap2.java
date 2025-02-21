package pack2network;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// jsoup 는 실제 HTML 및 XML 작업을 간소화하는 Java 라이브러리입니다. 
// DOM API 메서드, CSS 및 xpath 선택기를 사용하여 URL 페칭, 데이터 구문 분석, 추출 및 조작을 위한 사용하기 쉬운 API를 제공합니다.
public class WebScrap2 {
	
	public static void main(String[] args) {
		//https://ko.wikipedia.org/wiki/비욘세(인코딩)
		//https://ko.wikipedia.org/wiki/%EB%B9%84%EC%9A%98%EC%84%B8(디코딩)
		// URL 인코딩은 URL에서 사용될 수 없는 특수 문자나 공백을 안전하게 전송할 수 있도록 문자를 **%**와 두 자리 16진수로 변환하는 과정입니다.
		try {
//			System.out.println(URLEncoder.encode("비욘세", "utf-8"));	
			// 위키백과에서 비욘세를 검색해 해당 자료 읽기
			String url = "https://ko.wikipedia.org/wiki/" + URLEncoder.encode("비욘세", "utf-8");
			Document doc = Jsoup.connect(url).get();
			String text = doc.text(); //웹 페이지의 모드 텍스츠를 추출
			System.out.println(text);
			
			printKorText(text);
			//한글 데이터만 얻기
		} catch (Exception e) {
			
		} 
	}
	public static void printKorText(String text) {
		// 정규 표현식 사용
		// 프로그래밍에서 문자열을 다룰 때, 문자열의 일ㅇ정한 패턴을 표현하는 일종의 형식언어를 말한다.
		Pattern pattern = Pattern.compile("[가-힣\\s]+"); // 정규 표현식 패턴 작성
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			String line = matcher.group().trim(); // 앞뒤 공백 제거
			if (!line.isEmpty()) { // 빈 줄이 아닌 경우만 출력
				System.out.println(line);
				
			}
		}
	}
}
