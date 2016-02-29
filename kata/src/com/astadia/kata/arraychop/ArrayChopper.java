package com.astadia.kata.arraychop;

public interface ArrayChopper {
    
    /**
     * Returns the location in the array of the key.
     * The array supplied should be sorted to also facilitate a binary sort
     * if desired.
     * -1 is returned if the key can not be found.
     * 
     * @param key
     * @param values
     */
    int chop(int key, int[] values);
}
