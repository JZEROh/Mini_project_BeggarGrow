package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Money {
	public int money(String id,int money,int us,int uc) {
		PreparedStatement psmt =null;
		Connection conn =null;
		int row=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_24SW_FS_p1_7";
			String password1 = "smhrd7";
			conn = DriverManager.getConnection(url,user,password1);	
			String sql ="UPDATE 거지정보 SET WALLET=?,UPGRADE_STATUS=?,UPGRADE_COST=? WHERE ID=?";
<<<<<<< HEAD
			
=======
>>>>>>> 052cc1a0b6592e1b9008355cfd0282a307eef422
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, money);
			psmt.setInt(2, us);
			psmt.setInt(3, uc);
			psmt.setString(4,id);
<<<<<<< HEAD
			row=psmt.executeUpdate();
=======
			int row=psmt.executeUpdate();
>>>>>>> 052cc1a0b6592e1b9008355cfd0282a307eef422
			
		
		} catch (Exception e) {
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
	return row;
		
	}

}
