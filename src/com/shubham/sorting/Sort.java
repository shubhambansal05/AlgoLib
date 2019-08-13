package com.shubham.sorting;

public interface Sort {

    void sort(int[] numbersArr);

    default void swap(int[] numbersArr, int i, int j) {
        if (i != j) {
            int temp = numbersArr[i];
            numbersArr[i] = numbersArr[j];
            numbersArr[j] = temp;
        }
    }
}
