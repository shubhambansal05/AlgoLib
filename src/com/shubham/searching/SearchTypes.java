package com.shubham.searching;

public enum SearchTypes {

    LINEAR_SEARCH("Linear Search"),
    BINARY_SEARCH("Binary Search"),
    JUMP_SEARCH("Jump Search"),
    INTERPOLATION_SEARCH("Interpolation Search"),
    EXPONENTIAL_SEARCH("Exponential Search"),
    TERNARY_SEARCH("Ternary Search"),
    FIBONACCI_SEARCH("Fibonacci Search");

    private String name;

    SearchTypes(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
