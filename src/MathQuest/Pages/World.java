package MathQuest.Pages;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

		super(hero, MathQuest.class.getResource("Files/townMusic.mp3"));
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

		this.background = new ImageIcon(MathQuest.class.getResource("Files/world.jpg"));
		this.backgroundInnSelected = new ImageIcon(MathQuest.class.getResource("Files/worldInnSelected.jpg"));
		this.backgroundBlacksmithSelected = new ImageIcon(MathQuest.class.getResource("Files/worldBlacksmithSelected.jpg"));
		this.backgroundKillingFieldsSelected = new ImageIcon(MathQuest.class.getResource("Files/worldKillingFieldsSelected.jpg"));

	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this, this.hero, false);
	}
}
