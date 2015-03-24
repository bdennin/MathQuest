package MathQuest.Logic;

import java.awt.Color;
import java.lang.Math;
import java.util.ArrayList;

public class Item {

	boolean loopPrevention = true;
	
	boolean itemDropped;
	
	 String itemName;
	 Color color;
	 int itemLevel = 1;
	 int dmg = 0;
	 int str = 0;
	 int dex = 0;
	 int armor = 0;
	 int gold = 0;
	 int speed = 0;
	 
	 
	 public Item(){
		 
		this.color = Color.white;
		itemName = "Terrible Item";
		itemLevel = 1;
		dmg = 0;
		str = 0;
		dex = 0;
		armor = 0;
		gold = 1;
		speed = 0;
			
	 }
	 
	 
	 public Item(int monsterLvl, int catagoryNumber){
		 
		 
		 this.itemLevel = monsterLvl;
		 if (loopPrevention == true || catagoryNumber == 0)
		 	this.createRandomItems(monsterLvl);
		 if (catagoryNumber == 1)
			 this.setStatsBasic();
		 if (catagoryNumber == 2)
		 	this.setStatsRare();
		 if (catagoryNumber == 3)
		 	this.setStatsEpic();
		 if (catagoryNumber == 4)
		 	this.setStatsLegendary();
		 
	 }
	 
	 private ArrayList<Item> createRandomItems(int monsterLvl){
			
			ArrayList <Item> itemsDropped = new ArrayList <Item>();
			boolean droppedBasic = chanceToDropBasic();
			boolean droppedRare = chanceToDropRare();
			boolean droppedEpic = chanceToDropEpic();
			boolean droppedLegendary = chanceToDropLegendary();
			loopPrevention = false;
			
			if (droppedBasic == false)
				System.out.println("No basic items");
			else{
				Item basicItem = new Item(monsterLvl, 1);
				this.color = Color.white;
				itemsDropped.add(basicItem);
			}
			
			if (droppedRare == false)
				System.out.println("No rare Items");
			else{
				Item rareItem = new Item(monsterLvl, 2);
				this.color = Color.green;
				itemsDropped.add(rareItem);
			}
			
			if (droppedEpic == false)
				System.out.println("No epic items");
			else{
				Item epicItem = new Item(monsterLvl, 3);
				this.color = Color.blue;
				itemsDropped.add(epicItem);
			}
			
			if (droppedLegendary == false)
				System.out.println("No legendary items");
			else{
				Item legendaryItem = new Item(monsterLvl, 4);
				this.color = Color.orange;
				itemsDropped.add(legendaryItem);
			}
			
			loopPrevention = true;
			return itemsDropped;
		}
	 
	 private void setStatsBasic(){
		 
		 String slotName;
		 String modifier;
		 double randomItem = Math.random()*10;
		 double randomModifier = Math.random()*10;
		 if(randomItem < 20)
			 this.weapon();
		 else if(randomItem >= 20 && randomItem < 40)
			 this.helmet();
		 else if(randomItem >= 40 && randomItem < 60)
			 this.chest();
		 else if(randomItem >= 60 && randomItem < 80)
			 this.legs();
		 else
			 this.boots();
		 
		 this.dmg = this.dmg * this.itemLevel;
		 this.armor = this.armor * this.itemLevel;
		 this.speed = this.speed * this.itemLevel;
		 slotName = this.itemName;
		 
		 if(randomModifier < 20)
			 this.cracked();
		 else if(randomModifier >= 20 && randomModifier < 40)
			 this.damaged();
		 else if(randomModifier >= 40 && randomModifier < 60)
			 this.wornOut();
		 else if(randomModifier >= 60 && randomModifier < 80)
			 this.squishy();
		 else
			 this.tiny();
		 
		 this.str = this.str * this.itemLevel;
		 this.dex = this.dex * this.itemLevel;
		 this.gold = this.gold * this.itemLevel;
		 modifier = this.itemName;
		 this.itemName = modifier + slotName;
		 
	 }
	 
	
	 private void setStatsRare(){
		 
		 String slotName;
		 String animalName;
		 double randomAnimal = Math.random()*10;
		 double randomItem = Math.random()*10;
		 if(randomItem < 20)
			 this.weapon();
		 else if(randomItem >= 20 && randomItem < 40)
			 this.helmet();
		 else if(randomItem >= 40 && randomItem < 60)
			 this.chest();
		 else if(randomItem >= 60 && randomItem < 80)
			 this.legs();
		 else
			 this.boots();
		 
		 this.dmg = this.dmg * this.itemLevel;
		 this.armor = this.armor * this.itemLevel;
		 this.speed = this.speed * this.itemLevel;
		 slotName = this.itemName;
		 
		 if(randomAnimal < 10)
			 this.bear();
		 else if(randomAnimal >= 10 && randomAnimal < 20)
			 this.snake();
		 else if(randomAnimal >= 20 && randomAnimal < 30)
			 this.eagle();
		 else if(randomAnimal >= 30 && randomAnimal < 40)
			 this.tiger();
		 else if(randomAnimal >= 40 && randomAnimal < 50)
			 this.fox();
		 else if(randomAnimal >= 50 && randomAnimal < 60)
			 this.gorilla();
		 else if(randomAnimal >= 60 && randomAnimal < 70)
			 this.rabbit();
		 else if(randomAnimal >= 70 && randomAnimal < 80)
			 this.lion();
		 else if(randomAnimal >= 80 && randomAnimal < 90)
			 this.monkey();
		 else
			 this.elephant();
		 
		 this.str = this.str * this.itemLevel;
		 this.dex = this.dex * this.itemLevel;
		 this.gold = this.gold * this.itemLevel;
		 animalName = this.itemName;
		 this.itemName = slotName + animalName;
		 
	 }
	 
	 private void setStatsEpic(){
		 
		 String slotName;
		 String epicName;
		 double randomEpic = Math.random()*10;
		 double randomItem = Math.random()*10;
		 if(randomItem < 20)
			 this.weapon();
		 else if(randomItem >= 20 && randomItem < 40)
			 this.helmet();
		 else if(randomItem >= 40 && randomItem < 60)
			 this.chest();
		 else if(randomItem >= 60 && randomItem < 80)
			 this.legs();
		 else
			 this.boots();
		 
		 this.dmg = this.dmg * this.itemLevel;
		 this.armor = this.armor * this.itemLevel;
		 this.speed = this.speed * this.itemLevel;
		 slotName = this.itemName;
		 
		 if(randomEpic < 20)
			 this.amazing();
		 else if(randomEpic >= 20 && randomEpic < 40)
			 this.spectacular();
		 else if(randomEpic >= 40 && randomEpic < 60)
			 this.fantastic();
		 else if(randomEpic >= 60 && randomEpic < 80)
			 this.superEpic();
		 else
			 this.wonderful();
		 
		 this.str = this.str * this.itemLevel;
		 this.dex = this.dex * this.itemLevel;
		 this.gold = this.gold * this.itemLevel;
		 epicName = this.itemName;
		 this.itemName = epicName + slotName;
		 
	 }
	 
	 private void setStatsLegendary(){
		 
		 double randomItem = Math.random()*10;
		 if(randomItem < 20){
			 this.weapon();
			 this.legendaryWeapon();
		 }
		 else if(randomItem >= 20 && randomItem < 40){
			 this.helmet();
			 this.legendaryHelmet();
		 }
		 else if(randomItem >= 40 && randomItem < 60){
			 this.chest();
			 this.legendaryChest();
		 }
		 else if(randomItem >= 60 && randomItem < 80){
			 this.legs();
			 this.legendaryLegs();
		 }
		 else{
			 this.boots();
			 this.legendaryBoots();
		 }
		 
		 this.dmg = this.dmg * this.itemLevel;
		 this.armor = this.armor * this.itemLevel;
		 this.speed = this.speed * this.itemLevel;
		 this.str = this.str * this.itemLevel;
		 this.dex = this.dex * this.itemLevel;
		 this.gold = this.gold * this.itemLevel;
		 
	 }
	 
////////////////////////////////////////Set chances to drop////////////////////////////////////////
	 
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
	 
////////////////////////////////////////Basic Item Modifiers////////////////////////////////////////
		
	//1
	private void cracked(){
		this.str = 1;
		this.dex = 1;
		this.itemName = "Cracked ";
		this.gold = 50;
	}
	 
	//2
	private void damaged(){
		this.str = 2;
		this.dex = 1;
		this.itemName = "Damaged ";
		this.gold = 50;
	}
	
	//3
	private void wornOut(){
		this.str = 1;
		this.dex = 2;
		this.itemName = "Worn out ";
		this.gold = 50;
	}
	
	//4
	private void squishy(){
		this.str = 2;
		this.dex = 2;
		this.itemName = "Squishy ";
		this.gold = 50;
	}
	
	//5
	private void tiny(){
		this.str = 0;
		this.dex = 3;
		this.itemName = "Tiny ";
		this.gold = 50;
	}
	
////////////////////////////////////////Rare Item Modifiers////////////////////////////////////////
	 
	 //1
	 private void bear(){
		 this.dmg = this.dmg * 5;
		 this.str = 5;
		 this.itemName = " of the Bear";
		 this.gold = 20;
	 }
	 
	 //2
	 private void snake(){
		 this.dmg = this.dmg * 2;
		 this.dex = 5;
		 this.speed = this.speed *2;
		 this.itemName = " of the Snake";
		 this.gold = 20;
	 }
	 
	 //3
	 private void eagle(){
		 this.dmg = this.dmg * 3;
		 this.dex = 3;
		 this.str = 2;
		 this.itemName = " of the Eagle";
		 this.gold = 20;
	 }

	 //4
	 private void tiger(){
		 this.dmg = this.dmg * 4;
		 this.str = 4;
		 this.dex = 1;
		 this.itemName = " of the Tiger";
		 this.gold = 20;
	 }

	 //5
	 private void fox(){
		 this.dmg = this.dmg * 2;
		 this.dex = 4;
		 this.str = 1;
		 this.itemName = " of the Fox";
		 this.gold = 20;
	 }

	 //6
	 private void gorilla(){
		 this.dmg = this.dmg * 8;
		 this.str = 8;
		 this.itemName = " of the Gorilla";
		 this.gold = 20;
	 }

	 //7
	 private void rabbit(){
		 this.dmg = this.dmg * 2;
		 this.dex = 8;
		 this.speed = this.speed * 3;
		 this.itemName = " of the Rabbit";
		 this.gold = 20;
	 }

	 //8
	 private void lion(){
		 this.dmg = this.dmg * 5;
		 this.str = 4;
		 this.dex = 4;
		 this.itemName = " of the Lion";
		 this.gold = 20;
	 }
	 
	 //9
	 private void monkey(){
		 this.dmg = this.dmg * 3;
		 this.dex = 6;
		 this.str = 2;
		 this.itemName = " of the Monkey";
		 this.gold = 20;
	 }
	 
	 //10
	 private void elephant(){
		 this.dmg = this.dmg * 10;
		 this.str = 10;
		 this.itemName = " of the Elephant";
		 this.gold = 20;
	 }
	 
//////////////////////////////////////////Epic Item Modifiers//////////////////////////////////////////
	 
	 //1
	 private void amazing(){
		 this.dmg = this.dmg * 15;
		 this.str = 18;
		 this.dex = 12;
		 this.itemName = "Amazing ";
		 this.gold = 100;
	 }
	 
	 //2
	 private void spectacular(){
		 this.dmg = this.dmg * 12;
		 this.str = 12;
		 this.dex = 18;
		 this.itemName = "Spectacular ";
		 this.gold = 100;
	 }
	 
	 //3
	 private void fantastic(){
		 this.dmg = this.dmg * 14;
		 this.str = 15;
		 this.dex = 15;
		 this.itemName = "Fantastic ";
		 this.gold = 100;
	 }
	 
	 //4
	 private void superEpic(){
		 this.dmg = this.dmg * 20;
		 this.str = 20;
		 this.dex = 12;
		 this.itemName = "Super ";
		 this.gold = 100;
	 }
	 
	 //5
	 private void wonderful(){
		 this.dmg = this.dmg * 12;
		 this.str = 12;
		 this.dex = 20;
		 this.itemName = "Wonderful ";
		 this.gold = 100;
	 }
	 
////////////////////////////////////////Legendary Item Modifiers////////////////////////////////////////
	 
	 //Weapon
	 private void legendaryWeapon(){
		 this.dmg = this.dmg * 40;
		 this.str = 30;
		 this.dex = 30;
		 this.itemName = "Mathtastic Weapon of Solving";
		 this.gold = 200;
	 }
	 
	 //Helmet
	 private void legendaryHelmet(){
		 this.str = 30;
		 this.dex = 30;
		 this.itemName = "Mathtastic Helmet of Knowledge";
		 this.gold = 200;
	 }
	 
	 //Chest
	 private void legendaryChest(){
		 this.str = 30;
		 this.dex = 30;
		 this.itemName = "Mathtastic Chest of Power";
		 this.gold = 200;
	 }
	 
	 //Legs
	 private void legendaryLegs(){
		 this.str = 30;
		 this.dex = 30;
		 this.itemName = "Mathtastic Legs of Learning";
		 this.gold = 200;
	 }
	 
	 //Boots
	 private void legendaryBoots(){
		 this.str = 30;
		 this.dex = 30;
		 this.itemName = "Mathtastic Boots of Intelligence";
		 this.gold = 200;
	 }
	 
//////////////////////////////////////////////Item Slots//////////////////////////////////////////////
	 
	 private void weapon(){
		 this.dmg = 3;
		 this.itemName = "Weapon";
	 }
	 
	 private void helmet(){
		 this.armor = 4;
		 this.itemName = "Helmet";
	 }
	
	 private void chest(){
		 this.armor = 6;
		 this.itemName = "Armor";
	 }
	 
	 private void legs(){
		 this.armor = 3;
		 this.itemName = "Leggings";
	 }
	 
	 private void boots(){
		 this.armor = 2;
		 this.speed = 1;
		 this.itemName = "Boots";
	 }
	 

//////////////////////////////////////////Getters//////////////////////////////////////////
	 
	 

		public int getItemLvl(){
			return this.itemLevel;
		}
		
		public int getItemDmg(){
			return this.dmg;
		}
		
		public int getItemStr(){
			return this.str;
		}
		
		public int getItemDex(){
			return this.dex;
		}
		
		public int getItemArmor(){
			return this.armor;
		}
		
		public int getItemSpeed(){
			return this.speed;
		}
		
		public int getItemGold(){
			return this.gold;
		}
		
		public String toString(){
			return this.itemName;
		}
		
		public Color getColor(){
			return this.color;
		}
		
}
