package MathQuest;
import java.util.Scanner;

public class Combat {
	private static Character playerCharacter;
	private static Monster enemyMonster;
	private boolean isPlayerTurn;
	private boolean isCorrectAnswer;
	private Scanner input;
	private String playerChoice;
	
	
	public Combat(Character c, Monster m){
		playerCharacter = c;
		enemyMonster = m;
		input = new Scanner(System.in);
	}
	
	public Combat(Character c, int l){
		playerCharacter = c;
		input = new Scanner(System.in);
		if(l > 2 && l < 4){
			enemyMonster = new Monster(30, 300, 3, 30, 30, 30);
		}
		else if(l == 2){
			enemyMonster = new Monster(20, 200, 2, 20, 20, 20);
		}
		else{
			enemyMonster = new Monster();
		}
		
	}
	
	
//modify character and monster stats for level difference
	private void sizeUp(){
		if(playerCharacter.getLevel() - enemyMonster.getLevel() > 5){
			enemyMonster.setExperience((int)(enemyMonster.getExperience() * .25));
			enemyMonster.setGold((int)(enemyMonster.getGold()*.25));
			//other modifiers for higher player level than monster level
		}
		
	}
	
	private String playerTurn(){
		while(isPlayerTurn && enemyMonster.getCurrentHealth() > 0){
			System.out.println("Attack or potion");
			
			//player chooses to attack or drink a potion
			playerChoice = input.nextLine();
			
			if(playerChoice.equalsIgnoreCase("attack")){
				
				//math equation displayed
				isCorrectAnswer = true;
				
				if(isCorrectAnswer){
					//character deals damage
					enemyMonster.takeDamage(playerCharacter.getStrength());
				}
			}
			
			if(playerChoice.equalsIgnoreCase("potion")){
				//character drinks potion
				
			}
			
			isPlayerTurn = false;
		}
		
		return "End of Turn";
	}
	
	private String monsterTurn(){
		while(!isPlayerTurn && playerCharacter.getCurrentHealth() > 0){
			System.out.println("Monster is attacking");
			//does math equation for monster attack that character can defend
			
			if(!isCorrectAnswer){
//				playerCharacter.takeDamage(enemyMonster.getDamage());
			}
			isPlayerTurn = true;
		}
		
		return "Your Turn";
	}
	
	private int fight(){
		while(playerCharacter.getCurrentHealth() != 0 && enemyMonster.getCurrentHealth() != 0){
			
			System.out.println(this.playerTurn());
			System.out.println(enemyMonster.takeDamage(playerCharacter.getStrength()));
			System.out.println(this.monsterTurn());
		}
		
		return 0;
	}
	
	
	public static void main(String[] args){
		Character player = new Character();
		Monster enemy = new Monster();
		
		Combat testFight = new Combat(player, enemy);
		
		testFight.fight();
	}
}
