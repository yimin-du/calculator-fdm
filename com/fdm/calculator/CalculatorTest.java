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
	
	/* testing for a single number input */

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

	@Test
	public void when_receiving_string_0_should_return_double_0() {
		double result = calculator.evaluate("0");
		assertEquals(0d, result, 0.1);
	}

	@Test
	public void when_receiving_string_2dot5_should_return_double_2dot5() {
		double result = calculator.evaluate("2.5");
		assertEquals(2.5d, result, 0.1);
	}

	@Test
	public void when_receiving_string_89_should_return_double_89() {
		double result = calculator.evaluate("89");
		assertEquals(89d, result, 0.1);
	}
	
	
	 /* Testing for simple addition and subtraction */

	@Test
	public void when_receiving_1_plus_1_return_double_2() {
		double result = calculator.evaluate("1+1");
		assertEquals(2d, result, 0.1);
	}

	@Test
	public void when_receiving_2_minus_1_return_double_1() {
		double result = calculator.evaluate("2-1");
		assertEquals(1d, result, 0.1);
	}

	@Test
	public void when_receiving_2_minus_1_plus_4_return_double_5() {
		double result = calculator.evaluate("2-1+4");
		assertEquals(5d, result, 0.1);
	}

	@Test
	public void when_receiving_neg_2_minus_1_plus_4_return_double_1() {
		double result = calculator.evaluate("-2-1+4");
		assertEquals(1d, result, 0.1);
	}

	@Test
	public void when_receiving_neg_2_minus_1_plus_4_minus_neg_10_return_double_neg_9() {
		double result = calculator.evaluate("-2-1+4-10");
		assertEquals(-9d, result, 0.1);
	}

	@Test
	public void when_receiving_2_minus_4_add_6_minus_1_minus_1_minus_0_add_8_return_double_10() {
		double result = calculator.evaluate("6-1-1");
		assertEquals(4d, result, 0.1);
	}

	@Test
	public void when_receiving_1_minus_1_plus_2_minus_2_add_4_minus_4_plus_6_return_double_6() {
		double result = calculator.evaluate("1-1+2-2+4-4+6");
		assertEquals(6d, result, 0.1);
	}


	/* testing for simple multiplication and division*/

	@Test
	public void when_receiving_2_times_3_return_double_6() {
		double result = calculator.evaluate("2*3");
		assertEquals(6d, result, 0.1);
	}

	@Test
	public void when_receiving_6_divide_3_return_double_2() {
		double result = calculator.evaluate("6/3");
		assertEquals(2d, result, 0.1);
	}

	

	/* Testing for ASMD */


	@Test
	public void when_receiving_1_plus_2_times_3_return_double_7() {
		double result = calculator.evaluate("1+2*3");
		assertEquals(7d, result, 0.1);
	}

	@Test
	public void when_receiving_neg_1_minus_2_times_3_return_double_neg_7() {
		double result = calculator.evaluate("-1-2*3");
		assertEquals(-7d, result, 0.1);
	}

	@Test
	public void when_receiving_neg_1_add_2_times_3_return_double_neg_7() {
		double result = calculator.evaluate("-1+11*2-1.5");
		assertEquals(19.5d, result, 0.1);
	}

	@Test
	public void when_receiving_neg_1_add_10_div_2_minus_1dot5_times_2_return_double_1() {
		double result = calculator.evaluate("-1+10/2-1.5*2");
		assertEquals(1d, result, 0.1);
	}

	@Test
	public void when_receiving_neg100_times_neg2_return_double_200() {
		double result = calculator.evaluate("-100*-2");
		assertEquals(200d, result, 0.1);
	}

	@Test
	public void when_receiving_neg5_divide_neg2_return_double_2dot5() {
		double result = calculator.evaluate("-5/-2");
		assertEquals(2.5d, result, 0.1);
	}

	@Test
	public void when_receiving_4_time2dot5_add_8dot5_1dot5_div_3_return_double_19() {
		double result = calculator.evaluate("4*2.5+8.5+1.5/3.0");
		assertEquals(19d, result, 0.1);
	}

	@Test
	public void when_receiving_3_add_8_div_5_minus_1_minus_2_times_5_return_double_neg6dot4() {
		double result = calculator.evaluate("3+8/5-1-2*5");
		assertEquals(-6.4d, result, 0.1);
	}

	@Test
	public void when_receiving_neg20_div10_times_2_return_double_2dot5() {
		double result = calculator.evaluate("-20/10*2");
		assertEquals(-4d, result, 0.1);
	}

	@Test
	public void when_receiving_neg20_times_10_div_2_return_double_2dot5() {
		double result = calculator.evaluate("-20*10/2");
		assertEquals(-100d, result, 0.1);
	}

	@Test
	public void when_receiving_neg20_div_10_div_2_return_double_2dot5() {
		double result = calculator.evaluate("-20/10/2");
		assertEquals(-1d, result, 0.1);
	}

	/* Testing for power */

	@Test
	public void when_receiving_3_exp_2_return_double_9() {
		double result = calculator.evaluate("3^2");
		assertEquals(9d, result, 0.1);
	}

	@Test
	public void when_receiving_neg2_exp_2_return_double_neg8() {
		double result = calculator.evaluate("-2^2");
		assertEquals(-4d, result, 0.1);
	}

	@Test
	public void when_receiving_neg2_exp_neg2_return_double_dot25() {
		double result = calculator.evaluate("-2^-2");
		assertEquals(-0.25d, result, 0.1);
	}
	
}