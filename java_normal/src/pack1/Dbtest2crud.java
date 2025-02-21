package pack1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.sql.DriverManager;
import java.io.FileInputStream;

public class Dbtest2crud {
	private Connection conn = null; // DBMS와 연결 지원
	private Statement stmt = null; // SQL문 실행 지원
	private ResultSet rs = null; // SELECT 결과에 접근 가능
	private Properties properties = new Properties(); // ***.properties 읽기용

	public Dbtest2crud() {
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
		try {
			stmt = conn.createStatement(); // stmt 초기화
			
//			conn.setAutoCommit(false); -> Transaction 수동
//			insert, update, delete 등의 작업을 한다. Transaction 시작
//			commit or rollback으로 Transaction 종료
//			conn.setAutoCommit(true); -> commit, rollback 만나고 다시 true로 돌려놓아야 한다.
			
			// 자료 추가 - Auto commit (Transaction)
//			String sqlinsert = "insert into sangdata values(5, '새우깡', 2, 1000)";
//			stmt.executeUpdate(sqlinsert); // select 이외의 SQL은 executeUpdate 사용
			
			// 참고 : insert, update, delete는 성공하면 성공한 레코드 수, 실패하면 0을 반환
			// 자료 수정 
//			String sqlupdate = "update sangdata set sang = '허니칩', su = 17 where code = 5"; //하나를 수정해서 1반환(갯수반환)
//			// stmt.executeUpdate(sqlupdate);
//			int upResult = stmt.executeUpdate(sqlupdate);
//			System.out.println("upResult : " + upResult);
//			if (upResult > 0) {
//				System.out.println("수정 성공");
//			} else {
//				System.out.println("수정 실패");
//			}
			
			// 자료 삭제
			String sqlDelete = "delete from sangdata where code = 5";
			int delResult = stmt.executeUpdate(sqlDelete);
			if (delResult > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
			// 자료 읽기
			String sqlselect = "select * from sangdata";
			rs = stmt.executeQuery(sqlselect);
			int cou = 0;
			while (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su")
						+ rs.getString("dan"));
				cou++;
			}
			System.out.println("건수:" + cou);
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
		new Dbtest2crud(); // Dbtest2crud 객체 생성 시 연결 및 SQL 실행
	}
}
