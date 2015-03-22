package MathQuest.Pages;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.Logic.Equation.*;

import java.lang.Character;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;

import javax.swing.text.Document;
import javax.swing.border.LineBorder;


public class AdminFormularSetting extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField monsterLevel;
	private Vector cache;
	private DefaultTableModel qtm;
	private JTable table_1;
	private JTable table;
	private JTable table_2;
	public AdminFormularSetting (int Id) {
		
		final Timer timer = new Timer();
		final Vector headers = new Vector();
		final String[] string ={"Sign","Digits","Terms"};
		
		Database.getConnected();
		
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);

		JPanel EquationSettingPanel = new JPanel();
		EquationSettingPanel.setLayout(null);
		EquationSettingPanel.setBounds(331, 253, 462, 418);
		add(EquationSettingPanel);
		
		final JLabel successLabel = new JLabel();
		successLabel.setForeground(Color.GREEN);
		successLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		successLabel.setBounds(367, 140, 280, 29);
		add(successLabel);
		
		final JLabel errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		errorLabel.setBounds(314, 140, 491, 29);
		add(errorLabel);
		
		JLabel lblNewLabel = new JLabel("Signs");
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(22, 117, 130, 36);
		EquationSettingPanel.add(lblNewLabel);
		
		JLabel lblDigits = new JLabel("Digits");
		lblDigits.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblDigits.setHorizontalAlignment(SwingConstants.LEFT);
		lblDigits.setBounds(22, 187, 130, 36);
		EquationSettingPanel.add(lblDigits);
		
		JLabel lblTerms = new JLabel("Terms");
		lblTerms.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblTerms.setHorizontalAlignment(SwingConstants.LEFT);
		lblTerms.setBounds(22, 257, 130, 36);
		EquationSettingPanel.add(lblTerms);
		
		JLabel lblMonsterLevel = new JLabel("Monster Level");
		lblMonsterLevel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblMonsterLevel.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonsterLevel.setBounds(22, 47, 130, 36);
		EquationSettingPanel.add(lblMonsterLevel);

		final JComboBox<Sign> signs = new JComboBox<Sign>(Sign.values());
		signs.setBounds(163, 120, 101, 28);
		EquationSettingPanel.add(signs);
		
		final JComboBox<Digits> digits = new JComboBox<Digits>(Digits.values());
		digits.setBounds(163, 190, 101, 28);
		EquationSettingPanel.add(digits);

		final JComboBox<Terms> terms = new JComboBox<Terms>(Terms.values());
		terms.setBounds(163, 260, 101, 28);
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
	    	   successLabel.setText(null);
	    	   errorLabel.setText(null);
	    	   if (!(monsterLevel.getText().isEmpty()))
	    		  record = Integer.parseInt(monsterLevel.getText());
	    	   else 
	    		   record = 0;
	       }
	       public void textChanged(DocumentEvent e)
	       {
	    
	    	   int temp = Integer.parseInt(monsterLevel.getText());
	    	   if (temp <= 20 && temp >= 0){
	    	   if (record < temp)
	    		   record = temp;
	    	   
	    	   timer.schedule(new TimerTask() {
	    		   @Override
	    		   public void run() {
	    			   String[][] selected = Database.getFormular(Database.getId(), record);
	    			   qtm = new DefaultTableModel(selected,string);
	    			   table.setModel(qtm);
	    			   }
	    		 }, 1500);
	    	   }
	         else
	        	 errorLabel.setText("Invalid monster level. Monster level should smaller than 20 and bigger than 0.");
	       }
	     });
		monsterLevel.setBounds(163, 50, 101, 28);
		EquationSettingPanel.add(monsterLevel);
				
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sign selectedSign = (Sign)signs.getSelectedItem();
					Digits selectedDigit = (Digits)digits.getSelectedItem();
					Terms selectedTerm = (Terms)terms.getSelectedItem();
					boolean res = Database.setFormular(Integer.parseInt(monsterLevel.getText()), selectedSign, selectedDigit, selectedTerm);
					if (res){
						successLabel.setText("Successfully save to database!");
					}
					else
						errorLabel.setText("Cannot save to database");
			}
		}
		);
		btnSave.setBounds(339, 335, 93, 23);
		EquationSettingPanel.add(btnSave);
		
		JButton btnCancel = new JButton("Go Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.close();
				MathQuest.switchToAdminMain();
			}
		});
		btnCancel.setBounds(222, 335, 93, 23);
		EquationSettingPanel.add(btnCancel);
		
		JLabel lblFormula = new JLabel("Formular Setting");
		lblFormula.setFont(new Font("Simplified Arabic", Font.BOLD, 40));
		lblFormula.setBounds(55, 56, 294, 74);
		add(lblFormula);
		
		JPanel currentSettingPanel = new JPanel();
		currentSettingPanel.setBounds(331, 179, 347, 64);
		currentSettingPanel.setLayout(null);
		add(currentSettingPanel);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(178, 35, 159, 14);
		currentSettingPanel.add(table); 
		
		JLabel lblNewLabel_1 = new JLabel("Sign  |Digit |Term");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(178, 11, 159, 25);
		currentSettingPanel.add(lblNewLabel_1);
		
		JLabel lblCurrentSettings = new JLabel("Current Settings:");
		lblCurrentSettings.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblCurrentSettings.setBounds(29, 30, 144, 24);
		currentSettingPanel.add(lblCurrentSettings);
		
		
		
		
		
		
				
	}
}