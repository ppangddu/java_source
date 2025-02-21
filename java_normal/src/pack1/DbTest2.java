package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest2 {

	private Connection conn = null; // DBMS와 연결 지원
	private Statement stmt = null; // sql문 실행 지원
	private ResultSet rs = null; // select의 결과에 접근 가능

	public DbTest2() {
		try {
			// 1) JDBC 업체가 제공하는 Driver 파일 로딩
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e.getMessage());
			return;
		}

		try {
			// 2) DB 서버와 연결
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.28:3306/test", "root", "1234"); // localhost
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		
		try {
			// 3) SQL문 실행 : select로 자료 읽기
			stmt = conn.createStatement(); // stmt 초기화 추가
			
//			String sql = "select * from sangdata";
			String sql = "select jikwonno, jikwonname, jikwonjik, busername from jikwon join buser where busernum = buserno and (jikwonjik = '사원' or jikwonjik = '대리')";
			
			rs = stmt.executeQuery(sql); // 밑에 한줄짜리 소스와 동일하다.
			
//			rs = stmt.executeQuery("select * from sangdata");
//			System.out.println(rs.next()); // 읽을 데이터가 있으니까 true가 나온다. (true or false)
			
			while (rs.next()) { // 지료가 있는 동안 반복, 없으면 빠져나간다.
				String jikwonno = rs.getString("jikwonno");
				String jikwonname = rs.getString("jikwonname");
				String jikwonjik = rs.getString("jikwonjik");
				String busername = rs.getString("busername");
				
				System.out.println(jikwonno + " " + jikwonname + " " + jikwonjik + " " + busername);
			}
			
			sql = "select count(*) as inwonsu from jikwon where jikwonjik = '사원' or jikwonjik = '대리'";
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("인원수 : " + rs.getInt("inwonsu"));
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		}
	}
	
	public static void main(String[] args) {
		new DbTest2();
	}
}
