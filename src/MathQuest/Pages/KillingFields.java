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
		super(hero, "killingFieldsMusic.mp3");
		this.loadImages();
			
		JPanel creaturePanel = new JPanel();
		creaturePanel.setBackground(Color.GRAY);
		creaturePanel.setBounds(212, 180, 600, 407);
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
		creatureSelectionPanel.setBounds(6, 67, 588, 334);
		creaturePanel.add(creatureSelectionPanel);
		creatureSelectionPanel.setLayout(null);
		
		JButton btnGoblin = new JButton("Goblin");
		btnGoblin.setBounds(16, 16, 131, 29);
		btnGoblin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(1, "Goblin", "Goblin Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGoblin);
		
		JButton btnOrc = new JButton("Orc");
		btnOrc.setBounds(16, 55, 131, 29);
		btnOrc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(2, "Orc", "Orc Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnOrc);
		
		JButton btnGhoul = new JButton("Ghoul");
		btnGhoul.setBounds(16, 94, 131, 29);		
		btnGhoul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(3, "Ghoul", "Ghoul Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGhoul);
		
		JButton btnTormentor = new JButton("Tormentor");
		btnTormentor.setBounds(16, 172, 131, 29);
		btnTormentor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(5, "Tormentor", "Tormentor Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnTormentor);
		
		JButton btnSkeleton = new JButton("Skeleton");
		btnSkeleton.setBounds(16, 133, 131, 29);
		btnSkeleton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(4, "Skeleton", "Skeleton Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnSkeleton);
		
		JButton btnGhost = new JButton("Ghost");
		btnGhost.setBounds(16, 211, 131, 29);
		btnGhost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(6, "Ghost", "Ghost Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGhost);
		
		JButton btnHarpy = new JButton("Harpy");
		btnHarpy.setBounds(157, 55, 131, 29);
		btnHarpy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(10, "Harpy", "Harpy Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnHarpy);
		
		JButton btnFireElemental = new JButton("Fire Elemental");
		btnFireElemental.setBounds(298, 55, 131, 29);
		btnFireElemental.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(18, "Fire Elemental", "Fire Elemental Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnFireElemental);
		
		JButton btnEvilEye = new JButton("Evil Eye");
		btnEvilEye.setBounds(157, 94, 131, 29);
		btnEvilEye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(11, "Evil Eye", "Evil Eye Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnEvilEye);
		
		JButton btnGriffin = new JButton("Griffin");
		btnGriffin.setBounds(157, 133, 131, 29);
		btnGriffin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(12, "Griffin", "Griffin Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGriffin);
		
		JButton btnEarthElemental = new JButton("Earth Elemental");
		btnEarthElemental.setBounds(157, 172, 131, 29);
		btnEarthElemental.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(13, "Earth Elemental", "Earth Elemental Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnEarthElemental);
		
		JButton btnAirElemental = new JButton("Air Elemental");
		btnAirElemental.setBounds(157, 211, 131, 29);
		btnAirElemental.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(14, "Air Elemental", "Air Elemental Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnAirElemental);
		
		JButton btnNightmare = new JButton("Nightmare");
		btnNightmare.setBounds(439, 55, 131, 29);
		btnNightmare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(27, "Nightmare", "Nightmare Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnNightmare);
		
		JButton btnMinotaur = new JButton("Minotaur");
		btnMinotaur.setBounds(157, 250, 131, 29);
		btnMinotaur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(15, "Minotaur", "Minotaur Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnMinotaur);
		
		JButton btnAngel = new JButton("Angel");
		btnAngel.setBounds(439, 94, 131, 29);
		btnAngel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(28, "Angel", "Angel Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnAngel);
		
		JButton btnIceDragon = new JButton("Ice Dragon");
		btnIceDragon.setBounds(439, 133, 131, 29);
		btnIceDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(30, "Ice Dragon", "Ice Dragon Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnIceDragon);
		
		JButton btnLightningDragon = new JButton("Lightning Dragon");
		btnLightningDragon.setBounds(439, 172, 131, 29);
		btnLightningDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(32, "Lightning Dragon", "Lightning Dragon Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnLightningDragon);
		
		JButton btnShadowDragon = new JButton("Shadow Dragon");
		btnShadowDragon.setBounds(439, 211, 131, 29);
		btnShadowDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(35, "Shadow Dragon", "Shadow Dragon Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnShadowDragon);
		
		JButton btnSpiderQueen = new JButton("Spider Queen");
		btnSpiderQueen.setBounds(439, 250, 131, 29);
		btnSpiderQueen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(37, "Spider Queen", "Spider Queen Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnSpiderQueen);
		
		JButton btnVampireKnight = new JButton("Vampire Knight");
		btnVampireKnight.setBounds(298, 94, 131, 29);
		btnVampireKnight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(19, "Vampire Knight", "Vampire Knight Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnVampireKnight);
		
		JButton btnCentaur = new JButton("Centaur");
		btnCentaur.setBounds(298, 133, 131, 29);
		btnCentaur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(20, "Centaur", "Centaur Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnCentaur);
		
		JButton btnManticore = new JButton("Manticore");
		btnManticore.setBounds(298, 172, 131, 29);
		btnManticore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(21, "Manticore", "Manticore Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnManticore);
		
		JButton btnGiant = new JButton("Giant");
		btnGiant.setBounds(298, 211, 131, 29);
		btnGiant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(22, "Giant", "Giant Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGiant);
		
		JButton btnLich = new JButton("Lich");
		btnLich.setBounds(298, 250, 131, 29);
		btnLich.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(23, "Lich", "Lich Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnLich);
		
		JButton btnEnchantress = new JButton("Enchantress");
		btnEnchantress.setBounds(16, 250, 131, 29);
		btnEnchantress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(8, "Enchantress", "Enchantress Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnEnchantress);
		
		JButton btnVampire = new JButton("Vampire");
		btnVampire.setBounds(157, 289, 131, 29);
		btnVampire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(16, "Vampire", "Vampire Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnVampire);
		
		JButton btnGoldDragon = new JButton("Gold Dragon");
		btnGoldDragon.setBounds(298, 289, 131, 29);
		btnGoldDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(24, "Gold Dragon", "Gold Dragon Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGoldDragon);
		
		JButton btnUniverseDragon = new JButton("Universe Dragon");
		btnUniverseDragon.setBounds(439, 289, 131, 29);
		btnUniverseDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(40, "Universe Dragon", "Universe Dragon Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnUniverseDragon);
		
		JButton btnDemon = new JButton("Demon");
		btnDemon.setBounds(157, 16, 131, 29);
		btnDemon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(9, "Demon", "Demon Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnDemon);
		
		JButton btnSuccubus = new JButton("Succubus");
		btnSuccubus.setBounds(298, 16, 131, 29);		
		btnSuccubus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(17, "Succubus", "Succubus Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnSuccubus);
		
		JButton btnPitFiend = new JButton("Pit Fiend");
		btnPitFiend.setBounds(439, 16, 131, 29);
		btnPitFiend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(25, "Pit Fiend", "Pit Fiend Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnPitFiend);
		
		JButton btnHellhound = new JButton("Hellhound");
		btnHellhound.setBounds(16, 289, 131, 29);
		btnHellhound.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(7, "Hellhound", "Hellhound Portrait.png");
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnHellhound);
		
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
