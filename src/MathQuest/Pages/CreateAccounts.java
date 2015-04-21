package MathQuest.Pages;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.filechooser.*;
import javax.swing.table.DefaultTableModel;

import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.GUI.LogPanel;

public class CreateAccounts  extends JPanel implements ActionListener  {
	private static final long serialVersionUID = 1L;
	//static private final String newline = "\n";
	JFileChooser fc;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField userName;
	private JTextArea scrollText;
	private static JLabel lblsuccess2;
	private static JLabel lblerror1;
	private final Timer timer = new Timer();
	//private LogPanel combatLog;

	public CreateAccounts () {
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);

		
		
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		/*
		this.combatLog = new LogPanel("File upload");
		combatLog.addTextToScrollPane("Ready!");
		add(combatLog);
		 */
		
		JLabel lblNewLabel = new JLabel("Create Account(s)");
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(119, 60, 786, 99);
		add(lblNewLabel);
		
		scrollText = new JTextArea();
		scrollText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scrollText.setOpaque(false);
		scrollText.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		scrollText.setForeground(Color.RED);
		scrollText.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(scrollText);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(615, 399, 330, 162);
		scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(scrollPane);
		
		JButton btnNewButton = new JButton("File Upload");
		btnNewButton.setBounds(633, 316, 120, 23);
		btnNewButton.addActionListener(this);
		add(btnNewButton);

		JLabel lblor = new JLabel();
		lblor.setIcon(new ImageIcon(CreateAccounts.class.getResource("/MathQuest/Files/or.png")));
		lblor.setBounds(452, 158, 120, 360);
		add(lblor);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(154, 242, 298, 241);
		add(panel);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(36, 30, 113, 15);
		lblFirstName.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setBounds(36, 72, 96, 15);
		panel.add(lblLastName);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setBounds(36, 115, 96, 15);
		panel.add(lblUserName);

		firstName = new JTextField();
		firstName.setBounds(159, 29, 96, 21);
		panel.add(firstName);
		firstName.setColumns(10);

		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(159, 71, 96, 21);
		panel.add(lastName);

		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(159, 114, 96, 21);
		panel.add(userName);

		final JLabel lblsuccess1 = new JLabel();
		lblsuccess1.setBounds(67, 205, 188, 15);
		lblsuccess1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblsuccess1.setForeground(Color.GREEN);
		panel.add(lblsuccess1);
		
		lblerror1 = new JLabel();
		lblerror1.setBounds(67, 205, 188, 15);
		lblerror1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblerror1.setForeground(Color.RED);
		panel.add(lblerror1);

		lblsuccess2 = new JLabel();
		lblsuccess2.setBounds(605, 430, 188, 15);
		lblsuccess2.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblsuccess2.setForeground(Color.GREEN);
		add(lblsuccess2);
		
		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.setBounds(159, 163, 96, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] parameters = new String[5];
				ArrayList<String[]> account = new ArrayList<String[]>();
				parameters[0]= userName.getText();
				parameters[1]= firstName.getText();
				parameters[2]= lastName.getText();
				account.add(parameters);
				Database.getConnected();
				ArrayList<String[]> fails = Database.createAccount(account);
				Database.close();
				if(fails.size() == 0){
					lblsuccess1.setText(parameters[0] + " is created");
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							lblsuccess1.setText(null);
						}
					}, 1500);
					}
				else
					for(String[] failure : fails)
						lblerror1.setText(failure[0] + " is already existed");					
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToAdminMain();
			}
		});
		btnGoBack.setBounds(633, 352, 120, 23);
		add(btnGoBack);
		


		
	}
	public void actionPerformed(ActionEvent e) {
		int returnVal = fc.showOpenDialog(CreateAccounts.this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			//This is where a real application would open the file.
			//combatLog.addTextToScrollPane("Opening: " + file.getName() + "." + newline);
			Database.getConnected();
			ArrayList<String[]> fails = Database.createAccount(readyFile(file));
			Database.close();
			if(fails.size() == 0){
				lblsuccess2.setText("All accounts are created");
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						lblsuccess2.setText(null);
					}
				}, 1500);
				}
			else{
				System.out.println("Here");
				for(String[] failure : fails){
					System.out.println(1);
					scrollText.append(failure[0] + " is already existed.\n");
			}
		} /*else {
			combatLog.addTextToScrollPane("Open command cancelled by user." + newline);
		}*/
	}
	}

		private void clearMessage(){
			scrollText.setOpaque(false);
			scrollText.setText(null);
			lblerror1.setText(null);
		}
	public ArrayList<String[]> readyFile(File file) {
		try{
			Scanner reader = new Scanner(file);
			ArrayList<String[]> accounts = new ArrayList<String[]>();
			while (reader.hasNextLine()){

				String text = reader.nextLine();
				text = text.replaceAll("\\s+","");
				int start = 0;
				int end = text.indexOf(",");

				String[] row = new String[3];
				for (int i =0; i < 3;i++){
					row[i] = text.substring(start, end);
					start = end + 1;
					end = text.indexOf(",",start);
					if (end == -1)
						end = text.length();
				}
				accounts.add(row);
			}
			return accounts;
		}
		catch (IOException e){
			System.out.println("Cannot open the file.");
			return null;
		}
	}
}
