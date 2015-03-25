package MathQuest.Logic;

import java.lang.Math;



public class Loot {

	
	static String rarity;
	


public static Item getLoot(int monsterLvl){
	
	chanceToDrop();
	
	if (rarity == Color.black)
		return null;
	Item itemDropped = new Item(monsterLvl, rarity);
	
	return itemDropped;
}


private static String chanceToDrop(){
	double random = Math.random();
	if (random <= .50)
		rarity = "white";
	else if (random > .50 && random <= .75)
		rarity = "green";
	else if (random > .75 && random <= .85)
		rarity = "blue";
	else if (random > .85 && random <= .87)
		rarity = "orange";
	else
		rarity = "black";
	return rarity;
}


}

