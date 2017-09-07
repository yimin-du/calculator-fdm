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

	public static double evaluate(String exp) {
		exp = exp.replaceAll("\\s+","");
		if(exp.charAt(0) == '+') {
			exp = exp.substring(1);
		}
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

	private static String left(String exp, int i) {
		return exp.substring(0, i);
	}

	private static String right(String exp, int i) {
		return exp.substring(i + 1);
	}

	private static double power(double a, int b) {
		if(b == 0)
			return 1;
		if(b > 0)
			return a * power(a, b - 1);
		else {
			return 1/a * power(a, b + 1);
		}
	}

	private static int nextMinusSign(String exp) {
		int index = exp.lastIndexOf("-");
		if( index <= 0)
			return -1;
		else
			if(!Character.isDigit(exp.charAt(index-1)))
				return nextMinusSign(exp.substring(0, index));
			else 
				return index;
	}

	private static int nextAddSign(String exp) {
		int index = exp.lastIndexOf("+");
		if( index <= 0)
			return -1;
		else
			if(!Character.isDigit(exp.charAt(index-1)))
				return nextAddSign(exp.substring(0, index));
			else 
				return index;
	}
}