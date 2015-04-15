package MathQuest.GUI;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MathQuest.Logic.Character;
import MathQuest.Pages.Area;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class CharacterPanel extends JPanel {

	private static final long serialVersionUID = 1L;		
	private ImageIcon portrait;
	private ImageIcon fullPortrait;
	private ImageIcon magnifierImage;
	private HealthBar healthBar;
	private Character character;
	private boolean isMagnifiable;

	public CharacterPanel(final Area frame, Character character, boolean isLevelDisplayed, boolean isMagnifiable) {

		this.setLayout(null);
		this.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		this.setBounds(0, 0, 107, 144);
		this.isMagnifiable = isMagnifiable;
		this.character = character;
		this.loadImages(character.getImagePath());

		Integer level = character.getLevel();

		healthBar = new HealthBar(character);
		healthBar.setBounds(4, 112, 99, 28);
		this.add(healthBar);

		if(isLevelDisplayed) {

			JPanel levelPanel = new JPanel();
			levelPanel.setLayout(null);
			levelPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			levelPanel.setBounds(8, 89, 22, 20);
			add(levelPanel);

			JLabel levelLabel = new JLabel(level.toString());
			levelLabel.setBounds(0, 0, 22, 20);
			levelPanel.add(levelLabel);
			levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

		}

		JLabel charPortrait = new JLabel();
		charPortrait.setBounds(4, 4, 99, 109);
		charPortrait.setBorder(new LineBorder(new Color(0, 0, 0)));
		charPortrait.setIcon(this.portrait);
		if(this.isMagnifiable) {
			JLabel magnifier = new JLabel();
			magnifier.setBounds(72, 82, 25, 25);
			magnifier.setIcon(this.magnifierImage);
			charPortrait.add(magnifier);
			final JLabel fullPortrait = new JLabel();
			fullPortrait.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
			int height = this.fullPortrait.getIconHeight();
			int width = this.fullPortrait.getIconWidth();
			fullPortrait.setBounds((1024 - width)/2, (768 - height)/2 - 100, width, height);
			fullPortrait.setIcon(this.fullPortrait);
			magnifier.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					frame.add(fullPortrait);
					frame.renderBackground();
					frame.repaint();
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					frame.remove(fullPortrait);
					frame.renderBackground();
					frame.repaint();
				}

				@Override
				public void mousePressed(MouseEvent arg0) {

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {

				}

			});
		}
		add(charPortrait);
	}

	private void loadImages(String path) {
		try {                
			this.portrait = new ImageIcon(ImageIO.read(new File(path)));
			if(isMagnifiable) {
				this.fullPortrait = new ImageIcon(ImageIO.read(new File("src/MathQuest/Files/" + character.getName() + ".jpg")));
				this.magnifierImage = new ImageIcon(ImageIO.read(new File("src/MathQuest/Files/magnifier.png")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
