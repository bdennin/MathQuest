package MathQuest.GUI;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import MathQuest.MathQuest;
import MathQuest.Logic.Character;
import MathQuest.Logic.Monster;

public class CharacterPanel extends JPanel {

	private ImageIcon portrait;
	private static final String CHARACTER_PORTRAIT = "char.jpg";
	
	public CharacterPanel() {
		this.loadPortrait(CHARACTER_PORTRAIT);
		setLayout(null);

		JPanel characterPanel = new JPanel();
		characterPanel.setBounds(6, 6, 217, 121);
		add(characterPanel);
		characterPanel.setLayout(null);

		JPanel charPortrait = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage charPortrait = (BufferedImage)portrait.getImage();
				g.drawImage(charPortrait, 0, 0, null);           
			}
		};

		Character hero = MathQuest.getCharacter();
		Integer level = hero.getLevel();
		Integer currentExp = (int) hero.getCurrentExperience();
		Integer maxExp = (int) hero.getMaxExperience();
		Integer currentLife = hero.getCurrentHealth();
		Integer maxLife = hero.getMaxHealth();
		String expBar = new String(currentExp + "/" + maxExp);
		String lifeBar = new String(currentLife + "/" + maxLife);

		charPortrait.setBounds(0, 0, 99, 109);
		characterPanel.add(charPortrait);
		charPortrait.setLayout(null);

		JPanel charLevel = new JPanel();
		charLevel.setLayout(new GridLayout(1, 0, 0, 0));
		charLevel.setBounds(6, 85, 23, 18);
		charPortrait.add(charLevel);

		JLabel levelNumber = new JLabel(level.toString());
		levelNumber.setHorizontalAlignment(SwingConstants.CENTER);
		charLevel.add(levelNumber);

		JPanel charStats = new JPanel();
		charStats.setBounds(111, 6, 99, 109);
		characterPanel.add(charStats);
		charStats.setLayout(null);

		JLabel hitPointLabel = new JLabel("HP");
		hitPointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hitPointLabel.setBounds(13, 0, 61, 16);
		charStats.add(hitPointLabel);

		JLabel experienceLabel = new JLabel("XP");
		experienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		experienceLabel.setBounds(13, 55, 61, 16);
		charStats.add(experienceLabel);

		JLabel lifeBarLabel = new JLabel(lifeBar);
		lifeBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lifeBarLabel.setBounds(13, 15, 61, 16);
		charStats.add(lifeBarLabel);

		JLabel experienceBarLabel = new JLabel(expBar);
		experienceBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		experienceBarLabel.setBounds(13, 71, 61, 16);
		charStats.add(experienceBarLabel);
	}

	public CharacterPanel(Monster creature) {
		this.loadPortrait(creature.getImagePath());
		setLayout(null);

		JPanel characterPanel = new JPanel();
		characterPanel.setBounds(6, 6, 217, 121);
		add(characterPanel);
		characterPanel.setLayout(null);

		JPanel charPortrait = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage charPortrait = (BufferedImage)portrait.getImage();
				g.drawImage(charPortrait, 0, 0, null);           
			}
		};

		Integer level = creature.getLevel();
		Integer currentLife = creature.getCurrentHealth();
		Integer maxLife = creature.getMaxHealth();
		String lifeBar = new String(currentLife + "/" + maxLife);

		charPortrait.setBounds(0, 0, 99, 109);
		characterPanel.add(charPortrait);
		charPortrait.setLayout(null);

		JPanel charLevel = new JPanel();
		charLevel.setLayout(new GridLayout(1, 0, 0, 0));
		charLevel.setBounds(6, 85, 23, 18);
		charPortrait.add(charLevel);

		JLabel levelNumber = new JLabel(level.toString());
		levelNumber.setHorizontalAlignment(SwingConstants.CENTER);
		charLevel.add(levelNumber);

		JPanel charStats = new JPanel();
		charStats.setBounds(111, 6, 99, 109);
		characterPanel.add(charStats);
		charStats.setLayout(null);

		JLabel hitPointLabel = new JLabel("HP");
		hitPointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hitPointLabel.setBounds(13, 0, 61, 16);
		charStats.add(hitPointLabel);

		JLabel lifeBarLabel = new JLabel(lifeBar);
		lifeBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lifeBarLabel.setBounds(13, 15, 61, 16);
		charStats.add(lifeBarLabel);
	}

	private void loadPortrait(String path) {
		try {                
			this.portrait = new ImageIcon(ImageIO.read(new File(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
