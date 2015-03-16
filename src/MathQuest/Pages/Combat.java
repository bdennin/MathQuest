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

public class Combat extends Area {
	
	private static final long serialVersionUID = 1L;
	
	private CharacterPanel monsterPanel;
	private JTextArea scrollText;
	private Character hero;
	private Character creature;

	public Combat(Character hero, Character creature) {
		
		super(hero);
		this.loadImages();
		this.hero = hero;
		this.creature = creature;
		
		this.monsterPanel = loadMonsterPanel(this.creature);
		add(monsterPanel);

		JPanel combatPanel = new JPanel();
		combatPanel.setBounds(150, 590, 724, 150);
		add(combatPanel);
		combatPanel.setLayout(null);

		JPanel combatOptions = new JPanel();
		combatOptions.setBounds(429, 6, 289, 138);
		combatPanel.add(combatOptions);
		combatOptions.setLayout(null);

		JPanel attackPanel = new JPanel();
		attackPanel.setBounds(6, 6, 88, 126);
		combatOptions.add(attackPanel);
		attackPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnAttack = new JButton("Attack");
		btnAttack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				attack();
			}
		});
		attackPanel.add(btnAttack);

		JPanel potionPanel = new JPanel();
		potionPanel.setBounds(100, 6, 88, 126);
		combatOptions.add(potionPanel);
		potionPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnUsePotion = new JButton("Use Potion");
		potionPanel.add(btnUsePotion);

		JPanel runPanel = new JPanel();
		runPanel.setBounds(194, 6, 88, 126);
		combatOptions.add(runPanel);
		runPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnRunAway = new JButton("Run Away");
		btnRunAway.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToGameWorld();
			}
		});
		runPanel.add(btnRunAway);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 417, 138);
		combatPanel.add(scrollPane);

		this.scrollText = new JTextArea();
		this.scrollText.setEditable(false);
		this.scrollText.setLineWrap(true);
		this.scrollText.setWrapStyleWord(true);
		scrollPane.setViewportView(scrollText);
		this.scrollText.append("You have entered combat!  It is your turn to act...");
		
		this.renderBackground();
	}

	private void addTextToScrollPane(String text) {
		this.scrollText.append("\n");
		this.scrollText.append(text);
	}

	private void attack() {
		
		this.toggleElements();
		boolean hasBonusDamage = this.promptQuestion();
		
		this.toggleElements();
		int damage = hero.calculateDamage();
		
		if(hasBonusDamage) {
			damage = 2 * damage;
			this.addTextToScrollPane("You strike incredibly hard!");
		}
		
		String output = new String("You attack a " + creature.getName() + " for " + damage + " points of damage.");
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

	private boolean promptQuestion() {
		
		String question = Equation.constructEquation(Sign.ADDITION, Digits.ONE, Terms.TWO);
		int answer = Equation.solveEquation(question);
		Object[] options = new Object[4];
		boolean correctAnswerAdded = false;
		boolean correctAnswerChosen;
		
		for(int i = 0; i < 4; i++) {
			
			double random = Math.random();
			
			if(random <  .25 && !correctAnswerAdded || i == 3 && !correctAnswerAdded) {
				correctAnswerAdded = true;
				options[i] = answer;
			}
			else {
				options[i] = Equation.generateWrongAnswer(question);
			}
		}
		
		int outcome = JOptionPane.showOptionDialog(
				this, 
				new JLabel(question, JLabel.CENTER),
				"Solve for Bonus Damage\n", 
				JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE, 
				null, 
				options, 
				null);
		
		if((int)options[outcome] == answer) {
			correctAnswerChosen = true;
			JOptionPane.showMessageDialog(this, 
					new JLabel("You gain double damage on your next attack!", JLabel.CENTER), 
					"Correct", 
					JOptionPane.PLAIN_MESSAGE);
		}
		else {
			correctAnswerChosen = false;
			JOptionPane.showMessageDialog(this, 
					new JLabel("The correct answer was " + answer + ".", JLabel.CENTER), 
					"Good Try", 
					JOptionPane.PLAIN_MESSAGE);
		}
		return correctAnswerChosen;
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
	}
	
	private CharacterPanel loadMonsterPanel(Character character) {

		CharacterPanel monsterPanel = new CharacterPanel(character);
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
		int gold = (int)(creature.getGold());
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

		try {                
			this.background = new ImageIcon(ImageIO.read(new File("combat.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
