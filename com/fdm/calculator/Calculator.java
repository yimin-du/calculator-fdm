package com.fdm.calculator;

import java.util.Scanner;

public class Calculator {
	
	public static void main(String[] args) {

		while(true) {
			System.out.println("Enter an expression to evaluate or 'x' to exit: ");
			Scanner scanner = new Scanner(System.in);
			String exp = scanner.nextLine();
			if(exp.equals("x"))
				break;
			System.out.println("Result: " + evaluate(exp));
		}		
	}

	// Evaluate math expression
	public static double evaluate(String exp) {
		exp = exp.replaceAll("\\s+","");	// remove spaces
		if(exp.charAt(0) == '+') {		// remove prefix '+'
			exp = exp.substring(1);
		}

		if(exp.contains("(")) {
			int i = exp.lastIndexOf("(");
			int j = exp.indexOf(")", i);
			double resultInBracket = evaluate(exp.substring(i + 1, j));
			if(j == exp.length()) {
				return evaluate(exp.substring(0, i) + Double.toString(resultInBracket));
			} else {
				return evaluate(exp.substring(0, i) + Double.toString(resultInBracket) + exp.substring(j + 1));
			}
		} else if(nextPlusOrMinus(exp, "+") > -1) {
			int i = nextPlusOrMinus(exp, "+");
			return evaluate(left(exp, i)) + evaluate(right(exp, i));
		} else if(nextPlusOrMinus(exp, "-") > -1) {
			int i = nextPlusOrMinus(exp, "-");
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
		} else {	
			return Double.parseDouble(exp);
		} 
	}

	
	// get left substring
	private static String left(String exp, int i) {
		return exp.substring(0, i);
	}

	
	// get right substring
	private static String right(String exp, int i) {
		return exp.substring(i + 1);
	}

	
	private static double power(double base, int exp) {
		if(exp == 0)
			return 1;
		if(exp > 0)
			return base * power(base, exp - 1);
		else {
			return 1/base * power(base, exp + 1);
		}
	}

	
	// Return the next +/- operator in the expression
	private static int nextPlusOrMinus(String exp, String sign) {
		int index = 0;
		if(sign.equals("+")) {
			index = exp.lastIndexOf("+");
		} else {
			index = exp.lastIndexOf("-");
		}
		if( index <= 0)
			return -1;
		else
			if(!Character.isDigit(exp.charAt(index-1)))
				return nextPlusOrMinus(exp.substring(0, index), sign);
			else 
				return index;
	}
}