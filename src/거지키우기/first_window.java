package 거지키우기;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import 아스키아트.GameName;
import 아스키아트.Story;

public class first_window extends JFrame{
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton loginButton;
	
	//필드
	private String id;
	private String pw;
	public String saveID;
	boolean visible = true;
	
	// 함수
	public void first_windowMethod() {
		setTitle("거지키우기_로그인");
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,2));
		// 아이디 입력
		JLabel idLabel = new JLabel("ID:");
		idField = new JTextField();
		// 비번 입력
		JLabel passwordLabel = new JLabel("Password:");
		passwordField = new JPasswordField();
		//로그인 버튼 추가
		loginButton = new JButton("SIGN_IN");
		//회원가입 버튼 추가
		registerButton = new JButton("SIGN_UP");
		
		//패널에 컴포넌트 추가
		panel.add(idLabel);
		panel.add(idField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(registerButton);
		
		//게임 인트로 부분 아스키 아트
		GameName gn = new GameName();
		gn.GameName();
		
		
		//버튼 누를 시 상호작용 구현
		//회원가입 버튼 -> 패널 넘어가기
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// id필드에 입력한 값 받 
				RegisterForm rs = new RegisterForm();
				dispose();
			}
		});
		//로그인 버튼 -> 입력한 id랑 pw 값 반환 -> 반환받은 값으로 데베랑 비교
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				id = idField.getText();
				char[] passwordChars = passwordField.getPassword();
				pw = new String(passwordChars);
				
				System.out.println(id);
        		System.out.println(pw);	
        		//로그인 메서드 
        		Login log= new Login();
        		log.login(id, pw);
        		saveID = id;
        		System.out.println(saveID);
        		dispose();
        		// Game_Window 메서드 실행
        		
        		
			}
		});
		
	// 패널 프레임에 추가, 화면에 표시
		setLocationRelativeTo(null); // 화면 가운데로 띄우기
		add(panel);
		setVisible(visible);
	}
	// 아이디를 다른 클래스에서 가져가기 위한 게터 메소드
	public String getsaveID() {
		return this.saveID;
	}
	//메인 메소드
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				first_window fw = new first_window();
				fw.first_windowMethod();
			}
		});
	}
}
