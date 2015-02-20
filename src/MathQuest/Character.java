package MathQuest;

public class Character {

	private double maxExperience, currentExperience;
	private int strength;
	private int dexterity;
	private int maxHealth, currentHealth;
	private int level;
	private int armor;
	private double gold;
	private int speed;
	
	public Character() {
		currentExperience = 0;
		maxExperience = 10;
		strength = 10;
		gold = 0;
		currentHealth = maxHealth = 100;
		level = 1;
		armor = 0;
	}
	
	public double getMaxExperience(){
		return maxExperience;
	}
	
	public double getCurrentExperience(){
		return currentExperience;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public int getDexterity(){
		return dexterity;
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
	
	public void gainExperience(int c){
		currentExperience = currentExperience + c;
		if(currentExperience >= maxExperience){
			level = level++;
			currentExperience = currentExperience - maxExperience;
			maxExperience = maxExperience*2;
		}
	}
	
	
	public void addStrenght(int s){
		strength = strength + s;
	}
	
	public void setGold(int g){
		gold = gold + g;
	}
	
	public void setArmor(int a){
		armor = armor + a;
	}

	public String toString(){
		return level + " " + maxHealth + " " + currentExperience + " " + maxExperience + " " + " " + gold;
	}
}