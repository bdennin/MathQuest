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
import java.awt.Graphics;

import javax.swing.SwingConstants;

public class CharacterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon background;			
	private ImageIcon portrait;
	private HealthBar healthBar;

	public CharacterPanel(Character character, boolean isLevelDisplayed) {
		setLayout(null);
		this.setBounds(0, 0, 111, 149);
		this.loadImages(character.getImagePath());

		Integer level = character.getLevel();

		healthBar = new HealthBar(character);
		healthBar.setBounds(6, 115, 99, 28);
		this.add(healthBar);

		if(isLevelDisplayed) {

			JPanel levelPanel = new JPanel();
			levelPanel.setLayout(null);
			levelPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			levelPanel.setBounds(12, 89, 22, 20);
			add(levelPanel);

			JLabel levelLabel = new JLabel(level.toString());
			levelLabel.setBounds(0, 0, 22, 20);
			levelPanel.add(levelLabel);
			levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

		}

		JLabel charPortrait = new JLabel();
		charPortrait.setBounds(6, 6, 99, 109);
		add(charPortrait);
		charPortrait.setIcon(this.portrait);
	}

	private void loadImages(String path) {
		try {                
			this.portrait = new ImageIcon(ImageIO.read(new File(path)));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
