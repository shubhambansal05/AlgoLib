package com.shubham.sorting;

import java.util.Arrays;

public class InsertionSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        binaryInsertionSort(numbersArr, 0, numbersArr.length - 1);
    }

    public void insertionSort(int[] numbersArr, int start, int end) {
        for (int i = start + 1; i <= end; i++)
            for (int j = i - 1; j >= start; j--)
                if (numbersArr[j + 1] < numbersArr[j])
                    swap(numbersArr, j + 1, j);
                else
                    break;
    }

    public void binaryInsertionSort(int[] numbersArr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int number = numbersArr[i];
            int index = Math.abs(Arrays.binarySearch(numbersArr, 0, i, number) + 1);
            System.arraycopy(numbersArr, index, numbersArr, index + 1, i - index);
            numbersArr[index] = number;
        }
    }
}