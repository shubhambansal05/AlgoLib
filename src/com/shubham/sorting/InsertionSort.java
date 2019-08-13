package com.shubham.sorting;

public class InsertionSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        insertionSort(numbersArr, 0, numbersArr.length - 1);
    }

    public void insertionSort(int[] numbersArr, int start, int end) {
        for (int i = start + 1; i <= end; i++)
            for (int j = i - 1; j >= start; j--)
                if (numbersArr[j + 1] < numbersArr[j])
                    swap(numbersArr, j + 1, j);
                else
                    break;
    }
}