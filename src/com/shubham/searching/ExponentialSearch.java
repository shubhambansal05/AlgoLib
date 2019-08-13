package com.shubham.searching;

public class ExponentialSearch implements Search {

    @Override
    public int find(int[] numbersArr, int number) {
        if (numbersArr.length == 0)
            return -1;
        if (numbersArr[0] == number)
            return 0;
        int start = 1;
        while (start < numbersArr.length && numbersArr[start] < number)
            start *= 2;
        return BinarySearch.binarySearch(numbersArr, start / 2, Math.min(start, numbersArr.length - 1), number);
    }
}
