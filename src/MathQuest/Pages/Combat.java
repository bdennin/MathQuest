package MathQuest.Pages;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.script.ScriptException;

import MathQuest.MathQuest;
import MathQuest.GUI.CharacterPanel;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;
import MathQuest.Logic.Equation;
import MathQuest.Logic.Equation.Sign;
import MathQuest.Logic.Equation.Digits;
import MathQuest.Logic.Equation.Terms;

import java.awt.Font;

public class Combat extends Area {

	private static final long serialVersionUID = 1L;

	private CharacterPanel monsterPanel;
	private JPanel combatOptions;
	private JTextArea scrollText;
	private Character hero;
	private Character creature;
	private String creatureName;
	private Integer answer;

	public Combat(Character hero, Character creature) {
		super(hero);
		this.loadImages();
		this.hero = hero;
		this.creature = creature;
		this.creatureName = creature.getName();

		this.monsterPanel = loadMonsterPanel(this.creature);
		add(monsterPanel);

		this.combatOptions = new JPanel();
		this.loadCombatOptions();
		combatOptions.setBounds(587, 612, 288, 82);
		combatOptions.setLayout(null);
		add(combatOptions);

		JPanel combatLog = this.loadCombatLog();
		combatLog.setBounds(174, 555, 338, 177);
		add(combatLog);

		this.renderBackground();
	}

	private void addTextToScrollPane(String text) {
		this.scrollText.append("\n");
		this.scrollText.append(text);
	}

	private void monsterAttack() {

		int damage = creature.calculateDamage();

		String output = "A " + creature.getName() + " attacks YOU for " + damage + " points of damage.";
		this.addTextToScrollPane(output);
		MathQuest.getCharacter().takeDamage(damage);
		this.reloadCharacterPanel();

		if(MathQuest.getCharacter().getCurrentHealth() <= 0) {
			this.defeat();
		}
		else {
			this.addTextToScrollPane("It is your turn to act.");
		}
	}

	private void promptQuestion() {
		
		this.addTextToScrollPane("You try to find your opponents weakness.");
		String question = Equation.constructEquation(Sign.ADDITION, Digits.ONE, Terms.TWO);
		this.answer = Equation.solveEquation(question);
		Integer[] options = new Integer[3];
		boolean correctAnswerAdded = false;

		for(int i = 0; i < 3; i++) {

			double random = Math.random();

			if(random <  .33 && !correctAnswerAdded || i == 2 && !correctAnswerAdded) {
				correctAnswerAdded = true;
				options[i] = this.answer;
			}
			else {
				options[i] = Equation.generateWrongAnswer(question);
			}
		}

		this.reloadCombatOptions(options);
		this.addTextToScrollPane("Solve: " + question);
	}

	private JPanel loadCombatLog() {

		JPanel combatLog = new JPanel();
		combatLog.setBounds(174, 555, 338, 177);
		combatLog.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 21, 326, 149);
		combatLog.add(scrollPane);

		this.scrollText = new JTextArea();
		scrollPane.setViewportView(scrollText);
		this.scrollText.setEditable(false);
		this.scrollText.setLineWrap(true);
		this.scrollText.setWrapStyleWord(true);
		this.scrollText.append("You have entered combat!  It is your turn to act.");

		JLabel combatLogLabel = new JLabel("Combat Log");
		combatLogLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		combatLogLabel.setHorizontalAlignment(SwingConstants.CENTER);
		combatLogLabel.setBounds(0, 0, 338, 22);
		combatLog.add(combatLogLabel);
		return combatLog;
	}

	private void loadCombatOptions() {

		JButton attackButton = new JButton("Attack");
		attackButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		attackButton.setBounds(6, 6, 88, 70);
		attackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promptQuestion();
			}
		});
		combatOptions.add(attackButton);

		JButton runAwayButton = new JButton("<html><center>Run<br/>Away</center></html>");
		runAwayButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		runAwayButton.setBounds(194, 6, 88, 70);
		runAwayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToGameWorld();
			}
		});
		combatOptions.add(runAwayButton);

		JButton usePotionButton = new JButton("<html><center>Use<br/>Potion</center></html>");
		usePotionButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		usePotionButton.setBounds(100, 6, 88, 70);		
		combatOptions.add(usePotionButton);
		
		this.revalidate();
		this.repaint();
	}

	private void reloadCombatOptions(final Integer[] mathAnswers) {

		this.combatOptions.removeAll();

		if(null == mathAnswers) {
			loadCombatOptions();
		}
		else {

			JButton answerOne = new JButton(mathAnswers[0].toString());
			answerOne.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
			answerOne.setBounds(6, 6, 88, 70);
			answerOne.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					attack(mathAnswers[0]);
					reloadCombatOptions(null);
				}
			});
			combatOptions.add(answerOne);

			JButton answerTwo = new JButton(mathAnswers[1].toString());
			answerTwo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
			answerTwo.setBounds(194, 6, 88, 70);
			answerTwo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					attack(mathAnswers[1]);
					reloadCombatOptions(null);
				}
			});
			combatOptions.add(answerTwo);

			JButton answerThree = new JButton(mathAnswers[2].toString());
			answerThree.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
			answerThree.setBounds(100, 6, 88, 70);	
			answerThree.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					attack(mathAnswers[2]);
					reloadCombatOptions(null);
				}
			});
			combatOptions.add(answerThree);
		}

		this.revalidate();
		this.repaint();
	}
	
	private void attack(Integer answer) {
		int damage = hero.calculateDamage();
		String creatureName = creature.getName();
		
		this.addTextToScrollPane("You answered " + answer + ".");
		
		if(answer == this.answer) {
			this.addTextToScrollPane("Correct! You strike your enemy with great power!");
			damage = 2 * damage;
		}
		else {
			this.addTextToScrollPane("Good try, but the correct answer was " + this.answer + ".");
		}
		
		String output = new String("You attack a " + this.creatureName + " for " + damage + " points of damage.");
		this.addTextToScrollPane(output);

		creature.takeDamage(damage);
		this.reloadMonsterPanel();

		if(creature.getCurrentHealth() <= 0) {
			this.victory();
		}
		else {
			this.monsterAttack();
		}
	}

	private CharacterPanel loadMonsterPanel(Character monster) {

		CharacterPanel monsterPanel = new CharacterPanel(monster, false);
		monsterPanel.setLayout(null);
		monsterPanel.setBounds(907, 6, 111, 149);
		return monsterPanel;
	}

	private void reloadMonsterPanel() {

		if(this.monsterPanel != null)
			this.remove(this.monsterPanel);
		this.monsterPanel = loadMonsterPanel(this.creature);
		this.add(monsterPanel);
		this.renderBackground();
		this.repaint();
	}

	private void victory() {

		int experience = (int)(creature.getMaxExperience() * .5);
		int gold = creature.getGold();
		hero.addGold(gold);
		hero.gainExperience(experience);

		JOptionPane.showMessageDialog(this, 
				new JLabel("You are victorious! You have gained: \n"
						+ experience + "experience points\n"
						+ gold + "gold", JLabel.CENTER), 
						"Victory", 
						JOptionPane.PLAIN_MESSAGE);

		MathQuest.switchToGameWorld();
	}

	private void defeat() {

		hero.death();

		JOptionPane.showMessageDialog(this, 
				new JLabel("You are defeated! You have lost gold and experience!", JLabel.CENTER), 
				"Defeat", 
				JOptionPane.PLAIN_MESSAGE);

		MathQuest.switchToGameWorld();
	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return null;
	}

	@Override
	public void loadImages() {

		Random random = new Random();
		Integer pictureNumber = random.nextInt(7) + 1;
		String imagePath = "combat" + pictureNumber + ".jpg";
		
		try {                
			this.background = new ImageIcon(ImageIO.read(new File(imagePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
