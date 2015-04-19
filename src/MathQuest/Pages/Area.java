package MathQuest.Pages;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MathQuest.GUI.CharacterPanel;
import MathQuest.GUI.InventoryPanel;
import MathQuest.GUI.OptionsMenu;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;
import MathQuest.Logic.Item;

public abstract class Area extends JPanel {

	private static final long serialVersionUID = 1L;

	protected static OptionsMenu optionsMenu;
	protected static InventoryPanel inventoryPanel;

	protected CharacterPanel characterPanel;
	protected OptionsPanel optionsPanel;
	protected ImageIcon background;
	protected JLabel backgroundLabel;	
	protected Character hero;

	public static boolean isOptionsVisible;
	public static boolean isInventoryVisible;

	public Area(Character hero) {

		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);

		if(null != hero) {
			this.hero = hero;
			this.characterPanel = new CharacterPanel(this, this.hero, true, false);
			characterPanel.setLayout(null);
			characterPanel.setBounds(6, 6, 107, 144);
			add(characterPanel);
			
			isOptionsVisible = true;
			optionsMenu = new OptionsMenu(this);	
			Area.toggleOptions();
			add(optionsMenu);

			isInventoryVisible = true;
			inventoryPanel = new InventoryPanel(this, this.hero, hero.getInventory());
			Area.toggleInventory();
			add(inventoryPanel);

		}

		this.optionsPanel = loadOptionsPanel();
		if(null == optionsPanel) {

		}
		else if(this instanceof KillingFields) {
			optionsPanel.setLayout(null);
			optionsPanel.setBounds(891, 675, 125, 62);
			add(optionsPanel);
		}
		else{
			optionsPanel.setLayout(null);
			optionsPanel.setBounds(891, 645, 125, 92);
			add(optionsPanel);
		}
		
		this.refresh();
	}

	public abstract OptionsPanel loadOptionsPanel();

	public abstract void loadImages();

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

	public void reloadInventoryPanel(boolean a, ArrayList<Item> items) {

		this.remove(inventoryPanel);
		inventoryPanel = new InventoryPanel(this, this.hero, items);
		add(inventoryPanel);
		inventoryPanel.setVisible(a);
		this.renderBackground();
	}	

	public void renderBackground() {
		if(null != this.backgroundLabel)
			this.remove(backgroundLabel);

		this.backgroundLabel = new JLabel();
		backgroundLabel.setBounds(0, 0, 1024, 768);
		backgroundLabel.setIcon(this.background);
		add(backgroundLabel);
		this.revalidate();
		this.repaint();
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
	
	public void refresh() {
		this.revalidate();
		this.repaint();
	}
	
}
