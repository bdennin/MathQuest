package MathQuest.Pages;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private JLabel creatureImage;
	private Character creature;
	
	public KillingFields(Character hero) {
		super(hero, MathQuest.class.getResource("Files/killingFieldsMusic.mp3"));
		this.loadImages();
		
		JPanel creaturePanel = new JPanel();
		creaturePanel.setBackground(Color.GRAY);
		creaturePanel.setBounds(277, 485, 470, 252);
		creaturePanel.setLayout(null);
		add(creaturePanel);
		
		JPanel creatureHeaderPanel = new JPanel();
		creatureHeaderPanel.setBorder(new LineBorder(Color.BLACK));
		creatureHeaderPanel.setBackground(Color.LIGHT_GRAY);
		creatureHeaderPanel.setBounds(0, 0, 470, 22);
		creatureHeaderPanel.setLayout(null);
		creaturePanel.add(creatureHeaderPanel);

		
		JLabel creatureHeader = new JLabel("Creatures");
		creatureHeader.setHorizontalAlignment(SwingConstants.CENTER);
		creatureHeader.setBounds(0, 0, 470, 22);
		creatureHeader.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		creatureHeaderPanel.add(creatureHeader);
		
		JPanel creatureSelectionPanel = new JPanel();
		creatureSelectionPanel.setBounds(0, 22, 470, 230);
		creatureSelectionPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		creatureSelectionPanel.setLayout(new GridLayout(0, 4, 0, 0));
		creaturePanel.add(creatureSelectionPanel);
		
		JButton btnGoblin = new JButton("Goblin");
		btnGoblin.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnGoblin.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Goblin.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(1, "Goblin", MathQuest.class.getResource("Files/Goblin Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		creatureSelectionPanel.add(btnGoblin);
		
		JButton btnOrc = new JButton("Orc");
		btnOrc.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnOrc.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Orc.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(2, "Orc",  MathQuest.class.getResource("Files/Orc Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		JButton btnPitFiend = new JButton("Pit Fiend");
		btnPitFiend.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnPitFiend.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Pit Fiend.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(25, "Pit Fiend", MathQuest.class.getResource("Files/Pit Fiend Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		JButton btnSuccubus = new JButton("Succubus");
		btnSuccubus.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnSuccubus.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
	
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Succubus.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(17, "Succubus", MathQuest.class.getResource("Files/Succubus Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		JButton btnDemon = new JButton("Demon");
		btnDemon.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnDemon.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
	
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Demon.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(9, "Demon", MathQuest.class.getResource("Files/Demon Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		creatureSelectionPanel.add(btnDemon);
		creatureSelectionPanel.add(btnSuccubus);
		creatureSelectionPanel.add(btnPitFiend);
		creatureSelectionPanel.add(btnOrc);
		
		JButton btnHarpy = new JButton("Harpy");
		btnHarpy.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnHarpy.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Harpy.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(10, "Harpy", MathQuest.class.getResource("Files/Harpy Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		creatureSelectionPanel.add(btnHarpy);
		
		JButton btnFireElemental = new JButton("<html><center>Fire<br/>Elemental</center></html>");
		btnFireElemental.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnFireElemental.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Fire Elemental.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(18, "Fire Elemental", MathQuest.class.getResource("Files/Fire Elemental Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		creatureSelectionPanel.add(btnFireElemental);
		
		
		JButton btnNightmare = new JButton("Nightmare");
		btnNightmare.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnNightmare.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Nightmare.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(27, "Nightmare", MathQuest.class.getResource("Files/Nightmare Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		creatureSelectionPanel.add(btnNightmare);
		
		JButton btnVampireKnight = new JButton("<html><center>Vampire<br/>Knight</html></center>");
		btnVampireKnight.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnVampireKnight.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Vampire Knight.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(19, "Vampire Knight", MathQuest.class.getResource("Files/Vampire Knight Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		JButton btnEvilEye = new JButton("Evil Eye");
		btnEvilEye.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnEvilEye.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Evil Eye.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(11, "Evil Eye", MathQuest.class.getResource("Files/Evil Eye Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		JButton btnGhoul = new JButton("Ghoul");
		btnGhoul.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnGhoul.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Ghoul.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(3, "Ghoul", MathQuest.class.getResource("Files/Ghoul Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		creatureSelectionPanel.add(btnGhoul);
		creatureSelectionPanel.add(btnEvilEye);
		creatureSelectionPanel.add(btnVampireKnight);
		
		JButton btnCentaur = new JButton("Centaur");
		btnCentaur.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnCentaur.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Centaur.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(20, "Centaur", MathQuest.class.getResource("Files/Centaur Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		JButton btnGriffin = new JButton("Griffin");
		btnGriffin.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnGriffin.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Griffin.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(12, "Griffin", MathQuest.class.getResource("Files/Griffin Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		JButton btnSkeleton = new JButton("Skeleton");
		btnSkeleton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnSkeleton.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Skeleton.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(4, "Skeleton", MathQuest.class.getResource("Files/Skeleton Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
		
			}
		});
		
		JButton btnAngel = new JButton("Angel");
		btnAngel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnAngel.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
		
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Angel.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(28, "Angel", MathQuest.class.getResource("Files/Angel Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		creatureSelectionPanel.add(btnAngel);
		creatureSelectionPanel.add(btnSkeleton);
		creatureSelectionPanel.add(btnGriffin);
		creatureSelectionPanel.add(btnCentaur);
		
		JButton btnManticore = new JButton("Manticore");
		btnManticore.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnManticore.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Manticore.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(21, "Manticore", MathQuest.class.getResource("Files/Manticore Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}	
		});
		
		JButton btnEarthElemental = new JButton("<html><center>Earth<br/>Elemental</center></html>");
		btnEarthElemental.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnEarthElemental.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Earth Elemental.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(13, "Earth Elemental", MathQuest.class.getResource("Files/Earth Elemental Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
		
			}
		});
		
		JButton btnTormentor = new JButton("Tormentor");
		btnTormentor.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnTormentor.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Tormentor.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(5, "Tormentor", MathQuest.class.getResource("Files/Tormentor Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
		
			}
		});
		
		JButton btnIceDragon = new JButton("Ice Dragon");
		btnIceDragon.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnIceDragon.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Ice Dragon.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(30, "Ice Dragon", MathQuest.class.getResource("Files/Ice Dragon Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		
		creatureSelectionPanel.add(btnIceDragon);
		creatureSelectionPanel.add(btnTormentor);
		creatureSelectionPanel.add(btnEarthElemental);
		creatureSelectionPanel.add(btnManticore);
		
		JButton btnGiant = new JButton("Giant");
		btnGiant.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnGiant.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Giant.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(22, "Giant", MathQuest.class.getResource("Files/Giant Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		JButton btnAirElemental = new JButton("<html><center>Air<br/>Elemental</html></center>");
		btnAirElemental.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnAirElemental.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Air Elemental.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(14, "Air Elemental", MathQuest.class.getResource("Files/Air Elemental Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		
		JButton btnGhost = new JButton("Ghost");
		btnGhost.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnGhost.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Ghost.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(6, "Ghost", MathQuest.class.getResource("Files/Ghost Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
					
			}
		});
		
		JButton btnLightningDragon = new JButton("<html><center>Lightning<br/>Dragon</center></html>");
		btnLightningDragon.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnLightningDragon.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Lightning Dragon.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(32, "Lightning Dragon", MathQuest.class.getResource("Files/Lightning Dragon Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		creatureSelectionPanel.add(btnLightningDragon);
		creatureSelectionPanel.add(btnGhost);
		creatureSelectionPanel.add(btnAirElemental);
		creatureSelectionPanel.add(btnGiant);
		
		JButton btnEnchantress = new JButton("Enchantress");
		btnEnchantress.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnEnchantress.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Enchantress.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(7, "Enchantress", MathQuest.class.getResource("Files/Enchantress Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		
		JButton btnShadowDragon = new JButton("<html><center>Shadow<br/>Dragon</center></html>");
		btnShadowDragon.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnShadowDragon.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Shadow Dragon.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(35, "Shadow Dragon", MathQuest.class.getResource("Files/Shadow Dragon Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		creatureSelectionPanel.add(btnShadowDragon);
		creatureSelectionPanel.add(btnEnchantress);
		
		JButton btnVampire = new JButton("Vampire");
		btnVampire.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnVampire.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Vampire.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(16, "Vampire", MathQuest.class.getResource("Files/Vampire Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		
		JButton btnHellhound = new JButton("Hellhound");
		btnHellhound.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnHellhound.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
		
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Hellhound.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(8, "Hellhound", MathQuest.class.getResource("Files/Hellhound Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		
		JButton btnSpiderQueen = new JButton("<html><center>Spider<br/>Queen</html></center>");
		btnSpiderQueen.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnSpiderQueen.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Spider Queen.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(37, "Spider Queen", MathQuest.class.getResource("Files/Spider Queen Portrait.png"), DamageType.CRUSHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		
		JButton btnLich = new JButton("Lich");
		btnLich.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnLich.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Lich.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(23, "Lich", MathQuest.class.getResource("Files/Lich Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		
		JButton btnMinotaur = new JButton("Minotaur");
		btnMinotaur.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnMinotaur.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Minotaur.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(15, "Minotaur", MathQuest.class.getResource("Files/Minotaur Portrait.png"), DamageType.SLASHING);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});

		creatureSelectionPanel.add(btnMinotaur);
		creatureSelectionPanel.add(btnLich);
		creatureSelectionPanel.add(btnSpiderQueen);
		creatureSelectionPanel.add(btnHellhound);
		creatureSelectionPanel.add(btnVampire);
		
		JButton btnGoldDragon = new JButton("<html><center>Gold<br/>Dragon</html></center>");
		btnGoldDragon.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnGoldDragon.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Gold Dragon.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(24, "Gold Dragon", MathQuest.class.getResource("Files/Gold Dragon Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		creatureSelectionPanel.add(btnGoldDragon);
		
		JButton btnUniverseDragon = new JButton("<html><center>Universe<br/>Dragon</center></html>");
		btnUniverseDragon.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnUniverseDragon.addMouseListener(new MouseListener() {

			ImageIcon fullPortrait;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fullPortrait = new ImageIcon(MathQuest.class.getResource("Files/Universe Dragon.jpg"));
				addImage(fullPortrait);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				removeImage();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				creature = new Character(40, "Universe Dragon", MathQuest.class.getResource("Files/Universe Dragon Portrait.png"), DamageType.MAGICAL);
				MathQuest.switchToCombat(creature);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});
		creatureSelectionPanel.add(btnUniverseDragon);
		
		this.renderBackground();
	}

	public void removeImage() {
		this.remove(creatureImage);
		this.renderBackground();
	}
	
	public void addImage(ImageIcon image) {
		this.creatureImage = new JLabel();
		this.creatureImage.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		int height = image.getIconHeight();
		int width = image.getIconWidth();
		creatureImage.setBounds((1024 - width)/2, (768 - height)/2 - 140, width, height);
		creatureImage.setIcon(image);
		add(creatureImage);
		this.renderBackground();
	}
	
	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this, this.hero);
	}

	@Override
	public void loadImages() {              
		this.background = new ImageIcon(MathQuest.class.getResource("Files/killingFields.jpg"));
	}
}
