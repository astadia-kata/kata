package com.astadia.kata.numbers;

public interface Numbers {

	/**
	 * Add two numbers that are represented as Strings, and return the result, also represented as a String.
	 *
	 * @param string the first number, represented as a String.
	 * @param string2 the second number, represented as a String.
	 * @return the sum of the two numbers, represented as a String, or "Not a number." if either argument does not represent a number.
	 */
	public abstract String add(String string, String string2);

	/**
	 * Multiply two numbers that are represented as Strings, and return the result, also represented as a String.
	 *
	 * @param string the first number, represented as a String.
	 * @param string2 the second number, represented as a String.
	 * @return the product of the two numbers, represented as a String, or "Not a number." if either argument does not represent a number.
	 */
	public abstract String multiply(String string, String string2);

}