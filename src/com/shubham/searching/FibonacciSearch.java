package com.shubham.searching;

public class FibonacciSearch implements Search {

    @Override
    public int find(int[] numbersArr, int number) {
        int n = numbersArr.length - 1;
        if (n < 0)
            return -1;

        int fibM2 = 0;              //Fibonacci no. (m-2)th
        int fibM1 = 1;              //Fibonacci no. (m-1)th
        int fibM = fibM2 + fibM1;   //Fibonacci no. (m)th

        // finding fibM greater than or equal to n
        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        // offSet marks the range that has been eliminated, starting from the front
        int offSet = 0;
        while (fibM > 1) {
            int i = Math.min(offSet + fibM2, n);
            if (numbersArr[i] < number) {
                // moving Fibonacci nos. to one level down and eliminating indices from offset to i
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                // resetting offset value as all the indices below this have been eliminated
                offSet = i;
            } else if (numbersArr[i] > number) {
                // moving Fibonacci nos. to two levels down and eliminating indices after i
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else
                return i;
        }

        // Checking for boundary case like first or last
        if (numbersArr[offSet] == number)
            return offSet;
        else if (numbersArr[n] == number)
            return n;
        else
            return -1;
    }
}
