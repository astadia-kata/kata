package com.astadia.kata.arraychop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public abstract class AbstractArrayChopperTest {

	protected ArrayChopper chopper;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		chopper = null;
	}

	private int chop(int key, int[] vals) {
        return chopper.chop(key, vals);
    }

	@Test
    public void testChop1() {
        Assert.assertEquals(-1, chop(3, new int[] {}));
    }

	@Test
    public void testChop2() {
        Assert.assertEquals(-1, chop(3, new int[] { 1 }));
    }

	@Test
    public void testChop3() {
        Assert.assertEquals(0, chop(1, new int[] { 1 }));
    }

	@Test
    public void testChop4() {
        Assert.assertEquals(0, chop(1, new int[] { 1, 3, 5 }));
    }

	@Test
    public void testChop5() {
        Assert.assertEquals(1, chop(3, new int[] { 1, 3, 5 }));
    }
	
	@Test
    public void testChop6() {
        Assert.assertEquals(2, chop(5, new int[] { 1, 3, 5 }));
    }

	@Test
    public void testChop7() {
        Assert.assertEquals(-1, chop(0, new int[] { 1, 3, 5 }));
    }

	@Test
    public void testChop8() {
        Assert.assertEquals(-1, chop(2, new int[] { 1, 3, 5 }));
    }

	@Test
    public void testChop9() {
        Assert.assertEquals(-1, chop(4, new int[] { 1, 3, 5 }));
    }

	@Test
    public void testChop10() {
        Assert.assertEquals(-1, chop(6, new int[] { 1, 3, 5 }));
    }

	@Test
    public void testChop11() {
        Assert.assertEquals(0, chop(1, new int[] { 1, 3, 5, 7 }));
    }

	@Test
    public void testChop12() {
        Assert.assertEquals(1, chop(3, new int[] { 1, 3, 5, 7 }));
    }

	@Test
    public void testChop13() {
        Assert.assertEquals(2, chop(5, new int[] { 1, 3, 5, 7 }));
    }

	@Test
    public void testChop14() {
        Assert.assertEquals(3, chop(7, new int[] { 1, 3, 5, 7 }));
    }

	@Test
    public void testChop15() {
        Assert.assertEquals(-1, chop(0, new int[] { 1, 3, 5, 7 }));
    }

	@Test
    public void testChop16() {
        Assert.assertEquals(-1, chop(2, new int[] { 1, 3, 5, 7 }));
    }

	@Test
    public void testChop17() {
        Assert.assertEquals(-1, chop(4, new int[] { 1, 3, 5, 7 }));
    }

	@Test
    public void testChop18() {
        Assert.assertEquals(-1, chop(6, new int[] { 1, 3, 5, 7 }));
    }

	@Test
    public void testChop19() {
        Assert.assertEquals(-1, chop(8, new int[] { 1, 3, 5, 7 }));
    }
}
