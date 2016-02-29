package com.astadia.kata.strings;

public class StringsImpl implements Strings {

    /* (non-Javadoc)
	 * @see com.astadia.kata.strings.Strings#howMany(java.lang.String, char)
	 */
    @Override
	public int howMany(String strToParse, char c) {
        int count = 0;
        char[] whereToLook = strToParse.toCharArray();
        for (char currentChar : whereToLook) {
            if (currentChar == c) {
                count++;
            }
        }
        return count;
    }

    /* (non-Javadoc)
	 * @see com.astadia.kata.strings.Strings#containsHowMany(java.lang.String, java.lang.String)
	 */
    @Override
	public int containsHowMany(String wordToFind, String strToParse) {
        int count = 0;
        if (strToParse.contains(wordToFind)) {
            count++;
            String choppedString = strToParse.substring(strToParse.indexOf(wordToFind) + wordToFind.length());
            count += containsHowMany(wordToFind, choppedString);
        }
        return count;
    }
}
