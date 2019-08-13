package com.shubham.utils;

import java.util.Random;

public class RandomGenerator {

    private static final int MAX_NUMBER_ARRAY_SIZE = 100000;

    public static int[] getArrayOfRandomIntegers() {
        return getArrayOfRandomIntegers(getRandomSizeOfArray());
    }

    public static int[] getArrayOfRandomIntegers(int size) {
        return getArrayOfRandomIntegers(size, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int[] getArrayOfRandomIntegers(int size, int minNumber, int maxNumber) {
        return new Random().ints(size, minNumber, maxNumber).toArray();
    }

    public static int[] getArrayOfRandomPositiveIntegers() {
        return getArrayOfRandomPositiveIntegers(getRandomSizeOfArray());
    }

    public static int[] getArrayOfRandomPositiveIntegers(int size) {
        return getArrayOfRandomPositiveIntegers(size, Integer.MAX_VALUE);
    }

    public static int[] getArrayOfRandomPositiveIntegers(int size, int maxNumber) {
        return getArrayOfRandomIntegers(size, 0, maxNumber);
    }

    public static int[] getArrayOfRandomNegativeIntegers() {
        return getArrayOfRandomNegativeIntegers(getRandomSizeOfArray());
    }

    public static int[] getArrayOfRandomNegativeIntegers(int size) {
        return getArrayOfRandomNegativeIntegers(size, Integer.MIN_VALUE);
    }

    public static int[] getArrayOfRandomNegativeIntegers(int size, int minNumber) {
        return getArrayOfRandomIntegers(size, minNumber, 0);
    }

    private static int getRandomSizeOfArray() {
        return new Random().nextInt(MAX_NUMBER_ARRAY_SIZE) + 1;
    }
}
