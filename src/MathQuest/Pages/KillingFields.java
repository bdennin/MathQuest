package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import MathQuest.MathQuest;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;
import java.awt.Color;

public class KillingFields extends Area {

	private static final long serialVersionUID = 1L;
	private Character creature;
	
	public KillingFields(Character hero) {
		super(hero);
		this.loadImages();
			
		JPanel creaturePanel = new JPanel();
		creaturePanel.setBackground(Color.GRAY);
		creaturePanel.setBounds(212, 184, 600, 400);
		add(creaturePanel);
		creaturePanel.setLayout(null);
		
		JPanel creatureHeaderPanel = new JPanel();
		creatureHeaderPanel.setBackground(Color.WHITE);
		creatureHeaderPanel.setBounds(6, 6, 588, 73);
		creaturePanel.add(creatureHeaderPanel);
		
		JLabel creatureHeader = new JLabel("Select your opponent");
		creatureHeader.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		creatureHeaderPanel.add(creatureHeader);
		
		JPanel creatureSelectionPanel = new JPanel();
		creatureSelectionPanel.setBounds(6, 85, 588, 309);
		creaturePanel.add(creatureSelectionPanel);
		creatureSelectionPanel.setLayout(null);
		
		JButton button = new JButton("Goblin");
		button.setBounds(16, 28, 117, 29);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(1, "Goblin", "Goblin.jpg");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(button);
		
		JButton btnBugbear = new JButton("Orc");
		btnBugbear.setBounds(16, 69, 117, 29);
		creatureSelectionPanel.add(btnBugbear);
		
		JButton btnNewButton = new JButton("Ogre");
		btnNewButton.setBounds(16, 110, 117, 29);
		creatureSelectionPanel.add(btnNewButton);
		
		JButton btnSkeleton = new JButton("Skeleton");
		btnSkeleton.setBounds(16, 151, 117, 29);
		creatureSelectionPanel.add(btnSkeleton);
		
		JButton btnVampire = new JButton("Vampire");
		btnVampire.setBounds(16, 192, 117, 29);
		creatureSelectionPanel.add(btnVampire);
		
		JButton btnGiantSpider = new JButton("Giant Spider");
		btnGiantSpider.setBounds(16, 233, 117, 29);
		creatureSelectionPanel.add(btnGiantSpider);
		
		JButton btnUnicorn = new JButton("Unicorn");
		btnUnicorn.setBounds(145, 28, 117, 29);
		creatureSelectionPanel.add(btnUnicorn);
		
		JButton btnNoble = new JButton("Noble");
		btnNoble.setBounds(320, 28, 117, 29);
		creatureSelectionPanel.add(btnNoble);
		
		JButton btnRogue = new JButton("Minotaur");
		btnRogue.setBounds(145, 69, 117, 29);
		creatureSelectionPanel.add(btnRogue);
		
		JButton btnGargoyle = new JButton("Gargoyle");
		btnGargoyle.setBounds(145, 110, 117, 29);
		creatureSelectionPanel.add(btnGargoyle);
		
		JButton btnDragon = new JButton("Green Dragon");
		btnDragon.setBounds(145, 151, 117, 29);
		creatureSelectionPanel.add(btnDragon);
		
		JButton btnDrake = new JButton("Silver Drake");
		btnDrake.setBounds(145, 192, 117, 29);
		creatureSelectionPanel.add(btnDrake);
		
		JButton btnNewButton_1 = new JButton("Nightmare");
		btnNewButton_1.setBounds(453, 28, 117, 29);
		creatureSelectionPanel.add(btnNewButton_1);
		
		JButton btnZombie = new JButton("Zombie");
		btnZombie.setBounds(145, 233, 117, 29);
		creatureSelectionPanel.add(btnZombie);
		
		JButton btnGrizzlyBear = new JButton("Demon");
		btnGrizzlyBear.setBounds(453, 69, 117, 29);
		creatureSelectionPanel.add(btnGrizzlyBear);
		
		JButton btnNewButton_2 = new JButton("Black Dragon");
		btnNewButton_2.setBounds(453, 110, 117, 29);
		creatureSelectionPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Centaur King");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(453, 151, 117, 29);
		creatureSelectionPanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Titan");
		btnNewButton_4.setBounds(453, 192, 117, 29);
		creatureSelectionPanel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Giant");
		btnNewButton_5.setBounds(453, 233, 117, 29);
		creatureSelectionPanel.add(btnNewButton_5);
		
		JButton btnGriffin = new JButton("Griffin");
		btnGriffin.setBounds(320, 69, 117, 29);
		creatureSelectionPanel.add(btnGriffin);
		
		JButton btnNewButton_6 = new JButton("Treant");
		btnNewButton_6.setBounds(320, 110, 117, 29);
		creatureSelectionPanel.add(btnNewButton_6);
		
		JButton btnGolem = new JButton("Golem");
		btnGolem.setBounds(320, 151, 117, 29);
		creatureSelectionPanel.add(btnGolem);
		
		JButton btnWizard = new JButton("Lich");
		btnWizard.setBounds(320, 192, 117, 29);
		creatureSelectionPanel.add(btnWizard);
		
		JButton btnNewButton_7 = new JButton("Hydra");
		btnNewButton_7.setBounds(320, 233, 117, 29);
		creatureSelectionPanel.add(btnNewButton_7);
		
		this.renderBackground();
	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this.hero, true);
	}

	@Override
	public void loadImages() {
		try {                
			this.background = new ImageIcon(ImageIO.read(new File("killingFields.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
