package com.shubham.sorting;

public class BitonicSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        bitonicSort(numbersArr, 0, numbersArr.length, true); // order = true, for sorting in Ascending order
    }

    private void bitonicSort(int[] numbersArr, int start, int stepsCount, boolean order) {
        if (stepsCount > 1) {
            int k = stepsCount >>> 1;
            bitonicSort(numbersArr, start, k, !order);
            bitonicSort(numbersArr, start + k, stepsCount - k, order);
            bitonicMerge(numbersArr, start, stepsCount, order);
        }
    }

    private void bitonicMerge(int[] numbersArr, int start, int stepsCount, boolean order) {
        if (stepsCount > 1) {
            int k = greatestPowerOfTwoLessThan(stepsCount);
            for (int i = start; i < start + stepsCount - k; i++)
                if ((numbersArr[i] > numbersArr[i + k] == order))
                    swap(numbersArr, i, i + k);
            bitonicMerge(numbersArr, start, k, order);
            bitonicMerge(numbersArr, start + k, stepsCount - k, order);
        }
    }

    private int greatestPowerOfTwoLessThan(int n) {
        int k = 1;
        while (k > 0 && k < n)
            k = k << 1;
        return k >>> 1;
    }
}