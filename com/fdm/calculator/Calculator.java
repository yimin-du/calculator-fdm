package com.fdm.calculator;

public class Calculator {
	public double evaluate(String exp) {
		//System.out.println("exp:" + exp);

		if(exp.contains("+")) {
			int i = exp.indexOf("+");
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
				return -1 * Math.pow(evaluate(left(exp, i)), evaluate(right(exp, i)));
			else 
				return Math.pow(evaluate(left(exp, i)), evaluate(right(exp, i)));
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
	// private int nextMinusSign(int startIndex, String exp) {
	// 	if(exp.indexOf("-", startIndex) < 0)
	// 		return -1;
	// 	int indexOfNextMinus = exp.indexOf("-", startIndex);
	// 	if(indexOfNextMinus != startIndex && Character.isDigit(exp.charAt(indexOfNextMinus-1)))
	// 		return indexOfNextMinus;
	// 	else
	// 		return nextMinusSign(indexOfNextMinus + 1, exp);
	// }
}