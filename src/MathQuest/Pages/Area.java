package MathQuest.Pages;

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import MathQuest.MathQuest;
import MathQuest.GUI.CharacterPanel;
import MathQuest.GUI.OptionsMenu;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

public abstract class Area extends JPanel {

	private static final long serialVersionUID = 1L;
	protected static final BasicPlayer musicPlayer = new BasicPlayer();
	protected static final BasicPlayer soundPlayer = new BasicPlayer();
	protected static final BasicPlayer effectPlayer = new BasicPlayer();
	protected static final Random RANDOM = new Random();
	
	protected static OptionsMenu optionsMenu;
	protected CharacterPanel characterPanel;
	protected OptionsPanel optionsPanel;
	protected ImageIcon background;
	protected JLabel backgroundLabel;	
	protected Character hero;
	protected boolean isEnabled;

	public Area(Character hero, String musicFilePath) {

		if(null != musicFilePath)
			this.initializeMusic(musicFilePath);
		setVolume();
		
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.isEnabled = true;
		this.hero = hero;

		optionsMenu = new OptionsMenu(this);
		
		hideOptions();
		add(optionsMenu);
		
		this.characterPanel = new CharacterPanel(this.hero, true);
		characterPanel.setLayout(null);
		characterPanel.setBounds(6, 6, 107, 144);
		add(characterPanel);

		this.optionsPanel = loadOptionsPanel();
		if(null == optionsPanel) {

		}
		else { 
			optionsPanel.setLayout(null);
			optionsPanel.setBounds(884, 643, 132, 94);
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
		characterPanel.setBounds(6, 6, 107, 144);
		add(characterPanel);
		this.renderBackground();
		this.repaint();
	}
		
	public void renderBackground() {

		if(null != this.backgroundLabel)
			this.remove(backgroundLabel);

		this.backgroundLabel = new JLabel();
		backgroundLabel.setBounds(0, 0, 1024, 768);
		backgroundLabel.setIcon(this.background);
		add(backgroundLabel);
	}
	
	public static void setVolume() {
		double volume = MathQuest.getVolume();
		try {
			musicPlayer.setGain(volume);
			soundPlayer.setGain(volume);
			effectPlayer.setGain(volume);
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}
	
	public void initializeMusic(String fileName) {

		String musicPath = String.format("file:///%s%s%s", System.getProperty("user.dir").replace("\\", "/"), "/", fileName);

		try {
			musicPlayer.open(new URL(musicPath));
			musicPlayer.play();
		}
		catch(BasicPlayerException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void stopMusic() {
		try {
			musicPlayer.stop();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}	
	
	public static void showOptions() {
		optionsMenu.setVisible(true);
	}
	
	public static void hideOptions() {
		optionsMenu.setVisible(false);
	}
}
