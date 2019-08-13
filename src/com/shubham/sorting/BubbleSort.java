package com.shubham.sorting;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        for (int i = 0; i < numbersArr.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < numbersArr.length - 1 - i; j++) {
                if (numbersArr[j] > numbersArr[j + 1]) {
                    swap(numbersArr, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break;
        }
    }
}
