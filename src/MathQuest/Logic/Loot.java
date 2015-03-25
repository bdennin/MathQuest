package MathQuest.Logic;

import MathQuest.GUI.InventoryPanel;

import java.awt.Color;
import java.lang.Math;



public class Loot {

	
	static Color rarity;
	


public static Item getLoot(int monsterLvl){
	
	chanceToDrop();
	Item itemDropped = new Item(monsterLvl, rarity);
	
	return itemDropped;
}


private static Color chanceToDrop(){
	double random = Math.random()*100;
	if (random <= 50)
		rarity = Color.white;
	else if (random > 50 && random <= 75)
		rarity = Color.green;
	else if (random > 75 && random <= 85)
		rarity = Color.blue;
	else if (random > 85 && random <= 87)
		rarity = Color.orange;
	else
		rarity = Color.black;
	return rarity;
}


}

