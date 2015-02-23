package MathQuest;

import javax.swing.ImageIcon;

public class Monster {
	
	private int damage;
	private int currentHealth, maxHealth;
	private int level;
	private int gold;
	private int experience;
	private int armor;
	private int speed;
	private String name;
	private ImageIcon portrait;
	
	public Monster(){
		name = "Monster";
		damage = 10;
		currentHealth = maxHealth = 100;
		this.damage = 0;
		currentHealth = maxHealth = 10;
		this.damage = 0;
		this.maxHealth = 10;
		level = 1;
		gold = 10;
		experience = 10;
		armor = 0;
		speed = 10;
		this.portrait = portrait;
	}
	
	public Monster(ImageIcon portrait){
		name = "Monster";
		damage = 10;
		currentHealth = maxHealth = 10;
		this.damage = 0;
		this.maxHealth = 10;
		level = 1;
		gold = 10;
		experience = 10;
		armor = 0;
		speed = 10;
		this.portrait = portrait;
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
	
	public void setExperience(int e){
		experience = e;
	}
	
	//takes the strength of the character 
	public int takeDamage(int s){
		return currentHealth = currentHealth - s;
	}
	
	public ImageIcon getPortrait() {
		return this.portrait;
	}
	
}
