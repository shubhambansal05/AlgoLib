package com.shubham.sorting;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        quickSort(numbersArr, 0, numbersArr.length - 1);
    }

    private int partition(int[] numbersArr, int start, int end) {
        int i = start - 1;
        for (int j = start; j < end; j++)
            if (numbersArr[j] <= numbersArr[end]) // Taking last element as pivot element
                swap(numbersArr, ++i, j);
        // Putting pivot element at its correct position
        swap(numbersArr, i + 1, end);
        // Return pivot element index
        return i + 1;
    }

    private void quickSort(int[] numbersArr, int start, int end) {
        if (start < end) {
            int pi = partition(numbersArr, start, end);
            quickSort(numbersArr, start, pi - 1);
            quickSort(numbersArr, pi + 1, end);
        }
    }
}