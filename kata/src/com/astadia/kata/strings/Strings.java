package com.astadia.kata.strings;

public interface Strings {

	/**
	 * Count the number of times a given character appears in a String.
	 *
	 * @param strToParse the String containing the characters that we want to count.
	 * @param c the character that we want to count.
	 * @return the number of times the given character appears in the given string.
	 */
	public abstract int howMany(String strToParse, char c);

	/**
	 * Count the number of times a given word appears in the given String. Note that the search does not require the word to be surrounded by white space; i.e. the word may be
	 * embedded within the given string.
	 *
	 * @param wordToFind the word that we are to search for.
	 * @param strToParse the presumably larger String that we'll search.
	 * @return the number of times that the word appears in the given String.
	 */
	public abstract int containsHowMany(String wordToFind, String strToParse);

}