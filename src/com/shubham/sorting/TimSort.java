package com.shubham.sorting;

public class TimSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        InsertionSort is = new InsertionSort();
        MergeSort ms = new MergeSort();
        int run = 64; // Run can be 32 or 64
        int n = numbersArr.length;
        for (int i = 0; i < n; i += run)
            is.binaryInsertionSort(numbersArr, i, Math.min(i + run - 1, n - 1));
        for (int size = run; size < n; size = size << 1)
            for (int start = 0; start < n; start += size << 1) {
                int mid = start + size - 1;
                int end = Math.min(mid + size, n - 1);
                if (mid < end)
                    ms.merge(numbersArr, start, mid, end);
            }
    }
}