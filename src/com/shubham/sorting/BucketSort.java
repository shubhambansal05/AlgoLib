package com.shubham.sorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        int max = numbersArr[0];
        for (int number : numbersArr)
            if (max < number)
                max = number;
        int bucketSize = (int) (Math.log10(max)) + 1;
        List<Integer>[] bucket = new List[bucketSize];
        for (int i = 0; i < bucketSize; i++)
            bucket[i] = new LinkedList<>();
        for (int number : numbersArr) {
            int location = 0;
            if (number != 0)
                location = (int) Math.log10(number);
            int index = Math.abs(Collections.binarySearch(bucket[location], number) + 1);
            bucket[location].add(index, number);
        }
        int i = 0;
        for (List<Integer> list : bucket)
            for (int number : list)
                numbersArr[i++] = number;
    }
}