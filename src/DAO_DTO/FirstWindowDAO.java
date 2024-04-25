package DAO_DTO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import 거지키우기.Login;
import 거지키우기.RegisterForm;
import 아스키아트.GameName;

public class FirstWindowDAO extends JFrame {
	FirstWindowDTO dto = new FirstWindowDTO();

	// 함수
	public void first_windowMethod() {
		dto.setTitle("거지키우기_로그인");
		dto.setSize(600, 300);
		dto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));
		// 아이디 입력
		JLabel idLabel = new JLabel("ID:");
		dto.setIdField(new JTextField());
		// 비번 입력
		JLabel passwordLabel = new JLabel("Password:");
		dto.setPasswordField(new JPasswordField());
		// 로그인 버튼 추가
		dto.setLoginButton(new JButton("SIGN_IN"));
		// 회원가입 버튼 추가
		dto.setRegisterButton(new JButton("SIGN_UP"));

		// 패널에 컴포넌트 추가
		panel.add(idLabel);
		panel.add(dto.getIdField());
		panel.add(passwordLabel);
		panel.add(dto.getPasswordField());
		panel.add(dto.getLoginButton());
		panel.add(dto.getRegisterButton());

		// 게임 인트로 부분 아스키 아트
		GameName gn = new GameName();
		gn.GameName();

		// 버튼 누를 시 상호작용 구현
		// 회원가입 버튼 -> 패널 넘어가기
		dto.getRegisterButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// id필드에 입력한 값 받
				RegisterForm rs = new RegisterForm();
				dispose();
			}
		});
		// 로그인 버튼 -> 입력한 id랑 pw 값 반환 -> 반환받은 값으로 데베랑 비교
		dto.getLoginButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dto.setId(dto.getIdField().getText());
				char[] passwordChars = dto.getPasswordField().getPassword();
				dto.setPw(new String(passwordChars));

				System.out.println(dto.getId());
				System.out.println(dto.getPw());
				// 로그인 메서드
				Login log = new Login();
				log.login(dto.getId(), dto.getPw());
				dispose();
				// Game_Window 메서드 실행

			}
		});

		// 패널 프레임에 추가, 화면에 표시
		setLocationRelativeTo(null); // 화면 가운데로 띄우기
		add(panel);
		setVisible(dto.visible);
	}
}
