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
import MathQuest.Logic.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;

public class Blacksmith extends Area {
	
	private static final long serialVersionUID = 1L;
	private JTextArea scrollText;
	final JPanel buttonPanel = new JPanel();
	final JPanel buyPanel, sellPanel, enhancePanel;
	
	private ImageIcon panelImage, armorImage, weaponImage;
	
	private static Character character = new Character();
	
	
	public Blacksmith(Character hero) {
//			super(hero, "blacksmithMusic.mp3");
		super(character, null);
		this.loadImages();
		this.loadOptionsPanel();
		buttonPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		
		buttonPanel.setBounds(516, 599, 356, 138);
		add(buttonPanel);
		buttonPanel.setLayout(null);
									
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 107, 126);
		buttonPanel.add(panel_1);
		panel_1.setLayout(null);
												
		JButton btnBuyItems = new JButton("Buy Items");
		btnBuyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buyPanel.isVisible()){
					
					buyPanel.setVisible(false);	
				}
				else{
					buyPanel.setVisible(true);
				}
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
				if(enhancePanel.isVisible()){
					enhancePanel.setVisible(false);
				}
				else{
					enhancePanel.setVisible(true);
				}
			}
		});
		btnImproveItems.setBounds(0, 0, 106, 120);
		panel_2.add(btnImproveItems);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(125, 6, 107, 126);
		buttonPanel.add(panel_3);
		panel_3.setLayout(null);
		
		
		JButton btnSellItems = new JButton("Sell Items");
		btnSellItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollText.append("Let's see what you have?\n");
				if(sellPanel.isVisible()){
					sellPanel.setVisible(false);
				}
				else{
					sellPanel.setVisible(true);
				}
			}
		});
		
		btnSellItems.setBounds(0, 0, 101, 120);
		panel_3.add(btnSellItems);
																											
		buyPanel = new JPanel();
		buyPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		buyPanel.setBounds(267, 260, 456, 312);
		buyPanel.setVisible(false);
		add(buyPanel);
		buyPanel.setLayout(null);
		
		JPanel armorLabelPanel = new JPanel();
		armorLabelPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		armorLabelPanel.setBounds(19, 19, 198, 52);
		buyPanel.add(armorLabelPanel);
		armorLabelPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Armor");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 186, 40);
		armorLabelPanel.add(lblNewLabel);
		
		JPanel weaponLabelPanel = new JPanel();
		weaponLabelPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		weaponLabelPanel.setBounds(238, 19, 198, 52);
		buyPanel.add(weaponLabelPanel);
		weaponLabelPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Weapons");
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 6, 186, 40);
		weaponLabelPanel.add(lblNewLabel_1);
		
		JPanel armorPanel = new JPanel();
		armorPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		armorPanel.setBounds(19, 83, 198, 198);
		buyPanel.add(armorPanel);
		armorPanel.setLayout(null);
		
		JComboBox armorComboBox = new JComboBox();
		armorComboBox.setBounds(6, 6, 186, 36);
		armorPanel.add(armorComboBox);
		
		JPanel weaponPanel = new JPanel();
		weaponPanel.setLayout(null);
		weaponPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		weaponPanel.setBounds(238, 83, 198, 198);
		buyPanel.add(weaponPanel);
		
		JComboBox weaponComboBox = new JComboBox();
		weaponComboBox.setBounds(6, 6, 186, 36);
		weaponPanel.add(weaponComboBox);
		
		JPanel textPanel = new JPanel();
		textPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		textPanel.setBounds(166, 599, 338, 138);
		add(textPanel);
		textPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 326, 128);
		textPanel.add(scrollPane);
		
		this.scrollText = new JTextArea();
		this.scrollText.setEditable(false);
		this.scrollText.setLineWrap(true);
		this.scrollText.setWrapStyleWord(true);
		scrollPane.setColumnHeaderView(scrollText);
		this.scrollText.append("Hello! I am the town Blacksmith. How can I help you?\n");
		
		sellPanel = new JPanel();
		sellPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		sellPanel.setBounds(735, 260, 245, 150);
		sellPanel.setVisible(false);
		add(sellPanel);
		sellPanel.setLayout(null);
		
		JPanel sellLabelPanel = new JPanel();
		sellLabelPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		sellLabelPanel.setBounds(6, 6, 233, 41);
		sellPanel.add(sellLabelPanel);
		sellLabelPanel.setLayout(null);
		
		JLabel sellLabel = new JLabel("Sell Items");
		sellLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		sellLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sellLabel.setBounds(6, 6, 221, 29);
		sellLabelPanel.add(sellLabel);
		
		JComboBox inventoryComboBox = new JComboBox();
		inventoryComboBox.setBounds(6, 59, 233, 27);
		for(Item el : hero.getHeadItems())
			inventoryComboBox.addItem(el);
		for(Item el : hero.getChestItems())
			inventoryComboBox.addItem(el);
		for(Item el : hero.getGloveItems())
			inventoryComboBox.addItem(el);
		for(Item el : hero.getFeetItems())
			inventoryComboBox.addItem(el);
		sellPanel.add(inventoryComboBox);
		
		JButton sellBtn = new JButton("Sell");
		sellBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		sellBtn.setBounds(56, 98, 117, 35);
		sellPanel.add(sellBtn);
		
		enhancePanel = new JPanel();
		enhancePanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		enhancePanel.setBounds(735, 422, 245, 150);
		enhancePanel.setVisible(false);
		add(enhancePanel);
		enhancePanel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		panel_4.setBounds(6, 6, 233, 37);
		enhancePanel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Improve Items");
		lblNewLabel_2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 221, 25);
		panel_4.add(lblNewLabel_2);
		
		JComboBox enhanceComboBox = new JComboBox();
		enhanceComboBox.setBounds(6, 55, 233, 27);
		for(Item el : hero.getHeadItems())
			enhanceComboBox.addItem(el);
		for(Item el : hero.getChestItems())
			enhanceComboBox.addItem(el);
		for(Item el : hero.getGloveItems())
			enhanceComboBox.addItem(el);
		for(Item el : hero.getFeetItems())
			enhanceComboBox.addItem(el);
		enhancePanel.add(enhanceComboBox);
		
		JButton enhancheBtn = new JButton("Improve");
		enhancheBtn.setBounds(56, 98, 117, 35);
		enhancePanel.add(enhancheBtn);
			

			this.renderBackground();
	}
	
	
	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this, this.hero, true);
	}

	@Override
	public void loadImages() {
		try {           
			this.background = new ImageIcon(ImageIO.read(new File("insideBlacksmith.jpg")));
			this.panelImage = new ImageIcon(ImageIO.read(new File("wood.png")));
			this.armorImage = new ImageIcon(ImageIO.read(new File("goodShield.png")));
			this.weaponImage = new ImageIcon(ImageIO.read(new File("crappySword.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
