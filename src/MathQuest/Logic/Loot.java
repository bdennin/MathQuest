package MathQuest.Logic;

import MathQuest.GUI.Inventory;

public class Loot {

	String itemName;
	int itemLevel;
	int dmg;
	int str;
	int dex;
	int armor;
	int gold;
	int speed;
	double chanceToDrop;
	
	public Loot(){
		
		itemName = "Terrible Item";
		itemLevel = 1;
		dmg = 0;
		str = 0;
		dex = 0;
		armor = 0;
		gold = 0;
		speed = 0;
		
		
	}
	
	public int getItemLvl(){
		return this.itemLevel;
	}
	
	public String getItemName(){
		return this.itemName;
	}
	
	
	//Weapons
	
	//Armor-helmet
	
	//Armor-chest
	
	//Armor-legs
	
	//Armor-boots
	
	
}
