package MathQuest.Logic;

import MathQuest.GUI.Inventory;

import java.lang.Math;

public class Loot {

	static String itemName;
	static int itemLevel;
	static int dmg;
	static int str;
	static int dex;
	static int armor;
	static int gold;
	static int speed;
	static double chanceToDrop;
	static boolean itemDropped;
	
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

public Loot(Character monster){
	/*
	System.out.print(itemLevel);
	int monsterLvl = monster.getLevel();
	if (monsterLvl == 1){
		double chanceToDrop = Math.random()*100;
		if (chanceToDrop >= 0){
			Loot.Weapon1();
			System.out.print(itemLevel);
		}
	}
	*/
	
	createRandomItem(monster);
	
}



private Item createRandomItem(Character monster){
	boolean dropped = chanceToDrop();
	if (dropped == false)
		return null;
	else{
		Item newItem = new Item(monster);
		return newItem;
	}
	
}

private boolean chanceToDrop(){
	itemDropped = false;
	double random = Math.random()*100;
	if (random <= 10)
		itemDropped = true;
	return itemDropped;
	
}


/////////////////////////////////////////////Weapons/////////////////////////////////////////////

public static void Weapon1(){
	
	 
	itemName = "W1";
	itemLevel = 1;
	dmg = itemLevel * 2;
	str = 1;
	dex = 0;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
	}

public static void Weapon2(){
	
	 
	itemName = "W2";
	itemLevel = 2;
	dmg = itemLevel * 2;
	str = 1;
	dex = 1;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
}

public static void Weapon3(){
	
	 
	itemName = "W3";
	itemLevel = 3;
	dmg = itemLevel * 2;
	str = 2;
	dex = 1;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
}

public static void Weapon4(){
	
	 
	itemName = "W4";
	itemLevel = 4;
	dmg = itemLevel * 2;
	str = 3;
	dex = 1;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
}

public static void Weapon5(){
	
	 
	itemName = "W5";
	itemLevel = 5;
	dmg = itemLevel * 2;
	str = 2;
	dex = 3;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
}

public static void Weapon6(){
	
	 
	itemName = "W6";
	itemLevel = 6;
	dmg = itemLevel * 2;
	str = 3;
	dex = 3;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
}

public static void Weapon7(){
	
	 
	itemName = "W7";
	itemLevel = 7;
	dmg = itemLevel * 2;
	str = 5;
	dex = 2;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
}

public static void Weapon8(){
	
	 
	itemName = "W8";
	itemLevel = 8;
	dmg = itemLevel * 2;
	str = 3;
	dex = 5;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
}

public static void Weapon9(){
	
	 
	itemName = "W9";
	itemLevel = 9;
	dmg = itemLevel * 2;
	str = 5;
	dex = 4;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
	
}

public static void Weapon10(){
	
	 
	itemName = "W10";
	itemLevel = 10;
	dmg = itemLevel * 2;
	str = 7;
	dex = 3;
	armor = 0;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
	
}
/////////////////////////////////////////////Armor-helms/////////////////////////////////////////////

public static void Helmet1(){
	
	 
	itemName = "H1";
	itemLevel = 1;
	dmg = 0;
	str = 1;
	dex = 0;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet2(){
	
	 
	itemName = "H2";
	itemLevel = 2;
	dmg = 0;
	str = 1;
	dex = 1;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet3(){
	
	 
	itemName = "H3";
	itemLevel = 3;
	dmg = 0;
	str = 1;
	dex = 2;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet4(){
	
	 
	itemName = "H4";
	itemLevel = 4;
	dmg = 0;
	str = 3;
	dex = 1;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet5(){
	
	 
	itemName = "H5";
	itemLevel = 5;
	dmg = 0;
	str = 2;
	dex = 3;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet6(){
	
	 
	itemName = "H6";
	itemLevel = 6;
	dmg = 0;
	str = 5;
	dex = 1;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet7(){
	
	 
	itemName = "H7";
	itemLevel = 7;
	dmg = 0;
	str = 2;
	dex = 5;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet8(){
	
	 
	itemName = "H8";
	itemLevel = 8;
	dmg = 0;
	str = 4;
	dex = 4;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet9(){
	
	 
	itemName = "H9";
	itemLevel = 9;
	dmg = 0;
	str = 6;
	dex = 3;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

public static void Helmet10(){
	
	 
	itemName = "H10";
	itemLevel = 10;
	dmg = 0;
	str = 4;
	dex = 6;
	armor = itemLevel * 3;
	gold = itemLevel * 5;
	speed = 0;
	 
	 
}

/////////////////////////////////////////////Armor-chest/////////////////////////////////////////////

public static void Chest1(){
	
	 
	itemName = "C1";
	itemLevel = 1;
	dmg = 0;
	str = 0;
	dex = 1;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	
}

public static void Chest2(){
	
	 
	itemName = "C2";
	itemLevel = 2;
	dmg = 0;
	str = 2;
	dex = 0;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

public static void Chest3(){
	
	 
	itemName = "C3";
	itemLevel = 3;
	dmg = 0;
	str = 2;
	dex = 1;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

public static void Chest4(){
	
	 
	itemName = "C4";
	itemLevel = 4;
	dmg = 0;
	str = 1;
	dex = 3;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

public static void Chest5(){
	
	 
	itemName = "C5";
	itemLevel = 5;
	dmg = 0;
	str = 3;
	dex = 2;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

public static void Chest6(){
	
	 
	itemName = "C6";
	itemLevel = 6;
	dmg = 0;
	str = 2;
	dex = 4;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

public static void Chest7(){
	
	 
	itemName = "C7";
	itemLevel = 7;
	dmg = 0;
	str = 5;
	dex = 2;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

public static void Chest8(){
	
	 
	itemName = "C8";
	itemLevel = 8;
	dmg = 0;
	str = 4;
	dex = 4;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

public static void Chest9(){
	
	 
	itemName = "C9";
	itemLevel = 9;
	dmg = 0;
	str = 3;
	dex = 6;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

public static void Chest10(){
	
	 
	itemName = "C10";
	itemLevel = 10;
	dmg = 0;
	str = 8;
	dex = 2;
	armor = itemLevel * 5;
	gold = itemLevel * 7;
	speed = 0;
	 
	 
}

/////////////////////////////////////////////Armor-legs/////////////////////////////////////////////

public static void Legs1(){
	
	 
	itemName = "L1";
	itemLevel = 1;
	dmg = 0;
	str = 0;
	dex = 1;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs2(){
	
	 
	itemName = "L2";
	itemLevel = 2;
	dmg = 0;
	str = 1;
	dex = 1;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs3(){
	
	 
	itemName = "L3";
	itemLevel = 3;
	dmg = 0;
	str = 2;
	dex = 1;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs4(){
	
	 
	itemName = "L4";
	itemLevel = 4;
	dmg = 0;
	str = 1;
	dex = 3;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs5(){
	
	 
	itemName = "L5";
	itemLevel = 5;
	dmg = 0;
	str = 3;
	dex = 2;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs6(){
	
	 
	itemName = "L6";
	itemLevel = 6;
	dmg = 0;
	str = 2;
	dex = 4;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs7(){
	
	 
	itemName = "L7";
	itemLevel = 7;
	dmg = 0;
	str = 4;
	dex = 3;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs8(){
	
	 
	itemName = "L8";
	itemLevel = 8;
	dmg = 0;
	str = 3;
	dex = 5;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs9(){
	
	 
	itemName = "L9";
	itemLevel = 9;
	dmg = 0;
	str = 5;
	dex = 4;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}

public static void Legs10(){
	
	 
	itemName = "L10";
	itemLevel = 10;
	dmg = 0;
	str = 3;
	dex = 7;
	armor = itemLevel * 4;
	gold = itemLevel * 4;
	speed = 0;
	 
	 
}


/////////////////////////////////////////////Armor-boots/////////////////////////////////////////////

public static void Boots1(){
	
	 
	itemName = "B1";
	itemLevel = 1;
	dmg = 0;
	str = 0;
	dex = 1;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots2(){
	
	 
	itemName = "B2";
	itemLevel = 2;
	dmg = 0;
	str = 1;
	dex = 1;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots3(){
	
	 
	itemName = "B3";
	itemLevel = 3;
	dmg = 0;
	str = 0;
	dex = 3;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots4(){
	
	 
	itemName = "B4";
	itemLevel = 4;
	dmg = 0;
	str = 2;
	dex = 2;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots5(){
	
	 
	itemName = "B5";
	itemLevel = 5;
	dmg = 0;
	str = 1;
	dex = 4;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots6(){
	
	 
	itemName = "B6";
	itemLevel = 6;
	dmg = 0;
	str = 3;
	dex = 3;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots7(){
	
	 
	itemName = "B7";
	itemLevel = 7;
	dmg = 0;
	str = 1;
	dex = 6;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots8(){
	
	 
	itemName = "B8";
	itemLevel = 8;
	dmg = 0;
	str = 2;
	dex = 6;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots9(){
	
	 
	itemName = "B9";
	itemLevel = 9;
	dmg = 0;
	str = 4;
	dex = 5;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
}

public static void Boots10(){
	
	 
	itemName = "B10";
	itemLevel = 10;
	dmg = 0;
	str = 1;
	dex = 9;
	armor = itemLevel * 2;
	gold = itemLevel * 2;
	speed = itemLevel;
	 
	 
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

