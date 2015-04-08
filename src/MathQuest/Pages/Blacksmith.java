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
	final JPanel buyPanel, salePanel, sellPanel, enhancePanel, armorPanel, weaponPanel;
	private ImageIcon buyButtonIcon, sellButtonIcon, enhanceButtonIcon;
	
	private JComboBox inventoryComboBox, enhanceComboBox;
	
	private Item item1, item2;
	
	private static final Character character = new Character();
	
	public Blacksmith(final Character hero) {
//		super(hero, "blacksmithMusic.mp3");
		super(character, null);
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
		buttonPanel.setBounds(587, 612, 269, 77);
		add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton btnBuyItems = new JButton(this.buyButtonIcon);
		btnBuyItems.setBounds(3, 3, 88, 70);
		buttonPanel.add(btnBuyItems);
		
		
		JButton btnSellItems = new JButton(this.sellButtonIcon);
		btnSellItems.setBounds(90, 3, 88, 70);
		buttonPanel.add(btnSellItems);
		
		JButton btnImproveItems = new JButton(this.enhanceButtonIcon);
		btnImproveItems.setBounds(177, 3, 88, 70);
		buttonPanel.add(btnImproveItems);
		btnImproveItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.addTextToScrollPane("I can make anything stronger.\n");
				if(enhancePanel.isVisible()){
					enhancePanel.setVisible(false);
				}
				else{
					enhancePanel.setVisible(true);
				}
			}
		});
		
		
		btnSellItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sellPanel.isVisible()){
					scrollPane.addTextToScrollPane("Ok.\n");
					sellPanel.setVisible(false);
				}
				else{
					scrollPane.addTextToScrollPane("Let's see what you have.\n");
					sellPanel.setVisible(true);
				}
			}
		});
		
		
		btnBuyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(salePanel.isVisible()){
					scrollPane.addTextToScrollPane("Ok\n");
					salePanel.setVisible(false);	
				}
				else{
					scrollPane.addTextToScrollPane("I think you could handle these.\n");
					salePanel.setVisible(true);
				}
			}
		});
		
		scrollPane = new LogPanel("Blacksmith Log");
		add(scrollPane);
		this.scrollPane.addTextToScrollPane("Hello! I am the town Blacksmith. How can I help you?\n");
		
		sellPanel = new JPanel();
		sellPanel.setBackground(Color.LIGHT_GRAY);
		sellPanel.setBounds(735, 260, 245, 116);
		sellPanel.setVisible(false);
		add(sellPanel);
		sellPanel.setLayout(null);
		for(Item el : hero.getInventory())
			if(!el.isEquipped()){
				inventoryComboBox.addItem(el);
			}
		
		JPanel sellButtonPanel = new JPanel();
		sellButtonPanel.setBounds(1, 29, 244, 87);
		sellPanel.add(sellButtonPanel);
		sellButtonPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		sellButtonPanel.setLayout(null);
		
		inventoryComboBox = new JComboBox<Item>();
		inventoryComboBox.setBounds(6, 6, 233, 27);
		sellButtonPanel.add(inventoryComboBox);
		
		JButton sellBtn = new JButton("Sell");
		sellBtn.setBounds(56, 45, 117, 35);
		sellButtonPanel.add(sellBtn);
		
		JLabel sellLabel = new JLabel("Sell Items");
		sellLabel.setBackground(Color.LIGHT_GRAY);
		sellLabel.setBounds(1, 0, 244, 29);
		sellPanel.add(sellLabel);
		sellLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		sellLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sellBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item i = (Item)inventoryComboBox.getSelectedItem();
				hero.addGold(i.getItemGold());
				hero.removeFromInventory((Item)inventoryComboBox.getSelectedItem());
				inventoryComboBox.removeItem(inventoryComboBox.getSelectedItem());
				reloadInventoryPanel(false);
			}
		});
		
		enhancePanel = new JPanel();
		enhancePanel.setBackground(Color.LIGHT_GRAY);
		enhancePanel.setBounds(735, 422, 245, 105);
		enhancePanel.setVisible(false);
		add(enhancePanel);
		enhancePanel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		panel_4.setBounds(0, 24, 245, 80);
		enhancePanel.add(panel_4);
		panel_4.setLayout(null);
		
		enhanceComboBox = new JComboBox();
		enhanceComboBox.setBounds(6, 6, 233, 27);
		panel_4.add(enhanceComboBox);
		
		JButton enhancheBtn = new JButton("Improve");
		enhancheBtn.setBounds(51, 39, 117, 35);
		panel_4.add(enhancheBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Improve Items");
		lblNewLabel_2.setBounds(0, 0, 245, 25);
		enhancePanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		for(Item el : hero.getInventory())
			enhanceComboBox.addItem(el);
		
		salePanel = new JPanel();
		salePanel.setBackground(Color.LIGHT_GRAY);
		salePanel.setBounds(206, 225, 457, 248);
		salePanel.setVisible(false);
		add(salePanel);
		salePanel.setLayout(null);
		
		buyPanel = new JPanel();
		buyPanel.setBounds(0, 36, 456, 212);
		salePanel.add(buyPanel);
		buyPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		buyPanel.setLayout(null);
		
		armorPanel = new JPanel();
		armorPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		armorPanel.setBounds(6, 6, 198, 198);
		buyPanel.add(armorPanel);
		armorPanel.setLayout(null);
		
		JLabel armorItemLabel = new JLabel(item1.toString());
		armorItemLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		armorItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		armorItemLabel.setBounds(6, 6, 186, 25);
		armorPanel.add(armorItemLabel);
		if(item1.getColor().equalsIgnoreCase("gray")){
			armorItemLabel.setForeground(Color.black);
		}
		else if(item1.getColor().equalsIgnoreCase("green")){
			armorItemLabel.setForeground(Color.green);
		}
		else 
			armorItemLabel.setForeground(Color.blue);
		
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
					scrollPane.addTextToScrollPane("You don't have enough for that\n");
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
		weaponPanel.setBounds(252, 6, 198, 198);
		buyPanel.add(weaponPanel);
		
		JLabel weaponItemLabel = new JLabel(item2.toString());
		weaponItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weaponItemLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		weaponItemLabel.setBounds(6, 6, 186, 25);
		weaponPanel.add(weaponItemLabel);
		if(item2.getColor().equalsIgnoreCase("gray")){
			weaponItemLabel.setForeground(Color.black);
		}
		else if(item2.getColor().equalsIgnoreCase("green")){
			weaponItemLabel.setForeground(Color.green);
		}
		else{
			weaponItemLabel.setForeground(Color.green);
		}
		
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
					scrollPane.addTextToScrollPane("You don't have enough for that\n");
				}
			}
		});
		btnBuyWeapon.setBounds(40, 163, 117, 29);
		weaponPanel.add(btnBuyWeapon);
		
		JLabel weaponVitLabel = new JLabel("" + item2.getItemVit());
		weaponVitLabel.setBounds(131, 133, 61, 16);
		weaponPanel.add(weaponVitLabel);
		
		JLabel lblNewLabel = new JLabel("Items for Sale");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 456, 39);
		salePanel.add(lblNewLabel);
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
			this.sellButtonIcon = new ImageIcon(ImageIO.read(new File("sellcoins.png")));
			this.enhanceButtonIcon = new ImageIcon(ImageIO.read(new File("anvil.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
