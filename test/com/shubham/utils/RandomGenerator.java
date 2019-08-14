package com.shubham.utils;

import java.util.Random;

public class RandomGenerator {

    private static final int MAX_NUMBER_ARRAY_SIZE = 1000;
    private static final int MAX_NUMBER = 10000;

    public static int[] getArrayOfRandomIntegers() {
        return getArrayOfRandomIntegers(getRandomSizeOfArray());
    }

    public static int[] getArrayOfRandomIntegers(int size) {
        return getArrayOfRandomIntegers(size, Integer.MIN_VALUE, MAX_NUMBER);
    }

    public static int[] getArrayOfRandomIntegers(int size, int minNumber, int maxNumber) {
        return new Random().ints(size, minNumber, maxNumber).toArray();
    }

    public static int[] getArrayOfRandomPositiveIntegers() {
        return getArrayOfRandomPositiveIntegers(getRandomSizeOfArray());
    }

    public static int[] getArrayOfRandomPositiveIntegers(int size) {
        return getArrayOfRandomPositiveIntegers(size, MAX_NUMBER);
    }

    public static int[] getArrayOfRandomPositiveIntegers(int size, int maxNumber) {
        return getArrayOfRandomIntegers(size, 0, maxNumber);
    }

    private static int getRandomSizeOfArray() {
        return new Random().nextInt(MAX_NUMBER_ARRAY_SIZE) + 1;
    }
}
