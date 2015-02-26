package MathQuest.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Component;
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

public class World extends JPanel {

	private ImageIcon gameWorldBackground;
	private ImageIcon blacksmithPortrait;
	private ImageIcon innPortrait;
	private ImageIcon killingFieldsPortrait;
	boolean enabled = true;

	public World(Character hero) {
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.loadImages();
		
		final JPanel characterPanel = new CharacterPanel(hero);
		characterPanel.setBounds(6, 6, 112, 151);
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
				//	innLabel.
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

		final JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 1024, 768);
		add(lblNewLabel);
		lblNewLabel.setIcon(gameWorldBackground);
		lblNewLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(enabled) {
					for(Component el : getComponents()) {
						el.setEnabled(false);
					}
					for(Component el : characterPanel.getComponents()) {
						el.setEnabled(false);
					}
				}
				else {
					for(Component el : getComponents()) {
						el.setEnabled(true);
					}
				}
				enabled = !enabled;
				revalidate();
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}
	
	private void loadImages() {
		try {           
			this.gameWorldBackground = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
			this.blacksmithPortrait = new ImageIcon(ImageIO.read(new File("outsideBlacksmith2.png")));
			this.innPortrait = new ImageIcon(ImageIO.read(new File("outsideInn.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
