package com.shubham.sorting;

public class CombSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        boolean isSwapped = true;
        int gap = numbersArr.length;
        while (gap != 1 || isSwapped) {
            gap = nextGap(gap);
            isSwapped = false;
            for (int j = 0; j + gap < numbersArr.length; j++) {
                if (numbersArr[j] > numbersArr[j + gap]) {
                    swap(numbersArr, j, j + gap);
                    isSwapped = true;
                }
            }
        }
    }

    private int nextGap(int gap) {
        // 1.3 is the best shrink factor;
        gap = (int) (gap / 1.3);
        if (gap < 1)
            gap = 1;
        return gap;
    }
}