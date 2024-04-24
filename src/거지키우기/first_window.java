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

public class first_window extends JFrame{
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton loginButton;
	
	//필드
	private String id;
	private String pw;
	boolean visible = true;
	
	// 생성자
	public first_window() {
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
        		dispose();
        		// Game_Window 메서드 실행
        		new Game_Window();
			}
		});
		
	// 패널 프레임에 추가, 화면에 표시
		setLocationRelativeTo(null); // 화면 가운데로 띄우기
		add(panel);
		setVisible(visible);
	}
	// 아이디를 다른 클래스에서 가져가기 위한 게터 메소드
	public String getId() {
		return id;
	}
	//메인 메소드
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new first_window(); 
			}
		});
	}
}
