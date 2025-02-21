package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// PreparedStatement : 선 처리 방식
// 동일한 sql문을 여러 클라이언트가 빈번하게 사용할 경우 효과적(웹 프로그래밍)
// ? 연산자를 사용함으로 해서 보안을 강화하고 가독성을 향상시킬 수 있다.

public class DbTest4Prepare {
	/*
	 * 전체적인 흐름: Connection을 사용하여 데이터베이스에 연결합니다. 
	 * PreparedStatement을 사용하여 파라미터화 된 쿼리를 준비하고 실행합니다. 
	 * ResultSet을 사용하여 실행된 쿼리의 결과를 다룸.
	 */
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public DbTest4Prepare() {
		try {
			Class.forName(("org.mariadb.jdbc.Driver"));
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.28:3306/test", "root", "1234"); 
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e.getMessage());
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
			System.exit(0);
		}
	}

	public void dbProcess() {
		try {
			// 자료 추가
//			String isql = "insert into sangdata value(?,?,?,?)";
//			pstmt = conn.prepareStatement(isql);
//			pstmt.setString(1, "5");
//			pstmt.setString(2, "cafelatte");
//			pstmt.setString(3, "3");
//			pstmt.setInt(4, 5500);
//			
//			int re = pstmt.executeUpdate();
//			if (re == 1) {
//				System.out.println("추가 성공");
//			} else {
//				System.out.println("추가 실패");
//			}
			
			// 자료 수정
//			String usql = "update sangdata set sang = ?, su = ?, dan = ? where code = ?";
//			pstmt = conn.prepareStatement(usql);
//			pstmt.setString(1, "chocolatte");
//			pstmt.setInt(2, 11);
//			pstmt.setInt(3, 7700);
//			pstmt.setInt(4, 5);
//			
//			if (pstmt.executeUpdate() > 0) {
//				System.out.println("수정 성공");
//			} else {
//				System.out.println("수정 실패");
//			}
			
			//자료 삭제
			String dsql = "delete from sangdata where code = ?";
			pstmt = conn.prepareStatement(dsql);
			pstmt.setString(1, "5");
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
			
			// 전체 자료 읽기
			String sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql); // 선처리 방식
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " "
						+ rs.getString("dan"));
			}
			
			System.out.println();
			// 부분 자료 읽기
			String co = "3";
//			sql = "select * from sangdata where code = " + co; // 문자열 더하기 : secure 가이드에 위배됨
			sql = "select * from sangdata where code = ?"; // ? 연산자 사용 
			pstmt = conn.prepareStatement(sql); // 선처리 방식
			pstmt.setString(1, co); // 첫번째 ?에 co 변수값 mapping
			
			rs = pstmt.executeQuery();
			// re.next();는 읽을 값이 있으면 true 없으면 false, 하나는 while문 돌릴필요 없다. 
			// 하나면 re.next 사용하면 되는데 이렇게 하면 9번처럼 데이터가 없으면 강제적으로 종료한다. 그래서 if 문을 쓴다.
			if (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " "
						+ rs.getString("dan"));
			}
			
			System.out.println("읽기 완료");
		} catch (Exception e) {
			System.out.println("dbProcess err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {

			}
		}
	}

	public static void main(String[] args) {
		DbTest4Prepare obj = new DbTest4Prepare();
		obj.dbProcess();
	}
}
