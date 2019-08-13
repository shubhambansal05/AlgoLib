package com.shubham.sorting;

import java.util.Arrays;

public class PigeonholeSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        int min = numbersArr[0];
        int max = numbersArr[0];
        for (int number : numbersArr) {
            if (min > number)
                min = number;
            if (max < number)
                max = number;
        }
        // Range = max - min + 1;
        int[] pigeonHole = new int[max - min + 1];
        Arrays.fill(pigeonHole, 0);
        // Stroe count of numbers
        for (int number : numbersArr)
            pigeonHole[number - min]++;
        int index = 0;
        for (int i = 0; i < pigeonHole.length; i++)
            // Store numbers at their correct position
            while (pigeonHole[i]-- > 0)
                numbersArr[index++] = i + min;
    }
}