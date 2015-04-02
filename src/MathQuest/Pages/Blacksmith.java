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
import java.awt.Color;

public class Blacksmith extends Area {
	
	private static final long serialVersionUID = 1L;
	private JTextArea scrollText;
	final JPanel buttonPanel = new JPanel();
	final JPanel buyPanel, sellPanel, enhancePanel, armorPanel, weaponPanel;
	
	JComboBox inventoryComboBox, enhanceComboBox;
	
	private Item item1, item2;
	
	private static final Character character = new Character();
	
	public Blacksmith(final Character hero) {
		super(hero, "blacksmithMusic.mp3");
//		super(character, null);
		this.loadImages();
		this.loadOptionsPanel();
		
		int heroLevel = hero.getLevel();
		
		if(heroLevel < 5){
			item1 = new Item(heroLevel, "gray");
			item2 = new Item(heroLevel, "gray");
		}
		else if(heroLevel >= 5 && heroLevel < 10){
			item1 = new Item(heroLevel, "gray");
			item2 = new Item(heroLevel, "green");
		}
		else if(heroLevel >= 10 && heroLevel < 20){
			item1 = new Item(heroLevel, "green");
			item2 = new Item(heroLevel, "green");
		}
		else if(heroLevel >= 20){
			item1 = new Item(heroLevel, "green");
			item2 = new Item(heroLevel, "blue");
		}
		
		
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
					scrollText.append("Ok\n");
					buyPanel.setVisible(false);	
				}
				else{
					scrollText.append("I think you could handle these.\n");
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
				if(sellPanel.isVisible()){
					scrollText.append("Ok.\n");
					sellPanel.setVisible(false);
				}
				else{
					scrollText.append("Let's see what you have.\n");
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
		armorLabelPanel.setBounds(19, 19, 417, 52);
		buyPanel.add(armorLabelPanel);
		armorLabelPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Items for Sale");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 405, 40);
		armorLabelPanel.add(lblNewLabel);
		
		armorPanel = new JPanel();
		armorPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		armorPanel.setBounds(19, 83, 198, 198);
		buyPanel.add(armorPanel);
		armorPanel.setLayout(null);
		
		JLabel armorItemLabel = new JLabel(item1.toString());
		if(item1.getColor().equalsIgnoreCase("gray")){
			armorItemLabel.setForeground(Color.gray);
		}
		else if(item1.getColor().equalsIgnoreCase("green")){
			armorItemLabel.setForeground(Color.green);
		}
		else 
			armorItemLabel.setForeground(Color.blue);
		armorItemLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		armorItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		armorItemLabel.setBounds(6, 6, 186, 25);
		armorPanel.add(armorItemLabel);
		
		JLabel lblVit = new JLabel("Vitality:");
		lblVit.setBounds(6, 135, 61, 16);
		armorPanel.add(lblVit);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setBounds(6, 112, 61, 16);
		armorPanel.add(lblStrength);
		
		
		JLabel strNumber = new JLabel("" + item1.getItemStr());
		strNumber.setBounds(131, 112, 61, 16);
		armorPanel.add(strNumber);
		
		JLabel armorPrice = new JLabel("" + item1.getItemGold() + "g");
		armorPrice.setHorizontalAlignment(SwingConstants.CENTER);
		armorPrice.setBounds(65, 148, 61, 16);
		armorPanel.add(armorPrice);
		
		JButton btnBuyArmor = new JButton("Buy");
		btnBuyArmor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= item1.getItemGold()){
					armorPanel.setVisible(false);
					hero.addToInventory(item1);
					hero.removeGold(item1.getItemGold());
					inventoryComboBox.addItem(item1);
				}
				else{
					scrollText.append("You don't have enough for that\n");
				}
			}
		});
		btnBuyArmor.setBounds(39, 163, 117, 29);
		armorPanel.add(btnBuyArmor);
		
		JLabel vitLabel = new JLabel("" + item1.getItemVit());
		vitLabel.setBounds(131, 135, 61, 16);
		armorPanel.add(vitLabel);
		
		weaponPanel = new JPanel();
		weaponPanel.setLayout(null);
		weaponPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		weaponPanel.setBounds(238, 83, 198, 198);
		buyPanel.add(weaponPanel);
		
		JLabel weaponItemLabel = new JLabel(item2.toString());
		if(item2.getColor().equalsIgnoreCase("gray")){
			weaponItemLabel.setForeground(Color.GRAY);
		}
		else if(item2.getColor().equalsIgnoreCase("green")){
			weaponItemLabel.setForeground(Color.GREEN);
		}
		else{
			weaponItemLabel.setForeground(Color.BLUE);
		}
		weaponItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weaponItemLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		weaponItemLabel.setBounds(6, 6, 186, 25);
		weaponPanel.add(weaponItemLabel);
		
		JLabel lblWeaponStrength = new JLabel("Strength:");
		lblWeaponStrength.setBounds(6, 113, 61, 16);
		weaponPanel.add(lblWeaponStrength);
		
		JLabel lblWeaponVit = new JLabel("Vitality:");
		lblWeaponVit.setBounds(6, 133, 61, 16);
		weaponPanel.add(lblWeaponVit);
		
		JLabel weaponStrNumber = new JLabel("" + item2.getItemStr());
		weaponStrNumber.setBounds(131, 113, 61, 16);
		weaponPanel.add(weaponStrNumber);
		
		JLabel weaponPrice = new JLabel("" + item2.getItemGold() + "g");
		weaponPrice.setHorizontalAlignment(SwingConstants.CENTER);
		weaponPrice.setBounds(65, 148, 61, 16);
		weaponPanel.add(weaponPrice);
		
		JButton btnBuyWeapon = new JButton("Buy");
		btnBuyWeapon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= item2.getItemGold()){
					weaponPanel.setVisible(false);
					hero.addToInventory(item2);
					hero.removeGold(item2.getItemGold());
					inventoryComboBox.addItem(item2);
				}
				else{
					scrollText.append("You don't have enough for that\n");
				}
			}
		});
		btnBuyWeapon.setBounds(40, 163, 117, 29);
		weaponPanel.add(btnBuyWeapon);
		
		JLabel weaponVitLabel = new JLabel("" + item2.getItemVit());
		weaponVitLabel.setBounds(131, 133, 61, 16);
		weaponPanel.add(weaponVitLabel);
		
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
		
		inventoryComboBox = new JComboBox<Item>();
		inventoryComboBox.setBounds(6, 59, 233, 27);
		for(Item el : hero.getInventory())
			if(!el.isEquipped()){
				inventoryComboBox.addItem(el);
			}
		sellPanel.add(inventoryComboBox);
		
		JButton sellBtn = new JButton("Sell");
		sellBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item i = (Item)inventoryComboBox.getSelectedItem();
				hero.addGold(i.getItemGold());
				hero.removeFromInventory((Item)inventoryComboBox.getSelectedItem());
				inventoryComboBox.removeItem(inventoryComboBox.getSelectedItem());
				reloadInventoryPanel(false);
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
		
		enhanceComboBox = new JComboBox();
		enhanceComboBox.setBounds(6, 55, 233, 27);
		for(Item el : hero.getInventory())
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
