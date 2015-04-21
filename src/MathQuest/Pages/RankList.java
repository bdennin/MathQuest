package MathQuest.Pages;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import MathQuest.MathQuest;
import MathQuest.Database.Database;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankList extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTable rankTable;
	private DefaultTableModel qtm;
	public RankList(){
		final String[] string ={"Name", "Correctly Asnwered", "Incorrectly Asnwered","Accuracy"};
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		Database.getConnected();
		
		JLabel lblTitle = new JLabel("Students' Performance");
		lblTitle.setFont(new Font("Simplified Arabic", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(119, 60, 786, 99);
		add(lblTitle);
		
		rankTable = new JTable();
		String[][] selected = Database.getRank();

		qtm = new DefaultTableModel(selected,string);
		rankTable.setModel(qtm);
		JTableHeader header = rankTable.getTableHeader();
		header.setBackground(Color.lightGray);
		
		JScrollPane pane = new JScrollPane(rankTable);
		pane.setBounds(226, 177, 571, 427);
		pane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		
		add(pane);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.close();
				MathQuest.switchToAdminMain();
			}
		});
		btnNewButton.setBounds(679, 637, 93, 23);
		add(btnNewButton);
	}
}
