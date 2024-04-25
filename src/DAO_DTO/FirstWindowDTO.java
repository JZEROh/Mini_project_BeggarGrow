package DAO_DTO;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FirstWindowDTO extends JFrame {
	
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton loginButton;
	//필드
	private String id;
	private String pw;
	public String saveID;
	boolean visible = true;
	
	public JTextField getIdField() {
		return idField;
	}
	public void setIdField(JTextField idField) {
		this.idField = idField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	public JButton getRegisterButton() {
		return registerButton;
	}
	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}
	public JButton getLoginButton() {
		return loginButton;
	}
	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSaveID() {
		return saveID;
	}
	public void setSaveID(String saveID) {
		this.saveID = saveID;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
