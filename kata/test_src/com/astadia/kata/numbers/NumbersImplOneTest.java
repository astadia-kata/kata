package com.astadia.kata.numbers;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumbersImplOneTest {

	private Numbers numbers;

	@Before
	public void setUp() throws Exception {
		numbers = new NumbersImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntegerAddition() throws Exception {
        assertEquals("25", numbers.add("15", "10"));
    }

	@Test
	public void testNonNumberAddition() throws Exception {
        assertEquals("Not a number.", numbers.add("15", "foobar"));
    }

	@Test
    public void testIntegerMultiplication() throws Exception {
        assertEquals("25", numbers.multiply("5", "5"));
    }

	@Test
    public void testDecimalMultiplication() throws Exception {
        assertEquals("8.050", numbers.multiply("3.5", "2.3"));
    }

	@Test
    public void testDecimalMultiplication2() throws Exception {
        assertEquals("0.021", numbers.multiply("0.70", "0.03"));
    }

	@Test
    public void testNonNumberToString() {
        assertEquals("Not a number.", numbers.add("x", "10"));
    }
}
