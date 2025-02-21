package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DbTest6Ex {
//	키보드로 직급을 입력하여 해당 직급에 해당하는 직원 자료 출력
//	--- 출력 형태 ------------------
//	직원번호 직원명 부서명 직급 성별
//	... 
//	인원 수 : *
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public DbTest6Ex() { // 생성자에서 하지 않고 별도의 메서드를 만들고 불러주는 작업을 권장함
		dbLoad();
		showData();
	}

	private void dbLoad() {
		try {
			Class.forName(("org.mariadb.jdbc.Driver"));
		} catch (Exception e) {
			System.out.println("loading fail: " + e);
			System.exit(0);
		}
	}

	private void showData() {
		Scanner scanner = new Scanner(System.in);

		try {
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.28:3306/test", "root", "1234"); // 필요할 때만 DB랑
																											// 붙는다.
			System.out.println("직급 입력 : ");
			String jikwonrank = scanner.next();

			String sql = "select jikwonno, jikwonname, busername, jikwonjik, jikwongen "
					+ "from jikwon left join buser "
					+ "on busernum = buserno "
					+ "where jikwonjik = ?";
			pstmt = conn.prepareStatement(sql); // 선처리 방식
			pstmt.setString(1, jikwonrank);

			rs = pstmt.executeQuery();

			int cou = 0;
			System.out.println("직원번호 직원명 부서명 직급 성별");
			while (rs.next()) {
				System.out.println(
						rs.getString("jikwonno") + " " + rs.getString("jikwonname") + " " + rs.getString("busername")
								+ " " + rs.getString("jikwonjik") + " " + rs.getString("jikwongen"));
				cou++;
			}
			System.out.println("인원 수 : " + cou);

			System.out.println("계속할까요? (y/n)");
			String yn = scanner.next();
			if (yn.equals("n")) {
				scanner.close();
				return;
			} else {
				showData();
			}

		} catch (Exception e) {
			System.out.println("showData err: " + e);
			System.exit(0);
		} finally { // 연결 후 끝나면 닫기
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
		new DbTest6Ex();
	}

}
