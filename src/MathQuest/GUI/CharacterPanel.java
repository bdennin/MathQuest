package MathQuest.GUI;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MathQuest.Logic.Character;

public class CharacterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon portrait;
	private ImageIcon levelIdentifier;
	private HealthBar healthBar;
	
	public CharacterPanel(Character character) {
		setLayout(null);
		this.setBounds(0, 0, 111, 150);
		this.loadImages(character.getImagePath());

		Integer level = character.getLevel();
		
		JLabel charLevel = new JLabel();
		charLevel.setIcon(this.levelIdentifier);
		charLevel.setText(level.toString());
		charLevel.setBounds(6, 71, 50, 50);
		this.add(charLevel);
		
		JLabel charPortrait = new JLabel();
		charPortrait.setIcon(this.portrait);
		charPortrait.setBounds(6, 6, 99, 109);
		this.add(charPortrait);
		
		healthBar = new HealthBar(character);
		healthBar.setBounds(6, 122, 99, 22);
		this.add(healthBar);
	}

	private void loadImages(String path) {
		try {                
			this.portrait = new ImageIcon(ImageIO.read(new File(path)));
			this.levelIdentifier = new ImageIcon(ImageIO.read(new File("circle-outline.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
