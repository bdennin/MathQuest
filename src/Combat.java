import java.util.Scanner;

public class Combat {
	private static Character playerCharacter;
	private static Monster enemyMonster;
	private boolean isPlayerTurn;
	
	public Combat(Character c, Monster m , boolean turn){
		isPlayerTurn = turn;
		playerCharacter = c;
		enemyMonster = m;
	}
	
	private boolean playerTurn(Character c){
		System.out.println("Player's Turn");
		System.out.println("Health: " + c.getCurrentHealth() + " / " + c.getMaxHealth());
		return isPlayerTurn = false;
	}
	
	private boolean monsterTurn(Monster m){
		System.out.println("Monster's Turn");
		return isPlayerTurn = true;
	}
	
	private int fight(Character c, Monster m){
		Scanner input = new Scanner(System.in);
		
		
		return 0;
	}
	
	
//	public static void main(String[] args){
//		Character me = new Character();
//		Monster you = new Monster();
//		
//		
//		Combat testFight = new Combat(me,you,true);
//		
//		testFight.fight();
//	}
}
