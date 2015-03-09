package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.io.File;
import java.io.IOException;

import MathQuest.GUI.OptionsPanel;
import MathQuest.MathQuest;
import MathQuest.Logic.Character;

import javax.swing.JTextPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inn extends Area {

	private static final long serialVersionUID = 1L;
	private final static Character dude = new Character();
	private JTextArea scrollText;
	final JPanel options = new JPanel();
	final JPanel panel = new JPanel();

	public Inn(Character hero) {
		super(dude);
		this.loadImages();
		
		
		panel.setBounds(150, 590, 724, 150);
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
		this.scrollText.append("You have entered Inn!  How can I help you?\n");
				
		options.setBounds(429, 6, 289, 138);
		panel.add(options);
		options.setLayout(null);
		
		showOptions();
		
		this.renderBackground();
	}
	
	public void showOptions(){
		
		options.removeAll();
		
		JPanel potion = new JPanel();
		potion.setBounds(6, 6, 88, 126);
		options.add(potion);
		potion.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnPotion = new JButton("Buy Potions");
		potion.add(btnPotion);
		
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
		
		JPanel rest = new JPanel();
		rest.setBounds(100, 6, 88, 126);
		options.add(rest);
		rest.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnRest = new JButton("Rest");
		btnRest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showRoomOptions();
			}
		});
		rest.add(btnRest);
		
		options.revalidate();
		options.repaint();
	}

	public void showRoomOptions(){
		options.removeAll();

		scrollText.append("Here is the prices for suites today:\n");
		scrollText.append("     Studio Suite:" + hero.calculateCost("Studio")+ " gold for "+ hero.calculateIncrease("Studio")+" health unit\n");
		scrollText.append("     Deluxe Suite:" + hero.calculateCost("Deluxe")+ " gold for "+ hero.calculateIncrease("Deluxe")+" health unit\n");
		scrollText.append("     Luxury Suite:" + hero.calculateCost("Luxury")+ " gold for "+ hero.calculateIncrease("Luxury")+" health unit\n");
		scrollText.append("Please choose the room you want.\n");
		
		JPanel studio = new JPanel();
		studio.setBounds(6, 6, 88, 126);
		options.add(studio);
		studio.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnStudio = new JButton("Studio");
		btnStudio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.enoughGold("Studio")){
					hero.healthRegain("Studio");
					hero.payForInn("Studio");
					reloadCharacterPanel();
					scrollText.append("After spending a night in Stuido Suite, I feel much better now! Return to lobby.\n");
				}
				else
					scrollText.append("Oops. I don't have enough money pay for the Studio Suite! Return to lobby.\n");
				showOptions();
			}
		});
		studio.add(btnStudio);
		
		JPanel deluxe = new JPanel();
		deluxe.setBounds(100, 6, 88, 126);
		options.add(deluxe);
		deluxe.setLayout(new GridLayout(1, 0, 0, 0));
		

		JButton btnDeluxe = new JButton("Deluxe");
		btnDeluxe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.enoughGold("Deluxe")){
					hero.healthRegain("Deluxe");
					hero.payForInn("Deluxe");
					reloadCharacterPanel();
					scrollText.append("After spending a night in Deluxe Suite, I feel much better now! Return to lobby.\n");
				}
				else 
					scrollText.append("Oops. I don't have enough money pay for the Deluxe Suite! Return to lobby.\n");
				showOptions();
			}
		});
		deluxe.add(btnDeluxe);
		
		JPanel luxury = new JPanel();
		luxury.setBounds(194, 6, 88, 126);
		options.add(luxury);
		luxury.setLayout(new GridLayout(1, 0, 0, 0));
		

		JButton btnLuxury = new JButton("Luxury");
		btnLuxury.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.enoughGold("Luxury")){
					hero.healthRegain("Luxury");
					hero.payForInn("Luxury");
					reloadCharacterPanel();
					scrollText.append("After spending a night in Luxury Suite, I feel much better now! Return to lobby.\n");
				}
				else 
					scrollText.append("Oops. I don't have enough money pay for the Luxury Suite! Return to lobby.\n");
				showOptions();
			}
		});
		luxury.add(btnLuxury);
		
		options.revalidate();
		options.repaint();
	}
	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this.hero, true);
	}

	@Override
	public void loadImages() {
		try {                
			this.background = new ImageIcon(ImageIO.read(new File("insideInn.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
