package MathQuest;

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
	}

	public enum Terms {
		ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
		private int terms;
		Terms(int terms) {
			this.terms = terms;
		}
		public int getTerms(){
			return this.terms;
		}
	}
	
	private static final Random RANDOM = new Random();
	private static final ScriptEngineManager MANAGER = new ScriptEngineManager();
    private static final ScriptEngine ENGINE = MANAGER.getEngineByName("JavaScript");
   
	public static String constructEquation(Sign sign, Digits digits, Terms terms) {
		
		StringBuilder stringConstructor = new StringBuilder(50);
		int termsThreshold = terms.getTerms();
		int digitsThreshold = digits.getDigits();
		
		for(int i = 0; i < termsThreshold; i++) {
			for(int j = 0; j < digitsThreshold; j++) {
				int random;
				do{
					random = RANDOM.nextInt(10);
				}
				while(j == 0 && random == 0);
				
				stringConstructor.append(random);
				if(j == digitsThreshold - 1 && i != termsThreshold - 1) {
					if(sign == Sign.BOTH) {
						random = RANDOM.nextInt(2);
						if(random == 1)
							stringConstructor.append("+");
						else
							stringConstructor.append("-");
					}
					else {
						stringConstructor.append(sign.getSign());
					}
				}
			}
		}
		return stringConstructor.toString().trim();
	}
	
	public static int solveEquation(String equation) throws ScriptException {
		Double answer = (Double)ENGINE.eval(equation);
		return answer.intValue();
	}
}
