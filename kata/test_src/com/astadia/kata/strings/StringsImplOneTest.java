package com.astadia.kata.strings;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringsImplOneTest {

	private String strToParse;
	private StringsImpl strings;

	@Before
	public void setUp() throws Exception {
		strings = new StringsImpl();
		strToParse = "todayisagoodday";
	}

	@After
	public void tearDown() throws Exception {
		strToParse = null;
		strings = null;
	}

	@Test
	public void testStringArray() {
        assertEquals(15, strToParse.toCharArray().length);
    }

	@Test
    public void testHowManyAs() {
        assertEquals(3, strings.howMany(strToParse, 'a'));
    }

	@Test
    public void testHowManyDs() {
        assertEquals(3, strings.howMany(strToParse, 'd'));
    }

	@Test
    public void testGetDaysCount() {
        assertEquals(2, strings.containsHowMany("day", strToParse));
    }

	@Test
    public void testGetTodayCount() {
        assertEquals(1, strings.containsHowMany("today", strToParse));
    }

	@Test
    public void testABunchOfTodayCount() {
        assertEquals(5, strings.containsHowMany("today", "todayxtodayxtodayxtodayxtoday"));
    }
}
