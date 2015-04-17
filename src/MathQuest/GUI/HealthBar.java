package MathQuest.GUI;

import javax.swing.JPanel;

import MathQuest.Logic.Character;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class HealthBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel healthBar;
	
	public HealthBar(Character character) {
		this.setLayout(null);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(0, 0, 99, 28);
		
		final int life = character.getCurrentHealth();
		final int totalLife = character.getMaxHealth();
		double lifePercentage = (double)life/(double)totalLife;

		final JLabel lifeLabel = new JLabel();
		lifeLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lifeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lifeLabel.setBounds(0, 0, 99, 28);
		add(lifeLabel);
		
		this.addMouseListener(new MouseListener() {

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

		healthBar = new JPanel();
		healthBar.setBackground(Color.RED);
		healthBar.setBounds(1, 1, (int)(97*lifePercentage), 26);
		this.add(healthBar);
	}
}
