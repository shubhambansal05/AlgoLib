package com.shubham.searching;

public class BinarySearch implements Search {
    // recursive call approach
    public static int binarySearch(int[] numbersArr, int start, int end, int number) {
        if (start <= end) {
            int middle = start + ((end - start) >>> 1);
            if (number == numbersArr[middle])
                return middle;
            if (number < numbersArr[middle])
                return binarySearch(numbersArr, start, middle - 1, number);
            else
                return binarySearch(numbersArr, middle + 1, end, number);
        }
        return -1;
    }

    @Override
    public int find(int[] numbersArr, int number) {
        int start = 0, end = numbersArr.length - 1;
        while (start <= end) {
            int middle = (start + end) >>> 1;
            if (number == numbersArr[middle])
                return middle;
            if (number < numbersArr[middle])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
        // return binarySearch(numbersArr, start, end, number);
    }
}
