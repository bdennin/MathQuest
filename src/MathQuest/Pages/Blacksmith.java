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
import MathQuest.GUI.LogPanel;

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
import javax.swing.Icon;

public class Blacksmith extends Area {
	
	private static final long serialVersionUID = 1L;
	private LogPanel scrollPane;
	final JPanel buttonPanel = new JPanel();
	final JPanel itemsPanel, buyPanel, sellPanel, enhancePanel, itemPanel1, itemPanel2;
	private ImageIcon buyButtonIcon, sellButtonIcon, enhanceButtonIcon;
	
	private JComboBox inventoryComboBox, enhanceComboBox;
	
	private Item item1, item2;
	
	private static final Character character = new Character();
	
	public Blacksmith(final Character hero) {
		super(hero, "blacksmithMusic.mp3");
//		super(character, null);
		this.loadImages();
		this.loadOptionsPanel();
		
		int heroLevel = hero.getLevel();

//////////////////////////////////////////////
// generates Items the blacksmith will sell //
//////////////////////////////////////////////
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
//////////////////////////////////////////		
// Panel for buy, sell, enhance buttons //
//////////////////////////////////////////
		buttonPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		buttonPanel.setBounds(587, 612, 269, 77);
		add(buttonPanel);
		buttonPanel.setLayout(null);
		
		//Buy Button
		JButton btnBuyItems = new JButton(this.buyButtonIcon);
		btnBuyItems.setBounds(3, 3, 88, 70);
		buttonPanel.add(btnBuyItems);
		btnBuyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buyPanel.isVisible()){
					scrollPane.addTextToScrollPane("Ok.");
					buyPanel.setVisible(false);	
				}
				else{
					scrollPane.addTextToScrollPane("I think you could handle these.");
					buyPanel.setVisible(true);
				}
			}
		});
		
		//Sell Button
		JButton btnSellItems = new JButton(this.sellButtonIcon);
		btnSellItems.setBounds(90, 3, 88, 70);
		buttonPanel.add(btnSellItems);
		btnSellItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sellPanel.isVisible()){
					scrollPane.addTextToScrollPane("Ok.");
					sellPanel.setVisible(false);
				}
				else{
					scrollPane.addTextToScrollPane("Let's see what you have.");
					sellPanel.setVisible(true);
				}
			}
		});
		
		//Enhance Button
		JButton btnImproveItems = new JButton(this.enhanceButtonIcon);
		btnImproveItems.setBounds(177, 3, 88, 70);
		buttonPanel.add(btnImproveItems);
		btnImproveItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.addTextToScrollPane("I can make anything stronger.");
				if(enhancePanel.isVisible()){
					enhancePanel.setVisible(false);
				}
				else{
					enhancePanel.setVisible(true);
				}
			}
		});
		

//Blacksmith text panel
		scrollPane = new LogPanel("Blacksmith Log");
		add(scrollPane);
		this.scrollPane.addTextToScrollPane("Hello! I am the town Blacksmith. How can I help you?");
//////////////////////////
// Sell Inventory Panel //
//////////////////////////
		sellPanel = new JPanel();
		sellPanel.setBackground(Color.LIGHT_GRAY);
		sellPanel.setBounds(735, 260, 245, 116);
		sellPanel.setVisible(false);
		add(sellPanel);
		sellPanel.setLayout(null);
		
		//panel for sell button and combo box
		JPanel sellOptionsPanel = new JPanel();
		sellOptionsPanel.setBounds(1, 29, 244, 87);
		sellPanel.add(sellOptionsPanel);
		sellOptionsPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		sellOptionsPanel.setLayout(null);
		
		//sell combo box
		inventoryComboBox = new JComboBox<Item>();
		inventoryComboBox.setBounds(6, 6, 233, 27);
		for(Item el : hero.getInventory())
			if(!el.isEquipped()){
				inventoryComboBox.addItem(el);
			}
		sellOptionsPanel.add(inventoryComboBox);
		
		//sell button
		JButton sellBtn = new JButton("Sell");
		sellBtn.setBounds(56, 45, 117, 35);
		sellOptionsPanel.add(sellBtn);
		sellBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item i = (Item)inventoryComboBox.getSelectedItem();
				hero.addGold(i.getItemGold());
				hero.removeFromInventory((Item)inventoryComboBox.getSelectedItem());
				inventoryComboBox.removeItem(inventoryComboBox.getSelectedItem());
				reloadInventoryPanel(false);
			}
		});
		
		//Label for name of panel
		JLabel sellLabel = new JLabel("Sell Items");
		sellLabel.setBackground(Color.LIGHT_GRAY);
		sellLabel.setBounds(1, 0, 244, 29);
		sellPanel.add(sellLabel);
		sellLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		sellLabel.setHorizontalAlignment(SwingConstants.CENTER);

/////////////////////////
// Enhance Items Panel //
/////////////////////////
		enhancePanel = new JPanel();
		enhancePanel.setBackground(Color.LIGHT_GRAY);
		enhancePanel.setBounds(735, 422, 245, 132);
		enhancePanel.setVisible(false);
		add(enhancePanel);
		enhancePanel.setLayout(null);
		
		//Panel for enhance button and enhance combo box
		JPanel enhanceOptionsPanel = new JPanel();
		enhanceOptionsPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		enhanceOptionsPanel.setBounds(0, 24, 245, 108);
		enhancePanel.add(enhanceOptionsPanel);
		enhanceOptionsPanel.setLayout(null);
		
		//combo box that loads equipped inventory to enhance
		enhanceComboBox = new JComboBox();
		enhanceComboBox.setBounds(6, 6, 233, 27);
		enhanceOptionsPanel.add(enhanceComboBox);
		for(Item el : hero.getInventory())
			if(el.isEquipped()){
				enhanceComboBox.addItem(el);
			}
		
		//Button to enhance items if character has enough gold
		JButton enhancheBtn = new JButton("Improve");
		enhancheBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item i = (Item) enhanceComboBox.getSelectedItem();
				if(hero.getGold() >= (i.getItemGold() * 3)){
					i.enhanceItem();
				}
				else{
					scrollPane.addTextToScrollPane("You Don't have enough.");
				}
			}
		});
		enhancheBtn.setBounds(51, 67, 117, 35);
		enhanceOptionsPanel.add(enhancheBtn);
		
		if(null != enhanceComboBox.getSelectedItem()){
			Item i = (Item)enhanceComboBox.getSelectedItem();
			JLabel lblNewLabel_1 = new JLabel("" + i.getItemGold() + "g");
			lblNewLabel_1.setBounds(79, 39, 61, 16);
			enhanceOptionsPanel.add(lblNewLabel_1);
		}
		
		//Label for title of enhance panel
		JLabel lblNewLabel_2 = new JLabel("Improve Items");
		lblNewLabel_2.setBounds(0, 0, 245, 25);
		enhancePanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
////////////////////////////////////		
//Panel for items blacksmith sells//
////////////////////////////////////
		buyPanel = new JPanel();
		buyPanel.setBackground(Color.LIGHT_GRAY);
		buyPanel.setBounds(206, 225, 457, 248);
		buyPanel.setVisible(false);
		add(buyPanel);
		buyPanel.setLayout(null);
		
		//panel for items on sale
		itemsPanel = new JPanel();
		itemsPanel.setBounds(0, 36, 456, 212);
		buyPanel.add(itemsPanel);
		itemsPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		itemsPanel.setLayout(null);
		
		//panel for first item's labels and buy button
		itemPanel1 = new JPanel();
		itemPanel1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		itemPanel1.setBounds(6, 6, 198, 198);
		itemsPanel.add(itemPanel1);
		itemPanel1.setLayout(null);
		
		//Item 1 name Label
		JLabel armorItemLabel = new JLabel(item1.toString());
		armorItemLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		armorItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		armorItemLabel.setBounds(6, 6, 186, 25);
		itemPanel1.add(armorItemLabel);
		if(item1.getColor().equalsIgnoreCase("gray")){
			armorItemLabel.setForeground(Color.black);
		}
		else if(item1.getColor().equalsIgnoreCase("green")){
			armorItemLabel.setForeground(Color.green);
		}
		else 
			armorItemLabel.setForeground(Color.blue);
		
		//Labels to display item 1 vitality, strength and price
		JLabel lblVit = new JLabel("Vitality:");
		lblVit.setBounds(6, 135, 61, 16);
		itemPanel1.add(lblVit);
		JLabel vitLabel = new JLabel("" + item1.getItemVit());
		vitLabel.setBounds(131, 135, 61, 16);
		itemPanel1.add(vitLabel);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setBounds(6, 112, 61, 16);
		itemPanel1.add(lblStrength);
		JLabel strNumber = new JLabel("" + item1.getItemStr());
		strNumber.setBounds(131, 112, 61, 16);
		itemPanel1.add(strNumber);
		
		JLabel armorPrice = new JLabel("" + item1.getItemGold() + "g");
		armorPrice.setHorizontalAlignment(SwingConstants.CENTER);
		armorPrice.setBounds(65, 148, 61, 16);
		itemPanel1.add(armorPrice);
		
		//button to buy item 1
		JButton btnBuyArmor = new JButton("Buy");
		btnBuyArmor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= item1.getItemGold()){
					itemPanel1.setVisible(false);
					hero.addToInventory(item1);
					hero.removeGold(item1.getItemGold());
					inventoryComboBox.addItem(item1);
				}
				else{
					scrollPane.addTextToScrollPane("You don't have enough for that.");
				}
			}
		});
		btnBuyArmor.setBounds(39, 163, 117, 29);
		itemPanel1.add(btnBuyArmor);
		
		
		//panel for item 2's stats and buy button
		itemPanel2 = new JPanel();
		itemPanel2.setLayout(null);
		itemPanel2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		itemPanel2.setBounds(252, 6, 198, 198);
		itemsPanel.add(itemPanel2);
		
		//Label for item 2 name
		JLabel weaponItemLabel = new JLabel(item2.toString());
		weaponItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weaponItemLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		weaponItemLabel.setBounds(6, 6, 186, 25);
		itemPanel2.add(weaponItemLabel);
		if(item2.getColor().equalsIgnoreCase("gray")){
			weaponItemLabel.setForeground(Color.black);
		}
		else if(item2.getColor().equalsIgnoreCase("green")){
			weaponItemLabel.setForeground(Color.green);
		}
		else{
			weaponItemLabel.setForeground(Color.green);
		}
		
		//item 2 vitality, strength, and price
		JLabel lblWeaponStrength = new JLabel("Strength:");
		lblWeaponStrength.setBounds(6, 113, 61, 16);
		itemPanel2.add(lblWeaponStrength);
		JLabel weaponStrNumber = new JLabel("" + item2.getItemStr());
		weaponStrNumber.setBounds(131, 113, 61, 16);
		itemPanel2.add(weaponStrNumber);
		
		JLabel lblWeaponVit = new JLabel("Vitality:");
		lblWeaponVit.setBounds(6, 133, 61, 16);
		itemPanel2.add(lblWeaponVit);
		JLabel weaponVitLabel = new JLabel("" + item2.getItemVit());
		weaponVitLabel.setBounds(131, 133, 61, 16);
		itemPanel2.add(weaponVitLabel);
		
		JLabel weaponPrice = new JLabel("" + item2.getItemGold() + "g");
		weaponPrice.setHorizontalAlignment(SwingConstants.CENTER);
		weaponPrice.setBounds(65, 148, 61, 16);
		itemPanel2.add(weaponPrice);
		
		//Button to buy item 2
		JButton btnBuyWeapon = new JButton("Buy");
		btnBuyWeapon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= item2.getItemGold()){
					itemPanel2.setVisible(false);
					hero.addToInventory(item2);
					hero.removeGold(item2.getItemGold());
					inventoryComboBox.addItem(item2);
				}
				else{
					scrollPane.addTextToScrollPane("You don't have enough for that.");
				}
			}
		});
		btnBuyWeapon.setBounds(40, 163, 117, 29);
		itemPanel2.add(btnBuyWeapon);
		
		//Label for buy panel title
		JLabel lblNewLabel = new JLabel("Items for Sale");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 456, 39);
		buyPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			

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
			this.buyButtonIcon = new ImageIcon(ImageIO.read(new File("attack.png")));
			this.sellButtonIcon = new ImageIcon(ImageIO.read(new File("sellingcoins.png")));
			this.enhanceButtonIcon = new ImageIcon(ImageIO.read(new File("anvil.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
