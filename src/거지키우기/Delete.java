package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public void delete(String id ,String pw) {PreparedStatement psmt = null;
	PreparedStatement psmt2 = null;
	Connection conn = null;

	try {
	    // JDBC 드라이버 로딩
	    Class.forName("oracle.jdbc.driver.OracleDriver");

	    // 데이터베이스 연결 정보 설정
	    String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
	    String user = "campus_24SW_FS_p1_7";
	    String password = "smhrd7";

	    // 데이터베이스 연결
	    conn = DriverManager.getConnection(url, user, password);

	    // 첫 번째 PreparedStatement: 거지키우기 테이블에서 해당 ID와 PW를 가진 행 삭제
	    String sql = "DELETE FROM 거지키우기 WHERE ID = ? AND PW = ?";
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, id);
	    psmt.setString(2, pw);
	    int row1 = psmt.executeUpdate();

	    // 두 번째 PreparedStatement: 거지정보 테이블에서 해당 ID를 가진 행 삭제
	    String sql2 = "DELETE FROM 거지정보 WHERE ID = ?";
	    psmt2 = conn.prepareStatement(sql2);
	    psmt2.setString(1, id);
	    int row2 = psmt2.executeUpdate();

	    // 결과 확인
	    if (row1 > 0 && row2 > 0) {
	        System.out.println("데이터 삭제 성공");
	    } else {
	        System.out.println("데이터 삭제 실패");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
	        // 리소스 해제
	        if (psmt != null) 
	            psmt.close();
	        if (psmt2 != null) 
	            psmt2.close();
	        if (conn != null) 
	            conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
}
