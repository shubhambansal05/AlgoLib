package com.shubham.sorting;

public class CycleSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        for (int cycleStart = 0; cycleStart < numbersArr.length - 1; cycleStart++) {
            int item = numbersArr[cycleStart];
            int position = cycleStart;
            // Find the correct position of the item to put
            for (int i = cycleStart + 1; i < numbersArr.length; i++)
                if (item > numbersArr[i])
                    position++;
            // Rotate the cycle
            while (position != cycleStart) {
                position = cycleStart;
                for (int i = cycleStart + 1; i < numbersArr.length; i++)
                    if (item > numbersArr[i])
                        position++;
                // Ignores all the duplicate elements
                while (item == numbersArr[position])
                    position++;
                // Put the item at its correct position and updating its value with existing value
                if (item != numbersArr[position]) {
                    int temp = item;
                    item = numbersArr[position];
                    numbersArr[position] = temp;
                }
            }
        }
    }
}