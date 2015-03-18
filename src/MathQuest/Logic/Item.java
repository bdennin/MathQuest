package MathQuest.Logic;

import java.lang.Math;

public class Item extends Loot {

	 String itemName;
	 int itemLevel = 1;
	 int dmg = 0;
	 int str = 0;
	 int dex = 0;
	 int armor = 0;
	 int gold = 0;
	 int speed = 0;
	 
	 public Item(Character monster){
		 
		 this.setStats(monster);
					
	 }
	 
	
	 private void setStats(Character monster){
		 
		 String slotName;
		 String animalName;
		 this.itemLevel = monster.getLevel();
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
	 
	 public String getItemName(){
		 return this.itemName;
	 }
	 
}
