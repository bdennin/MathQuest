package MathQuest.Pages;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.GUI.CharacterPanel;
import MathQuest.GUI.LogPanel;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;
import MathQuest.Logic.Character.DamageType;
import MathQuest.Logic.Equation;
import MathQuest.Logic.Equation.Sign;
import MathQuest.Logic.Equation.Digits;
import MathQuest.Logic.Equation.Terms;
import MathQuest.Logic.Item;
import MathQuest.Logic.Loot;

import java.awt.Font;
import java.awt.GridLayout;

public class Combat extends Area {

	private static final long serialVersionUID = 1L;

	private CharacterPanel creaturePanel;
	private LogPanel combatLog;
	private JPanel combatOptions;
	private ImageIcon victoryIcon;
	private ImageIcon defeatIcon;
	private ImageIcon potionIcon;
	private ImageIcon levelUpIcon;
	private ImageIcon runAwayIcon;
	private ImageIcon attackIcon;
	private Character hero;
	private Character creature;
	private String creatureName;
	private Integer answer;
	private boolean isFirstToAct;
	private boolean isRunning;

	public Combat(Character hero, Character creature) {

		super(hero);
		this.loadImages();
		this.hero = hero;
		this.creature = creature;
		this.creatureName = creature.getName();
		this.isRunning = false;

		this.creaturePanel = loadMonsterPanel(this.creature);
		add(creaturePanel);

		this.combatOptions = new JPanel();
		this.loadCombatOptions();
		add(combatOptions);

		this.combatLog = new LogPanel("Combat Log");
		combatLog.addTextToScrollPane("You have entered combat!");
		add(combatLog);

		this.renderBackground();

		this.isFirstToAct = hero.getLevel() >= creature.getLevel();
		if(isFirstToAct)
			combatLog.addTextToScrollPane("It is your turn to act.");
		else
			combatLog.addTextToScrollPane("A(n) " + creature.getName() + " will attack first!");
		this.refresh();
	}

	private Boolean checkDamage(int damage) {
		return (damage > 0);
	}

	private void setAttacker() {
		this.isFirstToAct = true;
	}

	private void promptQuestion() {

		String question;
		if(MathQuest.connectToDatabase){
			String[] equationSettings = Database.getFormulaFromCache(creature.getLevel());
			if(equationSettings == null)
				question = Equation.constructEquation(Sign.ADDITION, Digits.ONE, Terms.TWO);
			else
				question = Equation.constructEquation(equationSettings);
		}
		else
			question = Equation.constructEquation(Sign.ADDITION, Digits.ONE, Terms.TWO);

		this.answer = Equation.solveEquation(question);
		ArrayList<Integer> options = this.generateWrongAnswers(question);
		this.reloadCombatOptions(options);

		combatLog.addTextToScrollPane("Solve: " + question);
		this.refresh();

	}

	private ArrayList<Integer> generateWrongAnswers(String question) {

		ArrayList<Integer> options = new ArrayList<Integer>();
		boolean correctAnswerAdded = false;

		int numberOfChoices = MathQuest.RANDOM.nextInt(4) + 2; 
		for(int i = 0; i < numberOfChoices; i++) {

			int random = MathQuest.RANDOM.nextInt(numberOfChoices);

			if(random == 0 && !correctAnswerAdded || i == (numberOfChoices - 1) && !correctAnswerAdded) {
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
		return options;

	}

	private void loadCombatOptions() {

		combatOptions.setBounds(587, 612, 269, 77);
		combatOptions.setLayout(new GridLayout(1, 0, 0, 0));
		combatOptions.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));

		JButton attackButton = new JButton(this.attackIcon);
		attackButton.setBounds(3, 3, 88, 70);
		attackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isFirstToAct) {
					monsterAttack();
				}
				combatLog.addTextToScrollPane("You try to find your opponent's weakness.");
				refresh();
				promptQuestion();	
			}
		});
		combatOptions.add(attackButton);

		JButton usePotionButton = new JButton(this.potionIcon);	
		usePotionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int potions = hero.getPotions();
				if(potions > 0) {
					if(!isFirstToAct) {
						monsterAttack();
					}
					int currentHealth = hero.getCurrentHealth();
					int maxHealth = hero.getMaxHealth();
					int potionHealth = (int)(maxHealth * .3);
					currentHealth = currentHealth + potionHealth;
					if(currentHealth > maxHealth)
						currentHealth = maxHealth;
					hero.setPotions(potions - 1);
					hero.setCurrentHealth(currentHealth);
					combatLog.addTextToScrollPane("You drank a potion and gained " + potionHealth + " health!");	
					monsterAttack();
				}
				else
					combatLog.addTextToScrollPane("You don't have any potions to use!");	
			}
		});
		combatOptions.add(usePotionButton);

		JButton runAwayButton = new JButton(this.runAwayIcon);
		runAwayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combatLog.addTextToScrollPane("You try to find a path to get away.");
				isRunning = true;
				refresh();
				promptQuestion();
			}
		});
		combatOptions.add(runAwayButton);
		this.refresh();
	}

	private void reloadCombatOptions(final ArrayList<Integer> mathAnswers) {

		this.combatOptions.removeAll();

		if(null == mathAnswers) {
			loadCombatOptions();
		}
		else {

			for(final Integer el : mathAnswers) {
				final JButton answerButton = new JButton(el.toString());
				answerButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
				answerButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						combatLog.addTextToScrollPane("You answered " + answer + ".");
						if(isRunning == true) {
							if(answerButton.getText().equals(answer.toString())) {
								combatLog.addTextToScrollPane("You found an escape route!");
								refresh();
								MathQuest.switchToGameWorld();
							}
							else {
								combatLog.addTextToScrollPane("You failed to find an escape.");
								refresh();
								reloadCombatOptions(null);
								monsterAttack();
							}
						}
						else {
							attack(el);
							reloadCombatOptions(null);
						}			
						isRunning = false;
					}
				});
				combatOptions.add(answerButton);
			}
			this.refresh();
		}
	}
	
	private void attack(Integer answer) {

		int damage = hero.calculateDamage();
		Boolean damageOutcome = checkDamage(damage);

		this.refresh();

		if(answer == this.answer) {
			combatLog.addTextToScrollPane("Correct! You strike your enemy with great power!");
			this.refresh();
			hero.incrementAnsweredCorrectly();
			damage = 2 * damage;
			damageOutcome = null;
		}
		else {
			combatLog.addTextToScrollPane("Good try, but the correct answer was " + this.answer + ".");
			this.refresh();
			hero.incrementAnsweredIncorrectly();
		}

		this.playAttackSound(hero, damageOutcome);

		String output = new String("You attack a " + this.creatureName + " for " + damage + " points of damage.");
		combatLog.addTextToScrollPane(output);
		this.refresh();

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
		Boolean damageOutcome = checkDamage(damage);

		this.playAttackSound(creature, damageOutcome);

		String output = "A(n) " + creature.getName() + " attacks YOU for " + damage + " points of damage.";
		combatLog.addTextToScrollPane(output);
		this.refresh();
		MathQuest.getCharacter().takeDamage(damage);
		this.reloadCharacterPanel();

		if(MathQuest.getCharacter().getCurrentHealth() <= 0) {
			this.defeat();
		}
		else if(!isFirstToAct) {
			setAttacker();
		}
		else {
			combatLog.addTextToScrollPane("It is your turn to act.");
			this.refresh();
		}
	}

	private CharacterPanel loadMonsterPanel(Character monster) {

		CharacterPanel monsterPanel = new CharacterPanel(this, monster, false, true);
		monsterPanel.setLayout(null);
		monsterPanel.setBounds(907, 6, 107, 144);
		return monsterPanel;
	}

	private void reloadMonsterPanel() {

		if(this.creaturePanel != null)
			this.remove(this.creaturePanel);
		this.creaturePanel = loadMonsterPanel(this.creature);
		this.add(creaturePanel);
		this.renderBackground();
	}

	public void playAttackSound(Character character, Boolean damageOutcome) {

		String combatSound;
		DamageType damageType = character.getDamageType();

		switch (damageType) {
		case CRUSHING:
			if (damageOutcome == null) {	
				combatSound = "Files/crushing2.mp3";
			}
			else if (damageOutcome == false) {
				combatSound = "Files/crushing0.mp3";
			}
			else {
				combatSound = "Files/crushing1.mp3";
			}
			break;
		case SLASHING:
			if (damageOutcome == null) {
				combatSound = "Files/slashing3.mp3";
			}
			else if (damageOutcome == false) {
				combatSound = "Files/slashing0.mp3";
			}
			else {
				combatSound = "Files/slashing" + (MathQuest.RANDOM.nextInt(2) + 1) + ".mp3";
			}
			break;
		case MAGICAL:
			if (damageOutcome == null){	
				combatSound = "Files/magic4.mp3";
			}
			else if (damageOutcome == false) {
				combatSound = "Files/magic0.mp3";
			}
			else {
				combatSound = "Files/magic" + (MathQuest.RANDOM.nextInt(3) + 1) + ".mp3";
			}
			break;
		default:
			throw new IllegalArgumentException();
		}
		MathQuest.playSound(MathQuest.class.getResource(combatSound));
	}

	private void victory() {
		
		MathQuest.playMusic(MathQuest.class.getResource("Files/victory.mp3"));
		
		double experienceRandomizer = (Math.random() * 30 + 50)/100;
		double goldRandomizer = (Math.random() * 50 + 81)/100;
		int experience = (int)(creature.getMaxExperience() * experienceRandomizer);
		int gold = (int)(creature.getGold() * goldRandomizer);
		int level = hero.getLevel();
		
		hero.addGold(gold);
		hero.gainExperience(experience);

		Item droppedItem = Loot.getLoot(this.creature.getLevel());
		String victoryString = String.format("<html>You are victorious! You check your<br/>enemy for gold and head back to<br/>town. You receive:<br/><Center><br/>%d XP<br/>%d Gold<br/></Center></html>", experience, gold); 
		
		if(droppedItem != null) {
			victoryString = String.format("<html>You are victorious! You check your<br/>enemy for gold and head back to<br/>town. You receive:<br/><Center><br/>%d XP<br/>%d Gold<br/><font color='%s'>[%s]</font><br/></Center></html>", experience, gold, droppedItem.getColor(), droppedItem.getName());
			hero.addToInventory(droppedItem);
		}

		JOptionPane.showMessageDialog(this, 
				new JLabel(victoryString), 
				"Victory", 
				JOptionPane.PLAIN_MESSAGE,
				victoryIcon);

		if (level < hero.getLevel()) {

			this.reloadCharacterPanel();
			MathQuest.playSound(MathQuest.class.getResource("Files/levelUp.wav"));
			
			victoryString = String.format("<html>Congratulations! You have gained a<br/>level! You are now level %d.</html>", hero.getLevel());

			JOptionPane.showMessageDialog(this, 
					new JLabel(victoryString), 
					"You Feel Stronger...", 
					JOptionPane.PLAIN_MESSAGE,
					levelUpIcon);
		}

		MathQuest.switchToGameWorld();
	}

	private void defeat() {

		MathQuest.playMusic(MathQuest.class.getResource("Files/defeat.mp3"));

		hero.death();

		JOptionPane.showMessageDialog(this, 
				new JLabel("<html>You have been defeated in battle!<br/>You have lost gold and experience.</html>"), 
				"Defeat", 
				JOptionPane.PLAIN_MESSAGE,
				defeatIcon);

		MathQuest.switchToGameWorld();
	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return null;
	}

	@Override
	public void loadImages() {

		Integer pictureNumber = MathQuest.RANDOM.nextInt(8) + 1;        
		this.background = new ImageIcon(MathQuest.class.getResource("Files/combat" + pictureNumber + ".jpg"));
		this.victoryIcon = new ImageIcon(MathQuest.class.getResource("Files/victoryIcon.png"));
		this.defeatIcon = new ImageIcon(MathQuest.class.getResource("Files/defeatIcon.png"));
		this.potionIcon = new ImageIcon(MathQuest.class.getResource("Files/potion.png"));
		this.attackIcon = new ImageIcon(MathQuest.class.getResource("Files/attack.png"));
		this.runAwayIcon = new ImageIcon(MathQuest.class.getResource("Files/runAway.png"));
		this.levelUpIcon = new ImageIcon(MathQuest.class.getResource("Files/levelUp.png"));
	}
}
