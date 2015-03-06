package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import MathQuest.MathQuest;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

public class World extends Area {

	private static final long serialVersionUID = 1L;
	private ImageIcon blacksmithPortrait;
	private ImageIcon innPortrait;
	private ImageIcon killingFieldsPortrait;
	
	public World(Character hero) {
		super(hero);
		this.loadImages();
		
		JLabel innLabel = new JLabel();
		innLabel.setBounds(31, 320, 300, 300);
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
		blacksmithLabel.setBounds(762, 300, 300, 300);
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
		killingFieldsLabel.setBounds(362, 300, 300, 300);
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
		
		this.renderBackground();
	}
	
	public void loadImages() {
		try {           
			this.background = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
			this.blacksmithPortrait = new ImageIcon(ImageIO.read(new File("outsideBlacksmith2.png")));
			this.innPortrait = new ImageIcon(ImageIO.read(new File("outsideInn.png")));
			this.killingFieldsPortrait = new ImageIcon(ImageIO.read(new File("outsideInn.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this.hero, false);
	}
}
