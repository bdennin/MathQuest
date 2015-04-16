package MathQuest.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import MathQuest.MathQuest;
import MathQuest.Database.Database;
import MathQuest.Logic.Character;
import MathQuest.Pages.Area;
import MathQuest.Pages.World;
import java.awt.GridLayout;
import java.awt.Font;

public class OptionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public OptionsPanel(final Area frame, final Character hero, boolean hasReturn) {
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBounds(0, 0, 125, 92);
		optionsPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		optionsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		this.add(optionsPanel);
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		inventoryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Area.isInventoryVisible && frame instanceof World) {
					World world = (World)frame;
					world.loadJLabels();
				}
				else if(!Area.isInventoryVisible && frame instanceof World) {
					World world = (World)frame;
					world.removeLabels();
				}
				Area.toggleInventory();
				frame.renderBackground();
			}
		});
		optionsPanel.add(inventoryButton);

		JButton button = new JButton();
		button.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));

		if(hasReturn) {
			button.setText("Return");
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MathQuest.switchToGameWorld();
				}
			});
		}
		else {
			button.setText("Options");
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					World world = (World)frame;
					if(Area.isOptionsVisible) {
						world.loadJLabels();
					}
					else {
						world.removeLabels();
					}
					Area.toggleOptions();
					frame.renderBackground();
				}
			});

		}
		optionsPanel.add(button);

		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MathQuest.connectToDatabase){
					Database.getConnected();
					Database.setStatus(hero.getStatus());
					Database.saveInventory(hero.getInventory());
					Database.saveAccuracy(hero.getAnsweredCorrectly(), hero.getAnsweredIncorrectly());
					Database.close();
				}
				System.exit(0);
			}
		});
		optionsPanel.add(quitButton);
	}

	public OptionsPanel(final Area frame, final Character hero) {
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBounds(0, 0, 125, 62);
		optionsPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		optionsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		this.add(optionsPanel);
		
		JButton button = new JButton("Return");
		button.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MathQuest.switchToGameWorld();
			}
		});
		optionsPanel.add(button);

		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MathQuest.connectToDatabase){
					Database.getConnected();
					Database.setStatus(hero.getStatus());
					Database.saveInventory(hero.getInventory());
					Database.saveAccuracy(hero.getAnsweredCorrectly(), hero.getAnsweredIncorrectly());
					Database.close();
				}
				System.exit(0);
			}
		});
		optionsPanel.add(quitButton);
	}
}
