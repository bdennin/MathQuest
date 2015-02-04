
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;

public class LoginPage extends JPanel
{
	public LoginPage() {
		this.setLayout(new GridBagLayout());
		this.add(constructLoginPage());	
		this.setBackground(Color.black);
	}
	
	private JPanel constructLoginPage() {
		
		JPanel loginFrame = new JPanel(new BorderLayout());
		JPanel userFrame = new JPanel(new FlowLayout());
		JPanel passwordFrame = new JPanel(new FlowLayout());
		
		JButton loginButton = new JButton("Login");
		final JTextField usernameTextField = new JTextField(12);
		final JTextField passwordTextField = new JPasswordField(12);
		JLabel usernameIdentifier = new JLabel("Username");
		JLabel passwordIdentifier = new JLabel("Password:");
		
		loginButton.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean isSuccessfulLogin = LoginPage.verifyCredentials(usernameTextField.getText(), passwordTextField.getText());
					
					if(isSuccessfulLogin) {
						MathQuest.switchToGameWorld();
					}
					else {
						//throw box with error
					}
				}
			});
	
		userFrame.add(usernameIdentifier);
		userFrame.add(usernameTextField);
		userFrame.add(loginButton);
		
		passwordFrame.add(passwordIdentifier);
		passwordFrame.add(passwordTextField);
	
		loginFrame.add(userFrame, BorderLayout.LINE_START);
		loginFrame.add(passwordFrame, BorderLayout.LINE_START);
		
		return loginFrame;
	}
	
	public static boolean verifyCredentials(String username, String password) 
	{
		return true;
	}
}
