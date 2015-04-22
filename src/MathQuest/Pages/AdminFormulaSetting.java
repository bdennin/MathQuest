package MathQuest.Pages;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.Logic.Equation.*;

import java.lang.Character;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;


public class AdminFormulaSetting extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField monsterLevel;
	private DefaultTableModel qtm;
	private JTable currentSettingTable;
	public AdminFormulaSetting (int Id) {

		final Timer timer = new Timer();
		final String[] string ={"Sign","Digits","Terms"};

		Database.getConnected();

		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);

		JPanel EquationSettingPanel = new JPanel();
		EquationSettingPanel.setLayout(null);
		EquationSettingPanel.setBounds(331, 253, 462, 381);
		add(EquationSettingPanel);

		final JLabel successLabel = new JLabel();
		successLabel.setForeground(Color.GREEN);
		successLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		successLabel.setBounds(183, 140, 657, 29);
		successLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(successLabel);
		
		final JLabel errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		errorLabel.setBounds(105, 140, 814, 29);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(errorLabel);

		JLabel lblNewLabel = new JLabel("Signs");
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(22, 80, 130, 36);
		EquationSettingPanel.add(lblNewLabel);

		JLabel lblDigits = new JLabel("Digits");
		lblDigits.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblDigits.setHorizontalAlignment(SwingConstants.LEFT);
		lblDigits.setBounds(22, 150, 130, 36);
		EquationSettingPanel.add(lblDigits);

		JLabel lblTerms = new JLabel("Terms");
		lblTerms.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblTerms.setHorizontalAlignment(SwingConstants.LEFT);
		lblTerms.setBounds(22, 220, 130, 36);
		EquationSettingPanel.add(lblTerms);

		JLabel lblMonsterLevel = new JLabel("Monster Level");
		lblMonsterLevel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblMonsterLevel.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonsterLevel.setBounds(22, 10, 130, 36);
		EquationSettingPanel.add(lblMonsterLevel);

		final JComboBox<Sign> signs = new JComboBox<Sign>(Sign.values());
		signs.setBounds(170, 80, 101, 28);
		signs.setSelectedItem(null);
		EquationSettingPanel.add(signs);

		final JComboBox<Digits> digits = new JComboBox<Digits>(Digits.values());
		digits.setBounds(170, 150, 101, 28);
		digits.setSelectedItem(null);
		EquationSettingPanel.add(digits);

		final JComboBox<Terms> terms = new JComboBox<Terms>(Terms.values());
		terms.setBounds(170, 220, 101, 28);
		terms.setSelectedItem(null);
		EquationSettingPanel.add(terms);


		monsterLevel = new JTextField();
		monsterLevel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c)) && (e.getKeyCode() != e.VK_BACK_SPACE) && (e.getKeyCode() != e.VK_DELETE)){
					getToolkit().beep();
					e.consume();	
				}
			}
		});

		monsterLevel.getDocument().addDocumentListener(new DocumentListener()
		{
			int record = 0;
			public void changedUpdate(DocumentEvent e) { textChanged(e); }
			public void insertUpdate(DocumentEvent e) { textChanged(e); }
			public void removeUpdate(DocumentEvent e) { 
				errorLabel.setText(null);
				if (!(monsterLevel.getText().isEmpty()))
					record = Integer.parseInt(monsterLevel.getText());
				else 
					record = 0;
			}
			public void textChanged(DocumentEvent e)
			{

				int temp = Integer.parseInt(monsterLevel.getText());
				if (temp <= 32 && temp >= 0){
					if (record < temp)
						record = temp;

					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							String[][] selected = Database.getFormula(record);
							qtm = new DefaultTableModel(selected,string);
							currentSettingTable.setModel(qtm);
						}
					}, 1500);
				}
				else
					errorLabel.setText("Invalid monster level. Monster level should smaller than 32 and bigger than 0.");
			}
		});
		monsterLevel.setBounds(170, 13, 101, 28);
		monsterLevel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		EquationSettingPanel.add(monsterLevel);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign selectedSign = (Sign)signs.getSelectedItem();
				Digits selectedDigit = (Digits)digits.getSelectedItem();
				Terms selectedTerm = (Terms)terms.getSelectedItem();
				boolean res = Database.setFormula(Integer.parseInt(monsterLevel.getText()), selectedSign, selectedDigit, selectedTerm);
				if (res){
					successLabel.setText("Successfully save to database!");

					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							successLabel.setText(null);
						}
					}, 1500);
				}
				else
					errorLabel.setText("Cannot save to database");
			}
		}
				);
		btnSave.setBounds(339, 298, 93, 23);
		EquationSettingPanel.add(btnSave);

		JButton btnCancel = new JButton("Go Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.close();
				MathQuest.switchToAdminMain();
			}
		});
		btnCancel.setBounds(222, 298, 93, 23);
		EquationSettingPanel.add(btnCancel);

		JLabel lblTitle = new JLabel("Formula Setting");
		lblTitle.setFont(new Font("Simplified Arabic", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(119, 60, 786, 99);
		add(lblTitle);

		JPanel currentSettingPanel = new JPanel();
		currentSettingPanel.setBounds(331, 179, 432, 64);
		currentSettingPanel.setLayout(null);
		add(currentSettingPanel);
		/*
		currentSettingTable = new JTable();
		currentSettingTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		currentSettingTable.setBounds(178, 35, 159, 14);
		currentSettingPanel.add(currentSettingTable); 

		JLabel lblNewLabel_1 = new JLabel("Sign  |Digit |Term");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(178, 11, 159, 25);
		currentSettingPanel.add(lblNewLabel_1);
		 */
		currentSettingTable = new JTable();

		JTableHeader header = currentSettingTable.getTableHeader();
		header.setBackground(Color.lightGray);

		JScrollPane pane = new JScrollPane(currentSettingTable);
		pane.setBounds(170, 10, 167, 46);
		pane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		currentSettingPanel.add(pane);

		JLabel lblCurrentSettings = new JLabel("Current Settings");
		lblCurrentSettings.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblCurrentSettings.setBounds(15, 25, 160, 24);
		currentSettingPanel.add(lblCurrentSettings);







	}
}