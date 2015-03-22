package MathQuest.Pages;

import javax.swing.*;

import MathQuest.MathQuest;
import MathQuest.Database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMain extends JPanel{
	private static final long serialVersionUID = 1L;

	public AdminMain () {
		
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(375, 228, 274, 286);
		add(panel);
		
		JButton btnSave = new JButton("Formular Setting");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MathQuest.switchToAdminFomularSetting(Database.getId());
			}
		});
		btnSave.setBounds(49, 75, 176, 31);
		panel.add(btnSave);
		
		JButton btnCheckStudentsStatues = new JButton("Check Students Statues");
		btnCheckStudentsStatues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckStudentsStatues.setBounds(49, 164, 176, 31);
		panel.add(btnCheckStudentsStatues);
	}
}
