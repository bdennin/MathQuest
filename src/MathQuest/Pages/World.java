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

	private JLabel innLabel;
	private JLabel blacksmithLabel;
	private JLabel killingFieldsLabel;
	
	private ImageIcon backgroundInnSelected;
	private ImageIcon backgroundBlacksmithSelected;
	private ImageIcon backgroundKillingFieldsSelected;
	
	public World(Character hero) {

		super(hero, "townMusic.mp3");
		this.loadImages();
		this.loadJLabels();
		this.renderBackground();
	}

	public void loadJLabels() {

		innLabel = new JLabel();
		innLabel.setBounds(548, 157, 468, 439);
		innLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				MathQuest.switchToInn();
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				backgroundLabel.setIcon(backgroundInnSelected);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backgroundLabel.setIcon(background);
			}
		});
		add(innLabel);

		blacksmithLabel = new JLabel();
		blacksmithLabel.setBounds(6, 161, 510, 435);
		blacksmithLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				MathQuest.switchToBlacksmith();
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				backgroundLabel.setIcon(backgroundBlacksmithSelected);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backgroundLabel.setIcon(background);
			}
		});
		add(blacksmithLabel);

		killingFieldsLabel = new JLabel();
		killingFieldsLabel.setBounds(301, 540, 573, 217);
		killingFieldsLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				MathQuest.switchToKillingFields();
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {
				backgroundLabel.setIcon(backgroundKillingFieldsSelected);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backgroundLabel.setIcon(background);
			}
		});
		add(killingFieldsLabel);
	}

	public void removeLabels() {
		this.remove(blacksmithLabel);
		this.remove(innLabel);
		this.remove(killingFieldsLabel);
	}
	
	public void loadImages() {
		try {           
			this.background = new ImageIcon(ImageIO.read(new File("world.jpg")));
			this.backgroundInnSelected = new ImageIcon(ImageIO.read(new File("worldInnSelected.jpg")));
			this.backgroundBlacksmithSelected = new ImageIcon(ImageIO.read(new File("worldBlacksmithSelected.jpg")));
			this.backgroundKillingFieldsSelected = new ImageIcon(ImageIO.read(new File("worldKillingFieldsSelected.jpg")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this, this.hero, false);
	}
}
