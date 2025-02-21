package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// 키보드로 반복해서 sangdata 테이블의 자료 검색
// 입력이 끝나면 자료 전체 출력

public class DbTest5Insert {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public DbTest5Insert() { // 생성자에서 하지 않고 별도의 메서드를 만들고 불러주는 작업을 권장함
		dbLoad();
		insertData();
		// 다른 거 하다가 showData()갈 수 있음. 그래서 DB를 필요할 때만 사용
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

	// insert, update, select를 각각의 메서드에서 별도로 진행할 때는
	// 메서드 별로 db를 연결한 후 처리가 끝나면 닫아준다.
	private void insertData() {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.28:3306/test", "root", "1234");

			// 입력 반복
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("코드 입력 : ");
				String code = scanner.next();
				System.out.println("상품명 입력 : ");
				String sang = scanner.next();
				System.out.println("수량 입력 : ");
				String su = scanner.next();
				System.out.println("단가 입력 : ");
				String dan = scanner.next();

				// 입력 자료 오류 검사 생략
				pstmt = conn.prepareStatement("insert into sangdata values(?,?,?,?)");
				pstmt.setString(1, code);
				pstmt.setString(2, sang);
				pstmt.setString(3, su);
				pstmt.setString(4, dan);
				pstmt.executeUpdate(); // 추가됨

				System.out.println("계속할까요? (y/n)");
				String yn = scanner.next();
				if (yn.equals("n"))
					break;
			}
			scanner.close();

		} catch (Exception e) {
			System.out.println("insertData err: " + e);
			System.exit(0);
		} finally { // 연결 후 끝나면 닫기
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {

			}
		}
	}

	private void showData() {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.28:3306/test", "root", "1234"); // 필요할 때만 DB랑 붙는다.
			
			pstmt = conn.prepareStatement("select * from sangdata");
			rs = pstmt.executeQuery();
			int cou = 0;
			
			while(rs.next()) {
					System.out.println(rs.getString("code") + " " + 
					rs.getString("sang") + " " + rs.getString("su")+ " " +
					rs.getString("dan"));
				
				cou++;
			}
			System.out.println("전체 건수 : " + cou);
			
			
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
		new DbTest5Insert();
	}

}
