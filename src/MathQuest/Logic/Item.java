package MathQuest.Logic;

import java.lang.Math;

public class Item {
	
	boolean itemDropped;
	
	String slot;
	String itemName;
	String color;
	int itemLevel = 1;
	int dmg = 0;
	int str = 0;
	int dex = 0;
	int armor = 0;
	int gold = 0;
	int speed = 0;
	 
	 
	 
	 public Item(){
		 
		color = "white";
		itemName = "Terrible Item";
		itemLevel = 1;
		dmg = 0;
		str = 0;
		dex = 0;
		armor = 0;
		gold = 1;
		speed = 0;
			
	 }
	 
	 
	 public Item(int monsterLvl, String catagory){
		 
		 color = catagory;
		 itemLevel = monsterLvl;
		 if (catagory == "white")
			 setStatsBasic();
		 if (catagory =="green")
		 	setStatsRare();
		 if (catagory == "blue")
		 	setStatsEpic();
		 if (catagory == "orange")
		 	setStatsLegendary();
		 
		 
	 }
	 

	 
	 private void setStatsBasic(){
		 
		 
		 String slotName;
		 String modifier;
		 double randomItem = Math.random()*10;
		 double randomModifier = Math.random()*10;
		 if(randomItem < 20)
			 weapon();
		 else if(randomItem >= 20 && randomItem < 40)
			 helmet();
		 else if(randomItem >= 40 && randomItem < 60)
			 chest();
		 else if(randomItem >= 60 && randomItem < 80)
			 legs();
		 else
			 boots();
		 
		 dmg = dmg * itemLevel;
		 armor = armor * itemLevel;
		 speed = speed * itemLevel;
		 slotName = itemName;
		 
		 if(randomModifier < 20)
			 cracked();
		 else if(randomModifier >= 20 && randomModifier < 40)
			 damaged();
		 else if(randomModifier >= 40 && randomModifier < 60)
			 wornOut();
		 else if(randomModifier >= 60 && randomModifier < 80)
			 squishy();
		 else
			 tiny();
		 
		 str = str * itemLevel;
		 dex = dex * itemLevel;
		 gold = gold * itemLevel;
		 modifier = itemName;
		 itemName = modifier + slotName;
		 
	 }
	 
	
	 private void setStatsRare(){
		 
		 String slotName;
		 String animalName;
		 double randomAnimal = Math.random()*10;
		 double randomItem = Math.random()*10;
		 if(randomItem < 20)
			 weapon();
		 else if(randomItem >= 20 && randomItem < 40)
			 helmet();
		 else if(randomItem >= 40 && randomItem < 60)
			 chest();
		 else if(randomItem >= 60 && randomItem < 80)
			 legs();
		 else
			 boots();
		 
		 dmg = dmg * itemLevel;
		 armor = armor * itemLevel;
		 speed = speed * itemLevel;
		 slotName = itemName;
		 
		 if(randomAnimal < 10)
			 bear();
		 else if(randomAnimal >= 10 && randomAnimal < 20)
			 snake();
		 else if(randomAnimal >= 20 && randomAnimal < 30)
			 eagle();
		 else if(randomAnimal >= 30 && randomAnimal < 40)
			 tiger();
		 else if(randomAnimal >= 40 && randomAnimal < 50)
			 fox();
		 else if(randomAnimal >= 50 && randomAnimal < 60)
			 gorilla();
		 else if(randomAnimal >= 60 && randomAnimal < 70)
			 rabbit();
		 else if(randomAnimal >= 70 && randomAnimal < 80)
			 lion();
		 else if(randomAnimal >= 80 && randomAnimal < 90)
			 monkey();
		 else
			 elephant();
		 
		 str = str * itemLevel;
		 dex = dex * itemLevel;
		 gold = gold * itemLevel;
		 animalName = itemName;
		 itemName = slotName + animalName;
		 
	 }
	 
	 private void setStatsEpic(){
		 
		 String slotName;
		 String epicName;
		 double randomEpic = Math.random()*10;
		 double randomItem = Math.random()*10;
		 if(randomItem < 20)
			 weapon();
		 else if(randomItem >= 20 && randomItem < 40)
			 helmet();
		 else if(randomItem >= 40 && randomItem < 60)
			 chest();
		 else if(randomItem >= 60 && randomItem < 80)
			 legs();
		 else
			 boots();
		 
		 dmg = dmg * itemLevel;
		 armor = armor * itemLevel;
		 speed = speed * itemLevel;
		 slotName = itemName;
		 
		 if(randomEpic < 20)
			 amazing();
		 else if(randomEpic >= 20 && randomEpic < 40)
			 spectacular();
		 else if(randomEpic >= 40 && randomEpic < 60)
			 fantastic();
		 else if(randomEpic >= 60 && randomEpic < 80)
			 superEpic();
		 else
			 wonderful();
		 
		 str = str * itemLevel;
		 dex = dex * itemLevel;
		 gold = gold * itemLevel;
		 epicName = itemName;
		 itemName = epicName + slotName;
		 
	 }
	 
	 private void setStatsLegendary(){
		 
		 double randomItem = Math.random()*10;
		 if(randomItem < 20){
			 weapon();
			 legendaryWeapon();
		 }
		 else if(randomItem >= 20 && randomItem < 40){
			 helmet();
			 legendaryHelmet();
		 }
		 else if(randomItem >= 40 && randomItem < 60){
			 chest();
			 legendaryChest();
		 }
		 else if(randomItem >= 60 && randomItem < 80){
			 legs();
			 legendaryLegs();
		 }
		 else{
			 boots();
			 legendaryBoots();
		 }
		 
		 dmg = dmg * itemLevel;
		 armor = armor * itemLevel;
		 speed = speed * itemLevel;
		 str = str * itemLevel;
		 dex = dex * itemLevel;
		 gold = gold * itemLevel;
		 
	 }
	 

	 
////////////////////////////////////////Basic Item Modifiers////////////////////////////////////////
		
	//1
	private void cracked(){
		str = 1;
		dex = 1;
		itemName = "Cracked ";
		gold = 50;
	}
	 
	//2
	private void damaged(){
		str = 2;
		dex = 1;
		itemName = "Damaged ";
		gold = 50;
	}
	
	//3
	private void wornOut(){
		str = 1;
		dex = 2;
		itemName = "Worn out ";
		gold = 50;
	}
	
	//4
	private void squishy(){
		str = 2;
		dex = 2;
		itemName = "Squishy ";
		gold = 50;
	}
	
	//5
	private void tiny(){
		str = 0;
		dex = 3;
		itemName = "Tiny ";
		gold = 50;
	}
	
////////////////////////////////////////Rare Item Modifiers////////////////////////////////////////
	 
	 //1
	 private void bear(){
		 dmg = dmg * 5;
		 str = 5;
		 itemName = " of the Bear";
		 gold = 20;
	 }
	 
	 //2
	 private void snake(){
		 dmg = dmg * 2;
		 dex = 5;
		 speed = speed *2;
		 itemName = " of the Snake";
		 gold = 20;
	 }
	 
	 //3
	 private void eagle(){
		 dmg = dmg * 3;
		 dex = 3;
		 str = 2;
		 itemName = " of the Eagle";
		 gold = 20;
	 }

	 //4
	 private void tiger(){
		 dmg = dmg * 4;
		 str = 4;
		 dex = 1;
		 itemName = " of the Tiger";
		 gold = 20;
	 }

	 //5
	 private void fox(){
		 dmg = dmg * 2;
		 dex = 4;
		 str = 1;
		 itemName = " of the Fox";
		 gold = 20;
	 }

	 //6
	 private void gorilla(){
		 dmg = dmg * 8;
		 str = 8;
		 itemName = " of the Gorilla";
		 gold = 20;
	 }

	 //7
	 private void rabbit(){
		 dmg = dmg * 2;
		 dex = 8;
		 speed = speed * 3;
		 itemName = " of the Rabbit";
		 gold = 20;
	 }

	 //8
	 private void lion(){
		 dmg = dmg * 5;
		 str = 4;
		 dex = 4;
		 itemName = " of the Lion";
		 gold = 20;
	 }
	 
	 //9
	 private void monkey(){
		 dmg = dmg * 3;
		 dex = 6;
		 str = 2;
		 itemName = " of the Monkey";
		 gold = 20;
	 }
	 
	 //10
	 private void elephant(){
		 dmg = dmg * 10;
		 str = 10;
		 itemName = " of the Elephant";
		 gold = 20;
	 }
	 
//////////////////////////////////////////Epic Item Modifiers//////////////////////////////////////////
	 
	 //1
	 private void amazing(){
		 dmg = dmg * 15;
		 str = 18;
		 dex = 12;
		 itemName = "Amazing ";
		 gold = 100;
	 }
	 
	 //2
	 private void spectacular(){
		 dmg = dmg * 12;
		 str = 12;
		 dex = 18;
		 itemName = "Spectacular ";
		 gold = 100;
	 }
	 
	 //3
	 private void fantastic(){
		 dmg = dmg * 14;
		 str = 15;
		 dex = 15;
		 itemName = "Fantastic ";
		 gold = 100;
	 }
	 
	 //4
	 private void superEpic(){
		 dmg = dmg * 20;
		 str = 20;
		 dex = 12;
		 itemName = "Super ";
		 gold = 100;
	 }
	 
	 //5
	 private void wonderful(){
		 dmg = dmg * 12;
		 str = 12;
		 dex = 20;
		 itemName = "Wonderful ";
		 gold = 100;
	 }
	 
////////////////////////////////////////Legendary Item Modifiers////////////////////////////////////////
	 
	 //Weapon
	 private void legendaryWeapon(){
		 dmg = dmg * 40;
		 str = 30;
		 dex = 30;
		 itemName = "Mathtastic Weapon of Solving";
		 gold = 200;
	 }
	 
	 //Helmet
	 private void legendaryHelmet(){
		 str = 30;
		 dex = 30;
		 itemName = "Mathtastic Helmet of Knowledge";
		 gold = 200;
	 }
	 
	 //Chest
	 private void legendaryChest(){
		 str = 30;
		 dex = 30;
		 itemName = "Mathtastic Chest of Power";
		 gold = 200;
	 }
	 
	 //Legs
	 private void legendaryLegs(){
		 str = 30;
		 dex = 30;
		 itemName = "Mathtastic Legs of Learning";
		 gold = 200;
	 }
	 
	 //Boots
	 private void legendaryBoots(){
		 str = 30;
		 dex = 30;
		 itemName = "Mathtastic Boots of Intelligence";
		 gold = 200;
	 }
	 
//////////////////////////////////////////////Item Slots//////////////////////////////////////////////
	 
	 private void weapon(){
		 dmg = 3;
		 itemName = "Weapon";
		 slot = "Weapon";
	 }
	 
	 private void helmet(){
		 armor = 4;
		 itemName = "Helmet";
		 slot = "Helmet";
	 }
	
	 private void chest(){
		 armor = 6;
		 itemName = "Armor";
		 slot = "Chest";
	 }
	 
	 private void legs(){
		 armor = 3;
		 itemName = "Leggings";
		 slot = "Legs";
	 }
	 
	 private void boots(){
		 armor = 2;
		 speed = 1;
		 itemName = "Boots";
		 slot = "Boots";
	 }
	 

//////////////////////////////////////////Getters//////////////////////////////////////////
	 
	 

		public int getItemLvl(){
			return itemLevel;
		}
		
		public int getItemDmg(){
			return dmg;
		}
		
		public int getItemStr(){
			return str;
		}
		
		public int getItemDex(){
			return dex;
		}
		
		public int getItemArmor(){
			return armor;
		}
		
		public int getItemSpeed(){
			return speed;
		}
		
		public int getItemGold(){
			return gold;
		}
		
		public String toString(){
			return itemName;
		}
		
		public String getColor(){
			return color;
		}
		
		public String getSlot(){
			return slot;
		}
		
}
