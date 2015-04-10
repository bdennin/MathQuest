package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import java.io.File;
import java.io.IOException;

import MathQuest.GUI.LogPanel;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inn extends Area {

	private static final long serialVersionUID = 1L;
	final JPanel options = new JPanel();
	private LogPanel combatLog;
	private ImageIcon potionIcon;
	private ImageIcon restIcon;
	private ImageIcon mealIcon;
	private ImageIcon showerIcon;
	private ImageIcon bedIcon;
	private int potionCost;

	public Inn(Character hero) {
		super(hero, "innMusic.mp3");
		this.loadImages();
		this.setBackground(Color.LIGHT_GRAY);

		this.combatLog = new LogPanel("Inn Log");
		combatLog.addTextToScrollPane("You have entered the Inn!");

		potionCost = hero.getLevel() * hero.getLevel() * 5;

		combatLog.addTextToScrollPane("The price for potion today is " + potionCost + " gold.");
		add(combatLog);

		options.setBounds(587, 612, 269, 77);
		options.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		options.setLayout(null);
		add(options);

		showOptions();

		this.renderBackground();
	}

	public void showOptions(){

		options.removeAll();

		JButton btnPotion = new JButton(this.potionIcon);
		btnPotion.setBounds(3, 3, 88, 70);
		btnPotion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int gold = hero.getGold();

				if(gold >= potionCost) {
					hero.removeGold(potionCost);
					hero.setPotions(hero.getPotions() + 1);
					combatLog.addTextToScrollPane("You have purchased a potion.");
				}
				else {
					combatLog.addTextToScrollPane("You don't have enough gold to buy a potion!");
				}
			}
		});
		options.add(btnPotion);

		JButton btnRest = new JButton(this.restIcon);
		btnRest.setBounds(90, 3, 88, 70);	
		btnRest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showRoomOptions();
			}
		});
		options.add(btnRest);

		options.revalidate();
		options.repaint();
	}

	public void showRoomOptions(){
		options.removeAll();

		combatLog.addTextToScrollPane("Here are the prices for various services:");
		combatLog.addTextToScrollPane("     Shower:" + hero.calculateCost("Shower",hero.getLevel())+ " gold for "+ hero.calculateIncrease("Shower")+" health");
		combatLog.addTextToScrollPane("     Meal:" + hero.calculateCost("Meal",hero.getLevel())+ " gold for "+ hero.calculateIncrease("Meal")+" health");
		combatLog.addTextToScrollPane("     Take a nap:" + hero.calculateCost("Sleep",hero.getLevel())+ " gold for "+ hero.calculateIncrease("Sleep")+" health");
		combatLog.addTextToScrollPane("Please choose the service you want.");

		JButton btnShower = new JButton(this.showerIcon);
		btnShower.setBounds(3, 3, 88, 70);
		btnShower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.enoughGold("Shower")){
					hero.healthRegain("Shower");
					hero.payForInn("Shower");
					reloadCharacterPanel();
					reloadInventoryPanel(false);
					combatLog.addTextToScrollPane("You feel much better after showering!");
				}
				else
					combatLog.addTextToScrollPane("You don't have enough gold to shower!");
				showOptions();
			}
		});
		options.add(btnShower);

		JButton btnMeal = new JButton(this.mealIcon);
		btnMeal.setBounds(90, 3, 88, 70);	
		btnMeal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.enoughGold("Meal")){
					hero.healthRegain("Meal");
					hero.payForInn("Meal");
					reloadCharacterPanel();
					reloadInventoryPanel(false);
					combatLog.addTextToScrollPane("You feel much better after eating!");
				}
				else 
					combatLog.addTextToScrollPane("You don't have enough gold to eat!");
				showOptions();
			}
		});
		options.add(btnMeal);

		JButton btnSleep = new JButton(this.bedIcon);
		btnSleep.setBounds(177, 3, 88, 70);
		btnSleep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.enoughGold("Sleep")){
					hero.healthRegain("Sleep");
					hero.payForInn("Sleep");
					reloadCharacterPanel();
					reloadInventoryPanel(false);
					combatLog.addTextToScrollPane("You feel much better after taking a nap!");
				}
				else 
					combatLog.addTextToScrollPane("You don't have enough gold to rest!");
				showOptions();
			}
		});
		options.add(btnSleep);

		options.revalidate();
		options.repaint();
	}
	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this, this.hero, true);
	}

	@Override
	public void loadImages() {
		try {                
			this.background = new ImageIcon(ImageIO.read(new File("insideInn.png")));
			this.potionIcon = new ImageIcon(ImageIO.read(new File("potion.png")));
			this.restIcon = new ImageIcon(ImageIO.read(new File("rest.png")));
			this.mealIcon = new ImageIcon(ImageIO.read(new File("meal.png")));
			this.showerIcon = new ImageIcon(ImageIO.read(new File("shower.png")));
			this.bedIcon = new ImageIcon(ImageIO.read(new File("bed.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
