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
	
	private boolean playerTurn(){
		System.out.println("Player's Turn");
		return isPlayerTurn = false;
	}
	
	private boolean monsterTurn(){
		System.out.println("Monster's Turn");
		return isPlayerTurn = true;
	}
	
	private int fight(){
		Scanner input = new Scanner(System.in);
		
		String decision = input.next();
		
		while(decision.equals("y")){
			if(isPlayerTurn){
				this.playerTurn();
			}
			else{
				this.monsterTurn();
			}
			decision = input.next();
		}
		return 0;
	}
	
	
	public static void main(String[] args){
		Character me = new Character();
		Monster you = new Monster();
		
		
		Combat testFight = new Combat(me,you,true);
		
		testFight.fight();
	}
}
