package MathQuest.GUI;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import MathQuest.MathQuest;
import MathQuest.Logic.Character;

public class KillingFields extends Area {

	private static final long serialVersionUID = 1L;
	private Character creature;
	
	public KillingFields(Character hero) {
		super(hero);
		this.loadImages();
			
		JPanel panel = new JPanel();
		panel.setBounds(212, 184, 600, 400);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 588, 73);
		panel.add(panel_1);
		
		JLabel lblSelectYourBattle = new JLabel("Select your battle");
		lblSelectYourBattle.setFont(new Font("Copperplate", Font.PLAIN, 45));
		panel_1.add(lblSelectYourBattle);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 91, 588, 300);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton button = new JButton("Goblin");
		button.setBounds(231, 61, 117, 29);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(1, "Goblin", "Goblin.jpg");
				MathQuest.switchToCombat(creature);
			}	
		});
		panel_2.add(button);
		
		this.renderBackground();
	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this.hero, true);
	}

	@Override
	public void loadImages() {
		try {                
			this.background = new ImageIcon(ImageIO.read(new File("killingFields.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
