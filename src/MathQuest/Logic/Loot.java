package MathQuest.Logic;

import java.lang.Math;



public class Loot {

	
	static String rarity;
	


public static Item getLoot(int monsterLvl){
	
	chanceToDrop();
	
	if (rarity == "black")
		return null;
	Item itemDropped = new Item(monsterLvl, rarity);
	
	return itemDropped;
}


private static String chanceToDrop(){
	double random = Math.random();
	if (random <= .3)
		rarity = "gray";
	else if (random > .3 && random <= .43)
		rarity = "green";
	else if (random > .43 && random <= .48)
		rarity = "blue";
	else if (random > .48 && random <= .5)
		rarity = "orange";
	else if (random > .5 && random <= .5001)
		rarity = "red";
	else
		rarity = "black";
	return rarity;
}


}

