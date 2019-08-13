package com.shubham.sorting;

public class ShellSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        for (int gap = numbersArr.length / 2; gap > 0; gap = gap >>> 1)
            for (int i = gap; i < numbersArr.length; i++) {
                int temp = numbersArr[i];
                int j;
                for (j = i; j >= gap && numbersArr[j - gap] > temp; j -= gap)
                    swap(numbersArr, j - gap, j);
                numbersArr[j] = temp;
            }
    }
}