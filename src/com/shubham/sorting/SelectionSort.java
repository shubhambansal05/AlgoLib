package com.shubham.sorting;

public class SelectionSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        for (int i = 0; i < numbersArr.length - 1; i++) {
            // Index of minimum number in the array
            int minIndex = i;
            for (int j = i + 1; j < numbersArr.length; j++)
                if (numbersArr[minIndex] > numbersArr[j])
                    minIndex = j;
            // Check for avoiding self swapping
            if (i != minIndex)
                swap(numbersArr, i, minIndex);
        }
    }
}