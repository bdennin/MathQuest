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

public class World extends JPanel {

	private ImageIcon gameWorldBackground;
	private ImageIcon blacksmithPortrait;
	private ImageIcon innPortrait;
	private ImageIcon killingFieldsPortrait;

	public World() {
		try {           
			gameWorldBackground = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
			blacksmithPortrait = new ImageIcon(ImageIO.read(new File("outsideBlacksmith2.png")));
			innPortrait = new ImageIcon(ImageIO.read(new File("outsideInn.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(null);
		
		JPanel characterPanel = new CharacterPanel();
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

		JButton optionsButton = new JButton("Options");
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

		JLabel innLabel = new JLabel();
		innLabel.setBounds(83, 320, 300, 300);
		innLabel.setIcon(innPortrait);
		innLabel.setToolTipText("Travel to the inn!");
		innLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MathQuest.switchToInn();
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(innLabel);

		JLabel blacksmithLabel = new JLabel();
		blacksmithLabel.setBounds(762, 250, 300, 300);
		blacksmithLabel.setIcon(blacksmithPortrait);
		blacksmithLabel.setToolTipText("Travel to the blacksmith!");
		blacksmithLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MathQuest.switchToBlacksmith();
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(blacksmithLabel);

		JLabel killingFieldsLabel = new JLabel();
		killingFieldsLabel.setIcon(killingFieldsPortrait);
		killingFieldsLabel.setBounds(693, 300, 300, 300);
		killingFieldsLabel.setToolTipText("Travel to the killing fields!");
		killingFieldsLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MathQuest.switchToKillingFields();
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		add(killingFieldsLabel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage gameWorldBack = (BufferedImage)gameWorldBackground.getImage();
		g.drawImage(gameWorldBack, 0, 0, null);          

	}
}
