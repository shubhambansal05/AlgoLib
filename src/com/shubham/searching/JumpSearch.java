package com.shubham.searching;

public class JumpSearch implements Search {

    @Override
    public int find(int[] numbersArr, int number) {
        int start = 0;
        int jump = (int) Math.floor(Math.sqrt(numbersArr.length));
        while (jump < numbersArr.length) {
            if (numbersArr[jump - 1] < number) {
                start = jump;
                jump += jump;
                if (jump > numbersArr.length)
                    jump = numbersArr.length;
            } else
                break;
        }
        for (int i = start; i < jump; i++)
            if (numbersArr[i] == number)
                return i;
        return -1;
    }
}