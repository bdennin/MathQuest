
public class Monster {
	
	private int damage;
	private int health;
	private int level;
	private int gold;
	private int experience;
	private int armor;
	
	public Monster(){
		damage = 0;
		health = 10;
		level = 1;
		gold = 10;
		experience = 10;
		armor = 0;
	}
	
	public Monster(int lev){
		damage = damage * lev;
		health = health * lev;
		level = lev;
		gold = gold * lev;
		experience = experience * lev;
		armor = armor + lev;
	}
	
	public Monster(int damage, int health, int level, int gold, int experience, int armor) {
		this.damage = damage;
		this.health = health;
		this.level = level;
		this.gold = gold;
		this.experience = experience;
		this.armor = armor;
	}
}
