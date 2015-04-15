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
import MathQuest.Logic.Character.DamageType;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class KillingFields extends Area {

	private static final long serialVersionUID = 1L;
	private Character creature;
	
	public KillingFields(Character hero) {
		super(hero, "src/MathQuest/Files/killingFieldsMusic.mp3");
		this.loadImages();
			
		JPanel creaturePanel = new JPanel();
		creaturePanel.setBackground(Color.GRAY);
		creaturePanel.setBounds(212, 180, 600, 407);
		add(creaturePanel);
		creaturePanel.setLayout(null);
		
		JPanel creatureHeaderPanel = new JPanel();
		creatureHeaderPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		creatureHeaderPanel.setBackground(Color.LIGHT_GRAY);
		creatureHeaderPanel.setBounds(0, 0, 600, 45);
		creaturePanel.add(creatureHeaderPanel);
		creatureHeaderPanel.setLayout(null);
		
		JLabel creatureHeader = new JLabel("Creature Selector");
		creatureHeader.setHorizontalAlignment(SwingConstants.CENTER);
		creatureHeader.setBounds(0, 0, 600, 45);
		creatureHeader.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		creatureHeaderPanel.add(creatureHeader);
		
		JPanel creatureSelectionPanel = new JPanel();
		creatureSelectionPanel.setBounds(0, 46, 600, 361);
		creatureSelectionPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		creaturePanel.add(creatureSelectionPanel);
		
		JButton btnGoblin = new JButton("Goblin");
		btnGoblin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(1, "Goblin", "src/MathQuest/Files/Goblin Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.setLayout(new GridLayout(0, 4, 0, 0));
		creatureSelectionPanel.add(btnGoblin);
		
		JButton btnOrc = new JButton("Orc");
		btnOrc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(2, "Orc", "src/MathQuest/Files/Orc Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnPitFiend = new JButton("Pit Fiend");
		btnPitFiend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(25, "Pit Fiend", "src/MathQuest/Files/Pit Fiend Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnSuccubus = new JButton("Succubus");
		btnSuccubus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(17, "Succubus", "src/MathQuest/Files/Succubus Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnDemon = new JButton("Demon");
		btnDemon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(9, "Demon", "src/MathQuest/Files/Demon Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnDemon);
		creatureSelectionPanel.add(btnSuccubus);
		creatureSelectionPanel.add(btnPitFiend);
		creatureSelectionPanel.add(btnOrc);
		
		JButton btnHarpy = new JButton("Harpy");
		btnHarpy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(10, "Harpy", "src/MathQuest/Files/Harpy Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnHarpy);
		
		JButton btnFireElemental = new JButton("Fire Elemental");
		btnFireElemental.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(18, "Fire Elemental", "src/MathQuest/Files/Fire Elemental Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnFireElemental);
		
		JButton btnNightmare = new JButton("Nightmare");
		btnNightmare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(27, "Nightmare", "src/MathQuest/Files/Nightmare Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnNightmare);
		
		JButton btnVampireKnight = new JButton("Vampire Knight");
		btnVampireKnight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(19, "Vampire Knight", "src/MathQuest/Files/Vampire Knight Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnEvilEye = new JButton("Evil Eye");
		btnEvilEye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(11, "Evil Eye", "src/MathQuest/Files/Evil Eye Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnGhoul = new JButton("Ghoul");
		btnGhoul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(3, "Ghoul", "src/MathQuest/Files/Ghoul Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGhoul);
		creatureSelectionPanel.add(btnEvilEye);
		creatureSelectionPanel.add(btnVampireKnight);
		
		JButton btnCentaur = new JButton("Centaur");
		btnCentaur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(20, "Centaur", "src/MathQuest/Files/Centaur Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnGriffin = new JButton("Griffin");
		btnGriffin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(12, "Griffin", "src/MathQuest/Files/Griffin Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnSkeleton = new JButton("Skeleton");
		btnSkeleton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(4, "Skeleton", "src/MathQuest/Files/Skeleton Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnAngel = new JButton("Angel");
		btnAngel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(28, "Angel", "src/MathQuest/Files/Angel Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnAngel);
		creatureSelectionPanel.add(btnSkeleton);
		creatureSelectionPanel.add(btnGriffin);
		creatureSelectionPanel.add(btnCentaur);
		
		JButton btnManticore = new JButton("Manticore");
		btnManticore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(21, "Manticore", "src/MathQuest/Files/Manticore Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnEarthElemental = new JButton("Earth Elemental");
		btnEarthElemental.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(13, "Earth Elemental", "src/MathQuest/Files/Earth Elemental Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnTormentor = new JButton("Tormentor");
		btnTormentor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(5, "Tormentor", "src/MathQuest/Files/Tormentor Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnIceDragon = new JButton("Ice Dragon");
		btnIceDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(30, "Ice Dragon", "src/MathQuest/Files/Ice Dragon Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnIceDragon);
		creatureSelectionPanel.add(btnTormentor);
		creatureSelectionPanel.add(btnEarthElemental);
		creatureSelectionPanel.add(btnManticore);
		
		JButton btnGiant = new JButton("Giant");
		btnGiant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(22, "Giant", "src/MathQuest/Files/Giant Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnAirElemental = new JButton("Air Elemental");
		btnAirElemental.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(14, "Air Elemental", "src/MathQuest/Files/Air Elemental Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnGhost = new JButton("Ghost");
		btnGhost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(6, "Ghost", "src/MathQuest/Files/Ghost Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnLightningDragon = new JButton("Lightning Dragon");
		btnLightningDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(32, "Lightning Dragon", "src/MathQuest/Files/Lightning Dragon Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnLightningDragon);
		creatureSelectionPanel.add(btnGhost);
		creatureSelectionPanel.add(btnAirElemental);
		creatureSelectionPanel.add(btnGiant);
		
		JButton btnEnchantress = new JButton("Enchantress");
		btnEnchantress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(7, "Enchantress", "src/MathQuest/Files/Enchantress Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnShadowDragon = new JButton("Shadow Dragon");
		btnShadowDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(35, "Shadow Dragon", "src/MathQuest/Files/Shadow Dragon Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnShadowDragon);
		creatureSelectionPanel.add(btnEnchantress);
		
		JButton btnVampire = new JButton("Vampire");
		btnVampire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(16, "Vampire", "src/MathQuest/Files/Vampire Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnHellhound = new JButton("Hellhound");
		btnHellhound.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(8, "Hellhound", "src/MathQuest/Files/Hellhound Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnSpiderQueen = new JButton("Spider Queen");
		btnSpiderQueen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(37, "Spider Queen", "src/MathQuest/Files/Spider Queen Portrait.png", DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnLich = new JButton("Lich");
		btnLich.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(23, "Lich", "src/MathQuest/Files/Lich Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		
		JButton btnMinotaur = new JButton("Minotaur");
		btnMinotaur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(15, "Minotaur", "src/MathQuest/Files/Minotaur Portrait.png", DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnMinotaur);
		creatureSelectionPanel.add(btnLich);
		creatureSelectionPanel.add(btnSpiderQueen);
		creatureSelectionPanel.add(btnHellhound);
		creatureSelectionPanel.add(btnVampire);
		
		JButton btnGoldDragon = new JButton("Gold Dragon");
		btnGoldDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(24, "Gold Dragon", "src/MathQuest/Files/Gold Dragon Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnGoldDragon);
		
		JButton btnUniverseDragon = new JButton("Universe Dragon");
		btnUniverseDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creature = new Character(40, "Universe Dragon", "src/MathQuest/Files/Universe Dragon Portrait.png", DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}	
		});
		creatureSelectionPanel.add(btnUniverseDragon);
		
		this.renderBackground();
	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this, this.hero, true);
	}

	@Override
	public void loadImages() {
		try {                
			this.background = new ImageIcon(ImageIO.read(new File("src/MathQuest/Files/killingFields.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
