package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Load {
	private String id;
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
			String sql ="SELECT * FROM 거지정보 WHERE ID=?";
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			rs.next();
			//로그인 시 불러오며 게임창 실행
			Game_Window gw = new Game_Window();
			gw.Game_WindowMethod();
			gw.setID(id);
			// 불러오기 위한 값
			gw.setWallet(rs.getInt("WALLET"));
			gw.setUpgrade_Status(rs.getInt("UPGRADE_STATUS"));
			gw.setUpgrade_cost(rs.getInt("UPGRADE_COST"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
