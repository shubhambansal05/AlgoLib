package com.shubham.sorting;

public class SortExecutor {
    public static void performSort(SortTypes sortType, int[] numberArr) {
        Sort sort = null;
        switch (sortType) {
            case SELECTION_SORT:
                sort = new SelectionSort();
                break;
            case BUBBLE_SORT:
                sort = new BubbleSort();
                break;
            case INSERTION_SORT:
                sort = new InsertionSort();
                break;
            case MERGE_SORT:
                sort = new MergeSort();
                break;
            case HEAP_SORT:
                sort = new HeapSort();
                break;
            case RADIX_SORT:
                sort = new RadixSort();
                break;
            case BUCKET_SORT:
                sort = new BucketSort();
                break;
            case TIM_SORT:
                sort = new TimSort();
                break;
            case QUICK_SORT:
                sort = new QuickSort();
                break;
            case SHELL_SORT:
                sort = new ShellSort();
                break;
            case COMB_SORT:
                sort = new CombSort();
                break;
            case PIGEONHOLE_SORT:
                sort = new PigeonholeSort();
                break;
            case COUNTING_SORT:
                sort = new CountingSort();
                break;
            case CYCLE_SORT:
                sort = new CycleSort();
                break;
            case BITONIC_SORT:
                sort = new BitonicSort();
                break;
            case COCKTAIL_SORT:
                sort = new CocktailSort();
                break;
        }
        sort.sort(numberArr);
    }
}