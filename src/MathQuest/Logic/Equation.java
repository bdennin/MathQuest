package MathQuest.Logic;

import java.util.Random;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Equation {

	public enum Sign {
		ADDITION("+"), SUBTRACTION("-"), BOTH("+/-");
		private String sign;
		Sign(String sign) {
			this.sign = sign;
		}
		public String getSign() {
			return this.sign;
		}
	}
	
	public enum Digits {
		ONE(1), TWO(2), THREE(3), FOUR(4);
		private int digits;
		Digits(int digits) {
			this.digits = digits;
		}
		public int getDigits() {
			return this.digits;
		}
		public String getString(){
			switch(digits){
			case 1: return "ONE";
			case 2: return "TWO";
			case 3: return "THREE";
			case 4: return "FOUR";
			default: return null;
			}
		}
		public static int getDigits(String digit){
			switch(digit){
			case "ONE": return 1;
			case "TWO": return 2;
			case "THREE": return 3;
			case "FOUR": return 4;
			default: return 1;
			}
		}
	}

	public enum Terms {
		TWO(2), THREE(3), FOUR(4), FIVE(5);
		private int terms;
		Terms(int terms) {
			this.terms = terms;
		}
		public int getTerms(){
			return this.terms;
		}
		public String getString(){
			switch(terms){
			case 2: return "TWO";
			case 3: return "THREE";
			case 4: return "FOUR";
			case 5: return "FIVE";
			default: return null;
			}
		}
		public static int getTerms(String term){
			switch(term){
			case "TWO": return 2;
			case "THREE": return 3;
			case "FOUR": return 4;
			case "FIVE": return 5;
			default: return 2;
			}
		}
	}
	
	private static final Random RANDOM = new Random();
	private static final ScriptEngineManager MANAGER = new ScriptEngineManager();
    private static final ScriptEngine ENGINE = MANAGER.getEngineByName("JavaScript");
   
	public static String constructEquation(Sign sign, Digits digits, Terms terms) {
		
		String signThreshold = sign.getSign();
		int termsThreshold = terms.getTerms();
		int digitsThreshold = digits.getDigits();
		
		return constructEquation(signThreshold,digitsThreshold,termsThreshold);
		
	}
	
	public static String constructEquation(String[] settings) {
		String signThreshold = settings[0];
		int digitsThreshold = Digits.getDigits(settings[1]);
		int termsThreshold = Terms.getTerms(settings[2]);
		
		return constructEquation(signThreshold,digitsThreshold,termsThreshold);
	}
	
	private static String constructEquation(String sign, int digitsThreshold, int termsThreshold){
		StringBuilder stringConstructor = new StringBuilder(50);
		for(int i = 0; i < termsThreshold; i++) {
			for(int j = 0; j < digitsThreshold; j++) {
				int random;
				do{
					random = RANDOM.nextInt(10);
				}
				while(j == 0 && random == 0);
				
				stringConstructor.append(random);
				if(j == digitsThreshold - 1 && i != termsThreshold - 1) {
					if(sign.equals("+/-")) {
						random = RANDOM.nextInt(2);
						if(random == 1)
							stringConstructor.append("+");
						else
							stringConstructor.append("-");
					}
					else {
						stringConstructor.append(sign);
					}
				}
			}
		}
		return stringConstructor.toString().trim();
	}
	
	public static int solveEquation(String equation) {
		Integer answer = null;
		try {
			answer = (Integer)ENGINE.eval(equation);
			
		} catch (ScriptException e) {
			
			e.printStackTrace();
		}
		return answer.intValue();
	}
	
	public static int generateWrongAnswer(String equation) {
		int wrongAnswer;
		int correctAnswer = Equation.solveEquation(equation);
		
		do {
			wrongAnswer = (int)(correctAnswer + (correctAnswer * (Math.random() -.5)));
		}
		while(correctAnswer == wrongAnswer);
		
		return wrongAnswer;
	}
	
}
