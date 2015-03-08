package MathQuest.Logic;

import MathQuest.Inventory;

public class Character {
	
	private int level;
	private int maxExperience;
	private int currentExperience;
	private int maxHealth;
	private int currentHealth;
	private int strength;
	private int dexterity;
	private int armor;
	private int gold;
	private int speed;
	private String name;
	private String imagePath;
	private Inventory inventory;

	public Character() {
		this.currentExperience = 0;
		this.maxExperience = 10;
		this.strength = 10;
		this.gold = 0;
		this.currentHealth = 10;
		this.maxHealth = 10;
		this.level = 1;
		this.armor = 0;
		this.imagePath = "char.jpg";
		this.name = "Hero#1";
	}

	public Character(int level, String name, String imagePath) {
		this.strength = 10 * level;
		this.gold = 2 * level;
		this.currentHealth = 10 * level;
		this.maxHealth = 10;
		this.level = level;
		this.armor = 0;
		this.name = name;
		this.currentExperience = 0;
		this.maxExperience = 10;
		this.imagePath = imagePath;
	}
	
	// test constructor
	public Character(int currentGold){
		this.currentExperience = 0;
		this.maxExperience = 10;
		this.strength = 10;
		this.gold = currentGold;
		this.currentHealth = 1;
		this.maxHealth = 10;
		this.level = 1;
		this.armor = 0;
		this.imagePath = "char.jpg";
		this.name = "Hero#1";
	}
	public Character(Integer[] charStats) {
		level = charStats[0];
		currentHealth = charStats[1];
		currentExperience = charStats[2];
		gold = charStats[3];
		maxHealth = level * 10;
		strength = 10 + 2 * level;
		maxExperience = (int)(10 * Math.pow(2, level));
		this.imagePath = "char.jpg";
	}

	public int getMaxExperience(){
		return this.maxExperience;
	}

	public int getCurrentExperience(){
		return this.currentExperience;
	}

	public int getStrength(){
		return this.strength;
	}

	public int getDexterity(){
		return this.dexterity;
	}

	public int getMaxHealth(){
		return this.maxHealth;
	}

	public int getCurrentHealth(){
		return this.currentHealth;
	}

	public int getLevel(){
		return this.level;
	}

	public int getArmor(){
		return this.armor;
	}
	
	public String getName() {
		return this.name;
	}

	public double getGold(){
		return this.gold;
	}
	
	public void addGold(int gold){
		this.gold = this.gold + gold;
	}
		
	public void gainExperience(int experience){
		this.currentExperience = this.currentExperience + experience;
		if(currentExperience >= maxExperience){
			this.level++;
			this.currentExperience = this.currentExperience - this.maxExperience;
			this.maxExperience = this.maxExperience*2;
		}
	}

	public int calculateDamage() {
		double maxDamage = this.strength * .2;
		double damage = this.strength * .2  - ((Math.random()/4) * maxDamage);
		return (int)Math.round(damage);
	}
	
	public void takeDamage(int damage){
		this.currentHealth = this.currentHealth - damage;
	}
	
	public int[] save() {
		int[] stats = new int[4];	
		stats[0] = this.level;
		stats[1] = this.currentHealth;
		stats[2] = this.currentExperience;
		stats[3] = this.gold;
		return stats;
	}
	
	public String getImagePath() {
		return this.imagePath;
	}
	
	public int calculateCost(String roomType){
		return 5;
	}
	
	public boolean enoughGold(String roomType){
		if (calculateCost(roomType) > this.gold)
			return false;
		else
			return true;
	}
	public void payForInn(String roomType){
		this.gold = this.gold - calculateCost(roomType);
	}
	public int calculateIncrease (String roomType){
		int increase;
		if (roomType.equalsIgnoreCase("Studio"))
			increase = this.maxHealth*30/100;
		else if (roomType.equalsIgnoreCase("Deluxe"))
			increase = this.maxHealth*60/100;
		else if (roomType.equalsIgnoreCase("Luxury"))
			increase = this.maxHealth*90/100;
		else
			increase = 0;
		return increase;
	}
	public void healthRegain (String roomType){
		int increase = calculateIncrease(roomType);
		if (this.currentHealth + increase < this.maxHealth)
			this.currentHealth = this.currentHealth + increase;
		else
			this.currentHealth = this.maxHealth;
	}
}