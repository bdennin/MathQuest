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
		panel.setBounds(373, 137, 277, 448);
		add(panel);
		
		JButton btnSave = new JButton("Formular Setting (Bulk)");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MathQuest.switchToAdminFomularSetting(Database.getId());
			}
		});
		btnSave.setBounds(50, 166, 176, 31);
		panel.add(btnSave);
		
		JButton btnCheckStudentsStatues = new JButton("Check Statues");
		btnCheckStudentsStatues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckStudentsStatues.setBounds(50, 255, 176, 31);
		panel.add(btnCheckStudentsStatues);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToLogin();
			}
		});
		btnLogOut.setBounds(50, 344, 176, 31);
		panel.add(btnLogOut);
		
		JButton btnFormularSettingindividual = new JButton("Formular Setting");
		btnFormularSettingindividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFormularSettingindividual.setBounds(50, 82, 176, 31);
		panel.add(btnFormularSettingindividual);
	}
}
