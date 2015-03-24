package MathQuest.Logic;

import MathQuest.GUI.InventoryPanel;

import java.lang.Math;

import java.util.ArrayList;

/*
 * I believe this class is useless but I'm leaving it here just in case. 
 * 
 * Item.java is no longer a child of this class and should work on its own.
 */

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

public Loot(int monsterLvl){
	
	createRandomItems(monsterLvl);
	
}



private ArrayList<Item> createRandomItems(int monsterLvl){
	
	ArrayList <Item> itemsDropped = new ArrayList <Item>();
	boolean droppedBasic = chanceToDropBasic();
	boolean droppedRare = chanceToDropRare();
	boolean droppedEpic = chanceToDropEpic();
	boolean droppedLegendary = chanceToDropLegendary();
	if (droppedRare == false)
		System.out.println("No rare Items");
	else{
		Item rareItem = new Item(monsterLvl, 5);
		itemsDropped.add(rareItem);
	}
	
	return itemsDropped;
}

private boolean chanceToDropBasic(){
	itemDropped = false;
	double random = Math.random()*100;
	if (random <= 50)
		itemDropped = true;
	return itemDropped;
}

private boolean chanceToDropRare(){
	itemDropped = false;
	double random = Math.random()*100;
	if (random <= 25)
		itemDropped = true;
	return itemDropped;
}

private boolean chanceToDropEpic(){
	itemDropped = false;
	double random = Math.random()*100;
	if (random <= 10)
		itemDropped = true;
	return itemDropped;
}

private boolean chanceToDropLegendary(){
	itemDropped = false;
	double random = Math.random()*100;
	if (random <= 2)
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

