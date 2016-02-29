package com.astadia.kata.arraychop;

import java.util.Arrays;


public class ArraySearchImplOne implements ArrayChopper
{

    /**
     * No need to re-invent the wheel... Just use an existing implementation.
     */
    @Override
	public int chop(int key, int[] values) {
        int retVal = Arrays.binarySearch(values, key);
        if (retVal < 0) {
            retVal = -1;
        }
        return retVal;
	}

}
