package MathQuest.Pages;

import java.awt.Color;

import javax.swing.JPanel;

import MathQuest.Logic.Character;
import javax.swing.JLabel;

public class ChangePassword extends JPanel{
	private static final long serialVersionUID = 1L;
	public ChangePassword() {
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(414, 242, 420, 334);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
	}
}
