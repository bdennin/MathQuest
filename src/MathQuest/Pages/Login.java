package MathQuest.Pages;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.Logic.Character;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField password;
	private JTextField username;
	final JLabel errorLabel;
	public Login() {
		this.setBounds(0, 0, 1024, 768);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(342, 286, 377, 207);
		add(panel);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblUsername.setBounds(27, 59, 80, 16);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblPassword.setBounds(27, 91, 80, 16);
		panel.add(lblPassword);

		username = new JTextField();
		username.setBounds(108, 53, 134, 28);
		panel.add(username);
		username.setColumns(10);

		password = new JPasswordField(10);
		password.setBounds(108, 85, 134, 28);
		panel.add(password);

		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		errorLabel.setBounds(87, 161, 215, 16);
		errorLabel.setForeground(Color.RED);
		panel.add(errorLabel);

		JButton btnLogin = new JButton("Login");
		MathQuest.getOuterFrame().getRootPane().setDefaultButton(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(108, 123, 134, 28);
		panel.add(btnLogin);

		JLabel lblWelcomToMathquest = new JLabel("Welcome to MathQuest");
		lblWelcomToMathquest.setFont(new Font("Simplified Arabic", Font.BOLD, 55));
		lblWelcomToMathquest.setForeground(Color.DARK_GRAY);
		lblWelcomToMathquest.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMathquest.setBounds(75, 106, 873, 144);
		add(lblWelcomToMathquest);

	}

	public void login(){
		@SuppressWarnings("deprecation")
		boolean isSuccessfulLogin = Login.verifyCredentials(username.getText(), password.getText());

		if(isSuccessfulLogin) {
			if (MathQuest.connectToDatabase){
				Database.close();
				String type = Database.getType();
				if (type.equals("student")){
					MathQuest.setCharacter(new Character(Database.getStats(),Database.getInventory()));
					MathQuest.switchToGameWorld();
					/*
     MathQuest.setUsername(username.getText());
     MathQuest.setPassword(password.getText());
					 */
				}
				else{
					MathQuest.switchToAdminMain();
				}
			}
			else{
				MathQuest.setCharacter(new Character());
				MathQuest.switchToGameWorld();
			}
		}
		else {
			errorLabel.setText("Invalid username/password.");
		}
	}
	public static boolean verifyCredentials(String username, String password) {
		boolean outcome;
		if(username.isEmpty() || password.isEmpty())
			outcome = false;
		else {
			if (MathQuest.connectToDatabase){
				Database.getConnected();
				outcome = Database.isValid(username, password);
			}
			else
				outcome = true;
		}
		return outcome;
	}
}
