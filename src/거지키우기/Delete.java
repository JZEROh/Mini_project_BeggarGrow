package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public void delete(String id ,String pw) {

		PreparedStatement psmt=null;
		Connection conn=null;
		int row =0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_24SW_FS_p1_7";
			String password1 = "smhrd7";
			
			DriverManager.getConnection(url, user, password1);
			
			conn = DriverManager.getConnection(url,user,password1);
			String sql ="DELETE FROM 거지키우기 WHERE ID =? AND PW=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			row =psmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) 
					psmt.close();
				if(conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
