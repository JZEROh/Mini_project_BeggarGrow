package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Join {
	public void joinmess(String id,String password) {

		PreparedStatement psmt=null;
		Connection conn=null;
		int row =0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "service";
			String password1 = "12345";
			
			DriverManager.getConnection(url, user, password1);
			
			conn = DriverManager.getConnection(url,user,password1);
			String sql ="INSERT INTO 거지키우기 VALUES(?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
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
