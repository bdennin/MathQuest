package MathQuest.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import MathQuest.Logic.Character;
import MathQuest.Pages.Area;
import MathQuest.Pages.World;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class InventoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ImageIcon inventoryImage;
	private ImageIcon helmetLabel;
	private ImageIcon armorLabel;
	private ImageIcon weaponLabel;
	
	public InventoryPanel(final Area frame, final Character hero) {

		this.setBounds(675, 4, 341, 461);
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
		String damage = String.format("%s - %s", minDamage.toString(), maxDamage.toString());
		String life = String.format("%s / %s", currentLife.toString(), maxLife.toString());
		
		JPanel inventoryBody = new JPanel();
		inventoryBody.setBounds(0, 22, 341, 439);
		inventoryBody.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		inventoryBody.setLayout(null);
		add(inventoryBody);

		JPanel inventoryStatsPanel = new JPanel();
		inventoryStatsPanel.setBounds(10, 131, 321, 263);
		inventoryBody.add(inventoryStatsPanel);
		inventoryStatsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inventoryStatsPanel.setLayout(null);
		
		final JLabel headLabel = new JLabel();
		headLabel.setBounds(136, 9, 52, 52);
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
				frame.addInventoryWindow("Helmets");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(headLabel);
		
		final JLabel gloveLabel = new JLabel();
		gloveLabel.setBounds(23, 183, 52, 52);
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
				frame.addInventoryWindow("Gloves");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(gloveLabel);
		
		final JLabel feetLabel = new JLabel();
		feetLabel.setBounds(249, 183, 52, 52);
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
				frame.addInventoryWindow("Boots");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(feetLabel);
		
		final JLabel mainLabel = new JLabel();
		mainLabel.setBounds(22, 51, 52, 109);
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
				frame.addInventoryWindow("Weapons");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(mainLabel);
		
		final JLabel chestLabel = new JLabel();
		chestLabel.setBounds(135, 79, 52, 82);
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
				frame.addInventoryWindow("Armor");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		inventoryStatsPanel.add(chestLabel);
		
		JLabel inventoryImage = new JLabel();
		inventoryImage.setBounds(1, 1, 318, 260);
		inventoryImage.setIcon(this.inventoryImage);
		inventoryStatsPanel.add(inventoryImage);

		JPanel characterStatsPanel = new JPanel();
		characterStatsPanel.setBounds(10, 11, 321, 110);
		inventoryBody.add(characterStatsPanel);
		characterStatsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		characterStatsPanel.setLayout(null);

		JLabel levelLabel = new JLabel("Level");
		levelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setVerticalAlignment(SwingConstants.TOP);
		levelLabel.setBorder(new LineBorder(Color.black));
		levelLabel.setBounds(10, 11, 68, 29);
		characterStatsPanel.add(levelLabel);

		JLabel experienceLabel = new JLabel("Experience");
		experienceLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		experienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		experienceLabel.setVerticalAlignment(SwingConstants.TOP);
		experienceLabel.setBorder(new LineBorder(Color.black));
		experienceLabel.setBounds(88, 11, 108, 29);
		characterStatsPanel.add(experienceLabel);

		JLabel nextLevelLabel = new JLabel("Next Level");
		nextLevelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		nextLevelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nextLevelLabel.setVerticalAlignment(SwingConstants.TOP);
		nextLevelLabel.setBorder(new LineBorder(Color.black));
		nextLevelLabel.setBounds(206, 11, 105, 29);
		characterStatsPanel.add(nextLevelLabel);
		
		JLabel actualLevel = new JLabel(level.toString());
		actualLevel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualLevel.setHorizontalAlignment(SwingConstants.CENTER);
		actualLevel.setBounds(10, 26, 68, 14);
		characterStatsPanel.add(actualLevel);
		
		JLabel actualExperience = new JLabel(experience.toString());
		actualExperience.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualExperience.setHorizontalAlignment(SwingConstants.CENTER);
		actualExperience.setBounds(88, 26, 105, 14);
		characterStatsPanel.add(actualExperience);
		
		JLabel actualNextLevel = new JLabel(nextLevel.toString());
		actualNextLevel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		actualNextLevel.setHorizontalAlignment(SwingConstants.CENTER);
		actualNextLevel.setBounds(206, 26, 105, 14);
		characterStatsPanel.add(actualNextLevel);

		JLabel strengthLabel = new JLabel("Strength");
		strengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strengthLabel.setBounds(10, 78, 68, 14);
		characterStatsPanel.add(strengthLabel);

		JLabel damageLabel = new JLabel("Damage");
		damageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		damageLabel.setBounds(170, 78, 68, 14);
		characterStatsPanel.add(damageLabel);
		
		JLabel actualStrengthLabel = new JLabel(actualStrength.toString());
		actualStrengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actualStrengthLabel.setBounds(88, 78, 68, 14);
		characterStatsPanel.add(actualStrengthLabel);
		
		JLabel actualDamage = new JLabel(damage);
		actualDamage.setHorizontalAlignment(SwingConstants.CENTER);
		actualDamage.setBounds(243, 78, 68, 14);
		characterStatsPanel.add(actualDamage);

		JLabel lifeLabel = new JLabel("Life");
		lifeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lifeLabel.setBounds(10, 53, 68, 14);
		characterStatsPanel.add(lifeLabel);
		
		JLabel actualLifeLabel = new JLabel(life);
		actualLifeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actualLifeLabel.setBounds(88, 53, 68, 14);
		characterStatsPanel.add(actualLifeLabel);

		JLabel goldLabel = new JLabel("Gold");
		goldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goldLabel.setBounds(166, 53, 73, 14);
		characterStatsPanel.add(goldLabel);
		
		JLabel actualGoldLabel = new JLabel(actualGold.toString());
		actualGoldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actualGoldLabel.setBounds(248, 53, 63, 14);
		characterStatsPanel.add(actualGoldLabel);

		JLabel statBorder = new JLabel();
		statBorder.setBounds(10, 51, 301, 43);
		statBorder.setBorder(new LineBorder(Color.black));
		characterStatsPanel.add(statBorder);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(129, 405, 88, 23);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(frame instanceof World) {
					World world = (World)frame;
					world.loadJLabels();
				}
				if(null == frame.getInventoryWindow()) {
					
				}
				else {
					frame.removeInventoryWindow();
				}
				
				Area.toggleInventory();
				frame.renderBackground();
			}
		});
		inventoryBody.add(btnOK);
	}

	public void loadImages() {
		try {                
			this.inventoryImage = new ImageIcon(ImageIO.read(new File("inventory.png")));
			this.helmetLabel = new ImageIcon(ImageIO.read(new File("helmetLabel.png")));
			this.weaponLabel = new ImageIcon(ImageIO.read(new File("weaponLabel.png")));
			this.armorLabel = new ImageIcon(ImageIO.read(new File("armorLabel.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
