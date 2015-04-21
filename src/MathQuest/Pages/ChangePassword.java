package MathQuest.Pages;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
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
import java.util.Timer;
import java.util.TimerTask;

public class ChangePassword extends Area {

	private static final long serialVersionUID = 1L;
	private JPasswordField newpassword;
	private JPasswordField oldpass;
	final JLabel errorLabel;
	final JLabel successLabel;
	private JPasswordField passwordField;
	private JButton btnGoBack;

	public ChangePassword() {
		super(null);
		this.setBounds(0, 0, 1024, 768);
		this.loadImages();
		this.setLayout(null);
		final Timer timer = new Timer();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(341, 424, 342, 211);
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		add(panel);

		JLabel lblUsername = new JLabel("Old Password:");
		lblUsername.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblUsername.setBounds(27, 33, 143, 16);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("New Password:");
		lblPassword.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblPassword.setBounds(27, 72, 143, 16);
		panel.add(lblPassword);

		oldpass = new JPasswordField();
		oldpass.setBounds(180, 27, 134, 28);
		oldpass.setColumns(10);
		panel.add(oldpass);

		newpassword = new JPasswordField(10);
		newpassword.setBounds(180, 66, 134, 28);
		panel.add(newpassword);

		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		errorLabel.setBounds(27, 180, 287, 16);
		errorLabel.setForeground(Color.RED);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(errorLabel);

		successLabel = new JLabel();
		successLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		successLabel.setBounds(27, 180, 287, 16);
		successLabel.setForeground(Color.GREEN);
		successLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(successLabel);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnSave.setBounds(180, 144, 134, 28);
		MathQuest.getOuterFrame().getRootPane().setDefaultButton(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MathQuest.connectToDatabase){
					String newPass = newpassword.getText();
					String confirmPass = passwordField.getText();
					String oldPass = oldpass.getText();
					if(newPass.equals(oldPass)){
						errorLabel.setText("New password must be unique");
					}
					else{
						if(newPass.equals(confirmPass)){
							Database.getConnected();
							if (Database.changePassword(oldPass, newPass)){
								Database.close();
								successLabel.setText("Successfully saveed! Returning to world.");
								timer.schedule(new TimerTask() {
									@Override
									public void run() {
										MathQuest.switchToGameWorld();
									}
								}, 1500);
							}
							else
								errorLabel.setText("Wrong old password");
						}
						else
							errorLabel.setText("New password does not match");
					}
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							errorLabel.setText(null);
						}
					}, 1500);
				}
				else
					errorLabel.setText("Database is not connected");
			}
		});
		panel.add(btnSave);

		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblConfirmPassword.setBounds(27, 111, 143, 16);
		panel.add(lblConfirmPassword);

		passwordField = new JPasswordField(10);
		passwordField.setBounds(180, 105, 134, 28);
		panel.add(passwordField);

		btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnGoBack.setBounds(27, 144, 134, 28);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.close();
				MathQuest.switchToGameWorld();
			}
		});
		panel.add(btnGoBack);

		this.renderBackground();

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
