package com.shubham.sorting;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] numbersArr) {
        int size = numbersArr.length;
        // Heapify the array for all the roots at index i in the bottom up order
        // Last root index in the array can be calculated as i = size / 2 - 1
        for (int i = (size >>> 1) - 1; i >= 0; i--)
            heapify(numbersArr, size, i);
        // Swap the top node with the bottom node, and decrease the size of the heap by 1, and heapify the top node again
        for (int n = size - 1; n >= 0; n--) {
            swap(numbersArr, 0, n);
            heapify(numbersArr, n, 0);
        }
    }

    private void heapify(int[] numbersArr, int size, int i) {
        int max = i;            // Root node index
        int left = 2 * i + 1;   // Left child node index
        int right = left + 1;   // Right child node index
        // Check if left child is larger
        if (left < size && numbersArr[max] < numbersArr[left])
            max = left;
        // Check if right node is larger so far
        if (right < size && numbersArr[max] < numbersArr[right])
            max = right;
        // Check if root node is not the largest, then swap it with the largest child and heapify the child again
        if (max != i) {
            swap(numbersArr, i, max);
            heapify(numbersArr, size, max);
        }
    }
}