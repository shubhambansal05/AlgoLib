package com.shubham.sorting;

import java.util.Arrays;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        mergeSort(numbersArr, 0, numbersArr.length - 1);
    }

    private void mergeSort(int[] numbersArr, int start, int end) {
        if (start < end) {
            int mid = (end + start) >>> 1;
            mergeSort(numbersArr, start, mid);
            mergeSort(numbersArr, mid + 1, end);
            merge(numbersArr, start, mid, end);
        }
    }

    public void merge(int[] numbersArr, int start, int mid, int end) {
        if (numbersArr[mid] <= numbersArr[mid + 1])
            return;
        int[] left = Arrays.copyOfRange(numbersArr, start, mid + 1);
        int[] right = Arrays.copyOfRange(numbersArr, mid + 1, end + 1);
        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length)
            numbersArr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        while (i < left.length)
            numbersArr[k++] = left[i++];
        while (j < right.length)
            numbersArr[k++] = right[j++];
    }

    public void mergeInPlace(int[] numbersArr, int start, int mid, int end) {
        if (numbersArr[mid] <= numbersArr[mid + 1])
            return;
        int start2 = mid + 1;
        while (start <= mid && start2 <= end) {
            if (numbersArr[start] > numbersArr[start2]) {
                int temp = numbersArr[start2];
                for (int i = start2; i > start; i--)
                    numbersArr[i] = numbersArr[i - 1];
                numbersArr[start] = temp;
                mid++;
                start2++;
            }
            start++;
        }
    }
}