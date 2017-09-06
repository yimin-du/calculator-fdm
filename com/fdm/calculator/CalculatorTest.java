package com.fdm.calculator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calculator;
	
	@Before
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void when_receiving_string_1_should_return_double_1() {
		double result = calculator.evaluate("1");
		assertEquals(1d, result, 0.1);
	}
	
	@Test
	public void when_receiving_string_neg_1_should_return_double_neg_1() {
		double result = calculator.evaluate("-1");
		assertEquals(-1d, result, 0.1);
	}
	
	
}