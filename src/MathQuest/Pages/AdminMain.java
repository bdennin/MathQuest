package MathQuest.Pages;

import javax.swing.*;

import MathQuest.MathQuest;
import MathQuest.Database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AdminMain extends JPanel{
	private static final long serialVersionUID = 1L;

	public AdminMain () {
		
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(373, 123, 277, 496);
		add(panel);
		
		JButton btnSave = new JButton("Formula Setting (Bulk)");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MathQuest.switchToAdminFomularSetting(Database.getId());
			}
		});
		btnSave.setBounds(50, 127, 176, 31);
		panel.add(btnSave);
		
		JButton btnCheckStudentsStatues = new JButton("Check Performances");
		btnCheckStudentsStatues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToRankList();
			}
		});
		btnCheckStudentsStatues.setBounds(50, 211, 176, 31);
		panel.add(btnCheckStudentsStatues);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToLogin();
			}
		});
		btnLogOut.setBounds(50, 379, 176, 31);
		panel.add(btnLogOut);
		
		JButton btnFormularSettingindividual = new JButton("Formula Setting");
		btnFormularSettingindividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToAdminIndividualFormulaSetting();
			}
		});
		btnFormularSettingindividual.setBounds(50, 43, 176, 31);
		panel.add(btnFormularSettingindividual);
		
		JButton btnCreateAccounts = new JButton("Create Accounts");
		btnCreateAccounts.setBounds(50, 295, 176, 31);
		btnCreateAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToCreateAccounts();
			}
		});
		panel.add(btnCreateAccounts);
	}
}
