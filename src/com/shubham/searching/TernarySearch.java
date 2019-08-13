package com.shubham.searching;

public class TernarySearch implements Search {
    // recursive call approach
    public static int ternarySearch(int[] numbersArr, int start, int end, int number) {
        if (start <= end) {
            int middle1 = start + (end - start) / 3;
            int middle2 = middle1 + (end - start) / 3;
            if (number == numbersArr[middle1])
                return middle1;
            if (number == numbersArr[middle2])
                return middle2;
            if (number < numbersArr[middle1])
                return ternarySearch(numbersArr, start, middle1 - 1, number);
            else if (number < numbersArr[middle2])
                return ternarySearch(numbersArr, middle1 + 1, middle2 - 1, number);
            else
                return ternarySearch(numbersArr, middle2 + 1, end, number);
        }
        return -1;
    }

    @Override
    public int find(int[] numbersArr, int number) {
        int start = 0, end = numbersArr.length - 1;
        return ternarySearch(numbersArr, start, end, number);
    }
}
