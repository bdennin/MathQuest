package MathQuest.GUI;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MathQuest.Logic.Character;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CharacterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon portrait;
	private ImageIcon goldImage;
	private HealthBar healthBar;
	
	public CharacterPanel(Character character) {
		setLayout(null);
		this.setBounds(0, 0, 111, 187);
		this.loadImages(character.getImagePath());

		Integer level = character.getLevel();
		
		healthBar = new HealthBar(character);
		healthBar.setBounds(6, 122, 99, 28);
		this.add(healthBar);
		
		JLabel charPortrait = new JLabel();
		charPortrait.setBounds(6, 6, 99, 109);
		add(charPortrait);
		charPortrait.setIcon(this.portrait);
		
		JPanel levelPanel = new JPanel();
		levelPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		levelPanel.setBounds(6, 87, 28, 28);
		add(levelPanel);
		levelPanel.setLayout(null);
		
		JLabel levelLabel = new JLabel(level.toString());
		levelLabel.setBounds(0, 0, 28, 28);
		levelPanel.add(levelLabel);
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel goldPicture = new JLabel();
		goldPicture.setIcon(goldImage);
		goldPicture.setBounds(6, 156, 25, 25);
		add(goldPicture);
		
		Integer gold = character.getGold();
		JLabel goldTotal = new JLabel(gold.toString());
		goldTotal.setHorizontalAlignment(JLabel.CENTER);
		goldTotal.setBounds(37, 156, 68, 25);
		add(goldTotal);
	}

	private void loadImages(String path) {
		try {                
			this.portrait = new ImageIcon(ImageIO.read(new File(path)));
			this.goldImage = new ImageIcon(ImageIO.read(new File("gold.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
