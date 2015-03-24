package MathQuest.GUI;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import MathQuest.Logic.Character;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class InventoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public InventoryPanel(Character hero) {
		this.setBounds(683, 0, 341, 768);
		this.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		setLayout(null);
		
		JPanel characterPanel = new JPanel();
		characterPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		characterPanel.setBounds(10, 10, 321, 37);
		add(characterPanel);
		characterPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Character Sheet");
		lblNewLabel.setBounds(49, 5, 219, 27);
		characterPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 24));
		
		JPanel characterStatsPanel = new JPanel();
		characterStatsPanel.setBounds(10, 54, 321, 325);
		add(characterStatsPanel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 387, 321, 37);
		add(panel);
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setBounds(49, 5, 219, 27);
		panel.add(lblInventory);
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 24));
	}
}
