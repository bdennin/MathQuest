package MathQuest;

public class Monster {
	
	private double damage;
	private int currentHealth, maxHealth;
	private int level;
	private double gold;
	private double experience;
	private int armor;
	private int speed;
	private String name;
	
	public Monster(){
		name = "Monster";
		damage = 10;
		currentHealth = maxHealth = 100;
		this.damage = 0;
		currentHealth = maxHealth = 10;
		level = 1;
		gold = 10;
		experience = 10;
		armor = 0;
		speed = 10;
	}
	
	
	//constructor for a monster that will be scaled to a specific level
	
	public Monster(int damage, int maxHealth, int level, int gold, int experience, int armor) {
		this.damage = damage;
		this.maxHealth = maxHealth;
		currentHealth = maxHealth;
		this.level = level;
		this.gold = gold;
		this.experience = experience;
		this.armor = armor;
	}
	
	
	public int getMaxHealth(){
		return maxHealth;
	}
	
	public int getCurrentHealth(){
		return currentHealth;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getArmor(){
		return armor;
	}
	
	public double getGold(){
		return gold;
	}
	
	public void setGold(int g){
		gold = g;
	}
	
	public double getExperience(){
		return experience;
	}
	
	public void setExperience(double e){
		experience = e;
	}
	
	//takes the strength of the character 
	public int takeDamage(int s){
		return currentHealth = currentHealth - s;
	}
	
	
}
