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

public class Inn extends JPanel {

	private ImageIcon characterPortrait;
	private ImageIcon gameWorldBackground;
	private ImageIcon blacksmithPortrait;
	private ImageIcon innPortrait;
	
	public Inn() {
		try {                
			
//			gameWorldBackground = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
			gameWorldBackground = new ImageIcon(ImageIO.read(new File("insideInn.png")));
			blacksmithPortrait = new ImageIcon(ImageIO.read(new File("blacksmith.jpg")));
			characterPortrait = new ImageIcon(ImageIO.read(new File("char.jpg")));
			innPortrait = new ImageIcon(ImageIO.read(new File("inn.jpg")));
			//hero = Character.load(database.getLogin())
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
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage gameWorldBack = (BufferedImage)gameWorldBackground.getImage();
		g.drawImage(gameWorldBack, 0, 0, null);          

	}
}
