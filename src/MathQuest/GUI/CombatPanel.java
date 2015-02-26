package MathQuest.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
import MathQuest.Logic.Character;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sun.awt.HorizBagLayout;

public class CombatPanel extends JPanel {

	private ImageIcon gameWorldBackground;
	private CharacterPanel characterPanel;
	private CharacterPanel monsterPanel;
	private JTextArea scrollText;
	private Character hero;
	private Character creature;
	
	public CombatPanel(Character hero, Character creature) {
		try {                
			gameWorldBackground = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(null);
		this.hero = hero;
		this.creature = creature;
		
		this.characterPanel = new CharacterPanel(this.hero);
		this.characterPanel.setBounds(6, 6, 217, 121);
		add(this.characterPanel);
		characterPanel.setLayout(null);
		
		this.monsterPanel = new CharacterPanel(this.creature);
		this.monsterPanel.setBounds(801, 6, 217, 121);
		add(this.monsterPanel);
		
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
	}

	public void addTextToScrollPane(String text) {
		this.scrollText.append("\n");
		this.scrollText.append(text);
	}

	private void attack() {
		int damage = MathQuest.getCharacter().calculateDamage();
		creature.takeDamage(damage);
		
		this.remove(monsterPanel);
		this.monsterPanel = new CharacterPanel(creature);
		this.monsterPanel.setBounds(801, 6, 217, 121);
		add(this.monsterPanel);
		this.repaint();
		
		this.addTextToScrollPane("You attack a " + creature.getName() + " for " + damage + " point(s) of damage.");
		if(creature.getCurrentHealth() <= 0) {
			this.victory();
		}
		else {
			this.monsterAttack();
		}
	}
	
	private void monsterAttack() {
		int damage = creature.calculateDamage();
		
		this.remove(characterPanel);
		this.characterPanel = new CharacterPanel(this.hero);
		this.characterPanel.setBounds(6, 6, 217, 121);
		add(this.characterPanel);
		this.repaint();
		
		this.addTextToScrollPane("A " + creature.getName() + " attacks YOU for " + damage + " point(s) of damage.");
		MathQuest.getCharacter().takeDamage(damage);
		
		if(MathQuest.getCharacter().getCurrentHealth() <= 0) {
			this.defeat();
		}
	}
	
	private void victory() {
		this.addTextToScrollPane("YOU WIN!");
	}
	
	private void defeat() {
		this.addTextToScrollPane("YOU LOSE!");
	}
 	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage gameWorldBack = (BufferedImage)gameWorldBackground.getImage();
		g.drawImage(gameWorldBack, 0, 0, null);          
	}
}
