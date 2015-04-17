package MathQuest.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class LogPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextArea scrollText;

	public LogPanel(String textHeader) {
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(174, 542, 338, 192);
		this.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 22, 338, 170);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		this.add(scrollPane);

		this.scrollText = new JTextArea();
		this.scrollText.setEditable(false);
		this.scrollText.setLineWrap(true);
		this.scrollText.setWrapStyleWord(true);
		scrollPane.setViewportView(scrollText);

		JLabel combatLogLabel = new JLabel(textHeader);
		combatLogLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		combatLogLabel.setBorder(new LineBorder(Color.black));
		combatLogLabel.setHorizontalAlignment(SwingConstants.CENTER);
		combatLogLabel.setBounds(0, 0, 338, 22);
		this.add(combatLogLabel);
	}

	public void addTextToScrollPane(String text) {
		this.scrollText.append(text);
		this.scrollText.append("\n");
		this.revalidate();
		this.repaint();
	}
}
