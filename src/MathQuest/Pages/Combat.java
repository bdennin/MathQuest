package MathQuest.Pages;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import javazoom.jlgui.basicplayer.BasicPlayerException;
import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.GUI.CharacterPanel;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;
import MathQuest.Logic.Character.DamageType;
import MathQuest.Logic.Equation;
import MathQuest.Logic.Equation.Sign;
import MathQuest.Logic.Equation.Digits;
import MathQuest.Logic.Equation.Terms;

import java.awt.Color;
import java.awt.Font;

public class Combat extends Area {

	private static final long serialVersionUID = 1L;

	private CharacterPanel monsterPanel;
	private JPanel combatOptions;
	private ImageIcon victoryIcon;
	private ImageIcon defeatIcon;
	private ImageIcon potionIcon;
	private ImageIcon runAwayIcon;
	private ImageIcon attackIcon;
	private JTextArea scrollText;
	private Character hero;
	private Character creature;
	private String creatureName;
	private Integer answer;

	public Combat(Character hero, Character creature) {

		super(hero, "combatMusic" + (RANDOM.nextInt(3) + 1) + ".mp3");
		this.loadImages();
		this.hero = hero;
		this.creature = creature;
		this.creatureName = creature.getName();

		this.monsterPanel = loadMonsterPanel(this.creature);
		add(monsterPanel);

		this.combatOptions = new JPanel();
		this.loadCombatOptions();
		combatOptions.setBounds(587, 612, 269, 77);
		combatOptions.setLayout(null);
		combatOptions.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
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

	private void promptQuestion() {

		this.addTextToScrollPane("You try to find your opponent's weakness.");
		String question;
		  if(MathQuest.connectToDatabase)
		   question = Equation.constructEquation(Database.getFormular(creature.getLevel()));
		  else
		   question = Equation.constructEquation(Sign.ADDITION, Digits.ONE, Terms.TWO);
		this.answer = Equation.solveEquation(question);
		ArrayList<Integer> options = new ArrayList<Integer>();
		boolean correctAnswerAdded = false;

		for(int i = 0; i < 3; i++) {

			double random = Math.random();

			if(random <  .33 && !correctAnswerAdded || i == 2 && !correctAnswerAdded) {
				correctAnswerAdded = true;
				options.add(this.answer);
			}
			else {
				Integer wrongAnswer;
				do {
					wrongAnswer = Equation.generateWrongAnswer(question);
				}
				while(options.contains(wrongAnswer));
				options.add(wrongAnswer);
			}
		}

		this.reloadCombatOptions(options);
		this.addTextToScrollPane("Solve: " + question);
	}

	private JPanel loadCombatLog() {

		JPanel combatLog = new JPanel();
		combatLog.setBackground(Color.LIGHT_GRAY);
		combatLog.setBounds(174, 555, 338, 177);
		combatLog.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 21, 338, 156);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		combatLog.add(scrollPane);

		this.scrollText = new JTextArea();
		scrollPane.setViewportView(scrollText);
		this.scrollText.setFont(null);
		this.scrollText.setEditable(false);
		this.scrollText.setLineWrap(true);
		this.scrollText.setWrapStyleWord(true);
		this.scrollText.append("You have entered combat!");
		this.addTextToScrollPane("It is your turn to act.");

		JLabel combatLogLabel = new JLabel("Combat Log");
		combatLogLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		combatLogLabel.setHorizontalAlignment(SwingConstants.CENTER);
		combatLogLabel.setBounds(0, 0, 338, 22);
		combatLog.add(combatLogLabel);
		return combatLog;
	}

	private void loadCombatOptions() {

		JButton attackButton = new JButton(this.attackIcon);
		attackButton.setBounds(3, 3, 88, 70);
		attackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promptQuestion();
			}
		});
		combatOptions.add(attackButton);

		JButton runAwayButton = new JButton(this.runAwayIcon);
		runAwayButton.setBounds(177, 3, 88, 70);
		runAwayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stopMusic();
				MathQuest.switchToGameWorld();
			}
		});
		combatOptions.add(runAwayButton);

		JButton usePotionButton = new JButton(this.potionIcon);
		usePotionButton.setBounds(90, 3, 88, 70);		
		combatOptions.add(usePotionButton);
		combatOptions.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		
		this.revalidate();
		this.repaint();
	}

	private void reloadCombatOptions(final ArrayList<Integer> mathAnswers) {

		this.combatOptions.removeAll();

		if(null == mathAnswers) {
			loadCombatOptions();
		}
		else {

			JButton answerOne = new JButton(mathAnswers.get(0).toString());
			answerOne.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
			answerOne.setBounds(3, 3, 88, 70);
			answerOne.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					attack(mathAnswers.get(0));
					reloadCombatOptions(null);
				}
			});
			combatOptions.add(answerOne);

			JButton answerTwo = new JButton(mathAnswers.get(1).toString());
			answerTwo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
			answerTwo.setBounds(177, 3, 88, 70);
			answerTwo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					attack(mathAnswers.get(1));
					reloadCombatOptions(null);
				}
			});
			combatOptions.add(answerTwo);

			JButton answerThree = new JButton(mathAnswers.get(2).toString());
			answerThree.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
			answerThree.setBounds(90, 3, 88, 70);	
			answerThree.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					attack(mathAnswers.get(2));
					reloadCombatOptions(null);
				}
			});
			combatOptions.add(answerThree);
			combatOptions.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		}

		this.revalidate();
		this.repaint();
	}

	private void attack(Integer answer) {
		int damage = hero.calculateDamage();

		this.addTextToScrollPane("You answered " + answer + ".");

		if(answer == this.answer) {
			this.addTextToScrollPane("Correct! You strike your enemy with great power!");
			hero.incrementAnsweredCorrectly();
			damage = 2 * damage;
			
			String filePath = "file:///" + System.getProperty("user.dir").replace("\\", "/") + "/quadDamage.mp3";
			try {
				effectPlayer.open(new URL(filePath));
				effectPlayer.play();
			}
			catch(BasicPlayerException | MalformedURLException e) {
				e.printStackTrace();
			}
		}
		else {
			this.addTextToScrollPane("Good try, but the correct answer was " + this.answer + ".");
			hero.incrementAnsweredIncorrectly();
		}

		this.playAttackSound(hero, damage);

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

	private void monsterAttack() {

		int damage = creature.calculateDamage();

		this.playAttackSound(creature, damage);

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

	private CharacterPanel loadMonsterPanel(Character monster) {

		CharacterPanel monsterPanel = new CharacterPanel(this, monster, false, true);
		monsterPanel.setLayout(null);
		monsterPanel.setBounds(907, 6, 107, 144);
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

		stopMusic();
		String filePath = "file:///" + System.getProperty("user.dir").replace("\\", "/") + "/victory.mp3";
		try {
			musicPlayer.open(new URL(filePath));
			musicPlayer.play();
		}
		catch(BasicPlayerException | MalformedURLException e) {
			e.printStackTrace();
		}

		int experience = (int)(creature.getMaxExperience() * .5);
		int gold = creature.getGold();
		hero.addGold(gold);
		hero.gainExperience(experience);

		String victoryString = String
				.format("<html>You are victorious! You check your<br/>enemy for gold and head back to<br/>town. You receive:<br/><Center><br/>%d XP<br/>%d Gold<br/></Center></html>", experience, gold);

		JOptionPane.showMessageDialog(this, 
				new JLabel(victoryString, JLabel.CENTER), 
				"Victory", 
				JOptionPane.PLAIN_MESSAGE,
				victoryIcon);

		stopMusic();
		MathQuest.switchToGameWorld();
	}

	private void defeat() {

		stopMusic();
		String filePath = "file:///" + System.getProperty("user.dir").replace("\\", "/") + "/defeat.mp3";
		
		try {
			musicPlayer.open(new URL(filePath));
			musicPlayer.play();
		}
		catch(BasicPlayerException | MalformedURLException e) {
			e.printStackTrace();
		}
		
		hero.death();

		JOptionPane.showMessageDialog(this, 
				new JLabel("<html>You have been defeated in battle!<br/>A good samaritan finds you and<br/>nurses you back to health. You<br/>have lost gold and experience!</html>", JLabel.CENTER), 
				"Defeat", 
				JOptionPane.PLAIN_MESSAGE,
				defeatIcon);

		stopMusic();
		MathQuest.switchToGameWorld();
	}

	private void playAttackSound(Character character, int damage) {

		String combatSound = "file:///" + System.getProperty("user.dir").replace("\\", "/");
		DamageType damageType = character.getDamageType();

		switch (damageType) {
		case CRUSHING:
			if (damage == 0) {
				combatSound += "/crushing0.mp3";
			}
			else {
				combatSound += "/crushing" + (RANDOM.nextInt(2) + 1) + ".mp3";
			}
			break;
		case SLASHING:
			if (damage == 0) {
				combatSound += "/slashing0.mp3";
			}
			else {
				combatSound += "/slashing" + (RANDOM.nextInt(3) + 1) + ".mp3";
			}
			break;
		case MAGICAL:
			if (damage == 0) {
				combatSound += "/magic0.mp3";
			}
			else {
				combatSound += "/magic" + (RANDOM.nextInt(4) + 1) + ".mp3";
			}
			break;
		default:
			throw new IllegalArgumentException();
		}

		try {
			soundPlayer.open(new URL(combatSound));
			soundPlayer.play();
		}
		catch(BasicPlayerException | MalformedURLException e) {
			e.printStackTrace();
		}	

	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return null;
	}

	@Override
	public void loadImages() {

		Random random = new Random();
		Integer pictureNumber = random.nextInt(8) + 1;
		String imagePath = "combat" + pictureNumber + ".jpg";

		try {                
			this.background = new ImageIcon(ImageIO.read(new File(imagePath)));
			this.victoryIcon = new ImageIcon(ImageIO.read(new File("victoryIcon.png")));
			this.defeatIcon = new ImageIcon(ImageIO.read(new File("defeatIcon.png")));
			this.potionIcon = new ImageIcon(ImageIO.read(new File("potion.png")));
			this.attackIcon = new ImageIcon(ImageIO.read(new File("attack.png")));
			this.runAwayIcon = new ImageIcon(ImageIO.read(new File("runAway.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
