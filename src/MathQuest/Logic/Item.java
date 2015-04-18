package MathQuest.Logic;

import java.lang.Math;
import java.net.URL;
import java.util.Random;

import MathQuest.MathQuest;

public class Item {

	private static final Random RANDOM = new Random();
	
	boolean itemDropped;
	boolean isEquipped;
	String slot;
	String itemName;
	String color;
	int itemLevel = 1;
	int vit = 0;
	int str = 0;
	int gold = 0;
	int enh = 0;
	private URL imagePath;

	public Item(String[] strings, Integer[] numbers, boolean equipped){
		itemName = strings[0]; 
		color = strings[1];
		slot = strings[2];
		itemLevel = numbers[0];
		str = numbers[1];
		gold = numbers[2];
		vit = numbers[3];
		isEquipped = equipped;  
		this.setImagePath();
	}

	public Item(int monsterLvl, String catagory){

		color = catagory;
		itemLevel = monsterLvl;
		if (catagory == "gray")
			setStatsBasic();
		else if (catagory =="green")
			setStatsRare();
		else if (catagory == "blue")
			setStatsEpic();
		else if (catagory == "orange")
			setStatsLegendary();
		else if (catagory == "red")
			setStatsFalcor();
		else
			setStatsBasic();
		this.setImagePath();
	}


	public void disrobe(){
		isEquipped = false;
	}
	public void equip(){
		isEquipped = true;
	}
	public boolean isEquipped(){
		return isEquipped;
	}
	private void setStatsBasic(){


		String slotName;
		String modifier;
		double randomItem = Math.random();
		double randomModifier = Math.random();
		if(randomItem < .20)
			weapon();
		else if(randomItem >= .20 && randomItem < .40)
			helmet();
		else if(randomItem >= .40 && randomItem < .60)
			chest();
		else if(randomItem >= .60 && randomItem < .80)
			gloves();
		else
			boots();

		slotName = itemName;

		if(randomModifier < .20)
			cracked();
		else if(randomModifier >= .20 && randomModifier < .40)
			damaged();
		else if(randomModifier >= .40 && randomModifier < .60)
			wornOut();
		else if(randomModifier >= .60 && randomModifier < .80)
			squishy();
		else
			tiny();

		str = str * itemLevel;
		vit = vit * itemLevel * 2;
		gold = gold * itemLevel;
		modifier = itemName;
		itemName = modifier + slotName;

	}

	private void setStatsRare(){

		String slotName;
		String animalName;
		double randomAnimal = Math.random();
		double randomItem = Math.random();
		if(randomItem < .20)
			weapon();
		else if(randomItem >= .20 && randomItem < .40)
			helmet();
		else if(randomItem >= .40 && randomItem < .60)
			chest();
		else if(randomItem >= .60 && randomItem < .80)
			gloves();
		else
			boots();

		slotName = itemName;

		if(randomAnimal < .10)
			bear();
		else if(randomAnimal >= .10 && randomAnimal < .20)
			snake();
		else if(randomAnimal >= .20 && randomAnimal < .30)
			eagle();
		else if(randomAnimal >= .30 && randomAnimal < .40)
			tiger();
		else if(randomAnimal >= .40 && randomAnimal < .50)
			fox();
		else if(randomAnimal >= .50 && randomAnimal < .60)
			gorilla();
		else if(randomAnimal >= .60 && randomAnimal < .70)
			rabbit();
		else if(randomAnimal >= .70 && randomAnimal < .80)
			lion();
		else if(randomAnimal >= .80 && randomAnimal < .90)
			monkey();
		else
			elephant();

		str = str * itemLevel;
		vit = vit * itemLevel * 2;
		gold = gold * itemLevel;
		animalName = itemName;
		itemName = slotName + animalName;
	}

	private void setStatsEpic(){

		String animalName;
		String slotName;
		String epicName;
		double randomAnimal = Math.random();
		double randomEpic = Math.random();
		double randomItem = Math.random();
		if(randomItem < .20)
			weapon();
		else if(randomItem >= .20 && randomItem < .40)
			helmet();
		else if(randomItem >= .40 && randomItem < .60)
			chest();
		else if(randomItem >= .60 && randomItem < .80)
			gloves();
		else
			boots();

		slotName = itemName;

		if(randomEpic < .20)
			amazing();
		else if(randomEpic >= .20 && randomEpic < .40)
			spectacular();
		else if(randomEpic >= .40 && randomEpic < .60)
			fantastic();
		else if(randomEpic >= .60 && randomEpic < .80)
			superEpic();
		else
			wonderful();

		epicName = itemName;

		if(randomAnimal < .10)
			bear();
		else if(randomAnimal >= .10 && randomAnimal < .20)
			snake();
		else if(randomAnimal >= .20 && randomAnimal < .30)
			eagle();
		else if(randomAnimal >= .30 && randomAnimal < .40)
			tiger();
		else if(randomAnimal >= .40 && randomAnimal < .50)
			fox();
		else if(randomAnimal >= .50 && randomAnimal < .60)
			gorilla();
		else if(randomAnimal >= .60 && randomAnimal < .70)
			rabbit();
		else if(randomAnimal >= .70 && randomAnimal < .80)
			lion();
		else if(randomAnimal >= .80 && randomAnimal < .90)
			monkey();
		else
			elephant();

		str = str * itemLevel;
		vit = vit * itemLevel * 2;
		gold = gold * itemLevel;
		animalName = itemName;
		itemName = epicName + slotName + animalName;
		
	}

	private void setStatsLegendary(){

		double randomItem = Math.random();
		if(randomItem < .20){
			weapon();
			legendaryWeapon();
		}
		else if(randomItem >= .20 && randomItem < .40){
			helmet();
			legendaryHelmet();
		}
		else if(randomItem >= .40 && randomItem < .60){
			chest();
			legendaryChest();
		}
		else if(randomItem >= .60 && randomItem < .80){
			gloves();
			legendaryGloves();
		}
		else{
			boots();
			legendaryBoots();
		}
		
		str = str * itemLevel;
		vit = vit * itemLevel * 2;
		gold = gold * itemLevel;

	}

	private void setStatsFalcor() {
		slot = "Weapons";
		itemName = "Falcor, the Master weapon of the GODS!";
		color = "red";
		vit = 100 * itemLevel;
		str = 100 * itemLevel;
		gold = 1000 * itemLevel;
		this.setImagePath();
	}


	////////////////////////////////////////Basic Item Modifiers////////////////////////////////////////

	//1
	private void cracked(){
		str = 1;
		vit = 0;
		itemName = "Cracked ";
		gold = 50;
	}

	//2
	private void damaged(){
		str = 0;
		vit = 1;
		itemName = "Damaged ";
		gold = 50;
	}

	//3
	private void wornOut(){
		str = 1;
		vit = 1;
		itemName = "Worn-Out ";
		gold = 50;
	}

	//4
	private void squishy(){
		str = 0;
		vit = 0;
		itemName = "Squishy ";
		gold = 50;
	}

	//5
	private void tiny(){
		str = 1;
		vit = 1;
		itemName = "Tiny ";
		gold = 50;
	}

	////////////////////////////////////////Rare Item Modifiers////////////////////////////////////////

	//1
	private void bear(){
		str = str + 3;
		vit = vit + 1;
		itemName = " of the Bear";
		gold = 20;
	}

	//2
	private void snake(){
		str = str + 2;
		vit = vit + 2;
		itemName = " of the Snake";
		gold = 20;
	}

	//3
	private void eagle(){
		str = str + 4;
		vit = vit + 0;
		itemName = " of the Eagle";
		gold = 20;
	}

	//4
	private void tiger(){
		str = str + 2;
		vit = vit + 2;
		itemName = " of the Tiger";
		gold = 20;
	}

	//5
	private void fox(){
		str = str + 1;
		vit = vit + 3;
		itemName = " of the Fox";
		gold = 20;
	}

	//6
	private void gorilla(){
		str = str + 3;
		vit = vit + 1;
		itemName = " of the Gorilla";
		gold = 20;
	}

	//7
	private void rabbit(){
		str = str + 0;
		vit = vit + 4;
		itemName = " of the Rabbit";
		gold = 20;
	}

	//8
	private void lion(){
		str = str + 3;
		vit = vit + 1;
		itemName = " of the Lion";
		gold = 20;
	}

	//9
	private void monkey(){
		str = str + 0;
		vit = vit + 4;
		itemName = " of the Monkey";
		gold = 20;
	}

	//10
	private void elephant(){
		str = str + 4;
		vit = vit + 0;
		itemName = " of the Elephant";
		gold = 20;
	}

	//////////////////////////////////////////Epic Item Modifiers//////////////////////////////////////////

	//1
	private void amazing(){
		str = str + 2;
		vit = vit + 2;
		itemName = "Amazing ";
		gold = 100;
	}

	//2
	private void spectacular(){
		str = str + 3;
		vit = vit + 2;
		itemName = "Spectacular ";
		gold = 100;
	}

	//3
	private void fantastic(){
		str = str + 2;
		vit = vit + 3;
		itemName = "Fantastic ";
		gold = 100;
	}

	//4
	private void superEpic(){
		str = str + 2;
		vit = vit + 3;
		itemName = "Super ";
		gold = 100;
	}

	//5
	private void wonderful(){
		str = str + 3;
		vit = vit + 2;
		itemName = "Wonderful ";
		gold = 100;
	}

	////////////////////////////////////////Legendary Item Modifiers////////////////////////////////////////

	//Weapon
	private void legendaryWeapon(){
		str = str + 10;
		vit = vit + 2;
		itemName = "Mathtastic Weapon of Solving";
		gold = 200;
	}

	//Helmet
	private void legendaryHelmet(){
		str = str + 6;
		vit = vit + 8;
		itemName = "Mathtastic Helmet of Knowledge";
		gold = 200;
	}

	//Chest
	private void legendaryChest(){
		str = str + 7;
		vit = vit + 7;
		itemName = "Mathtastic Chest of Power";
		gold = 200;
	}

	//gloves
	private void legendaryGloves(){
		str = str + 8;
		vit = vit + 6;
		itemName = "Mathtastic Gloves of Learning";
		gold = 200;
	}

	//Boots
	private void legendaryBoots(){
		str = str + 4;
		vit = vit + 8;
		itemName = "Mathtastic Boots of Intelligence";
		gold = 200;
	}

	//////////////////////////////////////////////Item Slots//////////////////////////////////////////////

	private void weapon(){
		str = str + 1;
		itemName = "Weapon";
		slot = "Weapons";
	}

	private void helmet(){
		vit = vit + 1;
		itemName = "Helmet";
		slot = "Helmets";
	}

	private void chest(){
		vit = vit + 3;
		itemName = "Armor";
		slot = "Armor";
	}

	private void gloves(){
		str = str + 1;
		vit = vit + 1;
		itemName = "Gloves";
		slot = "Gloves";
	}

	private void boots(){
		vit = vit + 1;
		itemName = "Boots";
		slot = "Boots";
	}


	//////////////////////////////////////////Getters//////////////////////////////////////////



	public int getItemLvl(){
		return itemLevel;
	}

	public int getItemStr(){
		return str;
	}

	public int getItemVit(){
		return vit;
	}

	public int getItemGold(){
		return gold;
	}

	public String toString(){
		if (isEquipped == true){
			return String.format("<html><font color='%s'>%s</font> (Equipped)</html>", this.getColor(), itemName);
		}
		return String.format("<html><font color='%s'>%s</font></html>", this.getColor(), itemName);
	}

	public String getName(){
		return itemName;
	}
	public String getColor(){
		return color;
	}

	public String getSlot(){
		return slot;
	}

	//enhance for blacksmith
	public void enhanceItem(){
		enh += 1;
		vit = vit + enh;
		str = str + enh;
		gold = gold * 2;
	}

	public URL getImagePath() {
		return this.imagePath;
	}


	private void setImagePath() {
		String filePath;
		if(this.slot == "Helmets") {
			filePath = String.format("Files/helmet%d.png", RANDOM.nextInt(7) + 1);
			this.imagePath = MathQuest.class.getResource(filePath);
		}
		else if(this.slot == "Boots") {
			filePath = String.format("Files/boots%d.png", RANDOM.nextInt(2) + 1);
			this.imagePath = MathQuest.class.getResource(filePath);
		}
		else if(this.slot == "Armor") {
			filePath = String.format("Files/armor%d.png", RANDOM.nextInt(10) + 1);
			this.imagePath = MathQuest.class.getResource(filePath);
		}
		else if(this.slot == "Weapons") {
			filePath = String.format("Files/weapon%d.png", RANDOM.nextInt(21) + 1);
			this.imagePath = MathQuest.class.getResource(filePath);
		}
		else if(this.slot == "Gloves") {
			filePath = String.format("Files/gloves%d.png", RANDOM.nextInt(3) + 1);
			this.imagePath = MathQuest.class.getResource(filePath);
		}
		else
			throw new IllegalArgumentException();
		

	}

}