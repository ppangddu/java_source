package pack1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbTest3 {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private Properties properties = new Properties();

	public DbTest3() {
		try {
			// 보안을 목적으로 연결 정보를 별도의 파일로 저장 후 읽기
			// secure coding 가이드라인을 따름
			properties.load(new FileInputStream("C:/ssu/javasource/java_normal/src/pack/dbinfo.properties"));

			// JDBC 드라이버 로드
			Class.forName(properties.getProperty("driver"));

			// DB 연결
			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("passwd"));

			dbProcess();

			System.out.println("프로그램 종료");

		} catch (Exception e) {
			System.out.println("처리 오류 : " + e);
			e.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}
	}

	private void dbProcess() { // 성격이 다르니까 생성자에서 뺌
//		jikwon 테이블로 직급별 연봉합, 연봉 평균 출력(console)
//		조건
//		1) 직급이 이사, 부장은 제외
//		2) 연봉이 null인 행도 제외
		try {
			stmt = conn.createStatement(); // stmt 초기화
			// 자료 읽기
			String sqlselect = "select jikwonjik, SUM(jikwonpay) as 연봉합, AVG(jikwonpay) as 연봉평균 from jikwon "
					+ "where jikwonpay is not null AND jikwonjik NOT IN ('이사', '부장') group by jikwonjik";
			rs = stmt.executeQuery(sqlselect);
			System.out.println("직급 연봉합계 연봉평균");
			while (rs.next()) {
				System.out.println(rs.getString("jikwonjik") + " " + 
                        + rs.getInt("연봉합") + " "+
                        rs.getInt("연봉평균"));
			}
			
			
		} catch (Exception e) {
			System.out.println("dbProcess err : " + e);
		} finally {
			// 자원 해제
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}
	}
	
	public static void main(String[] args) {
		new DbTest3();
	}
}
