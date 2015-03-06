package MathQuest.GUI;

import javax.swing.JPanel;

import MathQuest.Logic.Equation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String question;
	private int answer;
	
	public QuestionPanel() {
		setLayout(null);
		this.question = Equation.constructEquation(Equation.Sign.ADDITION, Equation.Digits.ONE, Equation.Terms.TWO);
		this.answer = Equation.solveEquation(question);
		
		JLabel lblNewLabel = new JLabel("You analyze your opponent to determine where it is vulnerable...");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(6, 6, 438, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel_1.setText(question);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 49, 438, 67);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("What is:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 28, 438, 16);
		add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 122, 438, 61);
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		String wrongAnswer = String.format("%d", answer);
		final JButton firstAnswer = new JButton();
		firstAnswer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				correct();
			}
		});
		firstAnswer.setText(wrongAnswer);
		panel.add(firstAnswer);
		
		wrongAnswer = String.format("%d", Equation.generateWrongAnswer(question));
		final JButton secondAnswer = new JButton();
		secondAnswer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				incorrect();
			}
		});
		secondAnswer.setText(wrongAnswer);
		panel.add(secondAnswer);
		
		wrongAnswer = String.format("%d", Equation.generateWrongAnswer(question));
		final JButton thirdAnswer = new JButton();
		thirdAnswer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				incorrect();
			}
		});
		thirdAnswer.setText(wrongAnswer);
		panel.add(thirdAnswer);
		
		wrongAnswer = String.format("%d", Equation.generateWrongAnswer(question));
		final JButton fourthAnswer = new JButton();
		fourthAnswer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				incorrect();
			}
		});
		fourthAnswer.setText(wrongAnswer);
		panel.add(fourthAnswer);
	}
	
	private void correct() {
		
	}
	
	private void incorrect() {
		
	}
}
