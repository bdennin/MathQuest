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
import MathQuest.Logic.Monster;

public class CombatPanel extends JPanel {

	private ImageIcon gameWorldBackground;
	private Monster creature;
	
	public CombatPanel(Monster monster) {
		try {                
			gameWorldBackground = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.creature = monster;
		setLayout(null);
		
		JPanel characterPanel = new CharacterPanel();
		characterPanel.setBounds(6, 6, 217, 121);
		add(characterPanel);
		characterPanel.setLayout(null);
		
		CharacterPanel monsterPanel = new CharacterPanel(monster);
		monsterPanel.setBounds(801, 6, 217, 121);
		add(monsterPanel);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBounds(882, 639, 135, 101);
		add(optionsPanel);
		optionsPanel.setLayout(null);

		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.setBounds(6, 6, 125, 29);
		optionsPanel.add(inventoryButton);

		JButton optionsButton = new JButton("Run Away");
		optionsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToGameWorld();
			}
		});
		optionsButton.setBounds(6, 36, 125, 29);
		optionsPanel.add(optionsButton);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage gameWorldBack = (BufferedImage)gameWorldBackground.getImage();
		g.drawImage(gameWorldBack, 0, 0, null);          
	}
}
