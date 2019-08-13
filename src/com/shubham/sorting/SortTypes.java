package com.shubham.sorting;

public enum SortTypes {
    SELECTION_SORT("Selection Sort"),
    BUBBLE_SORT("Bubble Sort"),
    INSERTION_SORT("Insertion Sort"),
    MERGE_SORT("Merge Sort"),
    HEAP_SORT("Heap Sort"),
    QUICK_SORT("Quick Sort"),
    TIM_SORT("Tim Sort"),
    SHELL_SORT("Shell Sort"),
    COMB_SORT("Comb Sort"),
    CYCLE_SORT("Cycle Sort"),
    COCKTAIL_SORT("Cocktail Sort"),
    BITONIC_SORT("Bitonic Sort"),
    RADIX_SORT("Radix Sort"),
    COUNTING_SORT("Counting Sort"),
    BUCKET_SORT("Bucket Sort"),
    PIGEONHOLE_SORT("Pigeonhole Sort");

    private String name;

    SortTypes(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
