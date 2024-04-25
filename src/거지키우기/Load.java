package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Load {
	public void load(String id) {
		ResultSet rs =null;
		PreparedStatement psmt =null;
		Connection conn =null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user="campus_24SW_FS_p1_7";
			String password1 = "smhrd7";
			conn = DriverManager.getConnection(url,user,password1);
			String sql ="SELECT * FROM 거지키우기 WHERE ID=?";
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			Game_Window gw = new Game_Window();
			rs.next();
			gw.setWallet(rs.getInt("WALLET"));
			gw.setUpgrade_Status(rs.getInt("UPGRADE_STATUS"));
			gw.setUpgrade_cost(rs.getInt("UPGRADE_COST"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
