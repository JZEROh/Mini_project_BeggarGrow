package 거지키우기;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Back extends JFrame {

	private JTextField idField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton backButton; // "뒤로돌아가기" 버튼 추가

	// 생성자
	public Back() {
		setTitle("회원가입"); // 프레임의 제목 설정
		setSize(300, 200); // 프레임의 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 동작 설정

		JPanel panel = new JPanel(); // 패널 생성
		panel.setLayout(new GridLayout(5, 1)); // 그리드 레이아웃 설정

		// ID 입력 레이블 및 텍스트 필드 추가
		JLabel idLabel = new JLabel("ID:");
		idField = new JTextField();
		// 비밀번호 입력 레이블 및 패스워드 필드 추가
		JLabel passwordLabel = new JLabel("Password:");
		passwordField = new JPasswordField();
		// 회원가입 버튼 추가
		registerButton = new JButton("회원가입");
		// "뒤로돌아가기" 버튼 추가
		backButton = new JButton("뒤로돌아가기");
		
		
		
		// 패널에 컴포넌트들 추가
		panel.add(idLabel);
		panel.add(idField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(registerButton);
		panel.add(backButton); // 패널에 "뒤로돌아가기" 버튼 추가

		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				char[] passwordChars = passwordField.getPassword();
				String pw = new String(passwordChars);

				System.out.println(id);
				System.out.println(pw);

			}

		});
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// "뒤로돌아가기" 버튼 동작 정의 (예를 들어, 로그인 화면으로 이동)
				// 여기에 필요한 동작을 추가하세요
				// 예시: dispose() 메서드를 사용하여 현재 폼을 닫고, 로그인 폼을 생성하여 보여줄 수 있습니다.
				dispose();
				new RegisterForm();// 현재 폼 닫기
				// 다음은 로그인 폼을 생성하여 보여주는 예시입니다.
				// LoginForm loginForm = new LoginForm();
				// loginForm.setVisible(true);
			}
		});

		// 패널을 프레임에 추가하고 화면에 표시

		add(panel);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// 메인 메서드
	public static void main(String[] args) {
		// 이벤트 디스패치 스레드에서 UI를 생성하도록 함
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Back(); // 회원가입 폼 생성
			}
		});
		
		

	}
}
