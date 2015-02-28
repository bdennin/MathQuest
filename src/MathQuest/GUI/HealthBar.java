package MathQuest.GUI;

import javax.swing.JPanel;

import MathQuest.Logic.Character;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HealthBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel healthBar;
	
	public HealthBar(Character character) {
		this.setLayout(null);
		this.setBounds(0, 0, 99, 22);
		
		final int life = character.getCurrentHealth();
		final int totalLife = character.getMaxHealth();
		double lifePercentage = (double)life/(double)totalLife;

		final JLabel lifeLabel = new JLabel();
		lifeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lifeLabel.setBounds(0, 0, 99, 22);
		add(lifeLabel);
		
		healthBar = new JPanel();
		healthBar.setBackground(Color.RED);
		healthBar.setBounds(0, 0, (int)(99*lifePercentage), 22);
		healthBar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lifeLabel.setText(life + "/" + totalLife);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lifeLabel.setText("");
			}
			
		});
		this.add(healthBar);
	}
}
