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
import MathQuest.GUI.InventoryPanel;
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
	protected static InventoryPanel inventoryPanel;

	protected CharacterPanel characterPanel;
	protected OptionsPanel optionsPanel;
	protected ImageIcon background;
	protected JLabel backgroundLabel;	
	protected Character hero;
	protected boolean isEnabled;
	
	public static boolean isOptionsVisible;
	public static boolean isInventoryVisible;
	
	public Area(Character hero, String musicFilePath) {

		if(null != musicFilePath)
			this.initializeMusic(musicFilePath);
		setVolume();

		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.isEnabled = true;
		this.hero = hero;

		isOptionsVisible = true;
		optionsMenu = new OptionsMenu(this);	
		Area.toggleOptions();
		add(optionsMenu);
		
		isInventoryVisible = true;
		inventoryPanel = new InventoryPanel(this, this.hero);
		Area.toggleInventory();
		add(inventoryPanel);

		this.characterPanel = new CharacterPanel(this, this.hero, true, false);
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

	public void setBackground()
	{
		this.backgroundLabel = null;
	}

	public void reloadCharacterPanel() {

		this.remove(characterPanel);
		this.characterPanel = new CharacterPanel(this, this.hero, true, false);
		characterPanel.setLayout(null);
		characterPanel.setBounds(6, 6, 107, 144);
		add(characterPanel);
		this.renderBackground();
	}

	public void renderBackground() {

		if(null != this.backgroundLabel)
			this.remove(backgroundLabel);

		this.backgroundLabel = new JLabel();
		backgroundLabel.setBounds(0, 0, 1024, 768);
		backgroundLabel.setIcon(this.background);
		add(backgroundLabel);
		this.repaint();
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

	public static void toggleInventory() {
		isInventoryVisible = !isInventoryVisible;
		if(isInventoryVisible && isOptionsVisible)
			toggleOptions();
		inventoryPanel.setVisible(isInventoryVisible);
	}

	public static void toggleOptions() {
		isOptionsVisible = !isOptionsVisible;
		if(isOptionsVisible && isInventoryVisible)
			toggleInventory();
		optionsMenu.setVisible(isOptionsVisible);
	}
}
