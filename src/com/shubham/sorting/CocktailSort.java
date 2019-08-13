package com.shubham.sorting;

public class CocktailSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        boolean isSwapped = true;
        int n = numbersArr.length;
        int count = 0;
        while (isSwapped) {
            isSwapped = false;
            for (int i = count++; i < n - 1; i++) {
                if (numbersArr[i] > numbersArr[i + 1]) {
                    swap(numbersArr, i, i + 1);
                    isSwapped = true;
                }
                if (numbersArr[n - 1 - i] < numbersArr[n - 2 - i]) {
                    swap(numbersArr, n - 1 - i, n - 2 - i);
                    isSwapped = true;
                }
            }
        }
    }
}
