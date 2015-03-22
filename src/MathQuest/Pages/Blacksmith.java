package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;

public class Blacksmith extends Area {
	
	private static final long serialVersionUID = 1L;
	private JTextArea scrollText;
	final JPanel blacksmithPanel = new JPanel();
	final JPanel buttonPanel = new JPanel();
	final JPanel buyPanel = new JPanel();
	final JLabel swordImage, swordImage2, shieldImage, shieldImage2, helmetImage, chestImage, armsImage, legsImage;
	private ImageIcon swIcon, swIcon2, shIcon, shIcon2, helmIcon, chestIcon, armIcon, legIcon;
	
	public Blacksmith(Character hero) {
			super(hero, "blacksmithMusic.mp3");
			this.loadImages();
			this.loadOptionsPanel();

//////////////////////////////////////////////
// Panel for the Text Area and Three Buttons//
//////////////////////////////////////////////
			blacksmithPanel.setBounds(150, 590, 724, 150);
			add(blacksmithPanel);
			blacksmithPanel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 6, 344, 138);
			blacksmithPanel.add(scrollPane);

			this.scrollText = new JTextArea();
			this.scrollText.setEditable(false);
			this.scrollText.setLineWrap(true);
			this.scrollText.setWrapStyleWord(true);
			scrollPane.setViewportView(scrollText);
			this.scrollText.append("Hello! I am the town Blacksmith. How can I help you?\n");

			buttonPanel.setBounds(362, 6, 356, 138);
			blacksmithPanel.add(buttonPanel);
			buttonPanel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(125, 6, 107, 126);
			buttonPanel.add(panel_1);
			panel_1.setLayout(null);

			JButton btnBuyItems = new JButton("Buy Items");
			btnBuyItems.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					openBlacksmithInventory();
				}
			});
			btnBuyItems.setBounds(0, 0, 101, 120);
			panel_1.add(btnBuyItems);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(244, 6, 107, 126);
			buttonPanel.add(panel_2);
			panel_2.setLayout(null);

			JButton btnImproveItems = new JButton("Improve Items");
			btnImproveItems.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scrollText.append("I can make anything stronger.\n");
					buyPanel.setVisible(false);
				}
			});
			btnImproveItems.setBounds(0, 0, 106, 120);
			panel_2.add(btnImproveItems);

			JPanel panel_3 = new JPanel();
			panel_3.setBounds(6, 6, 107, 126);
			buttonPanel.add(panel_3);
			panel_3.setLayout(null);


			JButton btnSellItems = new JButton("Sell Items");
			btnSellItems.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scrollText.append("Let's see what you have?\n");
					buyPanel.setVisible(false);
				}
			});
			
			btnSellItems.setBounds(0, 0, 101, 120);
			panel_3.add(btnSellItems);
			
///////////////////////////////////////			
// Panel For Buying Armor and Weapons//
//////////////////////////////////////
			buyPanel.setBounds(164, 200, 691, 367);
			buyPanel.setVisible(false);
			add(buyPanel);
			buyPanel.setLayout(null);
			
			JPanel swordPanel = new JPanel();
			swordPanel.setBounds(6, 6, 160, 170);
			buyPanel.add(swordPanel);
			swordPanel.setLayout(null);
			
			swordImage = new JLabel();
			swordImage.setHorizontalAlignment(SwingConstants.CENTER);
			swordImage.setBounds(6, 6, 148, 123);
			swordImage.setIcon(swIcon);
			
			swordPanel.add(swordImage);
			swordImage.setLayout(null);
			
			JButton btnBuySword = new JButton("Buy");
			btnBuySword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// make sure character can buy item first 
					scrollText.append("Don't hurt yourself.\n");
				}
			});
			btnBuySword.setBounds(6, 135, 148, 29);
			swordPanel.add(btnBuySword);
			
			JPanel swordPanel2 = new JPanel();
			swordPanel2.setBounds(178, 6, 160, 170);
			buyPanel.add(swordPanel2);
			swordPanel2.setLayout(null);
			
			swordImage2 = new JLabel();
			swordImage2.setHorizontalAlignment(SwingConstants.CENTER);
			swordImage2.setBounds(6, 6, 148, 123);
			swordImage2.setIcon(swIcon2);
			swordPanel2.add(swordImage2);
			swordImage2.setLayout(null);
			
			JButton btnBuySword2 = new JButton("Buy");
			btnBuySword2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// make sure character can buy item first 
					scrollText.append("Careful, this thing is sharp.\n");
				}
			});
			btnBuySword2.setBounds(6, 135, 148, 29);
			swordPanel2.add(btnBuySword2);
			
			JPanel shieldPanel2 = new JPanel();
			shieldPanel2.setBounds(522, 6, 160, 170);
			buyPanel.add(shieldPanel2);
			shieldPanel2.setLayout(null);
			
			shieldImage2 = new JLabel();
			shieldImage2.setHorizontalAlignment(SwingConstants.CENTER);
			shieldImage2.setBounds(6, 6, 148, 123);
			shieldImage2.setIcon(shIcon2);
			shieldPanel2.add(shieldImage2);
			shieldImage2.setLayout(null);
			
			JButton btnBuyShield2 = new JButton("Buy");
			btnBuyShield2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// make sure character can buy item first 
					scrollText.append("This will definitely save your life out there.\n");
				}
			});
			btnBuyShield2.setBounds(6, 135, 148, 29);
			shieldPanel2.add(btnBuyShield2);
			
			JPanel shieldPanel = new JPanel();
			shieldPanel.setBounds(350, 6, 160, 170);
			buyPanel.add(shieldPanel);
			shieldPanel.setLayout(null);
			
			shieldImage = new JLabel();
			shieldImage.setHorizontalAlignment(SwingConstants.CENTER);
			shieldImage.setBounds(6, 6, 148, 123);
			shieldImage.setIcon(shIcon);
			shieldPanel.add(shieldImage);
			shieldImage.setLayout(null);
			
			JButton btnBuyShield = new JButton("Buy");
			btnBuyShield.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//make sure character can buy item first 
					scrollText.append("This might help you out there\n");
				}
			});
			btnBuyShield.setBounds(6, 135, 148, 29);
			shieldPanel.add(btnBuyShield);
			
			JPanel helmetPanel = new JPanel();
			helmetPanel.setBounds(6, 188, 160, 170);
			buyPanel.add(helmetPanel);
			helmetPanel.setLayout(null);
			
			helmetImage = new JLabel();
			helmetImage.setHorizontalAlignment(SwingConstants.CENTER);
			helmetImage.setLayout(null);
			helmetImage.setBounds(6, 6, 148, 123);
			helmetImage.setIcon(helmIcon);
			helmetPanel.add(helmetImage);
			
			JButton btnBuyHelmet = new JButton("Buy");
			btnBuyHelmet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//make sure character can buy item first
					scrollText.append("This will save you from a concussion.\n");
				}
			});
			btnBuyHelmet.setBounds(6, 135, 148, 29);
			helmetPanel.add(btnBuyHelmet);
			
			JPanel chestPanel = new JPanel();
			chestPanel.setBounds(178, 188, 160, 170);
			buyPanel.add(chestPanel);
			chestPanel.setLayout(null);
			
			chestImage = new JLabel();
			chestImage.setHorizontalAlignment(SwingConstants.CENTER);
			chestImage.setLayout(null);
			chestImage.setBounds(6, 6, 148, 123);
			chestImage.setIcon(chestIcon);
			chestPanel.add(chestImage);
			
			JButton btnBuyChest = new JButton("Buy");
			btnBuyChest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//make sure character can buy item first
					scrollText.append("Now you won't get the wind knocked out of you.\n");
				}
			});
			btnBuyChest.setBounds(6, 135, 148, 29);
			chestPanel.add(btnBuyChest);
			
			JPanel armsPanel = new JPanel();
			armsPanel.setBounds(350, 188, 160, 170);
			buyPanel.add(armsPanel);
			armsPanel.setLayout(null);
			
			armsImage = new JLabel();
			armsImage.setHorizontalAlignment(SwingConstants.CENTER);
			armsImage.setLayout(null);
			armsImage.setBounds(6, 6, 148, 123);
			armsImage.setIcon(armIcon);
			armsPanel.add(armsImage);
			
			JButton btnBuyArms = new JButton("Buy");
			btnBuyArms.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//make sure character can buy item first
					scrollText.append("You definitely look stronger with those.\n");
				}
			});
			btnBuyArms.setBounds(6, 135, 148, 29);
			armsPanel.add(btnBuyArms);
			
			JPanel legsPanel = new JPanel();
			legsPanel.setBounds(522, 188, 160, 170);
			buyPanel.add(legsPanel);
			legsPanel.setLayout(null);
			
			legsImage = new JLabel();
			legsImage.setHorizontalAlignment(SwingConstants.CENTER);
			legsImage.setLayout(null);
			legsImage.setBounds(6, 6, 148, 123);
			legsImage.setIcon(legIcon);
			legsPanel.add(legsImage);
			
			JButton btnBuyLegs = new JButton("Buy");
			btnBuyLegs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//make sure character can buy item first
					scrollText.append("They might be slow but they'll save your legs.\n");
				}
			});
			btnBuyLegs.setBounds(6, 135, 148, 29);
			legsPanel.add(btnBuyLegs);

///////////////////////////////////////////////////////////
//Still need Panels for Selling Items and Enhancing Items//
///////////////////////////////////////////////////////////

			this.renderBackground();
	}
	
	public void openBlacksmithInventory(){
		if(buyPanel.isVisible()){
			scrollText.append("Be safe.");
			buyPanel.setVisible(false);
		}
		else{
			scrollText.append("I have the finest wares in the land.\n");
			buyPanel.setVisible(true);
		}
	}
	
	public void buyItem(){
		//take gold from character and give character item
		
	}
	
	//need methods for selling items and enhancing items, need inventory of character for them
	
	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this.hero, true);
	}

	@Override
	public void loadImages() {
		try {           
			this.background = new ImageIcon(ImageIO.read(new File("insideBlacksmith.jpg")));
			swIcon = new ImageIcon(ImageIO.read(new File("crappySword.png")));
			swIcon2 = new ImageIcon(ImageIO.read(new File("goodSword.png")));
			shIcon = new ImageIcon(ImageIO.read(new File("crappyShield.png")));
			shIcon2 = new ImageIcon(ImageIO.read(new File("goodShield.png")));
			helmIcon = new ImageIcon(ImageIO.read(new File("helmet.png")));
			chestIcon = new ImageIcon(ImageIO.read(new File("chestPlate.png")));
			armIcon = new ImageIcon(ImageIO.read(new File("gauntlets.png")));
			legIcon = new ImageIcon(ImageIO.read(new File("boots.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
