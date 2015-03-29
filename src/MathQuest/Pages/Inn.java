package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import java.io.File;
import java.io.IOException;

import MathQuest.GUI.LogPanel;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inn extends Area {

	private static final long serialVersionUID = 1L;
	private JTextArea scrollText;
	final JPanel options = new JPanel();
	//final JPanel panel = new JPanel();
	static Character hero;
	private LogPanel combatLog;
	private ImageIcon potionIcon;
	private ImageIcon restIcon;
	private ImageIcon mealIcon;
	private ImageIcon showerIcon;
	private ImageIcon bedIcon;

	public Inn(Character hero) {
		super(hero, "innMusic.mp3");
		this.hero = hero;
		this.loadImages();
		this.setBackground(Color.LIGHT_GRAY);
		
		this.combatLog = new LogPanel("Inn Log");
		combatLog.addTextToScrollPane("You have entered Inn!");
		combatLog.addTextToScrollPane("How can I help you?");
		add(combatLog);
		
/*		panel.setBounds(150, 590, 724, 150);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 417, 138);
		panel.add(scrollPane);

		this.scrollText = new JTextArea();
		this.scrollText.setEditable(false);
		this.scrollText.setLineWrap(true);
		this.scrollText.setWrapStyleWord(true);
		scrollPane.setViewportView(scrollText);
		this.combatLog.addTextToScrollPane("You have entered Inn!  How can I help you?\n");
*/
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
			}
		});
		options.add(btnPotion);

		/*
		  JPanel runPanel = new JPanel();
		  runPanel.setBounds(194, 6, 88, 126);
		  options.add(runPanel);
		  runPanel.setLayout(new GridLayout(1, 0, 0, 0));

		  JButton btnRunAway = new JButton("Look arround");
		  btnRunAway.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MathQuest.switchToGameWorld();
		   }

		  });
		  runPanel.add(btnRunAway);
		 */

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

		combatLog.addTextToScrollPane("Here is the prices for various servies:");
		combatLog.addTextToScrollPane("     Shower:" + hero.calculateCost("Shower")+ " gold for "+ hero.calculateIncrease("Shower")+" health unit");
		combatLog.addTextToScrollPane("     Meal:" + hero.calculateCost("Meal")+ " gold for "+ hero.calculateIncrease("Meal")+" health unit");
		combatLog.addTextToScrollPane("     Take a snap:" + hero.calculateCost("Sleep")+ " gold for "+ hero.calculateIncrease("Sleep")+" health unit");
		combatLog.addTextToScrollPane("Please choose the room you want.");

		JButton btnShower = new JButton(this.showerIcon);
		btnShower.setBounds(3, 3, 88, 70);
		btnShower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.enoughGold("Shower")){
					hero.healthRegain("Shower");
					hero.payForInn("Shower");
					reloadCharacterPanel();
					reloadInventoryPanel();
					combatLog.addTextToScrollPane("After shower, I feel much better now! Return to lobby.");
				}
				else
					combatLog.addTextToScrollPane("Oops. I don't have enough money pay for the Shower! Return to lobby.");
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
					reloadInventoryPanel();
					combatLog.addTextToScrollPane("After taking the meal, I feel much better now! Return to lobby.");
				}
				else 
					combatLog.addTextToScrollPane("Oops. I don't have enough money pay for the Meal! Return to lobby.");
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
					reloadInventoryPanel();
					combatLog.addTextToScrollPane("After taking a snap, I feel much better now! Return to lobby.");
				}
				else 
					combatLog.addTextToScrollPane("Oops. I don't have enough money pay for a rest room! Return to lobby.");
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
			this.mealIcon = new ImageIcon(ImageIO.read(new File("meal.jpg")));
			this.showerIcon = new ImageIcon(ImageIO.read(new File("shower.jpg")));
			this.bedIcon = new ImageIcon(ImageIO.read(new File("bed.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
