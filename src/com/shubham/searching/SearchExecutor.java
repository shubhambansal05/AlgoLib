package com.shubham.searching;

import com.sun.istack.internal.NotNull;

public class SearchExecutor {

    public static int performSearch(@NotNull SearchTypes searchType, @NotNull int[] numberArr, int number) {
        Search search = null;
        switch (searchType) {
            case LINEAR_SEARCH:
                search = new LinearSearch();
                break;
            case BINARY_SEARCH:
                search = new BinarySearch();
                break;
            case JUMP_SEARCH:
                search = new JumpSearch();
                break;
            case INTERPOLATION_SEARCH:
                search = new InterpolationSearch();
                break;
            case EXPONENTIAL_SEARCH:
                search = new ExponentialSearch();
                break;
            case TERNARY_SEARCH:
                search = new TernarySearch();
                break;
            case FIBONACCI_SEARCH:
                search = new FibonacciSearch();
                break;
        }
        return search.find(numberArr, number);
    }
}
