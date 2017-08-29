package net.nitroservices.algodsrealtimeperformance.RunTimeComplexity;

import java.util.Arrays;

/**
 * Created by rezan on 8/28/17.
 */

class SortTimeUtility {

    private Watch watch = new Watch();

    // BUBBLE SORT!
    public long bubbleSort(int[] arr) {
        // Start time watch
        watch.start();

        boolean swapped = true;
        while (swapped == true) {
            swapped = false;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;

                    // If we get here, swapped should equal true
                    // so the while loop will run through the for loop again.
                    // Otherwise, if we don't swap any items, there is no point
                    // to run through the remaining loops.
                    swapped = true;
                }
            }
        }

        // End time watch and get the time it took to complete.
        return watch.getTime();
    }



    // INSERTION SORT!
    public long insertionSort(int[] arr) {
        // Start time watch
        watch.start();

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[i]) {
                arr[j] = arr[--j];
            }

            arr[j] = arr[i];
        }

        // End time watch and get the time it took to complete.
        return watch.getTime();
    }



    // SELECTION SORT!
    public long selectionSort(int[] arr) {
        // Start time watch
        watch.start();

        for (int i = 0; i < arr.length - 1; i++) {
            int minValIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[minValIndex]) {
                    minValIndex = j;
                }
            }


            int tmp = arr[minValIndex];
            arr[minValIndex] = arr[i];
            arr[i] = tmp;
        }

        // End time watch and get the time it took to complete.
        return watch.getTime();
    }



    // MERGE SORT!
    public long mergeSort(int[] arr) {
        // Start time watch
        watch.start();

        mergeSortHelper(arr);

        // End time watch and get the time it took to complete.
        return watch.getTime();

    }

    private int[] mergeSortHelper(int[] arr) {
        if (arr.length > 1) {
            int[] first = new int[arr.length / 2];
            int[] second = new int[arr.length - first.length];

            System.arraycopy(arr, 0, first, 0, first.length);
            System.arraycopy(arr, first.length, second, 0, second.length);

            mergeSortHelper(first);
            mergeSortHelper(second);

            mergeSortHelper(first, second, arr);
        }


        return arr;
    }

    private void mergeSortHelper(int[] first, int[] second, int[] result) {
        int firstArrIndex = 0;
        int secondArrayIndex = 0;

        int j = 0;
        while ((firstArrIndex < first.length) && (secondArrayIndex < second.length)) {
            if (first[firstArrIndex] < second[secondArrayIndex]) {
                result[j] = first[firstArrIndex++];
            }
            else {
                result[j] = second[secondArrayIndex++];
            }

            j++;
        }

        System.arraycopy(first, firstArrIndex, result, j, first.length - firstArrIndex);
        System.arraycopy(second, secondArrayIndex, result, j, second.length - secondArrayIndex);
    }





    // QUICK SORT!
    public long quickSort(int[] arr) {
        // Start time watch
        watch.start();

        // Arrays.sort(arr);    // Arrays sort method uses the Quick Sort algorithm

        quickSortHelper(arr, 0, arr.length - 1);

        // End time watch and get the time it took to complete.
        return watch.getTime();
    }

    /*
        This method takes last element as pivot, places the pivot element
        at its correct position in sorted array, and places all smaller
        (smaller than pivot) to left of pivot and all greater elements to
        right of pivot.
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;    // Index of smaller element

        for (int j = low; j < high; j++) {

            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                // Swap arr[i] and arr[j]
                int tmp = arr[--i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;


        return i + 1;
    }

    /*
        This is the recursive method that implements quickSort()
        arr[] --> Array to be sorted
        low --> Starting index
        hight --> Ending index
     */
    private void quickSortHelper(int arr[], int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place.
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }


}

