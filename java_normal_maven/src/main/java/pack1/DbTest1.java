package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest1 {
	private Connection conn = null; // DBMS와 연결 지원
	private Statement stmt = null; // sql문 실행 지원
	private ResultSet rs = null; // select의 결과에 접근 가능

	public DbTest1() {
		try {
			// 1) JDBC 업체가 제공하는 Driver 파일 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2) DB 서버와 연결
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.28:3306/test", "root", "1234"); // localhost
		
			// 3) SQL문 실행 : select로 자료 읽기
			stmt = conn.createStatement(); // stmt 초기화 추가
			
//			String sql = "select * from sangdata";
			String sql = "select code, sang, su, dan as 단가 from sangdata";
			
			rs = stmt.executeQuery(sql); // 밑에 한줄짜리 소스와 동일하다.
			
//			rs = stmt.executeQuery("select * from sangdata");
//			System.out.println(rs.next()); // 읽을 데이터가 있으니까 true가 나온다. (true or false)
			
			while (rs.next()) { // 지료가 있는 동안 반복, 없으면 빠져나간다.
				String code = rs.getString("code");
				String sangpum = rs.getString("sang");
				int su = rs.getInt(3); // 순서(index)를 적을 수 있다.
				int dan = rs.getInt("단가"); // 별명이 칼럼명이 됨
				
				System.out.println(code + " " + sangpum + " " + su + " " + dan);
			}
			
			sql = "select count(*) as cou from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수 : " + rs.getInt("cou"));
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				
			}
		}
//		System.out.println("ok");
	}

	public static void main(String[] args) {
		new DbTest1();
	}
}
