package MathQuest.Pages;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MathQuest.GUI.CharacterPanel;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

public abstract class Area extends JPanel {

	private static final long serialVersionUID = 1L;
	protected CharacterPanel characterPanel;
	protected OptionsPanel optionsPanel;
	protected ImageIcon background;
	protected JLabel backgroundPanel;	
	protected Character hero;
	protected boolean isEnabled;

	public Area(Character hero) {

		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.isEnabled = true;
		this.hero = hero;

		this.characterPanel = new CharacterPanel(this.hero, true);
		characterPanel.setLayout(null);
		characterPanel.setBounds(6, 6, 111, 149);
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

	public void toggleElements() {
		this.isEnabled = !isEnabled;
		for(Component el : this.getComponents()) {
			el.setEnabled(isEnabled);
		}
		this.revalidate();
		this.repaint();
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
		this.characterPanel = new CharacterPanel(this.hero, true);
		characterPanel.setLayout(null);
		characterPanel.setBounds(6, 6, 111, 149);
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
