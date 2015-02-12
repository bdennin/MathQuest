import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;


public class GameWorld extends JPanel {
	
	private BufferedImage gameWorldBackground;
	private BufferedImage characterPortrait;
	
	public GameWorld() {
		try {                
	          gameWorldBackground = ImageIO.read(new File("gameworld.jpg"));
	          characterPortrait = ImageIO.read(new File("char.jpg"));
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
		        g.drawImage(characterPortrait, 0, 0, null);           
		    }
		};
		charPortrait.setBounds(6, 6, 99, 109);
		characterPanel.add(charPortrait);
		charPortrait.setLayout(null);
		
		JPanel charLevel = new JPanel();
		charLevel.setLayout(new GridLayout(1, 0, 0, 0));
		charLevel.setBounds(6, 85, 23, 18);
		charPortrait.add(charLevel);
		
		JLabel levelNumber = new JLabel("10");
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
		
		JLabel label = new JLabel("100/100");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(19, 21, 61, 16);
		charStats.add(label);
		
		JLabel lblNewLabel = new JLabel("0/1000");
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
		optionsPanel.add(quitButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(70, 519, 206, 139);
		add(lblNewLabel_1);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gameWorldBackground, 0, 0, null);             
    }
}
