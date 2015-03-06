package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.script.ScriptException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

import MathQuest.MathQuest;
import MathQuest.GUI.CharacterPanel;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;
import MathQuest.Logic.Equation;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sun.awt.HorizBagLayout;

public class Combat extends Area {

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

	public void addTextToScrollPane(String text) {
		this.scrollText.append("\n");
		this.scrollText.append(text);
	}

	private void attack() {
		int damage = hero.calculateDamage();
		creature.takeDamage(damage);

		this.reloadMonsterPanel();

		String output = new String("You attack a " + creature.getName() + " for " + damage + " points of damage.");
		this.addTextToScrollPane(output);
		if(creature.getCurrentHealth() <= 0) {
			this.victory();
		}
		else {
			this.monsterAttack();
		}
	}

	private void monsterAttack() {
		int damage = creature.calculateDamage();

		this.addTextToScrollPane("A " + creature.getName() + " attacks YOU for " + damage + " points of damage.");
		MathQuest.getCharacter().takeDamage(damage);

		this.reloadCharacterPanel();

		if(MathQuest.getCharacter().getCurrentHealth() <= 0) {
			this.defeat();
		}
	}

	private CharacterPanel loadMonsterPanel(Character character) {

		CharacterPanel monsterPanel = new CharacterPanel(character);
		monsterPanel.setLayout(null);
		monsterPanel.setBounds(907, 6, 111, 150);
		return monsterPanel;
	}

	private void reloadMonsterPanel() {

		this.remove(this.monsterPanel);
		this.monsterPanel = loadMonsterPanel(this.creature);
		this.add(monsterPanel);
		this.renderBackground();
		this.repaint();
	}

	private void victory() {
		this.addTextToScrollPane("YOU WIN!");
	}

	private void defeat() {
		this.addTextToScrollPane("YOU LOSE!");
	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return null;
	}

	@Override
	public void loadImages() {

		try {                
			this.background = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
