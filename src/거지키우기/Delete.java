package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public void delete(String id ,String pw) {

		PreparedStatement psmt=null;
		PreparedStatement psmt2=null;
		Connection conn=null;
		int row =0;
		int row2 =0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_24SW_FS_p1_7";
			String password1 = "smhrd7";
			
			DriverManager.getConnection(url, user, password1);
			
			conn = DriverManager.getConnection(url,user,password1);
			String sql2 ="DELETE FROM 거지정보 WHERE ID =?";
			psmt2=conn.prepareStatement(sql2);
			psmt2.setString(1, id);
			row2 =psmt2.executeUpdate();
			String sql ="DELETE FROM 거지키우기 WHERE ID =? AND PW=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			row =psmt.executeUpdate();
			if(row>0 && row>0) {
				System.out.println("성공");
			}
			else {
				System.out.println("실패");
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) 
					psmt.close();
				if(psmt!=null) 
					psmt2.close();
				if(conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
