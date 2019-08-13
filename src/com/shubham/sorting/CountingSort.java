package com.shubham.sorting;

import java.util.Arrays;

public class CountingSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        int min = numbersArr[0];
        int max = min;
        for (int number : numbersArr) {
            if (min > number)
                min = number;
            if (max < number)
                max = number;
        }
        // Range = max - min + 1;
        int[] count = new int[max - min + 1];
        Arrays.fill(count, 0);
        // Store count of numbers
        for (int number : numbersArr)
            count[number - min]++;
        // Calculate position of numbers
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
        // Store numbers at their correct position
        int[] output = new int[numbersArr.length];
        for (int i = numbersArr.length - 1; i >= 0; i--) {
            output[count[numbersArr[i] - min] - 1] = numbersArr[i];
            count[numbersArr[i] - min]--;
        }
        // Copy the output result
        for (int i = 0; i < numbersArr.length; i++)
            numbersArr[i] = output[i];
    }
}