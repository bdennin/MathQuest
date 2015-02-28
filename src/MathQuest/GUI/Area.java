package MathQuest.GUI;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MathQuest.Logic.Character;

public abstract class Area extends JPanel {

	private static final long serialVersionUID = 1L;
	protected CharacterPanel characterPanel;
	protected OptionsPanel optionsPanel;
	protected ImageIcon background;
	protected JLabel backgroundPanel;	
	protected Character hero;

	public Area(Character hero) {

		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.hero = hero;

		this.characterPanel = new CharacterPanel(this.hero);
		characterPanel.setLayout(null);
		characterPanel.setBounds(6, 6, 111, 150);
		add(characterPanel);

		this.optionsPanel = loadOptionsPanel();
		if(null == optionsPanel) {

		}
		else { 
			optionsPanel.setLayout(null);
			optionsPanel.setBounds(881, 640, 137, 99);
			add(optionsPanel);
		}
	}

	public abstract OptionsPanel loadOptionsPanel();

	public abstract void loadImages();

	public void toggleElements(boolean isEnabled) {
		for(Component el : this.getComponents()) {
			el.setEnabled(isEnabled);
		}
		for(Component el : this.optionsPanel.getComponents()) {
			el.setEnabled(isEnabled);
		}
		for(Component el : this.characterPanel.getComponents()) {
			el.setEnabled(isEnabled);
		}
	}
	
	public CharacterPanel getCharacterPanel() {
		return this.characterPanel;
	}

	public Character getHero() {
		return this.hero;
	}

	public OptionsPanel getOptionsPanel() {
		return this.optionsPanel;
	}

	public void reloadCharacterPanel() {

		this.remove(characterPanel);
		this.characterPanel = new CharacterPanel(this.hero);
		characterPanel.setLayout(null);
		characterPanel.setBounds(6, 6, 111, 150);
		add(characterPanel);
		this.renderBackground();
		this.repaint();
	}
	
	public void renderBackground() {
		
		if(null != this.backgroundPanel)
			this.remove(backgroundPanel);
		
		this.backgroundPanel = new JLabel();
		backgroundPanel.setBounds(0, 0, 1024, 768);
		backgroundPanel.setIcon(this.background);
		add(backgroundPanel);
	}
}
