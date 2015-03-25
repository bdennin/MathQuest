package MathQuest.GUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JCheckBox;

import MathQuest.MathQuest;


import MathQuest.Pages.Area;
import MathQuest.Pages.World;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OptionsMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public OptionsMenu(final Area frame) {
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(343, 296, 338, 177);
		setLayout(null);	
		
		JLabel optionsLabel = new JLabel("Options");
		optionsLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		optionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionsLabel.setBorder(new LineBorder(Color.BLACK));
		optionsLabel.setBounds(0, 0, 338, 22);
		this.add(optionsLabel);
		
		JPanel optionsBody = new JPanel();
		optionsBody.setBounds(0, 21, 338, 156);
		optionsBody.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		this.add(optionsBody);
		optionsBody.setLayout(null);
		
		JLabel volumeLabel = new JLabel("Volume");
		volumeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		volumeLabel.setBounds(10, 11, 80, 22);
		optionsBody.add(volumeLabel);
		
		final JSlider volumeSlider = new JSlider();
		volumeSlider.setPaintTicks(true);
		volumeSlider.setSnapToTicks(true);
		volumeSlider.setValue((int)(MathQuest.getVolume() * 10));
		volumeSlider.setMinorTickSpacing(1);
		volumeSlider.setMaximum(10);
		volumeSlider.setBounds(100, 11, 228, 22);
		volumeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				double volume = (double)((double)volumeSlider.getValue()/10);
				MathQuest.setVolume(volume);
				Area.setVolume();
			}	
		});
		optionsBody.add(volumeSlider);
		
		final JCheckBox checkboxMuteSound = new JCheckBox("Mute Sound");
		checkboxMuteSound.setBounds(100, 40, 97, 23);
		checkboxMuteSound.setSelected(MathQuest.isMuted);
		checkboxMuteSound.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkboxMuteSound.isSelected()) {
					volumeSlider.setValue(0);
					volumeSlider.setEnabled(false);
				}
				else {
					volumeSlider.setValue(10);
					volumeSlider.setEnabled(true);
				}
			}
		});
		optionsBody.add(checkboxMuteSound);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(125, 122, 88, 23);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Area.toggleOptions();
				World world = (World)frame;
				world.loadJLabels();
				world.renderBackground();
			}
		});
		optionsBody.add(btnClose);
	}
}