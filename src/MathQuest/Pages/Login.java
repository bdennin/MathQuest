package MathQuest.Pages;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login extends Area {

	private static final long serialVersionUID = 1L;
	private JPasswordField password;
	private JTextField username;
	final JLabel errorLabel;
	private static Character hero = new Character();
	public Login() {
		super(null);
		this.setBounds(0, 0, 1024, 768);
		this.loadImages();
		this.setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(367, 565, 289, 170);
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		add(panel);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblUsername.setBounds(27, 33, 80, 16);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblPassword.setBounds(27, 72, 80, 16);
		panel.add(lblPassword);

		username = new JTextField();
		username.setBounds(128, 27, 134, 28);
		username.setColumns(10);
		panel.add(username);

		password = new JPasswordField(10);
		password.setBounds(128, 66, 134, 28);
		panel.add(password);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnLogin.setBounds(128, 105, 134, 28);
		MathQuest.getOuterFrame().getRootPane().setDefaultButton(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		panel.add(btnLogin);
		
				errorLabel = new JLabel();
				errorLabel.setBounds(37, 143, 215, 16);
				panel.add(errorLabel);
				errorLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
				errorLabel.setForeground(Color.RED);
		
		this.renderBackground();

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

	@Override
	public OptionsPanel loadOptionsPanel() {
		return null;
	}

	@Override
	public void loadImages() {			
		this.background = new ImageIcon(MathQuest.class.getResource("Files/login.png"));
	}
}
