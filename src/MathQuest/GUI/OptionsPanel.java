package MathQuest.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import MathQuest.MathQuest;
import MathQuest.Logic.Character;
import MathQuest.Pages.Area;
import MathQuest.Pages.World;

public class OptionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public OptionsPanel(final Area frame, Character hero, boolean hasReturn) {
		
		this.setLayout(null);
		this.setBounds(0, 0, 132, 94);
		this.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));

		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.setBounds(3, 3, 125, 29);
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
		this.add(inventoryButton);

		JButton button = new JButton();
		button.setBounds(3, 32, 125, 29);
	
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
		this.add(button);

		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(3, 61, 125, 29);
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(quitButton);
	}
}
