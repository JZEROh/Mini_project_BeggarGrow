package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Join {
	public void joinmess(String id,String password) {

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
			String sql ="INSERT INTO 거지키우기 VALUES(?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			row =psmt.executeUpdate();
			String sql2 ="INSERT INTO 거지정보 VALUES(?,0,1,10)";
			psmt2=conn.prepareStatement(sql2);
			psmt2.setString(1, id);
			row2 =psmt2.executeUpdate();
			if(row>0 || row2>0) {
				System.out.println("성공");
			}
			else {
				System.out.println("빈칸은 입력할 수 없어용 ㅠㅠ");

				
			}
			
		}catch (Exception e) {
			System.out.println("아이디가 이미 있는디용?");
		}finally {
			try {
				if(psmt!=null) 
					psmt.close();
				if(psmt2!=null) 
					psmt2.close();
				if(conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

}
