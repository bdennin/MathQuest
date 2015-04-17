package MathQuest.GUI;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import MathQuest.MathQuest;
import MathQuest.Logic.Character;
import MathQuest.Logic.Item;
import MathQuest.Pages.Area;
import MathQuest.Pages.World;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class InventoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static ImageIcon headImage;
	private static ImageIcon gloveImage;
	private static ImageIcon feetImage;
	private static ImageIcon mainImage;
	private static ImageIcon chestImage;
	
	private ImageIcon inventoryImage;
	private ImageIcon helmetLabel;
	private ImageIcon armorLabel;
	private ImageIcon weaponLabel;

	public InventoryPanel(final Area frame, final Character hero, final ArrayList<Item> items) {

		this.setBounds(675, 4, 341, 558);
		this.setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		this.loadImages();

		JLabel combatLogLabel = new JLabel("Inventory");
		combatLogLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		combatLogLabel.setBorder(new LineBorder(Color.black));
		combatLogLabel.setHorizontalAlignment(SwingConstants.CENTER);
		combatLogLabel.setBounds(0, 0, 341, 22);
		add(combatLogLabel);

		Integer level = hero.getLevel();
		Integer experience = hero.getCurrentExperience();
		Integer nextLevel = hero.getMaxExperience();
		Integer actualStrength = hero.getStrength();
		Integer currentLife = hero.getCurrentHealth();
		Integer actualGold = hero.getGold();
		Integer maxLife = hero.getMaxHealth();
		Integer maxDamage = (int)(Math.round(actualStrength * .2));
		Integer minDamage = (int)(Math.round(.75 * maxDamage));
		Integer potions = hero.getPotions();
		String damage = String.format("%s - %s", minDamage.toString(), maxDamage.toString());
		String life = String.format("%s / %s", currentLife.toString(), maxLife.toString());

		JPanel inventoryBody = new JPanel();
		inventoryBody.setBounds(0, 22, 342, 537);
		inventoryBody.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		inventoryBody.setLayout(null);
		add(inventoryBody);

		JPanel inventoryStatsPanel = new JPanel();
		inventoryStatsPanel.setBounds(10, 67, 321, 278);
		inventoryBody.add(inventoryStatsPanel);
		inventoryStatsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inventoryStatsPanel.setLayout(null);

		JPanel equipmentPanel = new JPanel();
		equipmentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		equipmentPanel.setBounds(10, 352, 321, 174);
		inventoryBody.add(equipmentPanel);
		equipmentPanel.setLayout(null);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 301, 99);
		equipmentPanel.add(scrollPane);

		final JList<Item> itemList = new JList<Item>();
		final DefaultListModel<Item> model = new DefaultListModel<Item>();
		itemList.setModel(model);
		for(Item el : items) 
			model.addElement(el);
		scrollPane.setViewportView(itemList);

		JButton btnEquip = new JButton("Equip");
		btnEquip.setBounds(222, 137, 89, 29);
		btnEquip.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnEquip.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				Item item = itemList.getSelectedValue();
				if(null == item) {

				}
				else {
					hero.equip(item);
					frame.reloadCharacterPanel();
					frame.reloadInventoryPanel(true, items);
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		equipmentPanel.add(btnEquip);

		JButton btnShowAll = new JButton("<html><center>Show All</center></html>");
		btnShowAll.setBounds(116, 137, 89, 29);
		btnShowAll.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnShowAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				final JList items = new JList(hero.getInventory().toArray());
				scrollPane.setViewportView(items);
				frame.renderBackground();
			}
		});
		equipmentPanel.add(btnShowAll);

		final JLabel headLabel = new JLabel();
		headLabel.setBounds(233, 17, 52, 52);
		headLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				headLabel.setIcon(helmetLabel);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				headLabel.setIcon(null);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				ArrayList<Item> headItems = new ArrayList<Item>();
				for(Item el : hero.getInventory()) {
					if(el.getSlot() == "Helmets")
						headItems.add(el);
				}
				frame.reloadInventoryPanel(true, headItems);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(headLabel);

		final JLabel gloveLabel = new JLabel();
		gloveLabel.setBounds(121, 191, 52, 52);
		gloveLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				gloveLabel.setIcon(helmetLabel);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				gloveLabel.setIcon(null);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				ArrayList<Item> handItems = new ArrayList<Item>();
				for(Item el : hero.getInventory()) {
					if(el.getSlot() == "Gloves")
						handItems.add(el);
				}
				frame.reloadInventoryPanel(true, handItems);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(gloveLabel);

		final JLabel feetLabel = new JLabel();
		feetLabel.setBounds(233, 191, 52, 52);
		feetLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				feetLabel.setIcon(helmetLabel);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				feetLabel.setIcon(null);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				ArrayList<Item> feetItems = new ArrayList<Item>();
				for(Item el : hero.getInventory()) {
					if(el.getSlot() == "Boots")
						feetItems.add(el);
				}
				frame.reloadInventoryPanel(true, feetItems);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(feetLabel);

		final JLabel mainLabel = new JLabel();
		mainLabel.setBounds(121, 59, 52, 109);
		mainLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainLabel.setIcon(weaponLabel);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainLabel.setIcon(null);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				ArrayList<Item> mainItems = new ArrayList<Item>();
				for(Item el : hero.getInventory()) {
					if(el.getSlot() == "Weapons")
						mainItems.add(el);
				}
				frame.reloadInventoryPanel(true, mainItems);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(mainLabel);

		final JLabel chestLabel = new JLabel();
		chestLabel.setBounds(233, 87, 52, 82);
		chestLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				chestLabel.setIcon(armorLabel);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				chestLabel.setIcon(null);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				ArrayList<Item> chestItems = new ArrayList<Item>();
				for(Item el : hero.getInventory()) {
					if(el.getSlot() == "Armor")
						chestItems.add(el);
				}
				frame.reloadInventoryPanel(true, chestItems);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(chestLabel);

		JLabel headItem = new JLabel();
		headItem.setBounds(233, 17, 52, 52);
		if(null != headImage)
			headItem.setIcon(headImage);
		inventoryStatsPanel.add(headItem);

		JLabel gloveItem = new JLabel();
		if(null != gloveImage)
			gloveItem.setIcon(gloveImage);
		gloveItem.setBounds(121, 191, 52, 52);
		inventoryStatsPanel.add(gloveItem);

		JLabel feetItem = new JLabel();
		if(null != feetImage)
			feetItem.setIcon(feetImage);
		feetItem.setBounds(233, 191, 52, 52);
		inventoryStatsPanel.add(feetItem);

		JLabel mainItem = new JLabel();
		if(null != mainImage)
			mainItem.setIcon(mainImage);
		mainItem.setBounds(121, 59, 52, 109);
		inventoryStatsPanel.add(mainItem);

		JLabel chestItem = new JLabel();
		if(null != chestImage)
			chestItem.setIcon(chestImage);
		chestItem.setBounds(233, 87, 52, 82);
		inventoryStatsPanel.add(chestItem);

		JLabel inventoryImage = new JLabel();
		inventoryImage.setBounds(99, 9, 212, 260);
		inventoryImage.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryImage.setIcon(this.inventoryImage);
		inventoryStatsPanel.add(inventoryImage);

		JLabel lifeLabel = new JLabel("Life:");
		lifeLabel.setBounds(10, 9, 75, 14);
		inventoryStatsPanel.add(lifeLabel);
		lifeLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lifeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel actualLifeLabel = new JLabel(life);
		actualLifeLabel.setBounds(10, 23, 75, 14);
		inventoryStatsPanel.add(actualLifeLabel);
		actualLifeLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualLifeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel strengthLabel = new JLabel("Strength:");
		strengthLabel.setBounds(10, 52, 75, 14);
		inventoryStatsPanel.add(strengthLabel);
		strengthLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		strengthLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel damageLabel = new JLabel("Damage:");
		damageLabel.setBounds(10, 91, 75, 14);
		inventoryStatsPanel.add(damageLabel);
		damageLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		damageLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel actualDamage = new JLabel(damage);
		actualDamage.setBounds(10, 105, 75, 14);
		inventoryStatsPanel.add(actualDamage);
		actualDamage.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualDamage.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel actualStrengthLabel = new JLabel(actualStrength.toString());
		actualStrengthLabel.setBounds(10, 66, 75, 14);
		inventoryStatsPanel.add(actualStrengthLabel);
		actualStrengthLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualStrengthLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel goldLabel = new JLabel("Gold:");
		goldLabel.setBounds(10, 200, 75, 14);
		inventoryStatsPanel.add(goldLabel);
		goldLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		goldLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel potionLabel = new JLabel("Potions:");
		potionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		potionLabel.setBounds(10, 241, 75, 14);
		inventoryStatsPanel.add(potionLabel);
		potionLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));

		JLabel actualGoldLabel = new JLabel(actualGold.toString());
		actualGoldLabel.setBounds(10, 214, 75, 14);
		inventoryStatsPanel.add(actualGoldLabel);
		actualGoldLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualGoldLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel actualPotionsLabel = new JLabel(potions.toString());
		actualPotionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actualPotionsLabel.setBounds(10, 255, 75, 14);
		inventoryStatsPanel.add(actualPotionsLabel);
		actualPotionsLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));

		JPanel characterStatsPanel = new JPanel();
		characterStatsPanel.setBounds(10, 11, 321, 49);
		inventoryBody.add(characterStatsPanel);
		characterStatsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		characterStatsPanel.setLayout(null);

		JLabel levelLabel = new JLabel("Level:");
		levelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setVerticalAlignment(SwingConstants.TOP);
		levelLabel.setBounds(10, 9, 68, 14);
		characterStatsPanel.add(levelLabel);

		JLabel experienceLabel = new JLabel("Experience:");
		experienceLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		experienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		experienceLabel.setVerticalAlignment(SwingConstants.TOP);
		experienceLabel.setBounds(88, 9, 108, 14);
		characterStatsPanel.add(experienceLabel);

		JLabel nextLevelLabel = new JLabel("Next Level:");
		nextLevelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		nextLevelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nextLevelLabel.setVerticalAlignment(SwingConstants.TOP);
		nextLevelLabel.setBounds(206, 9, 105, 14);
		characterStatsPanel.add(nextLevelLabel);

		JLabel actualLevel = new JLabel(level.toString());
		actualLevel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualLevel.setHorizontalAlignment(SwingConstants.CENTER);
		actualLevel.setBounds(10, 24, 68, 14);
		characterStatsPanel.add(actualLevel);

		JLabel actualExperience = new JLabel(experience.toString());
		actualExperience.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualExperience.setHorizontalAlignment(SwingConstants.CENTER);
		actualExperience.setBounds(88, 24, 105, 14);
		characterStatsPanel.add(actualExperience);

		JLabel actualNextLevel = new JLabel(nextLevel.toString());
		actualNextLevel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualNextLevel.setHorizontalAlignment(SwingConstants.CENTER);
		actualNextLevel.setBounds(206, 24, 105, 14);
		characterStatsPanel.add(actualNextLevel);

		JLabel equipmentLabel = new JLabel("Equipment:");
		equipmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		equipmentLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		equipmentLabel.setBounds(91, 9, 138, 14);
		equipmentPanel.add(equipmentLabel);

		JButton btnOK = new JButton("<html><center>X</center></html>");
		btnOK.setHorizontalAlignment(SwingConstants.LEFT);
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOK.setBounds(303, 2, 36, 18);
		add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(frame instanceof World) {
					World world = (World)frame;
					world.loadJLabels();
				}

				Area.toggleInventory();
				frame.renderBackground();
			}
		});

	}

	public static void setHelmetImage(ImageIcon image) {
		headImage = image;
	}

	public static void setArmorImage(ImageIcon image) {
		chestImage = image;
	}

	public static void setFeetImage(ImageIcon image) {
		feetImage = image;
	}

	public static void setWeaponImage(ImageIcon image) {
		mainImage = image;
	}

	public static void setGloveImage(ImageIcon image) {
		gloveImage = image;
	}

	public void loadImages() {

		this.inventoryImage = new ImageIcon(MathQuest.class.getResource("Files/inventory.png"));
		this.helmetLabel = new ImageIcon(MathQuest.class.getResource("Files/helmetLabel.png"));
		this.weaponLabel = new ImageIcon(MathQuest.class.getResource("Files/weaponLabel.png"));
		this.armorLabel = new ImageIcon(MathQuest.class.getResource("Files/armorLabel.png"));
	}
}
