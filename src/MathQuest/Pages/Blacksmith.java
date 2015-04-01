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
	final JPanel buyPanel, sellPanel, enhancePanel, armorPanel, weaponPanel;
	
	JComboBox inventoryComboBox, enhanceComboBox;
	
	private Item item1, item2;
	
	public Blacksmith(final Character hero) {
		super(hero, "blacksmithMusic.mp3");
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
		armorItemLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		armorItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		armorItemLabel.setBounds(6, 6, 186, 25);
		armorPanel.add(armorItemLabel);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(6, 43, 61, 16);
		armorPanel.add(lblLevel);
		
		JLabel lblArmor = new JLabel("Armor:");
		lblArmor.setBounds(6, 64, 61, 16);
		armorPanel.add(lblArmor);
		
		JLabel lblDexterity = new JLabel("Dexterity:");
		lblDexterity.setBounds(6, 101, 71, 16);
		armorPanel.add(lblDexterity);
		
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setBounds(6, 120, 61, 16);
		armorPanel.add(lblSpeed);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setBounds(6, 82, 61, 16);
		armorPanel.add(lblStrength);
		
		JLabel levelNumber = new JLabel("" + item1.getItemLvl());
		levelNumber.setBounds(131, 43, 61, 16);
		armorPanel.add(levelNumber);
		
		JLabel armorNumber = new JLabel("" + item1.getItemArmor());
		armorNumber.setBounds(131, 64, 61, 16);
		armorPanel.add(armorNumber);
		
		JLabel strNumber = new JLabel("" + item1.getItemStr());
		strNumber.setBounds(131, 82, 61, 16);
		armorPanel.add(strNumber);
		
		JLabel dexNumber = new JLabel("" + item1.getItemDex());
		dexNumber.setBounds(131, 101, 61, 16);
		armorPanel.add(dexNumber);
		
		JLabel speedNumber = new JLabel("" + item1.getItemSpeed());
		speedNumber.setBounds(131, 120, 61, 16);
		armorPanel.add(speedNumber);
		
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
		
		weaponPanel = new JPanel();
		weaponPanel.setLayout(null);
		weaponPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		weaponPanel.setBounds(238, 83, 198, 198);
		buyPanel.add(weaponPanel);
		
		JLabel weaponItemLabel = new JLabel(item2.toString());
		weaponItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weaponItemLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		weaponItemLabel.setBounds(6, 6, 186, 25);
		weaponPanel.add(weaponItemLabel);
		
		JLabel lblWeaponLevel = new JLabel("Level:");
		lblWeaponLevel.setBounds(6, 46, 61, 16);
		weaponPanel.add(lblWeaponLevel);
		
		JLabel lblWeaponDamage = new JLabel("Damage:");
		lblWeaponDamage.setBounds(6, 67, 61, 16);
		weaponPanel.add(lblWeaponDamage);
		
		JLabel lblWeaponStrength = new JLabel("Strength:");
		lblWeaponStrength.setBounds(6, 85, 61, 16);
		weaponPanel.add(lblWeaponStrength);
		
		JLabel lblWeaponDexterity = new JLabel("Dexterity:");
		lblWeaponDexterity.setBounds(6, 104, 71, 16);
		weaponPanel.add(lblWeaponDexterity);
		
		JLabel lblWeaponSpeed = new JLabel("Speed:");
		lblWeaponSpeed.setBounds(6, 123, 61, 16);
		weaponPanel.add(lblWeaponSpeed);
		
		JLabel weaponLevelNumber = new JLabel("" + item2.getItemLvl());
		weaponLevelNumber.setBounds(131, 46, 61, 16);
		weaponPanel.add(weaponLevelNumber);
		
		JLabel weaponDamageNumber = new JLabel("" + item2.getItemDmg());
		weaponDamageNumber.setBounds(131, 67, 61, 16);
		weaponPanel.add(weaponDamageNumber);
		
		JLabel weaponStrNumber = new JLabel("" + item2.getItemStr());
		weaponStrNumber.setBounds(131, 85, 61, 16);
		weaponPanel.add(weaponStrNumber);
		
		JLabel weaponDexNumber = new JLabel("" + item2.getItemDex());
		weaponDexNumber.setBounds(131, 104, 61, 16);
		weaponPanel.add(weaponDexNumber);
		
		JLabel weaponSpeedNumber = new JLabel("" + item2.getItemSpeed());
		weaponSpeedNumber.setBounds(131, 123, 61, 16);
		weaponPanel.add(weaponSpeedNumber);
		
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
			inventoryComboBox.addItem(el);
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
