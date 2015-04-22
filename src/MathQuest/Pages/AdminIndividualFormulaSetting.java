package MathQuest.Pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.Logic.DropdownElement;
import MathQuest.Logic.Equation.*;

public class AdminIndividualFormulaSetting extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField monsterLevel;
	private DefaultTableModel qtm;
	private JTable currentSettingTable;
	private int selectedID = 0;
	private int selectedLevel = 0;
	public AdminIndividualFormulaSetting () {
		
		final Timer timer = new Timer();
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
		successLabel.setBounds(183, 140, 657, 29);
		successLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(successLabel);
		
		final JLabel errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		errorLabel.setBounds(105, 140, 814, 29);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(errorLabel);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudent.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblStudent.setBounds(51, 12, 102, 36);
		EquationSettingPanel.add(lblStudent);
		
		JLabel lblMonsterLevel = new JLabel("Level");
		lblMonsterLevel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblMonsterLevel.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonsterLevel.setBounds(70, 82, 102, 36);
		EquationSettingPanel.add(lblMonsterLevel);
		
		JLabel lblNewLabel = new JLabel("Signs");
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(70, 152, 102, 36);
		EquationSettingPanel.add(lblNewLabel);
		
		JLabel lblDigits = new JLabel("Digits");
		lblDigits.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblDigits.setHorizontalAlignment(SwingConstants.LEFT);
		lblDigits.setBounds(70, 222, 102, 36);
		EquationSettingPanel.add(lblDigits);
		
		JLabel lblTerms = new JLabel("Terms");
		lblTerms.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblTerms.setHorizontalAlignment(SwingConstants.LEFT);
		lblTerms.setBounds(70, 292, 102, 36);
		EquationSettingPanel.add(lblTerms);
		
		final JComboBox<DropdownElement> student = new JComboBox<DropdownElement>(Database.getNames()); 
		student.setBounds(178, 14, 120, 28);
		student.setSelectedItem(null);
		EquationSettingPanel.add(student);
		
		final JComboBox<Sign> signs = new JComboBox<Sign>(Sign.values());
		signs.setBounds(178, 154, 101, 28);
		signs.setSelectedItem(null);
		EquationSettingPanel.add(signs);
		
		final JComboBox<Digits> digits = new JComboBox<Digits>(Digits.values());
		digits.setBounds(178, 224, 101, 28);
		digits.setSelectedItem(null);
		EquationSettingPanel.add(digits);

		final JComboBox<Terms> terms = new JComboBox<Terms>(Terms.values());
		terms.setBounds(178, 294, 101, 28);
		terms.setSelectedItem(null);
		EquationSettingPanel.add(terms);
	
		student.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 if ((e.getStateChange() == ItemEvent.ITEM_STATE_CHANGED || e.getStateChange() == ItemEvent.SELECTED )) {
					 DropdownElement selected = (DropdownElement) student.getSelectedItem();
					 selectedID = selected.getId();
					 if (selectedLevel != 0)
						 timer.schedule(new TimerTask() {
				    		   @Override
				    		   public void run() {
				    			   String[][] selected = Database.getFormula(selectedID, selectedLevel);
				    			   qtm = new DefaultTableModel(selected,string);
				    			   currentSettingTable.setModel(qtm);
				    			   }
				    		 }, 1500);
					 //System.out.println(id);
				 }
			}
		});
		
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
	       public void changedUpdate(DocumentEvent e) { textChanged(e); }
	       public void insertUpdate(DocumentEvent e) { textChanged(e); }
	       public void removeUpdate(DocumentEvent e) { 
	    	   errorLabel.setText(null);
	    	   if (!(monsterLevel.getText().isEmpty()))
	    		  selectedLevel = Integer.parseInt(monsterLevel.getText());
	    	   else 
	    		   selectedLevel = 0;
	       }
	       public void textChanged(DocumentEvent e)
	       {
	    
	    	   int temp = Integer.parseInt(monsterLevel.getText());
	    	   if (temp <= 32 && temp >= 0){
	    	   if (selectedLevel < temp)
	    		   selectedLevel = temp;
	    	   if(selectedID != 0)
	    	   timer.schedule(new TimerTask() {
	    		   @Override
	    		   public void run() {
	    			   String[][] selected = Database.getFormula(selectedID, selectedLevel);
	    			   qtm = new DefaultTableModel(selected,string);
	    			   currentSettingTable.setModel(qtm);
	    			   }
	    		 }, 1500);
	    	   }
	         else
	        	 errorLabel.setText("Invalid monster level. Monster level should smaller than 32 and bigger than 0.");
	       }
	     });
		monsterLevel.setBounds(178, 85, 101, 28);
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
		btnSave.setBounds(339, 370, 93, 23);
		EquationSettingPanel.add(btnSave);
		
		JButton btnCancel = new JButton("Go Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.close();
				MathQuest.switchToAdminMain();
			}
		});
		btnCancel.setBounds(222, 370, 93, 23);
		EquationSettingPanel.add(btnCancel);
		
		JLabel lblTitle = new JLabel("Formula Setting");
		lblTitle.setFont(new Font("Simplified Arabic", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(119, 60, 786, 99);
		add(lblTitle);
		
		JPanel currentSettingPanel = new JPanel();
		currentSettingPanel.setBounds(331, 179, 347, 64);
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
		lblCurrentSettings.setBounds(10, 25, 160, 24);
		currentSettingPanel.add(lblCurrentSettings);
}
}
