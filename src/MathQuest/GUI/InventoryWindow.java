package MathQuest.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import MathQuest.Logic.Character;
import MathQuest.Logic.Item;
import MathQuest.Pages.Area;

import javax.swing.JButton;
import javax.swing.JList;

public class InventoryWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String header;
	
	public InventoryWindow(final Area frame, final Character hero, String headerText) {

		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(172, 150, 338, 177);
		this.setLayout(null);
		this.header = headerText;
		
		JLabel combatLogLabel = new JLabel(headerText);
		combatLogLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		combatLogLabel.setBorder(new LineBorder(Color.black));
		combatLogLabel.setHorizontalAlignment(SwingConstants.CENTER);
		combatLogLabel.setBounds(0, 0, 338, 22);
		this.add(combatLogLabel);

		JPanel windowPanelBody = new JPanel();
		windowPanelBody.setBounds(0, 22, 338, 155);
		windowPanelBody.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		add(windowPanelBody);
		windowPanelBody.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 318, 104);
		windowPanelBody.add(scrollPane);

		ArrayList<Item> slotItems = new ArrayList<Item>();
		for(Item el : hero.getInventory()) {
			if(el.getSlot().equals(header))
				slotItems.add(el);
		}
		final JList itemList = new JList(slotItems.toArray());
		scrollPane.setViewportView(itemList);

		JButton btnEquip = new JButton("Equip");
		btnEquip.setBounds(125, 122, 88, 23);
		btnEquip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hero.equip(itemList.getSelectedValue());
				frame.removeInventoryWindow();
				frame.reloadInventoryPanel();
			}
		});
		windowPanelBody.add(btnEquip);
		
		
		
	}
	
	public String getHeaderText() {
		return header;
	}
}
