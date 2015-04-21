package MathQuest.GUI;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class ItemViewer extends JPanel {

	private static final long serialVersionUID = 1L;

	public ItemViewer(String itemName, int vitality, int strength) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		Integer lifeActual = vitality;
		Integer strengthActual = strength;

		JLabel lblNewLabel = new JLabel(itemName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 289, 22);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 289, 39);
		add(panel);
		panel.setLayout(null);

		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblStrength.setBounds(145, 11, 67, 14);
		panel.add(lblStrength);

		JLabel lblLife = new JLabel("Life:");
		lblLife.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblLife.setBounds(10, 11, 67, 14);
		panel.add(lblLife);

		JLabel lblLifeActual = new JLabel(lifeActual.toString());
		lblLifeActual.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblLifeActual.setBounds(77, 11, 67, 14);
		panel.add(lblLifeActual);

		JLabel lblStrengthActual = new JLabel(strengthActual.toString());
		lblStrengthActual.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		lblStrengthActual.setBounds(212, 11, 67, 14);
		panel.add(lblStrengthActual);

	}
}
