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
	private static Character hero = new Character();
	
	public KillingFields(Character her) {
		super(hero);
		this.loadImages();
			
		JPanel creaturePanel = new JPanel();
		creaturePanel.setBackground(Color.GRAY);
		creaturePanel.setBounds(212, 184, 600, 400);
		add(creaturePanel);
		creaturePanel.setLayout(null);
		
		JPanel creatureHeaderPanel = new JPanel();
		creatureHeaderPanel.setBackground(Color.WHITE);
		creatureHeaderPanel.setBounds(6, 6, 588, 55);
		creaturePanel.add(creatureHeaderPanel);
		
		JLabel creatureHeader = new JLabel("Select your opponent");
		creatureHeader.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		creatureHeaderPanel.add(creatureHeader);
		
		JPanel creatureSelectionPanel = new JPanel();
		creatureSelectionPanel.setBounds(6, 66, 588, 328);
		creaturePanel.add(creatureSelectionPanel);
		creatureSelectionPanel.setLayout(null);
		
		JButton btnGoblin = new JButton("Goblin");
		btnGoblin.setBounds(24, 24, 117, 29);
		btnGoblin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(1, "Goblin", "Goblin.jpg");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGoblin);
		
		JButton btnFamiliar = new JButton("Familiar");
		btnFamiliar.setBounds(24, 65, 117, 29);
		creatureSelectionPanel.add(btnFamiliar);
		
		JButton btnOrc = new JButton("Orc");
		btnOrc.setBounds(24, 106, 117, 29);
		creatureSelectionPanel.add(btnOrc);
		
		JButton btnGargoyle = new JButton("Gargoyle");
		btnGargoyle.setBounds(24, 188, 117, 29);
		creatureSelectionPanel.add(btnGargoyle);
		
		JButton btnSkeleton = new JButton("Skeleton");
		btnSkeleton.setBounds(24, 147, 117, 29);
		creatureSelectionPanel.add(btnSkeleton);
		
		JButton btnGrizzlyBear = new JButton("Grizzly Bear");
		btnGrizzlyBear.setBounds(24, 229, 117, 29);
		creatureSelectionPanel.add(btnGrizzlyBear);
		
		JButton btnZombie = new JButton("Zombie");
		btnZombie.setBounds(165, 24, 117, 29);
		creatureSelectionPanel.add(btnZombie);
		
		JButton btnDemon = new JButton("Demon");
		btnDemon.setBounds(306, 24, 117, 29);
		creatureSelectionPanel.add(btnDemon);
		
		JButton btnMinotaur = new JButton("Minotaur");
		btnMinotaur.setBounds(165, 65, 117, 29);
		creatureSelectionPanel.add(btnMinotaur);
		
		JButton btnUnicorn = new JButton("Unicorn");
		btnUnicorn.setBounds(165, 106, 117, 29);
		creatureSelectionPanel.add(btnUnicorn);
		
		JButton btnIronGolem = new JButton("Iron Golem");
		btnIronGolem.setBounds(165, 147, 117, 29);
		creatureSelectionPanel.add(btnIronGolem);
		
		JButton btnChromaticDrake = new JButton("Chromadrake");
		btnChromaticDrake.setBounds(165, 188, 117, 29);
		creatureSelectionPanel.add(btnChromaticDrake);
		
		JButton btnHydra = new JButton("Hydra");
		btnHydra.setBounds(447, 24, 117, 29);
		creatureSelectionPanel.add(btnHydra);
		
		JButton btnVampire = new JButton("Vampire");
		btnVampire.setBounds(165, 229, 117, 29);
		creatureSelectionPanel.add(btnVampire);
		
		JButton btnTemplar = new JButton("Templar");
		btnTemplar.setBounds(447, 65, 117, 29);
		creatureSelectionPanel.add(btnTemplar);
		
		JButton btnCentaurKing = new JButton("Centaur King");
		btnCentaurKing.setBounds(447, 106, 117, 29);
		creatureSelectionPanel.add(btnCentaurKing);
		
		JButton btnGiant = new JButton("Giant");
		btnGiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGiant.setBounds(447, 147, 117, 29);
		creatureSelectionPanel.add(btnGiant);
		
		JButton btnTitan = new JButton("Titan");
		btnTitan.setBounds(447, 188, 117, 29);
		creatureSelectionPanel.add(btnTitan);
		
		JButton btnBlackDragon = new JButton("Black Dragon");
		btnBlackDragon.setBounds(447, 229, 117, 29);
		creatureSelectionPanel.add(btnBlackDragon);
		
		JButton btnGriffin = new JButton("Griffin");
		btnGriffin.setBounds(306, 65, 117, 29);
		creatureSelectionPanel.add(btnGriffin);
		
		JButton btnTreant = new JButton("Treant");
		btnTreant.setBounds(306, 106, 117, 29);
		creatureSelectionPanel.add(btnTreant);
		
		JButton btnPitFiend = new JButton("Pit Fiend");
		btnPitFiend.setBounds(306, 147, 117, 29);
		creatureSelectionPanel.add(btnPitFiend);
		
		JButton btnLich = new JButton("Lich");
		btnLich.setBounds(306, 188, 117, 29);
		creatureSelectionPanel.add(btnLich);
		
		JButton btnWyvern = new JButton("Wyvern");
		btnWyvern.setBounds(306, 229, 117, 29);
		creatureSelectionPanel.add(btnWyvern);
		
		JButton btnGiantspid = new JButton("Giant Spider");
		btnGiantspid.setBounds(24, 270, 117, 29);
		creatureSelectionPanel.add(btnGiantspid);
		
		JButton btnOgreMagi = new JButton("Ogre Magi");
		btnOgreMagi.setBounds(165, 270, 117, 29);
		creatureSelectionPanel.add(btnOgreMagi);
		
		JButton btnNightmare = new JButton("Nightmare");
		btnNightmare.setBounds(306, 270, 117, 29);
		creatureSelectionPanel.add(btnNightmare);
		
		JButton btnPhoenix = new JButton("Phoenix");
		btnPhoenix.setBounds(447, 270, 117, 29);
		creatureSelectionPanel.add(btnPhoenix);
		
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
