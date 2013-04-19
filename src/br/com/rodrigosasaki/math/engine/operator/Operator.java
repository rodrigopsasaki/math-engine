package br.com.rodrigosasaki.math.engine.operator;

import static br.com.rodrigosasaki.math.engine.operator.Associativity.*;

/**
 * @author Rodrigo Sasaki
 */
public enum Operator{

	ADDITION("+", 0, LEFT){
		
		public double evaluate(double a, double b){
			return a + b;
		}
		
	},
	SUBTRACTION("-", 0, LEFT){
		
		public double evaluate(double a, double b){
			return a - b;
		}
		
	},
	MULTIPLICATION("*", 1, LEFT){
		
		public double evaluate(double a, double b){
			return a * b;
		}
		
	},
	DIVISION("/", 1, LEFT){
		
		public double evaluate(double a, double b){
			return a / b;
		}
		
	},
	MODULO("%", 1, LEFT){
		
		public double evaluate(double a, double b){
			return a % b;
		}
		
	},
	POWER("^", 2, RIGHT){
		
		public double evaluate(double a, double b){
			return Math.pow(a, b);
		}
		
	};

	private String operator;
	private int precedence;
	private Associativity associativity;

	private Operator(String operator, int precedence, Associativity associativity){
		this.operator = operator;
		this.precedence = precedence;
		this.associativity = associativity;
	}
	
	public static boolean isOperator(String operator){
		for(Operator op : Operator.values()){
			if(op.getOperator().equals(operator)){
				return true;
			}
		}
		return false;
	}

	public static Operator asOperator(String operator){
		for(Operator op : Operator.values()){
			if(op.getOperator().equals(operator)){
				return op;
			}
		}
		return null;
	}
	
	public abstract double evaluate(double a, double b);
	
	public boolean lowerPrecedenceThan(Operator operator){
		return this.precedence < operator.getPrecedence();
	}
	
	public boolean lowerOrEqualPrecedenceThan(Operator operator){
		return this.precedence <= operator.getPrecedence();
	}
	
	public boolean higherPrecedenceThan(Operator operator){
		return this.precedence > operator.getPrecedence();
	}
	
	public boolean higherOrEqualPrecedenceThan(Operator operator){
		return this.precedence >= operator.getPrecedence();
	}
	
	public boolean isLeftAssociative(){
		return LEFT.equals(associativity);
	}
	
	public boolean isRightAssociative(){
		return RIGHT.equals(associativity);
	}
	
	public boolean isNoneAssociative(){
		return NONE.equals(associativity);
	}

	public String getOperator(){
		return operator;
	}

	public int getPrecedence(){
		return precedence;
	}

	public Associativity getAssociativity(){
		return associativity;
	}

}
