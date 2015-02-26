package MathQuest.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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

import java.awt.Font;

public class KillingFields extends JPanel {

	private ImageIcon killingFieldsBackground;
	private Character creature;
	
	public KillingFields(Character hero) {
		try {                
			killingFieldsBackground = new ImageIcon(ImageIO.read(new File("killingFields.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setLayout(null);
		
		JPanel characterPanel = new CharacterPanel(hero);
		characterPanel.setBounds(6, 6, 217, 121);
		add(characterPanel);
		characterPanel.setLayout(null);
				
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBounds(882, 639, 135, 101);
		add(optionsPanel);
		optionsPanel.setLayout(null);

		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.setBounds(6, 6, 125, 29);
		optionsPanel.add(inventoryButton);

		JButton optionsButton = new JButton("Return");
		optionsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToGameWorld();
			}
		});
		optionsButton.setBounds(6, 36, 125, 29);
		optionsPanel.add(optionsButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(6, 67, 125, 29);
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Character.save(character);
				System.exit(0);
			}
		});
		optionsPanel.add(quitButton);
		
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
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage gameWorldBack = (BufferedImage)killingFieldsBackground.getImage();
		g.drawImage(gameWorldBack, 0, 0, null);          

	}
}
