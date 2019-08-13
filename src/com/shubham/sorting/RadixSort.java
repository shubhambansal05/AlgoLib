package com.shubham.sorting;

import java.util.Arrays;

public class RadixSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        int max = Integer.MIN_VALUE;
        for (int i : numbersArr)
            if (max < i)
                max = i;
        for (int exp = 1; max / exp > 0; exp *= 10) {
            // Performing counting sort
            int[] count = new int[10];
            Arrays.fill(count, 0);
            for (int number : numbersArr)
                count[(number / exp) % 10]++;
            for (int i = 1; i < count.length; i++)
                count[i] += count[i - 1];
            int n = numbersArr.length;
            int[] output = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                int pos = (numbersArr[i] / exp) % 10;
                output[count[pos] - 1] = numbersArr[i];
                count[pos]--;
            }
            for (int i = 0; i < n; i++)
                numbersArr[i] = output[i];
        }
    }
}