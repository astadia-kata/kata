package com.astadia.kata.arraychop;


public class ArraySearchImplTwo implements ArrayChopper
{

    /**
     * Just satisfy the contract... this will be really fast for small arrays, and not so good for large ones... since it's a simple linear search.
     * @param key the integer to search for.
     * @param values the list of values in which to search.
     * @return the index where the value is found, or -1 if not found.
     */
    @Override
	public int chop(int key, int[] values) {
        int retVal = -1;
        for (int i = 0; i < values.length; i++) {
            if (key == values[i]) {
                retVal = i;
                break;
            }
        }
        return retVal;
	}
}
