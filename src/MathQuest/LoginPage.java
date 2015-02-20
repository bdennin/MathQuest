package MathQuest;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JPanel {
	
	private JPasswordField password;
	private JTextField username;

	public LoginPage() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(317, 285, 401, 166);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(35, 63, 72, 16);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 91, 61, 16);
		panel.add(lblPassword);
		
		password = new JPasswordField(10);
		password.setBounds(108, 85, 134, 28);
		panel.add(password);
		
		username = new JTextField();
		username.setBounds(108, 57, 134, 28);
		panel.add(username);
		username.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isSuccessfulLogin = LoginPage.verifyCredentials(username.getText(), password.getText());
				
				if(isSuccessfulLogin) {
					MathQuest.switchToGameWorld();
				}
				else {
					//throw box with error
				}
			}
		});
		btnLogin.setBounds(248, 57, 117, 29);
		panel.add(btnLogin);
		
	}
	
	public static boolean verifyCredentials(String username, String password) {
		return true;
	}
}
