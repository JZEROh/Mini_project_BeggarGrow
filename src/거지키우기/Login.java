package 거지키우기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	public void login(String id,String pw) {
		ResultSet rs =null;
		PreparedStatement psmt =null;
		Connection conn =null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user="campus_24SW_FS_p1_7";
			String password1 = "smhrd7";
			conn = DriverManager.getConnection(url,user,password1);
			String sql ="SELECT * FROM 거지키우기 WHERE ID=? AND PW=?";
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				String uName=rs.getString("id");
				System.out.println(uName+"님 환영합니다~");
			}else {
				System.out.println("로그인이 실패했습니다");
				System.out.println("아이디나 비밀번호 다시 확인해보세요");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
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
