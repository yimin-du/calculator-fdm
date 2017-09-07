package com.fdm.calculator;

public class Calculator {
	
	public static void main(String[] args) {

		
	}

	public double evaluate(String exp) {
		exp = exp.replaceAll("\\s+","");
		//System.out.println("exp:" + exp);
		if(exp.contains("(")) {
			int i = exp.lastIndexOf("(");
			int j = exp.indexOf(")", i);
			double resultInBracket = evaluate(exp.substring(i + 1, j));
			if(j == exp.length()) {
				return evaluate(exp.substring(0, i) + Double.toString(resultInBracket));
			} else {
				return evaluate(exp.substring(0, i) + Double.toString(resultInBracket) + exp.substring(j + 1));
			}
		} else if(nextAddSign(exp) > -1) {
			int i = nextAddSign(exp);
			return evaluate(left(exp, i)) + evaluate(right(exp, i));
		} else if(nextMinusSign(exp) > -1) {
			int i = nextMinusSign(exp);
			return evaluate(left(exp, i)) - evaluate(right(exp, i));
		} else if(exp.contains("*")) {
			int i = exp.indexOf("*");
			return evaluate(left(exp, i)) * evaluate(right(exp, i));
		} else if(exp.contains("/")) {
			int i = exp.lastIndexOf("/");
			return evaluate(left(exp, i)) / evaluate(right(exp, i));
		} else if(exp.contains("^")) {
			int i = exp.indexOf("^");
			if(exp.charAt(0) == '-')
				return -1 * power(evaluate(left(exp, i)), (int)evaluate(right(exp, i)));
			else 
				return power(evaluate(left(exp, i)), (int)evaluate(right(exp, i)));
		}
		else {	
			return Double.parseDouble(exp);
		} 
	}

	private String left(String exp, int i) {
		return exp.substring(0, i);
	}

	private String right(String exp, int i) {
		return exp.substring(i + 1);
	}

	private double power(double a, int b) {
		if(b == 0)
			return 1;
		if(b > 0)
			return a * power(a, b - 1);
		else {
			return 1/a * power(a, b + 1);
		}
	}

	private int nextMinusSign(String exp) {
		int index = exp.lastIndexOf("-");
		if( index <= 0)
			return -1;
		else
			if(!Character.isDigit(exp.charAt(index-1)))
				return -1;
			else 
				return index;
	}

	private int nextAddSign(String exp) {
		int index = exp.indexOf("+");
		if( index <= 0)
			return -1;
		else
			if(!Character.isDigit(exp.charAt(index-1)))
				return -1;
			else 
				return index;
	}
}