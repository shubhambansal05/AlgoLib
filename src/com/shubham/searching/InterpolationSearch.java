package com.shubham.searching;

public class InterpolationSearch implements Search {

    @Override
    public int find(int[] numbersArr, int number) {
        int start = 0;
        int end = numbersArr.length - 1;
        while (start <= end && number >= numbersArr[start] && number <= numbersArr[end]) {
            if (start == end) {
                if (numbersArr[start] == number)
                    return start;
                else
                    return -1;
            }
            // Probe Formula
            int middle = start + (Math.abs((number - numbersArr[start]) * (end - start) / (numbersArr[end] - numbersArr[start])));
            if (number == numbersArr[middle])
                return middle;
            if (number < numbersArr[middle])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }
}
