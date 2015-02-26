package MathQuest.GUI;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import MathQuest.Logic.Character;
import java.awt.Color;
import java.awt.Font;

public class CharacterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon portrait;
	private HealthBar healthBar;
	
	public CharacterPanel(Character character) {
		setLayout(null);
		this.setBounds(0, 0, 111, 172);
		this.loadImages(character.getImagePath());

		Integer level = character.getLevel();
		
		JLabel charPortraitLabel = new JLabel(level.toString());
		charPortraitLabel.setFont(new Font("Copperplate", Font.PLAIN, 14));
		charPortraitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		charPortraitLabel.setForeground(new Color(0, 0, 0));
		charPortraitLabel.setBounds(6, 91, 24, 24);
		this.add(charPortraitLabel);		
		
		JLabel charPortrait = new JLabel();
		charPortrait.setIcon(this.portrait);
		charPortrait.setBounds(6, 6, 99, 109);
		this.add(charPortrait);
		
		healthBar = new HealthBar(character);
		healthBar.setBounds(6, 121, 111, 20);
		this.add(healthBar);
	}

	private void loadImages(String path) {
		try {                
			this.portrait = new ImageIcon(ImageIO.read(new File(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
