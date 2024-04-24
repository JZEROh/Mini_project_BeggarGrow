package 거지키우기;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {

	private JTextField idField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton deleteButton;
	Join join =new Join();
	Delete delete =new Delete();

	// 생성자
	public RegisterForm() {
        setTitle("회원가입"); // 프레임의 제목 설정
        setSize(300, 150); // 프레임의 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 동작 설정

        JPanel panel = new JPanel(); // 패널 생성
        panel.setLayout(new GridLayout(4, 1)); // 그리드 레이아웃 설정

        // ID 입력 레이블 및 텍스트 필드 추가
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        // 비밀번호 입력 레이블 및 패스워드 필드 추가
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        // 회원가입 버튼 추가
        registerButton = new JButton("회원가입");
        deleteButton = new JButton("회원삭제");

        // 패널에 컴포넌트들 추가
        panel.add(idLabel);
        panel.add(idField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(deleteButton);

        registerButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String id = idField.getText();
        		char[] passwordChars = passwordField.getPassword();
        		String pw = new String(passwordChars);
        		
        		join.joinmess(id, pw);
        		
        	}
        	

        });
        deleteButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String id = idField.getText();
        		char[] passwordChars = passwordField.getPassword();
        		String pw = new String(passwordChars);
        		
        		
        		delete.delete(id, pw);
        		
        	}
        });
	// 패널을 프레임에 추가하고 화면에 표시
	add(panel);setVisible(true);}
	
	// 메인 메서드
	public static void main(String[] args) {
		// 이벤트 디스패치 스레드에서 UI를 생성하도록 함
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new RegisterForm(); // 회원가입 폼 생성
			}
		});
		
	}
}
