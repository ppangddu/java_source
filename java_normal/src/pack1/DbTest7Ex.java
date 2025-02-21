package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DbTest7Ex {
	/*
	 * 문제) 키보드로 특정 직원의 번호와 이름을 입력한다. 해당 직원이 jikwon 테이블에 없으면 "작업 종료" 메세지와 함께 프로그램 종료.
	 * 예 : 이순신과 같은 부서에 근무하는 직원과 해당 직원이 관리하는 고객 출력 --- 출력 형태 ------------------ 
	 * 직원명 부서명 근무지역 직급 고객명 고객전화 고객나이 한송이 총무부 서울 사원 천송이 333-7788 29 ... 총무부 연봉 평균 : ***
	 * (소수 첫째자리에서 반올림)
	 */
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public DbTest7Ex() {
		dbLoad();
		showData();
	}

	private void dbLoad() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("loading fail: " + e);
			System.exit(0);
		}
	}

	private void showData() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.28:3306/test", "root", "1234");
			System.out.println("직원 번호 입력 : ");
			int jikwonNumber = scanner.nextInt();
			System.out.println("직원 이름 입력 : ");
			String jikwonName = scanner.next();

			// 수정된 SQL 쿼리
			String sql = "select jikwon.jikwonname, buser.busername, buser.buserloc, jikwon.jikwonjik, "
				       + "gogek.gogekname, gogek.gogektel, gogek.gogekjumin "
				       + "from jikwon "
				       + "join buser on jikwon.busernum = buser.buserno "
				       + "join gogek on jikwon.jikwonno = gogek.gogekdamsano "
				       + "where buser.buserloc = (select buser.buserloc from jikwon "
				       + "join buser on jikwon.busernum = buser.buserno "
				       + "where jikwon.jikwonno = ? and jikwon.jikwonname = ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jikwonNumber);  // 직원 번호 바인딩
			pstmt.setString(2, jikwonName); // 직원 이름 바인딩
			
			rs = pstmt.executeQuery();
			
			// 결과 출력
			System.out.println("직원명 부서명 근무지역 직급 고객명 고객전화 고객나이");
			boolean found = false;
			while (rs.next()) {
				System.out.println(rs.getString("jikwonname") + " " 
						+ rs.getString("busername") + " " 
						+ rs.getString("buserloc") + " "
						+ rs.getString("jikwonjik") + " "
						+ rs.getString("gogekname") + " "
						+ rs.getString("gogektel") + " "
						+ rs.getString("gogekjumin"));
				found = true;
			}

			if (!found) {
				System.out.println("해당 직원이 존재하지 않거나 같은 부서에 직원이 없습니다. 작업 종료.");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("showData err : " + e);
			System.exit(0);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DbTest7Ex();
	}
}
