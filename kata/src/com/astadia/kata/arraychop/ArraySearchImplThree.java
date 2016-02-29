package com.astadia.kata.arraychop;


public class ArraySearchImplThree implements ArrayChopper
{

    /**
     * This satisfies the spirit of a binary type of search. Note that we assume the array is already sorted. If it's not sorted, then results are unpredictable.
     * @param key the value whose index we're trying to find.
     * @param values the array of sorted values.
     * @return the index of key with the sorted array of values, or -1 if the key does not exist within that sorted array.
     */
    @Override
	public int chop(int key, int[] values) {
        int retVal = -1;
        if (values.length > 0) {
            int pivotIndex = values.length / 2;
            retVal = recurseSearch(values, key, pivotIndex, 0, values.length - 1);
        }
        System.out.println("************ Returning: [" + retVal + "]");
        return retVal;
	}

    private int recurseSearch(int[] values, int key, int pivotIndex, int loIndex, int hiIndex) {
        System.out.println("values: [" + printValues(values) + "] key: [" + key + "] + pivotIndex: [" + pivotIndex + "] + loIndex: [" + loIndex + "] hiIndex: [" + hiIndex + "]");
        int retVal;
        if (values[pivotIndex] == key) {
            retVal = pivotIndex;
        } else if ((hiIndex - loIndex) == 0) {
            retVal = -1;
        } else if (values[pivotIndex] > key) {
            // The value is below the pivotIndex.
            int newPivotIndex = (pivotIndex - loIndex) / 2;
            if (newPivotIndex == pivotIndex) {
                newPivotIndex--;
            }
            retVal = recurseSearch(values, key, newPivotIndex, loIndex, pivotIndex - 1);
        } else {
            // The value is above the pivotIndex.
            int newPivotIndex = hiIndex - (hiIndex - loIndex) / 2;
            if (newPivotIndex == pivotIndex) {
                newPivotIndex++;
            }
            retVal = recurseSearch(values, key, newPivotIndex, pivotIndex + 1, hiIndex);
        }
        return retVal;
    }

    private String printValues(int[] values) {
        StringBuilder s = new StringBuilder();
        for (int i : values) {
            s.append(i).append(",");
        }
        return s.toString();
    }
}
