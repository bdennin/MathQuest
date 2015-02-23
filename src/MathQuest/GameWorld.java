package MathQuest;

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

public class GameWorld extends JPanel {

	private ImageIcon characterPortrait;
	private ImageIcon gameWorldBackground;
	private ImageIcon blacksmithPortrait;
	private ImageIcon innPortrait;
	private ImageIcon killingFieldsPortrait;
	
	public GameWorld() {
		try {           
	          gameWorldBackground = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
	          characterPortrait = new ImageIcon(ImageIO.read(new File("char.jpg")));
	          blacksmithPortrait = new ImageIcon(ImageIO.read(new File("blacksmith.jpg")));
//	          innPortrait = new ImageIcon(ImageIO.read(new File("inn.jpg")));
	          innPortrait = new ImageIcon(ImageIO.read(new File("outsideInn.png")));
	       } catch (IOException e) {
	    	   e.printStackTrace();
	       }
		setLayout(null);
		
		JPanel characterPanel = new JPanel();
		characterPanel.setBounds(6, 6, 217, 121);
		add(characterPanel);
		characterPanel.setLayout(null);
		
		JPanel charPortrait = new JPanel() {
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        BufferedImage charPortrait = (BufferedImage)characterPortrait.getImage();
		        g.drawImage(charPortrait, 0, 0, null);           
		    }
		};
		
		Character hero = MathQuest.getCharacter();
		Integer level = hero.getLevel();
		Integer currentExp = (int) hero.getCurrentExperience();
		Integer maxExp = (int) hero.getMaxExperience();
		Integer currentLife = hero.getCurrentHealth();
		Integer maxLife = hero.getMaxHealth();
		String expBar = new String(currentExp + "/" + maxExp);
		String lifeBar = new String(currentLife + "/" + maxLife);
		
		charPortrait.setBounds(6, 6, 99, 109);
		characterPanel.add(charPortrait);
		charPortrait.setLayout(null);
		
		JPanel charLevel = new JPanel();
		charLevel.setLayout(new GridLayout(1, 0, 0, 0));
		charLevel.setBounds(6, 85, 23, 18);
		charPortrait.add(charLevel);
		
		JLabel levelNumber = new JLabel(level.toString()); //char level
		levelNumber.setHorizontalAlignment(SwingConstants.CENTER);
		charLevel.add(levelNumber);
		
		JPanel charStats = new JPanel();
		charStats.setBounds(111, 6, 99, 109);
		characterPanel.add(charStats);
		charStats.setLayout(null);
		
		JLabel lblHp = new JLabel("HP");
		lblHp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHp.setBounds(19, 6, 61, 16);
		charStats.add(lblHp);
		
		JLabel lblXp = new JLabel("XP");
		lblXp.setHorizontalAlignment(SwingConstants.CENTER);
		lblXp.setBounds(19, 61, 61, 16);
		charStats.add(lblXp);
		
		
		JLabel label = new JLabel(lifeBar); //character.getCurrentLife(), character.getTotalLife();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(19, 21, 61, 16);
		charStats.add(label);
		
		JLabel lblNewLabel = new JLabel(expBar); //character.getCurrentExperience(), character.getMaxExperience();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(19, 77, 61, 16);
		charStats.add(lblNewLabel);
		
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
		blacksmithLabel.setBounds(362, 300, 300, 300);
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
