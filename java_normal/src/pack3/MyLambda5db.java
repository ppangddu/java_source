package pack3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.function.Consumer;

public class MyLambda5db {
//	private Connection conn; // DBMS와 연결 지원
//	private Statement stmt; // sql문 실행 지원
//	private ResultSet rs; // select의 결과에 접근 가능
	
	
	public MyLambda5db() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(Exception e) {
			System.out.println("로딩 실패 : " + e);
		}
		System.out.println("처리1");
		String sql = "select * from sangdata";
		queryDb(sql, rs -> { // 두 번째 매개변수르 넘겨지는 것은 람다식이다. 이 람다식은 Consumer<ResultSet>을 구현한 코드
			try {
				System.out.println("처리3");
				while(rs.next()) {
				System.out.println(rs.getString("code") + " " + 
				rs.getString("sang") + " " + rs.getString("su")+ " " +
				rs.getString("dan"));
				}
		} catch(Exception e) {
			System.out.println("err : " + e);
		}
			
		});
	}
	
	private void queryDb(String sql, Consumer<ResultSet> consumer) {
		// try - with - resources 문법 사용해 try 문에 매개변수를 허용
		// 매개변수 객체는 자동 close()
		try (
			Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "1234"); // DriverManager.getConnection을 통해 MariaDB에 연결함
			PreparedStatement pstmt = conn.prepareStatement(sql); // preparedStatement를 사용하여 sql 쿼리를 실행하고 ResultSet을 얻는다.
			ResultSet rs = pstmt.executeQuery() // executeQuery메서드는 select 쿼리를 실행하고 그 결과를 ResultSet 객체로 반환함, ResultSet 객체는 결과 데이터를 행 단위로 가져올 수 있도록 해주며, 데이터를 읽고처리할 수 있다.
		) {
			System.out.println("처리2");
			consumer.accept(rs); // consumer.accept(rs)를 호출하여 consumer(람다식)가 전달한 로직을 실행한다.
			System.out.println("처리4");
		} catch (Exception e) {
			System.out.println("queryDb err : " + e);
		}
	}
	
	public static void main(String[] args) {
		new MyLambda5db();
	}
}
