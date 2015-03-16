package MathQuest.Logic;

import MathQuest.GUI.Inventory;

import java.lang.Math;

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
	boolean itemDropped;
	
	public Loot(){
		
		itemName = "Terrible Item";
	itemLevel = 1;
	dmg = 0;
	str = 0;
	dex = 0;
	armor = 0;
	gold = 0;
	speed = 0;
	chanceToDrop = 1;	
}

public Loot(Character player, Character monster){
	
	
}


/////////////////////////////////////////////Weapons/////////////////////////////////////////////
public boolean Weapon1(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W1";
		itemLevel = 1;
		dmg = itemLevel * 2;
		str = 1;
		dex = 0;
		armor = 0;
		gold = itemLevel * 5;
		speed = 0;
		chanceToDrop = .5;
		itemDropped = true;
		return itemDropped;
		
	}

public boolean Weapon2(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W2";
	itemLevel = 2;
	dmg = itemLevel * 2;
	str = 1;
	dex = 1;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}

public boolean Weapon3(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W3";
	itemLevel = 3;
	dmg = itemLevel * 2;
	str = 2;
	dex = 1;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}

public boolean Weapon4(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W4";
	itemLevel = 4;
	dmg = itemLevel * 2;
	str = 3;
	dex = 1;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}

public boolean Weapon5(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W5";
	itemLevel = 5;
	dmg = itemLevel * 2;
	str = 2;
	dex = 3;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}

public boolean Weapon6(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W6";
	itemLevel = 6;
	dmg = itemLevel * 2;
	str = 3;
	dex = 3;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}

public boolean Weapon7(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W7";
	itemLevel = 7;
	dmg = itemLevel * 2;
	str = 5;
	dex = 2;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}

public boolean Weapon8(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W8";
	itemLevel = 8;
	dmg = itemLevel * 2;
	str = 3;
	dex = 5;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}

public boolean Weapon9(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W9";
	itemLevel = 9;
	dmg = itemLevel * 2;
	str = 5;
	dex = 4;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}

public boolean Weapon10(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "W10";
	itemLevel = 10;
	dmg = itemLevel * 2;
	str = 7;
	dex = 3;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
	
}
/////////////////////////////////////////////Armor-helms/////////////////////////////////////////////

public boolean Helmet1(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H1";
	itemLevel = 1;
	dmg = 0;
	str = 1;
	dex = 0;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet2(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H2";
	itemLevel = 2;
	dmg = 0;
	str = 1;
	dex = 1;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet3(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H3";
	itemLevel = 3;
	dmg = 0;
	str = 1;
	dex = 2;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet4(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H4";
	itemLevel = 4;
	dmg = 0;
	str = 3;
	dex = 1;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet5(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H5";
	itemLevel = 5;
	dmg = 0;
	str = 2;
	dex = 3;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet6(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H6";
	itemLevel = 6;
	dmg = 0;
	str = 5;
	dex = 1;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet7(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H7";
	itemLevel = 7;
	dmg = 0;
	str = 2;
	dex = 5;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet8(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H8";
	itemLevel = 8;
	dmg = 0;
	str = 4;
	dex = 4;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet9(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H9";
	itemLevel = 9;
	dmg = 0;
	str = 6;
	dex = 3;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Helmet10(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "H10";
	itemLevel = 10;
	dmg = 0;
	str = 4;
	dex = 6;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

/////////////////////////////////////////////Armor-chest/////////////////////////////////////////////

public boolean Chest1(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C1";
	itemLevel = 1;
	dmg = 0;
	str = 0;
	dex = 1;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest2(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C2";
	itemLevel = 2;
	dmg = 0;
	str = 2;
	dex = 0;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest3(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C3";
	itemLevel = 3;
	dmg = 0;
	str = 2;
	dex = 1;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest4(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C4";
	itemLevel = 4;
	dmg = 0;
	str = 1;
	dex = 3;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest5(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C5";
	itemLevel = 5;
	dmg = 0;
	str = 3;
	dex = 2;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest6(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C6";
	itemLevel = 6;
	dmg = 0;
	str = 2;
	dex = 4;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest7(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C7";
	itemLevel = 7;
	dmg = 0;
	str = 5;
	dex = 2;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest8(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C8";
	itemLevel = 8;
	dmg = 0;
	str = 4;
	dex = 4;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest9(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C9";
	itemLevel = 9;
	dmg = 0;
	str = 3;
	dex = 6;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Chest10(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "C10";
	itemLevel = 10;
	dmg = 0;
	str = 8;
	dex = 2;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

/////////////////////////////////////////////Armor-legs/////////////////////////////////////////////

public boolean Legs1(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L1";
	itemLevel = 1;
	dmg = 0;
	str = 0;
	dex = 1;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs2(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L2";
	itemLevel = 2;
	dmg = 0;
	str = 1;
	dex = 1;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs3(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L3";
	itemLevel = 3;
	dmg = 0;
	str = 2;
	dex = 1;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs4(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L4";
	itemLevel = 4;
	dmg = 0;
	str = 1;
	dex = 3;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs5(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L5";
	itemLevel = 5;
	dmg = 0;
	str = 3;
	dex = 2;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs6(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L6";
	itemLevel = 6;
	dmg = 0;
	str = 2;
	dex = 4;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs7(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L7";
	itemLevel = 7;
	dmg = 0;
	str = 4;
	dex = 3;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs8(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L8";
	itemLevel = 8;
	dmg = 0;
	str = 3;
	dex = 5;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs9(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L9";
	itemLevel = 9;
	dmg = 0;
	str = 5;
	dex = 4;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Legs10(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "L10";
	itemLevel = 10;
	dmg = 0;
	str = 3;
	dex = 7;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}


/////////////////////////////////////////////Armor-boots/////////////////////////////////////////////

public boolean Boots1(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B1";
	itemLevel = 1;
	dmg = 0;
	str = 0;
	dex = 1;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots2(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B2";
	itemLevel = 2;
	dmg = 0;
	str = 1;
	dex = 1;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots3(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B3";
	itemLevel = 3;
	dmg = 0;
	str = 0;
	dex = 3;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots4(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B4";
	itemLevel = 4;
	dmg = 0;
	str = 2;
	dex = 2;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots5(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B5";
	itemLevel = 5;
	dmg = 0;
	str = 1;
	dex = 4;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots6(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B6";
	itemLevel = 6;
	dmg = 0;
	str = 3;
	dex = 3;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots7(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B7";
	itemLevel = 7;
	dmg = 0;
	str = 1;
	dex = 6;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots8(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B8";
	itemLevel = 8;
	dmg = 0;
	str = 2;
	dex = 6;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots9(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B9";
	itemLevel = 9;
	dmg = 0;
	str = 4;
	dex = 5;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

public boolean Boots10(Character monster){
	
	int monsterLvl = monster.getLevel();
	itemName = "B10";
	itemLevel = 10;
	dmg = 0;
	str = 1;
	dex = 9;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	chanceToDrop = .5;
	itemDropped = true;
	return itemDropped;
}

	public int getItemLvl(){
		return this.itemLevel;
	}
	
	public String getItemName(){
		return this.itemName;
	}
	
	public int getItemDmg(){
		return this.dmg;
	}
	
	public int getItemGold(){
		return this.gold;
	}

}
