package MathQuest.GUI;

import javax.swing.JPanel;
import MathQuest.Logic.Character;
import java.awt.Color;

public class HealthBar extends JPanel {

	private JPanel healthBar;
	
	public HealthBar(Character character) {
		this.setLayout(null);
		this.setBounds(0, 0, 99, 30);
		
		int life = character.getCurrentHealth();
		int totalLife = character.getMaxHealth();
		double lifePercentage = (double)life/(double)totalLife;
		
		healthBar = new JPanel();
		healthBar.setBackground(Color.RED);
		healthBar.setBounds(0, 0, (int)(99*lifePercentage), 30);
		this.add(healthBar);
	}
}
