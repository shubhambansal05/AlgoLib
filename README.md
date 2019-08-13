# AlgoLib
This repository contains basic practices of algorithms.

**Searching Algorithms:**
                        
        Search Type         Time Complexity      Comments
     1) Linear Search           O(n)             Good for unsorted array.
     2) Binary Search           O(log n)         Good for sorted array with two divisions technique.
     3) Jump Search             O(√n)            Good for sorted array where jumping back is costly (for example, to search smallest number in array).
     4) Interpolation Search    O(log log n)     Good for sorted array where array is uniformly distributed.
     5) Exponential Search      O(log n)         Good for sorted array where size of array is infinite, also when the element to be searched is closer to the first element
     6) Ternary Search          O(log n)         Good for sorted array with three divisions technique, but does more comparisions than Binary Search.
     7) Fibonacci Search        O(log n)         Good for sorted array where CPU cache or RAM is not enough, also it examines relatively closer elements in subsequent steps, 
                                                 also it uses + or - operators intead of / operator for making divisions as / can be a costly opeartion.


**Sorting Algorithms:**

        Sort Type           Time Complexity         Comments
                           (best, avg, worst)
     1) Selection Sort          O(n^2)              Sort by selecting a minimum number from the right unsorted subarray and put it in the left sorted subarray, it takes only O(n) swaps.
     2) Cycle Sort              O(n^2)              Sort by puting the first item at its correct position, and the number at existing position becomes the next item to put at its correct position and so on. Good for where memory writes or swapping is costly
     3) Bubble Sort       O(n), O(n^2), O(n^2)      Sort by repeatedly swapping the adjacent elements if they are in wrong order.
     4) Insertion Sort    O(n), O(n^2), O(n^2)      Sort by inserting a[i] in left sorted subarray a[0,i-1] and shifting elements to right, good for mostly sorted arrays
     5) Cocktail Sort     O(n), O(n^2), O(n^2)      Sort like Bubble Sort, but iterates in both forward and backward directions.
     6) Comb Sort         O(n), O(n^2), O(n^2)      Sort by performing bubble sort with initial gap as array size which shrinks by a factor of 1.3 in every iteration until it reaches to 1, hence it reduces the inversion counts.
     7) Shell Sort              O(n^2)              Sort like Insertion Sort with a variation of exchanging an element at large gap instead of one with the gap keep reducing.
     8) Merge Sort              O(nlogn)            Sort by using Dive and Conquer algorithm, divides arrays in two halves recursively, and merges the two sorted halves. Good for sorting Linked list (no need to occupy extra memory to perform merge operations).
     9) Tim Sort          O(n), O(nlogn), O(nlogn)  Sort by using combination of Insertion sort in run of 64 and Merge sort's merge technique for merging runs.
    10) Quick Sort    O(nlogn), O(nlogn), O(n^2)    Sort by using Dive and Conquer algorithm, choose pivot element, partition number array in two half, first half contains smaller and other half contains greater values than pivot element.
    11) Heap Sort               O(nlogn)            Sort by creating max binary heap, replace top node with last node, reduce the heap size by 1 and heapify the top node again.
    12) Pigeonhole Sort         O(n + Range)        Sort by putting a[i] in Pigeonhole array of length[max-min+1] at a[i]-min position, and then copy back to main array. Good for where count of numbers and range is approx. the same.
    13) Counting Sort           O(n + Range)        Sort like Pigeonhole Sort, it moves items in the array once only instaed of twice as in Pigeonhole Sort.
    14) Bucket Sort             O(n + Range)        Sort by dividing the numbers in the different buckets created based on data type, then perform insertion sort on aech bucket, and join all the buckets to get the result. Good for uniformly distributed data.
    15) Radix Sort              O(nlogb(n))         Sort by doing digit by digit sort starting from least significant digit to most significant digit. It uses counting sort as a subroutine to sort. Good for higer Range.
    16) Bitonic Sort            O(n log(n)^2)       Sort by rearranging array into bitoinc sequence (i.e. fisrt half in ascending and second half in descending order). Number of comparisions are O(nlog^2 n) and good for parallel implementation.