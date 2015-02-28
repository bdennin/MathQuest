package MathQuest.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import MathQuest.MathQuest;
import MathQuest.Logic.Character;

public class OptionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public OptionsPanel(Character hero, boolean hasReturn) {
		
		this.setLayout(null);
		this.setBounds(0, 0, 137, 99);

		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.setBounds(6, 6, 125, 29);
		this.add(inventoryButton);

		JButton button = new JButton();
		button.setBounds(6, 35, 125, 29);
	
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
				}
			});

		}
		this.add(button);

		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(6, 64, 125, 29);
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(quitButton);
	}
}
