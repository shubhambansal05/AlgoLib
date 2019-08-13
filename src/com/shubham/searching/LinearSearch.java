package com.shubham.searching;

import com.sun.istack.internal.NotNull;

public class LinearSearch implements Search {

    @Override
    public int find(@NotNull int[] numbersArr, int number) {
        for (int i = 0; i < numbersArr.length; i++)
            if (numbersArr[i] == number)
                return i;
        return -1;
    }
}
